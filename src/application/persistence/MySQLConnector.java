package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	//se elige la base de datos a la cual se quiere conectar, en caso de prueba elegimos biblioteca
	private static final String DBNAME = "camu_soporte";
	//Pide ruta de la base de datos, como esta local se pone localhost
	//puerto 3306 por defecto para mysql
	private static final String URL = "jdbc:mysql://localhost:3306/"+DBNAME+"?useUnicode=true&characterEncoding=UTF-8";
	//El siguiente parametro es el usuario, por dejecto root
	private static final String USER = "root";
	//El ultimo parametro es la contraseña de ese usuario que le pusimos cuando instalamos mysql
	private static final String PASSWORD = "1234";

	static{
		try{
			//Conexion especifica con el controlador de mysql
			Class.forName(CONTROLADOR);
		}catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}

	public Connection conectar(){
		Connection conexion = null;
		try {
			//Conexion a la base de datos -------------------------
			conexion = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			System.out.println("Error en la conexión con DB: "+DBNAME);
			e.printStackTrace();
		}
		return conexion;
	}
}
