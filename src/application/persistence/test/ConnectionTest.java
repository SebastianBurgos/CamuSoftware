package application.persistence.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.model.Usuario;
import application.persistence.MySQLConnector;

public class ConnectionTest {
	public static void main(String[] args) {
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM USUARIO");

			//Recorrer todos los datos obtenidos de la sentencia SQL
			while (rset.next()) {
				int id = rset.getInt(1);
				String nombre = rset.getString(2);
				String apellidos = rset.getString(3);
				String cedula = rset.getString(4);
				String telefono = rset.getString(5);
				String email = rset.getString(6);
				String direccion = rset.getString(7);
				String ciudadResidencia = rset.getString(8);
				String password = rset.getString(9);

				Usuario newUser = new Usuario(id, nombre, apellidos, cedula, telefono, email, direccion, ciudadResidencia, password);
				System.out.println(newUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rset != null) {
					rset.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
