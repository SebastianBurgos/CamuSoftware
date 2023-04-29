package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ModuleChoiceController {
	private MainApp aplicacion;
	private String rol;
	private String email;
	private int id_ingresado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblUsuarioIngresado;

    @FXML
    private Label lblRolUsuarioIngresado;

    @FXML
    private Label lblBienvenido;

    @FXML
    private Button btnSoporte;

    @FXML
    void ingresar(ActionEvent event) {
    	aplicacion.showLogin();
    }

    @FXML
    void ingresarModuloPQRS(ActionEvent event) {
    	if (rol.equals("Usuario")) {
    		aplicacion.showEnvioPQRS(email);
		}
    	if (rol.equals("Desarrollador")) {
    		aplicacion.showGestionPQRSAsignadas(id_ingresado, email);
		}
    	if (rol.equals("Asignador")) {
    		aplicacion.showAsignacionPQRS(email);
		}
    }

    @FXML
    void initialize() {

    }

	public void setMainApp(MainApp mainApp, String rol, String email, int id) {
		this.aplicacion = mainApp;
		if (rol != null) {
			this.btnSoporte.setDisable(false);
			this.lblBienvenido.setVisible(true);
			this.lblRolUsuarioIngresado.setText(rol+":");
			this.lblUsuarioIngresado.setText(email);
			this.rol = rol;
			this.email = email;
			this.id_ingresado = id;
		}
	}
}