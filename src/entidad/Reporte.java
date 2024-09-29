package entidad;

import java.util.List;

public class Reporte {
	double totalVentaDelDia;
	String fecha;
	List<ReporteItem> ReporteItem ;
	
	
	public List<ReporteItem> getReporteItem() {
		return ReporteItem;
	}
	public void setReporteItem(List<ReporteItem> reporteItem) {
		ReporteItem = reporteItem;
	}
	public double getTotalVentaDelDia() {
		return totalVentaDelDia;
	}
	public void setTotalVentaDelDia(double totalVentaDelDia) {
		this.totalVentaDelDia = totalVentaDelDia;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
