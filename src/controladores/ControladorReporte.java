package controladores;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import dao.ReporteDao;
import entidad.Reporte;
import entidad.ReporteItem;

public class ControladorReporte {
	
	private View view;
	private ReporteDao reporteDao;
	
	public ControladorReporte(View view) {
		this.view = view;
		reporteDao = new ReporteDao(); 
	}
	
	public void generarReporte(String fecha) {

		Reporte reporte = new Reporte();
		
		List<ReporteItem> temporal =  reporteDao.generarReporte(fecha);
		List<ReporteItem> listaReporte = agruparDatosReporte(temporal);
		reporte.setReporteItem(listaReporte);
		view.mostrarListaReporte(listaReporte);

		double total = listaReporte.stream().map(item-> item.getTotal()).mapToDouble(Double::doubleValue).sum();
		reporte.setTotalVentaDelDia(total);
		
		
		DecimalFormat df = new DecimalFormat("S/###,##0.00");
		
		view.mostrarTotalReporte(df.format(total));
	}
	
	public List<ReporteItem> agruparDatosReporte(List<ReporteItem> listaReporte) {
		HashMap<String, ReporteItem> map = new HashMap<>();
		for(ReporteItem reporteItem : listaReporte) {
			if(map.containsKey(reporteItem.getCodigoProducto())) {
				ReporteItem reporteItemActual = map.get(reporteItem.getCodigoProducto());
				reporteItemActual.agregarCantidad(reporteItem.getCantidadProducto());
				map.put(reporteItem.getCodigoProducto(), reporteItemActual);	
			}else {
				map.put(reporteItem.getCodigoProducto(), reporteItem);	
			}
		}
		return new ArrayList<>(map.values());
	}
	
	public interface View {
		void mostrarListaReporte(List<ReporteItem> items);
		void mostrarTotalReporte(String total);
	}

}
