package application.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import application.model.Desarrollador;
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

	public static void asignarSoporte(int idPQRSSeleccionado, int idDesarrollador) {
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;
		if(validarSoporteDesarrollador(idPQRSSeleccionado, idDesarrollador)== false ){
			if(validarCondicionSoporte(idPQRSSeleccionado)==false){			
				try {
					conexion = conector.conectar();
					stm = conexion.createStatement();
					String query = "INSERT INTO SOPORTEASIGNADO (id,id_desarrollador, id_soporte) VALUES (?, ?, ?)";
		
					PreparedStatement pstmt = conexion.prepareStatement(query);
		
					pstmt.setInt(1, 0);
					pstmt.setInt(2, idDesarrollador);
					pstmt.setInt(3, idPQRSSeleccionado);
		
					JOptionPane.showMessageDialog(null, "Soporte asignado exitosamente, numero de columnas afectadas: "+pstmt.executeUpdate());
		
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
			}else{
				JOptionPane.showMessageDialog(null, "No se puede asignar mas de 3 desarrolladores");
			}
		}else{
			JOptionPane.showMessageDialog(null, "No se puede asignar el mismo desarrollador");
		}
	}

	public static void desasignarSoporte(int idPQRSSeleccionado, int idDesarrollador) {
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			String query = "DELETE FROM soporteasignado WHERE id_desarrollador = ? AND id_soporte = ?";

			PreparedStatement pstmt = conexion.prepareStatement(query);

			pstmt.setInt(1, idDesarrollador);
			pstmt.setInt(2, idPQRSSeleccionado);

			JOptionPane.showMessageDialog(null, "Desarrollador desasignado exitosamente, numero de columnas afectadas: "+pstmt.executeUpdate());

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
	
	public static ArrayList<Desarrollador> listaDesarrolladoresSoportes(int idPQRSSeleccionada) {
		ArrayList<Desarrollador> listaDesarrolladorSoporte = new ArrayList<>();
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT DISTINCT * FROM  DESARROLLADOR D JOIN SOPORTEASIGNADO S ON D.ID = S.ID_DESARROLLADOR WHERE S.ID_SOPORTE = "+idPQRSSeleccionada);

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
				listaDesarrolladorSoporte.add(new Desarrollador(id, id_estado,nombre,apellidos,cedula,telefono,email,
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
		return listaDesarrolladorSoporte;
	}
	
	public static boolean validarCondicionSoporte(int idSoporteSeleccionado){		
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;
		boolean respuesta= false;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT COUNT(*) FROM DESARROLLADOR D JOIN SOPORTEASIGNADO S "
					+ "ON D.ID = S.ID_DESARROLLADOR WHERE S.ID_SOPORTE = "+idSoporteSeleccionado);

			//Recorrer todos los datos obtenidos de la sentencia SQL
			while (rset.next()) {
				int cantidadSoportes = rset.getInt(1);
				if (cantidadSoportes == 3){
					respuesta = true;
				}
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
		return respuesta;
	}
	
	public static boolean validarSoporteDesarrollador(int idSoporteSeleccionado,int idDesSeleccionado){		
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;
		boolean respuesta= false;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM SOPORTEASIGNADO WHERE ID_DESARROLLADOR = "+idDesSeleccionado+" AND ID_SOPORTE = "+idSoporteSeleccionado);

			//Recorrer todos los datos obtenidos de la sentencia SQL
			while (rset.next()) {
				if (rset != null){
					respuesta = true;
				}
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
		return respuesta;
	}
}
