package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConectorBD {
private static Connection cn;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BD_LAREMEDIOSA","sa","Cibertec23");
		} catch (Exception e){
			e.printStackTrace();
			cn=null;
		}
		return cn;
	}
	public static void main(String[] args) {
		Connection pruebaCn = ConectorBD.getConnection();
		if(pruebaCn!=null) {
			System.out.println("Conectado papu :), por fin");
			System.out.println(pruebaCn);
		} else {
			System.out.println("Desconectado csm:(");
		}
	}

}
