package dao;

import java.sql.Connection;
import java.sql.Statement;

import conexion.ConectorBD;
import entidad.Detalle;

public class DetalleDao {
	
	public void guardarDetalle(Detalle detalle) {
		Connection cn = ConectorBD.getConnection();

		if (cn != null) {
			try {
				Statement statement = cn.createStatement();
				statement.executeUpdate("insert into detalle(id_pro , cantidad , precio , id_venta )values(" + detalle.getId_pro() +","+detalle.getCantidad()+"," +detalle.getPrecio() +","+detalle.getId_venta() +")");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(":(");
		}

	}

}
