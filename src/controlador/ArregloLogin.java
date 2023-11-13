package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorBD;
import entidad.Login;

public class ArregloLogin {
	Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ConectorBD cn = new ConectorBD();
    
    public Login log(String correo, String pass){
        Login l = new Login();
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND pass = ?";
        try {
            con = ConectorBD.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);
            rs= ps.executeQuery();
            if (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));
                l.setRol(rs.getString("rol"));
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
    
    public boolean Registrar(Login reg){
        String sql = "INSERT INTO usuarios (nombre, correo, pass, rol) VALUES (?,?,?,?)";
        try {
            con = ConectorBD.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getCorreo());
            ps.setString(3, reg.getPass());
            ps.setString(4, reg.getRol());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List<Login> ListarUsuarios(){
       List<Login> Lista = new ArrayList<Login>();
       String sql = "SELECT * FROM usuarios";
       try {
           con = ConectorBD.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Login lg = new Login();
               lg.setId(rs.getInt("id"));
               lg.setNombre(rs.getString("nombre"));
               lg.setCorreo(rs.getString("correo"));
               lg.setRol(rs.getString("rol"));
               Lista.add(lg);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return Lista;
   }

}
