package application.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.model.Soporte;
import application.persistence.MySQLConnector;

public class SoporteAsignadoService {

	/**
	 * Servicio que retorna la lista de soportes asignados a un desarrollador segun su id
	 * @return
	 */
	public static ArrayList<Soporte> listaSoportesAsignados(int id_desarrollador) {
		ArrayList<Soporte> listaSoportesAsignados = new ArrayList<>();
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM SOPORTEASIGNADO S WHERE S.ID_DESARROLLADOR = "+id_desarrollador);

			//Recorrer todos los datos obtenidos de la sentencia SQL
			while (rset.next()) {
				int id_soporte = rset.getInt(3);
				Soporte soporteAsignado = SoporteService.obtenerSoporte(id_soporte);
				listaSoportesAsignados.add(soporteAsignado);
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
		return listaSoportesAsignados;
	}

}
