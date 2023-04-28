package application.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.codec.digest.DigestUtils;

import application.model.Usuario;
import application.persistence.MySQLConnector;

public class UsuarioService {

	public static boolean ingresar(String email, String password) {
		boolean valido = false;
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		String encriptMD5 = DigestUtils.md5Hex(password);

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery(
					"SELECT * FROM USUARIO U WHERE U.email = '" + email + "' AND U.password = '" + encriptMD5 + "'");

			if (rset.next() == true) {
				valido = true;
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

		return valido;
	}

	public static Usuario obtenerUsuarioCedula(String cedula) {
		Usuario usuarioEncontrado = null;
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM USUARIO U WHERE U.cedula = '" + cedula + "'");
			
			//Recorrer todos los datos obtenidos de la sentencia SQL
			while (rset.next()) {
				int id = rset.getInt(1);
				String nombre = rset.getString(2);
				String apellidos = rset.getString(3);
				String idCedula = rset.getString(4);
				String telefono = rset.getString(5);
				String emailUsuario = rset.getString(6);
				String direccion = rset.getString(7);
				String ciudadResidencia = rset.getString(8);
				String password = rset.getString(9);

				usuarioEncontrado = new Usuario(id, nombre, apellidos, idCedula, telefono, emailUsuario, direccion,
						ciudadResidencia, password);
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

		return usuarioEncontrado;
	}

}
