package application.controller;

import javax.swing.JOptionPane;

import application.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EnvioPQRSController {
	private MainApp aplicacion;
	private String email_usuario_ingresado;

	@FXML
	private ComboBox<String> comboBoxTipoSolicitud;

	@FXML
	private ComboBox<String> comboBoxModulo;

	@FXML
	private ComboBox<String> comboBoxPlataforma;

	@FXML
	private TextArea txtDetalle;

	@FXML
	private TextField txtAsunto;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtEstadoPQRS;

	@FXML
	private TextField txtNumeroIdentificacion;

	// Se crea una variable tipo observableList para agregar las opciones de los
	// combo box
	private ObservableList<String> listTipoSolicitud = FXCollections.observableArrayList("Petición", "Queja", "Reclamo",
			"Sugerencia");
	private ObservableList<String> listPlatforma = FXCollections.observableArrayList("Web", "Móvil", "Escritorio");
	private ObservableList<String> listModulo = FXCollections.observableArrayList("Contabilidad", "Proyectos",
			"Contratos", "Recursos humanos", "Inventario");

	@FXML
	void EnviarSolicitud(ActionEvent event) {
		try {
			//varificamos que todos los campos esten correctamente llenos
			if (camposRellenos() == true && verificarComboBoxTipoSolicitud() != 0 && verificarComboBoxPlataforma() != 0
					&& verificarComboBoxModulo() != 0) {
				String email = this.txtEmail.getText();
				String cedula = this.txtNumeroIdentificacion.getText();
				String asunto = this.txtAsunto.getText();
				String detalle = this.txtDetalle.getText();
				
				//Creacion de la PQRS
				aplicacion.enviarSolicitud(email, cedula, asunto, detalle, verificarComboBoxTipoSolicitud(),
						verificarComboBoxPlataforma(), verificarComboBoxModulo());
				
				this.txtEstadoPQRS.setText("(Enviado) Nuevo");
				
				limpiarCamposPQRS();
			} else {
				// Si no se han ingresado todos los datos se hace una excepcion
				throw new Exception();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Rellene todos los campos correctamente \ny seleccione una de las opciones de cada una de las listas desplegables");
			this.txtEstadoPQRS.setText("En espera");
		}
	}

	// metodo que se utiliza para verificar que los campos se rellenen de manera
	// correcta
	private boolean camposRellenos() {
		String email = this.txtEmail.getText();
		String cedula = this.txtNumeroIdentificacion.getText();
		String asunto = this.txtAsunto.getText();
		String detalle = this.txtDetalle.getText();

		if (email.isEmpty()) {
			return false;
		}
		if (cedula.isEmpty()) {
			System.out.println(cedula);
			System.out.println(cedula.isEmpty());
			return false;
		}
		if (asunto.isEmpty()) {
			
			return false;
		}
		if (detalle.isEmpty()) {
				return false;
		}
		return true;
	}

	// Verificamos que se este seleccionando una opcion del combo box tipo de
	// solicitud
	// y se retorna el numero de id de cada tipo de solicitud
	private int verificarComboBoxTipoSolicitud() {
		if (this.comboBoxTipoSolicitud.getSelectionModel().getSelectedItem().equals("Petición")) {
			return 1;
		}
		if (this.comboBoxTipoSolicitud.getSelectionModel().getSelectedItem().equals("Queja")) {
			return 2;
		}
		if (this.comboBoxTipoSolicitud.getSelectionModel().getSelectedItem().equals("Reclamo")) {
			return 3;
		}
		if (this.comboBoxTipoSolicitud.getSelectionModel().getSelectedItem().equals("Sugerencia")) {
			return 4;
		}
		return 0;
	}

	// Verifiacmos que se este seleccionando una opcion del combo box plataforma
	// y se retorna el numero de id de cada plataforma
	private int verificarComboBoxPlataforma() {
		if (this.comboBoxPlataforma.getSelectionModel().getSelectedItem().equals("Web")) {
			return 1;
		}
		if (this.comboBoxPlataforma.getSelectionModel().getSelectedItem().equals("Móvil")) {
			return 2;
		}
		if (this.comboBoxPlataforma.getSelectionModel().getSelectedItem().equals("Escritorio")) {
			return 3;
		}
		return 0;
	}

	// Verifiacmos que se este seleccionando una opcion del combo box modulo
	// y se retorna el numero de id de cada modulo
	private int verificarComboBoxModulo() {
		if (this.comboBoxModulo.getSelectionModel().getSelectedItem().equals("Contabilidad")) {
			return 1;
		}
		if (this.comboBoxModulo.getSelectionModel().getSelectedItem().equals("Proyectos")) {
			return 2;
		}
		if (this.comboBoxModulo.getSelectionModel().getSelectedItem().equals("Contratos")) {
			return 3;
		}
		if (this.comboBoxModulo.getSelectionModel().getSelectedItem().equals("Recursos humanos")) {
			return 4;
		}
		if (this.comboBoxModulo.getSelectionModel().getSelectedItem().equals("Inventario")) {
			return 5;
		}
		return 0;
	}
	
	private void limpiarCamposPQRS() {
		this.txtEmail.setText("");
		this.txtNumeroIdentificacion.setText("");
		this.txtAsunto.setText("");
		this.txtDetalle.setText("");
		this.txtEstadoPQRS.setText("");
	}

	/**
	 * TODO
	 *
	 *
	 * ACA PONGA TOOD LO DE SU CONTROLADOR Y LOS METODOS
	 *
	 *
	 * @param mainApp
	 */

	@FXML
	void volver(ActionEvent event) {
		aplicacion.showModuleChoice("Usuario", email_usuario_ingresado, 0);
	}

	public void setMainApp(MainApp mainApp, String email_usuario_ingresado) {
		this.aplicacion = mainApp;
		this.email_usuario_ingresado = email_usuario_ingresado;

		// Se inicializan todos los datos de los combo box
		this.comboBoxTipoSolicitud.setItems(listTipoSolicitud);
		this.comboBoxPlataforma.setItems(listPlatforma);
		this.comboBoxModulo.setItems(listModulo);
	}

}
