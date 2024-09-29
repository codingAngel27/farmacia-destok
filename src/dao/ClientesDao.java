package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import conexion.ConectorBD;
import entidad.Cliente;

public class ClientesDao {
	public Cliente buscarCliente(String dni) {
		Connection cn = ConectorBD.getConnection();
		if (cn != null) {
			try {
				Statement statement = cn.createStatement();
				ResultSet result = statement.executeQuery("select *from clientes where dni like('" + dni + "')");

				if (result.next()) {
					Cliente client = new Cliente();
					client.setId(result.getInt("id"));
					client.setDni(result.getString("dni"));
					client.setNombre(result.getString("nombre"));
					client.setTelefono(result.getString("telefono"));
					client.setDireccion(result.getString("direccion"));
					return client;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(":(");
		}
		return null;
	}


}
