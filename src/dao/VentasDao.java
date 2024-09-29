package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import conexion.ConectorBD;
import entidad.Venta;

public class VentasDao {
	
	public int ultimoId() {
		int obtenido = 0;
		Connection cn = ConectorBD.getConnection();

		if (cn != null) {
			try {
				Statement statement = cn.createStatement();
				ResultSet result = statement.executeQuery("select top 1 id from ventas order by id desc");

				if (result.next()) {

					obtenido = result.getInt("id");

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(":(");
		}
		return obtenido;
	}

	public void guardarVenta(Venta venta) {
		Connection cn = ConectorBD.getConnection();

		if (cn != null) {
			try {
				Statement statement = cn.createStatement();
				statement.executeUpdate("insert into ventas (cliente,vendedor,total,fecha)values(" +venta.getCliente()+",'"+venta.getVendedor() +"',"+venta.getTotal() +",'"+venta.getFecha()+"')");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(":(");
		}

	}

}
