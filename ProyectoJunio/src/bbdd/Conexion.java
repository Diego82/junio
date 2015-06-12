package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.sqlite.SQLiteConfig;

public class Conexion {
	private static Connection conexion = null;
	//Constructor privado
	private Conexion(){};
	
	public static Connection getConexion(){
		String nombreBD = "jdbc:sqlite:/home/diego/sqlite/empresas";
		SQLiteConfig config = new SQLiteConfig();
		config.enforceForeignKeys(true);
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection(nombreBD, config.toProperties());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	
	public static void desconectar(){
		if (conexion != null)
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}