package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainApp;
import application.model.Modulo;
import application.model.PQRS;
import application.model.Plataforma;
import application.model.TipoPQRS;
import application.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetallePQRSController {
	private MainApp aplicacion;
	private int idSoporte;

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Label lblEstado;
    @FXML
    private Label lblId;
    @FXML
    private Label lblFecha;
    @FXML
    private Label lblPlataforma;
    @FXML
    private Label lblAsunto;
    @FXML
    private Label lblCedula;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblDetalles;
    @FXML
    private Label lblModulo;
    @FXML
    private Label lblTipo;

    @FXML
    void initialize() {

    }

	public void setMainApp(MainApp mainApp, int idSoporte) {
		this.aplicacion = mainApp;
		this.idSoporte = idSoporte;

		showDetallesSoporte();
	}

	private void showDetallesSoporte() {
		PQRS pqrs = aplicacion.obtenerPQRSSoporte(idSoporte);
		Usuario usuario = aplicacion.obtenerUsuarioSoporte(idSoporte);
		Plataforma plataforma = aplicacion.obtenerPlataformaSoporte(idSoporte);
		Modulo modulo = aplicacion.obtenerModuloSoporte(idSoporte);
		TipoPQRS tipoPQRS = aplicacion.obtenerTipoPQRSSoporte(idSoporte);

		lblId.setText(idSoporte+"");
		lblCedula.setText(usuario.getCedula());
		lblEmail.setText(usuario.getEmail());
		lblPlataforma.setText(plataforma.getNombre());
		lblModulo.setText(modulo.getNombre());
		lblTipo.setText(tipoPQRS.getNombre());
		lblDetalles.setText(pqrs.getDetalles());
		lblAsunto.setText(pqrs.getAsunto());
		lblEstado.setText(pqrs.getEstado());
		lblFecha.setText(pqrs.getFecha_solicitud().toString());

	}
}
