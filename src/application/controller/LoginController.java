package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

public class LoginController {
	private MainApp aplicacion;
	private String usuario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private SplitMenuButton splitRol;

    @FXML
    void ingresar(ActionEvent event) {
    	if (camposRellenos()) {
    		String email = txtEmail.getText();
    		String password = txtPassword.getText();
    		if (this.usuario.equals("user")) {
    			if (aplicacion.ingresarUsuario(email, password)) {
    				aplicacion.showModuleChoice("Usuario", email, 0);
				}else{
					JOptionPane.showMessageDialog(null, "Usuario no encontrado o contraseña invalida");
				}
			}
    		if (this.usuario.equals("dev")) {
    			if (aplicacion.ingresarDesarrollador(email, password)) {
    				int id_desarrollador = aplicacion.buscarDesarrolladorEmail(email);
    				aplicacion.showModuleChoice("Desarrollador", email, id_desarrollador);
				}else{
					JOptionPane.showMessageDialog(null, "Desarrollador no encontrado o contraseña invalida");
				}
			}
    		if (this.usuario.equals("asig")) {
    			if (email.equals("asignador@gmail") && password.equals("asignador")) {
    				aplicacion.showModuleChoice("Asignador", "asignador@gmail", 0);
				}else{
					JOptionPane.showMessageDialog(null, "Asignador no encontrado o contraseña invalida");
				}

			}
		}else{
			JOptionPane.showMessageDialog(null, "Rellene todos los campos y elija un rol");
		}

    }

    private boolean camposRellenos() {
		if (txtEmail.getText().isEmpty()) {
			return false;
		}
		if (txtPassword.getText().isEmpty()) {
			return false;
		}
		if (splitRol.equals("Seleccione un rol") || this.usuario == null) {
			return false;
		}
		return true;
	}


    @FXML
    void cambiarRolUsuario(ActionEvent event) {
    	splitRol.setText("Usuario");
    	this.usuario = "user";
    }

    @FXML
    void cambiarRolDesarrollador(ActionEvent event) {
    	splitRol.setText("Desarrollador");
    	this.usuario = "dev";
    }

    @FXML
    void cambiarRolAsignador(ActionEvent event) {
    	splitRol.setText("Asignador");
    	this.usuario = "asig";
    }

	@FXML
    void volver(ActionEvent event) {
    	aplicacion.showModuleChoice(null, null, 0);
    }

    @FXML
    void initialize() {

    }

	public void setMainApp(MainApp mainApp) {
		this.aplicacion = mainApp;
	}

}
