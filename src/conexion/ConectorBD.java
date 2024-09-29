package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectorBD {
	private static Connection cn;

	public static Connection getConnection() {
		try {
			if (cn == null || cn.isClosed()) {

				String server = "localhost";
				String port = "1433";
				String database = "BD_LAREMEDIOSA";
				String username = "sa";
				String password = "Cibertec23";
				String dbUrl = "jdbc:sqlserver://" + server + ":" + port + ";databaseName=" + database + ";user="
						+ username + ";password=" + password + ";encrypt=" + false;
				cn = DriverManager.getConnection(dbUrl);
			}
		} catch (Exception e) {
			e.printStackTrace();
			cn = null;
		}
		return cn;
	}

	public static void main(String[] args) {
		Connection pruebaCn = ConectorBD.getConnection();
		if (pruebaCn != null) {
			System.out.println("Conectado, por fin");
			System.out.println(pruebaCn);
		} else {
			System.out.println("Desconectado :(");
		}
	}

}
