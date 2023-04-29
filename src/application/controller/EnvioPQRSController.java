package application.controller;

import application.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class EnvioPQRSController {
	private MainApp aplicacion;
	private String email_usuario_ingresado;




    @FXML
    private ComboBox<String> cbTipoSolicitud;

    @FXML
    void volver(ActionEvent event) {
    	aplicacion.showModuleChoice("Usuario", email_usuario_ingresado, 0);
    }

	public void setMainApp(MainApp mainApp, String email_usuario_ingresado) {
		this.aplicacion = mainApp;
		this.email_usuario_ingresado = email_usuario_ingresado;
	}

}
