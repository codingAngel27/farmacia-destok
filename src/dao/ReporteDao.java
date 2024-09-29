package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorBD;
import entidad.ReporteItem;

public class ReporteDao {
	
	public List<ReporteItem> generarReporte(String fecha) {
		Connection cn = ConectorBD.getConnection();
		List<ReporteItem> reporteItems = new ArrayList<>();
		if (cn != null) {
			try {
				Statement statement = cn.createStatement();
				String query = "select "
						+ "p.codigo as 'codigo de producto', "
						+ "p.nombre as 'Nombre del Producto', "
						+ "d.cantidad as 'Cantidad de unidad', "
						+ "p.precio as 'Precio del Producto' " 
						+ "from productos as p "
						+ "inner join detalle as d on p.id =  d.id_pro "
						+ "inner join ventas as v on v.id = d.id_venta "
						+ "where v.fecha = '" +fecha+ "'";
				ResultSet result = statement.executeQuery(query);

				while (result.next()) {

					ReporteItem rI = new ReporteItem();
					rI.setCodigoProducto(result.getString("codigo de producto"));
					rI.setNombreProducto(result.getString("Nombre del Producto"));
					rI.setCantidadProducto(result.getInt("Cantidad de unidad"));
					rI.setPrecioProducto(result.getDouble("Precio del Producto"));
					reporteItems.add(rI);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(":(");
		}
		return reporteItems;
	}

}
