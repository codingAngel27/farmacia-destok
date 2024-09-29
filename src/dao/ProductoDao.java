package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorBD;
import entidad.Detalle;
import entidad.Producto;

public class ProductoDao {
	
	public List<Producto> listarProducto(){
		List<Producto> lista = new ArrayList<>();
		Connection cn = ConectorBD.getConnection();
		if(cn!=null) {
			try {
				Statement statement = cn.createStatement();
				ResultSet result = statement.executeQuery("Select * from productos");
				
				while (result.next()) {
		         
		            Producto obj = new Producto();
		            obj.setId(result.getInt("id"));
		            obj.setCodigo(result.getString("codigo"));
		            obj.setNombre(result.getString("nombre"));
		            obj.setProveedor(result.getInt("proveedor"));
		            obj.setStock(result.getInt("stock"));
		            obj.setPrecio(result.getDouble("precio"));
		            
		            lista.add(obj);
		        }
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(cn);
		} else {
			System.out.println(":(");
		}
		return lista;
	}
	
	
	public List<Producto> buscarProducto(String nombre){
		Connection cn = ConectorBD.getConnection();
		List<Producto> productoBus = new ArrayList<>();
		if(cn!=null) {
			try {
				Statement statement = cn.createStatement();	
				ResultSet result = statement.executeQuery("select * from productos where nombre like('%"+nombre+"%')");
				
				while (result.next()) {
					Producto obj = new Producto();
		            obj.setId(result.getInt("id"));
		            obj.setCodigo(result.getString("codigo"));
		            obj.setNombre(result.getString("nombre"));
		            obj.setStock(result.getInt("stock"));
		            obj.setProveedor(result.getInt("proveedor"));
		            obj.setPrecio(result.getDouble("precio"));
		            
		            productoBus.add(obj);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(cn);
		}else {
			System.out.println(":(");
		}
		return productoBus;
	}
	
	public void actualizarStock(Detalle detalle) {
		Connection cn = ConectorBD.getConnection();
		if(cn !=null) {
			try {
				Statement statement = cn.createStatement();	
				statement.executeUpdate("UPDATE productos\r\n"
						+ "    SET stock = stock -"+detalle.getCantidad()
						+ "    WHERE ID = "+detalle.getId_pro());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(":(");
		}
		}
		

}
