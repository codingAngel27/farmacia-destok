package controladores;

import java.text.DecimalFormat;
import java.text.Format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.print.CancelablePrintJob;


import dao.ClientesDao;
import dao.DetalleDao;
import dao.ProductoDao;
import dao.VentasDao;
import entidad.Cliente;
import entidad.Detalle;
import entidad.Producto;
import entidad.Venta;

public class ControladorVenta {

	private ProductoDao productoDao;
	private VentasDao ventaDao;
	private DetalleDao detalledao;
	private ClientesDao clienteDao;
	private View view;
	private List<Producto> carrito;
	double total = 0;
	int idCliente = -1;

	public ControladorVenta(View view) {
		productoDao = new ProductoDao();
		ventaDao = new VentasDao();
		carrito = new ArrayList<>();
		detalledao = new DetalleDao();
		clienteDao = new ClientesDao();
		this.view = view;
		iniciarReloj();
		calcularCorrelativo();
	}

	public void buscarProducto(String nombre) {
		if (nombre.length() < 3) {
			view.ocultarBusqueda();
		} else {
			List<Producto> lista = productoDao.buscarProducto(nombre);
			if (lista.isEmpty()) {
				view.ocultarBusqueda();
			} else {
				view.mostrarBusqueda(lista);
			}
		}
	}

	public void agregarProducto(Producto producto) {
		carrito.add(producto);
		refrescarCarrito();
	}

	public void refrescarCarrito() {

		List<Object[]> rows = new ArrayList<>();
		HashMap<String, List<Producto>> grupos = getCarritoAgrupado();

		for (Entry<String, List<Producto>> entry : grupos.entrySet()) {
			List<Producto> productos = entry.getValue();

			Producto producto = productos.get(0);
			int cantidad = productos.size();

			Object[] fila = { producto.getCodigo(), producto.getNombre(), producto.getPrecio(), cantidad };
			rows.add(fila);
		}

		view.borrarTabla();
		view.mostrarCarrito(rows);
	}

	public void quitarProductodeLista(String codigo) {
		carrito.removeIf(p -> p.getCodigo().equals(codigo));
		refrescarCarrito();
	}

	private void calcularFechaHora() {

		LocalDateTime date = LocalDateTime.now();

		DateTimeFormatter fechaFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter horaFormat = DateTimeFormatter.ofPattern("hh:mm:ss a");

		String fecha = date.format(fechaFormat);
		String hora = date.format(horaFormat);

		view.mostrarFechaHora(fecha, hora);
	}

	private HashMap<String, List<Producto>> getCarritoAgrupado() {
		HashMap<String, List<Producto>> map = new HashMap<>();
		for (Producto producto : carrito) {
			List<Producto> productos;
			if (map.containsKey(producto.getCodigo())) {
				productos = map.get(producto.getCodigo());
				productos.add(producto);
			} else {
				productos = new ArrayList<>();
				productos.add(producto);
			}
			map.put(producto.getCodigo(), productos);
		}
		return map;
	}

	public void calcularTotales() {
		total = 0;
		HashMap<String, List<Producto>> grupos = getCarritoAgrupado();

		for (Entry<String, List<Producto>> entry : grupos.entrySet()) {
			List<Producto> productos = entry.getValue();

			Producto producto = productos.get(0);
			double precio = producto.getPrecio();
			int cantidad = productos.size();
			double subTotal = precio * cantidad;
			total += subTotal;
		}
		double valorVenta = total / 1.18;
		double igv = total - valorVenta;

		DecimalFormat df = new DecimalFormat("S/###,##0.00");
		String datoIgv = df.format(igv);
		String datoValorV = df.format(valorVenta);
		String datoTotal = df.format(total);

		view.mostrarTotales(datoIgv, datoValorV, datoTotal);
	}

	public void guardarVenta(String correlativo, String nombre,String fecha) {
		Venta venta = new Venta();
		venta.setId(Integer.parseInt(correlativo));
		venta.setCliente(idCliente);
		venta.setVendedor(nombre);
		venta.setTotal(total);
		venta.setFecha(fecha);
		ventaDao.guardarVenta(venta);

		HashMap<String, List<Producto>> grupos = getCarritoAgrupado();
		for (Entry<String, List<Producto>> entry : grupos.entrySet()) {
			List<Producto> productos = entry.getValue();

			Producto producto = productos.get(0);
			Detalle detalle = new Detalle();
			detalle.setCantidad(productos.size());
			detalle.setId_pro(producto.getId());
			detalle.setPrecio(producto.getPrecio());
			detalle.setId_venta(venta.getId());

			detalledao.guardarDetalle(detalle);
			productoDao.actualizarStock(detalle);
		}
	}

	public void buscarNombreCliente(String dni) {
		Cliente cliente = clienteDao.buscarCliente(dni);
		idCliente = cliente.getId();
		view.mostrarNombreCliente(cliente.getNombre());
	}

	private void iniciarReloj() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					calcularFechaHora();
					try {
						Thread.sleep(1000);// 60 seconds interval
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	private void calcularCorrelativo() {
		int ultimoId = ventaDao.ultimoId();
		int correlativo = ultimoId + 1;
		view.mostarIdCorrelativo(correlativo + "");
	}

	public interface View {
		void mostrarCarrito(List<Object[]> rows);

		void borrarTabla();

		void mostrarFechaHora(String fecha, String hora);

		void mostarIdCorrelativo(String correlativo);

		void mostrarBusqueda(List<Producto> productos);

		void ocultarBusqueda();

		void mostrarTotales(String datoIgv, String datoValorV, String datoTotal);

		void mostrarNombreCliente(String nombre);
	}
}
