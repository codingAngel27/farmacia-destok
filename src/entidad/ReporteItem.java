package entidad;

public class ReporteItem {
	
	String codigoProducto;
	String nombreProducto;
	int cantidadProducto;
	double precioProducto;
	
	
	

	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String coidigoProducto) {
		this.codigoProducto = coidigoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	
	public void agregarCantidad(int cantidad) {
		cantidadProducto+=cantidad;
	}
	
	public double getTotal() {
		return precioProducto * cantidadProducto;
	}

}
