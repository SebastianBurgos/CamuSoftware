package application.controller;

import application.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class EnvioPQRSController {
	private MainApp aplicacion;
	private String email_usuario_ingresado;

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
	}

}
