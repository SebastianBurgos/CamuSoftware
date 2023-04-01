package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ModuleChoiceController {
	MainApp aplicacion;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblUsuarioIngresado;

    @FXML
    private Label lblRolUsuarioIngresado;

    @FXML
    void registrar(ActionEvent event) {

    }

    @FXML
    void ingresar(ActionEvent event) {
    	aplicacion.showLogin();
    }

    @FXML
    void ingresarModuloPQRS(ActionEvent event) {
    	aplicacion.showRegister();
    }

    @FXML
    void initialize() {

    }

	public void setMainApp(MainApp mainApp) {
		this.aplicacion = mainApp;
	}
}