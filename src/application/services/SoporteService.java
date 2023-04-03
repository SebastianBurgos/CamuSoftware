package application.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.model.Soporte;
import application.persistence.MySQLConnector;

public class SoporteService {

	/**
	 * Servicio para obtener un soporte por su id
	 * @param id
	 * @return
	 */
	public static Soporte obtenerSoporte(int id_buscar) {
		Soporte soporteEncontrado = null;
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM SOPORTE S WHERE S.ID = "+id_buscar);

			//Recorrer todos los datos obtenidos de la sentencia SQL
			while (rset.next()) {
				int id = rset.getInt(1);
				int id_pqrs = rset.getInt(2);
				String estado = rset.getString(3);
				String tipo = rset.getString(4);
				Date fecha_creacion = rset.getDate(5);
				Date fecha_ultima_actualizacion = rset.getDate(6);
				String tiempo_respuesta = rset.getString(7);
				String observaciones = rset.getString(8);
				String respuesta = rset.getString(9);

				soporteEncontrado = new Soporte(id, id_pqrs, estado, tipo, fecha_creacion,
									fecha_ultima_actualizacion, tiempo_respuesta, observaciones,
									respuesta);

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

		return soporteEncontrado;
	}
}
