package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controladores.ControladorVenta;
import entidad.Producto;
import entidad.Venta;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.Color;
import java.awt.Font;

public class FrmVenta extends JFrame implements ActionListener, ControladorVenta.View,IFMetodoPago.Listener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textNBoleta;
	private JLabel lblNewLabel_1;
	private JTextField textFecha;
	private JLabel lblNewLabel_2;
	private JTextField textHora;
	private JTextField textBuscar;
	private JTable tblProductos;
	private JScrollPane scrollPane;
	private JButton btnLimpiar;
	private JButton btnQuitar;
	private JTextField textValorVenta;
	private JLabel lblNewLabel_3;
	private JTextField textIGV;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textTotal;
	private JTextField textCliente;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textDNI;
	private IFMetodoPago  IFPago ;
	DefaultTableModel model = new DefaultTableModel();

	ControladorVenta controlVenta;
	IFMetodoPago ifmetodoPago;
	private JTextField textVendedor;
	private JLabel lblNewLabel_8;
	private JList<Producto> listProducto;
	private JLabel lblNewLabel_9;
	private JButton btnPagar;
	private JButton btnBuscarCliente;
	private JLabel lblNewLabel_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVenta frame = new FrmVenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmVenta() {
		setTitle("VENTA");
		IFPago= new IFMetodoPago(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 729, 561);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		IFPago.setLocation(74, 101);
		contentPane.add(IFPago);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("N° Boleta");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(481, 206, 80, 14);
		contentPane.add(lblNewLabel);

		textNBoleta = new JTextField();
		textNBoleta.setEditable(false);
		textNBoleta.setEnabled(false);
		textNBoleta.setBounds(559, 203, 115, 20);
		contentPane.add(textNBoleta);
		textNBoleta.setColumns(10);

		lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(470, 25, 68, 14);
		contentPane.add(lblNewLabel_1);

		textFecha = new JTextField();
		textFecha.setEnabled(false);
		textFecha.setEditable(false);
		textFecha.setBounds(574, 24, 100, 20);
		contentPane.add(textFecha);
		textFecha.setColumns(10);

		lblNewLabel_2 = new JLabel("Hora");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(470, 50, 68, 14);
		contentPane.add(lblNewLabel_2);

		textHora = new JTextField();
		textHora.setEnabled(false);
		textHora.setEditable(false);
		textHora.setBounds(574, 55, 100, 20);
		contentPane.add(textHora);
		textHora.setColumns(10);

		textBuscar = new JTextField();
		textBuscar.setBounds(40, 48, 237, 20);
		contentPane.add(textBuscar);
		textBuscar.setColumns(10);
		textBuscar.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				buscarProducto();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 234, 664, 163);
		contentPane.add(scrollPane);

		tblProductos = new JTable();
		scrollPane.setViewportView(tblProductos);
		model.addColumn("Código");
		model.addColumn("Producto");
		model.addColumn("Precio");
		model.addColumn("Cantidad");

		tblProductos.setModel(model);

		btnLimpiar = new JButton("Limpiar ");
		btnLimpiar.setBackground(new Color(255, 255, 255));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(31, 469, 127, 33);
		contentPane.add(btnLimpiar);

		btnQuitar = new JButton("Quitar");
		btnQuitar.setBackground(new Color(255, 255, 255));
		btnQuitar.addActionListener(this);
		btnQuitar.setIcon(new ImageIcon(FrmVenta.class.getResource("/img/salir.png")));
		btnQuitar.setBounds(31, 407, 127, 44);
		contentPane.add(btnQuitar);

		textValorVenta = new JTextField();
		textValorVenta.setBounds(554, 419, 106, 20);
		contentPane.add(textValorVenta);
		textValorVenta.setColumns(10);

		lblNewLabel_3 = new JLabel("Valor  Venta");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(409, 420, 106, 14);
		contentPane.add(lblNewLabel_3);

		textIGV = new JTextField();
		textIGV.setBounds(554, 450, 106, 20);
		contentPane.add(textIGV);
		textIGV.setColumns(10);

		lblNewLabel_4 = new JLabel("IGV 18%");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(409, 451, 71, 14);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Total");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(409, 479, 71, 14);
		contentPane.add(lblNewLabel_5);

		textTotal = new JTextField();
		textTotal.setBounds(554, 478, 106, 20);
		contentPane.add(textTotal);
		textTotal.setColumns(10);

		textCliente = new JTextField();
		textCliente.setEditable(false);
		textCliente.setBounds(126, 200, 264, 20);
		contentPane.add(textCliente);
		textCliente.setColumns(10);

		lblNewLabel_6 = new JLabel("NOMBRES");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(31, 203, 86, 14);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel(" DNI");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(31, 164, 68, 14);
		contentPane.add(lblNewLabel_7);

		textDNI = new JTextField();
		textDNI.setBounds(126, 161, 151, 20);
		contentPane.add(textDNI);
		textDNI.setColumns(10);

		textVendedor = new JTextField();
		textVendedor.setBounds(559, 151, 115, 20);
		contentPane.add(textVendedor);
		textVendedor.setColumns(10);

		lblNewLabel_8 = new JLabel("Vendedor");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(470, 152, 80, 14);
		contentPane.add(lblNewLabel_8);

		listProducto = new JList<Producto>();
		listProducto.setBackground(new Color(0, 206, 209));
		listProducto.setVisible(false);
		listProducto.setVisibleRowCount(5);
		listProducto.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()&& !listProducto.isSelectionEmpty()) {  
					Producto producto = listProducto.getSelectedValue();
					controlVenta.agregarProducto(producto);
					listProducto.clearSelection();
				}
			}
		});

		listProducto.setBounds(40, 75, 274, 57);
		contentPane.add(listProducto);

		lblNewLabel_9 = new JLabel("BUSCAR PRODUCTO");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(42, 25, 209, 14);
		contentPane.add(lblNewLabel_9);
		
		btnPagar = new JButton("Pagar");
		btnPagar.setBackground(new Color(255, 255, 255));
		btnPagar.addActionListener(this);
		btnPagar.setIcon(new ImageIcon(FrmVenta.class.getResource("/img/pago1.png")));
		btnPagar.setBounds(188, 408, 127, 44);
		contentPane.add(btnPagar);
		
		btnBuscarCliente = new JButton("BUSCAR");
		btnBuscarCliente.addActionListener(this);
		btnBuscarCliente.setIcon(new ImageIcon(FrmVenta.class.getResource("/img/Clientes.png")));
		btnBuscarCliente.setBounds(312, 145, 127, 33);
		contentPane.add(btnBuscarCliente);
		
		lblNewLabel_10 = new JLabel("INGRESE SU NOMBRE(obligatorio)");
		lblNewLabel_10.setBounds(470, 127, 204, 14);
		contentPane.add(lblNewLabel_10);

		controlVenta = new ControladorVenta(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnBuscarCliente) {
			actionPerformedBtnBuscarCliente(e);
		}
		if (e.getSource() == btnPagar) {
			actionPerformedBtnPagar(e);
		}
		if (e.getSource() == btnQuitar) {
			actionPerformedBtnQuitar(e);
		}		
	}

	public void buscarProducto() {
		String consulta = textBuscar.getText();
		controlVenta.buscarProducto(consulta);
	}

	@Override
	public void mostrarCarrito(List<Object[]> rows) {
		for (Object[] row : rows) {
			model.addRow(row);
		}
		tblProductos.setModel(model);
		controlVenta.calcularTotales();
	}

	@Override
	public void borrarTabla() {
		model.setRowCount(0);
		tblProductos.setModel(model);
	}

	@Override
	public void mostrarFechaHora(String fecha, String hora) {
		textHora.setText(hora);
		textFecha.setText(fecha);
	}

	@Override
	public void mostarIdCorrelativo(String correlativo) {
		textNBoleta.setText(correlativo);
	}

	@Override
	public void mostrarBusqueda(List<Producto> productos) {
		AbstractListModel<Producto> model = new AbstractListModel<Producto>() {

			private static final long serialVersionUID = 1L;

			@Override
			public int getSize() {
				return productos.size();
			}

			@Override
			public Producto getElementAt(int index) {
				return productos.get(index);
			}
		};
		listProducto.setModel(model);
		listProducto.setVisible(true);
	}

	@Override
	public void ocultarBusqueda() {
		listProducto.setVisible(false);
	}
	
	public void eliminarProducto() {
		int posicion =  tblProductos.getSelectedRow();
		if(posicion==-1) {
			JOptionPane.showMessageDialog(this, "Seleccione el Producto que desea quitar");
		}else {
			String codigo = (String) model.getValueAt(posicion, 0);
			controlVenta.quitarProductodeLista(codigo);
			JOptionPane.showMessageDialog(this, "Producto removido");
		}
	}

	protected void actionPerformedBtnQuitar(ActionEvent e) {
		eliminarProducto();
	}

	@Override
	public void mostrarTotales(String datoIgv, String datoValorV, String datoTotal) {
		textIGV.setText(datoIgv);
		textValorVenta.setText(datoValorV);
		textTotal.setText(datoTotal);
	}
	
	protected void actionPerformedBtnPagar(ActionEvent e) {
			
		IFPago.setVisible(true);
	
	
		
	}
	public void guardarVentaProducto() {
		String correlativo = textNBoleta.getText() ;
		String nombre = textVendedor.getText();
		String fecha = textFecha.getText();
		controlVenta.guardarVenta(correlativo, nombre,fecha);
	}
	

	protected void actionPerformedBtnBuscarCliente(ActionEvent e) {
		String dni =textDNI.getText();
		controlVenta.buscarNombreCliente(dni);
		
	}
	
	@Override
	public void mostrarNombreCliente(String nombre) {
		textCliente.setText(nombre);
	}

	@Override
	public void onPagarClick() {
		
		guardarVentaProducto();
		limpiar();
	}
	
	public void limpiar() {
		textCliente.setText("");
		textDNI.setText("");
		model.setRowCount(0);
		textValorVenta.setText("");
		textIGV.setText("");
		textTotal.setText("");
		textVendedor.setText("");
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiar();
	}
}
