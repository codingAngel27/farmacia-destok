package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexion.ConectorBD;
import entidad.Proveedor;

public class ProveedorDAO {
	Connection con;
    ConectorBD cn = new ConectorBD();
    PreparedStatement ps;
    ResultSet rs;
    public boolean RegistrarProveedor(Proveedor pr){
        String sql = "INSERT INTO proveedor(ruc, nombre, telefono, direccion) VALUES (?,?,?,?)";
        try {
           con = ConectorBD.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, pr.getRuc());
           ps.setString(2, pr.getNombre());
           ps.setString(3, pr.getTelefono());
           ps.setString(4, pr.getDireccion());
           ps.execute();
           JOptionPane.showMessageDialog(null, "Se ha sido registrado correctamente.");
           return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public boolean existeProveedor(String ruc) {
        boolean respuesta = false;
        String sql = "select ruc from proveedor where ruc = '" + ruc+ "';";
        Statement st;
        try {
            Connection cn = ConectorBD.getConnection();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar proveedor: " + e);
        }
        return respuesta;
    }
    public List<Proveedor> ListarProveedor(){
        List<Proveedor> Listapr = new ArrayList<Proveedor>();
        String sql = "SELECT * FROM proveedor";
        try {
            con = ConectorBD.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Proveedor pr = new Proveedor();
                pr.setId(rs.getInt("id"));
                pr.setRuc(rs.getString("ruc"));
                pr.setNombre(rs.getString("nombre"));
                pr.setTelefono(rs.getString("telefono"));
                pr.setDireccion(rs.getString("direccion"));
                Listapr.add(pr);
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Listapr;
    }
    
    public boolean EliminarProveedor(int id){
        String sql = "DELETE FROM proveedor WHERE id = ? ";
        try {
            con = ConectorBD.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public boolean ModificarProveedor(Proveedor pr){
        String sql = "UPDATE proveedor SET ruc=?, nombre=?, telefono=?, direccion=? WHERE id=?";
        try {
            con = ConectorBD.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getRuc());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setInt(5, pr.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

}
