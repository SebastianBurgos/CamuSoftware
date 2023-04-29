package application.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import application.model.PQRS;
import application.persistence.MySQLConnector;

public class PQRSService {

	public static ArrayList<PQRS> listaPQRS() {
		ArrayList<PQRS> listaPQRS = new ArrayList<>();
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM PQRS");

			//Recorrer todos los datos obtenidos de la sentencia SQL
			while (rset.next()) {
				int id = rset.getInt(1);
				int id_usuario = rset.getInt(2);
				int id_plataforma = rset.getInt(3);
				int id_modulo = rset.getInt(4);
				int id_tipo = rset.getInt(5);
				String detalles = rset.getString(6);
				String asunto = rset.getString(7);
				Date fecha_solicitud = rset.getDate(8);
				String estado = rset.getString(9);

				listaPQRS.add(new PQRS(id,id_usuario,id_plataforma,id_modulo,id_tipo,detalles,asunto,
						 fecha_solicitud,estado));
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
		return listaPQRS;
	}

}
