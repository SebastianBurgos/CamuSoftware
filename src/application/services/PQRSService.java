package application.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import application.model.PQRS;
import application.model.Usuario;
import java.util.ArrayList;
import application.persistence.MySQLConnector;

public class PQRSService {

	public static void crearPQRS(String email, String cedula, String asunto, String detalle, int idTipoSolicitud,
			int idPlataforma, int idModulo) {
		PQRS PQRSenviada = null;
		Usuario usuarioBuscar = UsuarioService.obtenerUsuarioCedula(cedula);
		Date fechaPQRS = Date.valueOf(LocalDate.now());
		String estado = "Nuevo";

		if (usuarioBuscar != null) {
			MySQLConnector conector = new MySQLConnector();
			Connection conexion = null;
			Statement stm = null;
			ResultSet rset = null;

			try {
				conexion = conector.conectar();
				stm = conexion.createStatement();
				String query = "INSERT INTO PQRS (id, id_usuario, id_plataforma, id_modulo, id_tipo, detalles, asunto, fecha_solicitud, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement pstmt = conexion.prepareStatement(query);

				pstmt.setInt(1, 0);
				pstmt.setInt(2, usuarioBuscar.getId());
				pstmt.setInt(3, idPlataforma);
				pstmt.setInt(4, idModulo);
				pstmt.setInt(5, idTipoSolicitud);
				pstmt.setString(6, detalle);
				pstmt.setString(7, asunto);
				pstmt.setDate(8, fechaPQRS);
				pstmt.setString(9, estado);

				JOptionPane.showMessageDialog(null,
						"PQRS agregada exitosamente, numero de columnas afectadas: " + pstmt.executeUpdate());

				PQRSenviada = new PQRS(0, usuarioBuscar.getId(), idPlataforma, idModulo, idTipoSolicitud, detalle,
						asunto, fechaPQRS, estado);

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
		} else {
			JOptionPane.showMessageDialog(null, "No se encontro el usuario");
		}

		if (PQRSenviada != null) {
			notificarSolicitudEnviada(usuarioBuscar, PQRSenviada);
		}

	}

	private static void notificarSolicitudEnviada(Usuario usuario, PQRS pqrs) {
		String email = usuario.getEmail();
		String asunto = "Actualización sobre el estado de su PQRS";
		String cuerpo = "Estimado " + usuario.getNombre() + ",el soporte de su PQRS ha cambiado de estado a: "
				+ pqrs.getEstado() + "." + "\nCon respecto al soporte realizado por usted el día: "
				+ pqrs.getFecha_solicitud().toString() + "" + "\nSolicitud: \"" + pqrs.getDetalles();
		EmailService.enviarEmail(email, asunto, cuerpo);
	}
	
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
