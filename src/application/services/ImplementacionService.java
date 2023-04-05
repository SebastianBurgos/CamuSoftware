package application.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import application.model.Implementacion;
import application.persistence.MySQLConnector;

public class ImplementacionService {

	public static ArrayList<Implementacion> listaImplementacionesSoporte(int id_soporteBuscar) {
		ArrayList<Implementacion> listaImplementaciones = new ArrayList<>();
		Implementacion implementacion = null;
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM IMPLEMENTACION I "
								+ "	JOIN SOPORTE S ON I.ID_SOPORTE = S.ID"
								+ " WHERE S.ID = "+id_soporteBuscar);

			//Recorrer todos los datos obtenidos de la sentencia SQL
			while (rset.next()) {
				int id = rset.getInt(1);
				int id_soporte = rset.getInt(2);
				String especificacion = rset.getString(3);
				Date fecha_implementacion = rset.getDate(4);
				int horas_invertidas = rset.getInt(5);
				String estado = rset.getString(6);

				implementacion = new Implementacion(id, id_soporte, especificacion,
						fecha_implementacion, horas_invertidas, estado);
				listaImplementaciones.add(implementacion);
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

		return listaImplementaciones;
	}

	/**
	 * Metodo para agregar una nueva implementacion a un soporte seleciconado
	 * @param idSoporteSeleccionado
	 * @param especificacion
	 * @param fechaFX
	 * @param horas
	 * @param estado
	 */
	public static void agregarImplementacionSoporteSeleccionado(int idSoporteSeleccionado, String especificacion, LocalDate fechaFX, int horas, String estado) {
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;
		Date fecha = Date.valueOf(fechaFX);

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			String query = "INSERT INTO implementacion (id, id_soporte, especificacion, fecha_implementacion, horas_invertidas, estado) VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement pstmt = conexion.prepareStatement(query);

			pstmt.setInt(1, 0);
			pstmt.setInt(2, idSoporteSeleccionado);
			pstmt.setString(3, especificacion);
			pstmt.setDate(4, fecha);
			pstmt.setInt(5, horas);
			pstmt.setString(6, estado);

			JOptionPane.showMessageDialog(null, "Implementacion agregada exitosamente, numero de columnas afectadas: "+pstmt.executeUpdate());

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
