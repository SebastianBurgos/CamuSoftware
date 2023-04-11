package application.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import application.model.PQRS;
import application.model.Modulo;
import application.model.Plataforma;
import application.model.Soporte;
import application.model.TipoPQRS;
import application.model.Usuario;
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

	/**
	 * Metodo para obtener un usuario segun el id del posorte
	 * @param idSoporte
	 * @return
	 */
	public static Usuario obtenerUsuario(int idSoporte) {
		Usuario usuarioEncontrado = null;
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM USUARIO U "
					+ "JOIN PQRS ON U.ID = PQRS.ID_USUARIO "
					+ "JOIN SOPORTE S ON S.ID_PQRS = PQRS.ID "
					+ "WHERE S.ID = "+idSoporte);

			//Recorrer todos los datos obtenidos de la sentencia SQL
			while (rset.next()) {
				int id = rset.getInt(1);
				String nombre = rset.getString(2);
				String apellidos = rset.getString(3);
				String cedula = rset.getString(4);
				String telefono = rset.getString(5);
				String email = rset.getString(6);
				String direccion = rset.getString(7);
				String ciudad_residencia = rset.getString(8);
				String password = rset.getString(9);

				usuarioEncontrado = new Usuario(id, nombre, apellidos,
						cedula, telefono, email, direccion, ciudad_residencia, password);

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

	public static Plataforma obtenerPlataforma(int idSoporte) {
		Plataforma plataformaEncontrada = null;
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM PLATAFORMA PLAT "
					+ "JOIN PQRS ON PLAT.ID = PQRS.ID_PLATAFORMA "
					+ "JOIN SOPORTE S ON S.ID_PQRS = PQRS.ID "
					+ "WHERE S.ID = "+idSoporte);

			//Recorrer todos los datos obtenidos de la sentencia SQL
			while (rset.next()) {
				int id = rset.getInt(1);
				String nombre = rset.getString(2);

				plataformaEncontrada = new Plataforma(id, nombre);

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

		return plataformaEncontrada;
	}

	public static Modulo obtenerModulo(int idSoporte) {
		Modulo moduloEncontrado = null;
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM MODULO M "
					+ "JOIN PQRS ON M.ID = PQRS.ID_MODULO "
					+ "JOIN SOPORTE S ON S.ID_PQRS = PQRS.ID "
					+ "WHERE S.ID = "+idSoporte);

			//Recorrer todos los datos obtenidos de la sentencia SQL
			while (rset.next()) {
				int id = rset.getInt(1);
				String nombre = rset.getString(2);
				String descripcion = rset.getString(3);

				moduloEncontrado = new Modulo(id, nombre, descripcion);

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

		return moduloEncontrado;
	}

	public static TipoPQRS obtenerTipoPQRS(int idSoporte) {
		TipoPQRS tipoEncontrado = null;
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM TIPOPQRS T "
					+ "JOIN PQRS ON T.ID = PQRS.ID_TIPO "
					+ "JOIN SOPORTE S ON S.ID_PQRS = PQRS.ID "
					+ "WHERE S.ID = "+idSoporte);

			//Recorrer todos los datos obtenidos de la sentencia SQL
			while (rset.next()) {
				int id = rset.getInt(1);
				String nombre = rset.getString(2);
				String descripcion = rset.getString(3);

				tipoEncontrado = new TipoPQRS(id, nombre, descripcion);
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

		return tipoEncontrado;
	}

	public static PQRS obtenerPQRSSoporte(int idSoporte) {
		PQRS pqrsEncontrada = null;
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			rset = stm.executeQuery("SELECT * FROM PQRS "
					+ "JOIN SOPORTE S ON PQRS.ID = S.ID_PQRS "
					+ "WHERE S.ID = "+idSoporte);

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

				pqrsEncontrada = new PQRS(id, id_usuario, id_plataforma,
						id_modulo, id_tipo, detalles, asunto, fecha_solicitud, estado);
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

		return pqrsEncontrada;
	}

	public static void agregarRespuestaSoporte(int idSoporteSeleccionado, String respuesta, String estadoNew) {
		Soporte soporteEncontrado = obtenerSoporte(idSoporteSeleccionado);
		MySQLConnector conector = new MySQLConnector();
		Connection conexion = null;
		Statement stm = null;
		ResultSet rset = null;

		Date fecha_actualizacion = Date.valueOf(LocalDate.now());
		long diferencia = fecha_actualizacion.getTime() - soporteEncontrado.getFecha_creacion().getTime();
        long dias_respuesta = TimeUnit.DAYS.convert(diferencia, TimeUnit.MILLISECONDS);

		try {
			conexion = conector.conectar();
			stm = conexion.createStatement();
			String query = "UPDATE soporte SET respuesta = ?, estado = ?, fecha_ultima_actualizacion = ?, tiempo_respuesta = ? WHERE id = ?";

			PreparedStatement pstmt = conexion.prepareStatement(query);

			pstmt.setString(1, respuesta);
			pstmt.setString(2, estadoNew);
			pstmt.setDate(3, fecha_actualizacion);
			pstmt.setString(4, dias_respuesta+" dias");
			pstmt.setInt(5, idSoporteSeleccionado);

			JOptionPane.showMessageDialog(null, "Respuesta guardada y estado actualizado exitosamente, numero de columnas afectadas: "+pstmt.executeUpdate());

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
		enviarNotificacionSoporte(idSoporteSeleccionado, respuesta, estadoNew);
	}

	public static void enviarNotificacionSoporte(int idSoporteSeleccionado, String respuesta, String estadoNew) {
		Usuario usuario = obtenerUsuario(idSoporteSeleccionado);
		PQRS pqrs = obtenerPQRSSoporte(idSoporteSeleccionado);
		String email = usuario.getEmail();
		String asunto = "Actualización sobre el estado de su PQRS";
		String cuerpo = "Estimado "+usuario.getNombre()+",el soporte de su PQRS ha cambiado de estado a: "+estadoNew+"."
				+ "\nCon respecto al soporte realizado por usted el día: "+pqrs.getFecha_solicitud().toString()+""
				+ "\nSolicitud: \""+pqrs.getDetalles()+"\" "
				+ "\nRespuesta: "+respuesta;
		EmailService.enviarEmail(email, asunto, cuerpo);
	}

}
