package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainApp;
import application.model.Soporte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GestionPQRSAsignadasController {
	MainApp aplicacion;

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtRespuestaSoporte;

    @FXML
    private TextField txtEstadoSoporte;

    @FXML
    private TableColumn<?, ?> columnHorasImplementacion;

    @FXML
    private TableColumn<Integer, Soporte> columnIdSoporte;

    @FXML
    private TableColumn<?, ?> columnFechaImplementacion;

    @FXML
    private TextField txtObservacionesSoporte;

    @FXML
    private TextField txtHorasImplementacion;

    @FXML
    private TextField txtEspecificacion;

    @FXML
    private TableColumn<?, ?> columnDetallesSoporte;

    @FXML
    private TextField txtEstadoImplementacion;

    @FXML
    private TableColumn<?, ?> columnEstadoImplementacion;

    @FXML
    private TableColumn<?, ?> columnEspecificacionImplementacion;

    @FXML
    private TableView<?> tableSoporteAsignado;

    @FXML
    private DatePicker dateFechaImplementacion;

    @FXML
    private TableColumn<?, ?> columnEstadoSoporte;

    @FXML
    private TableView<?> tableImplementacionesSoporte;

    @FXML
    private TableColumn<?, ?> columnIdImplementacion;

    @FXML
    void confirmarCambios(ActionEvent event) {

    }

    @FXML
    void agregarImplementacion(ActionEvent event) {

    }

    @FXML
    void eliminarImplementacion(ActionEvent event) {

    }

    @FXML
    void actualizarImplementacion(ActionEvent event) {

    }

    @FXML
    void volver(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert tableSoporteAsignado != null : "fx:id=\"tableSoporteAsignado\" was not injected: check your FXML file 'GestionPQRSAsignadasView.fxml'.";
        assert tableImplementacionesSoporte != null : "fx:id=\"tableImplementacionesSoporte\" was not injected: check your FXML file 'GestionPQRSAsignadasView.fxml'.";

    }

	public void setMainApp(MainApp mainApp) {
		this.aplicacion = mainApp;
	}
}
