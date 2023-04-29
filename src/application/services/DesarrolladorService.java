package application.services;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;

import application.model.Desarrollador;
import application.persistence.MySQLConnector;

public class DesarrolladorService {

	public static int buscarDesarrolladorEmail(String email) {
		int id_desarrollador = 0;
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM DESARROLLADOR D WHERE D.email = '"+email+"'");

			if (rset.next() == true) {
				id_desarrollador = rset.getInt(1);
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
		return id_desarrollador;

	}

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
			rset = stm.executeQuery("SELECT * FROM DESARROLLADOR D WHERE D.email = '"+email+
					"' AND D.password = '"+encriptMD5+"'");

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

	public static ArrayList<Desarrollador> listaDesarrolladores() {
		ArrayList<Desarrollador> listaDesarrolladores = new ArrayList<>();
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM DESARROLLADOR");

			//Recorrer todos los datos obtenidos de la sentencia SQL
			while (rset.next()) {
				int id = rset.getInt(1);
				int id_estado = rset.getInt(2);
				String nombre = rset.getString(4);
				String apellidos = rset.getString(5);
				String cedula = rset.getString(3);
				String telefono = rset.getString(6);
				String email = rset.getString(7);
				String direccion = rset.getString(8);
				String password = rset.getString(9);

				listaDesarrolladores.add(new Desarrollador(id, id_estado,nombre,apellidos,cedula,telefono,email,
						direccion, password));
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
		return listaDesarrolladores;
	}

}
