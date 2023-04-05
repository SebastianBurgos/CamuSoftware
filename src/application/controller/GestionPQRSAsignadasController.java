package application.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.MainApp;
import application.model.Implementacion;
import application.model.Soporte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionPQRSAsignadasController {
	private MainApp aplicacion;
	private int idDesarrolladorIngresado;
	private Soporte soporteSeleccionado;
	private Implementacion implementacionSeleccionada;
	private ObservableList<Soporte> lstSoportesData = FXCollections.observableArrayList();
	private ObservableList<Implementacion> lstImplementacionesSoporteData = FXCollections.observableArrayList();

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Soporte> tableSoporteAsignado;
    @FXML
    private TableView<Implementacion> tableImplementacionesSoporte;

    @FXML
    private TableColumn<Integer, Soporte> columnIdSoporte;
    @FXML
    private TableColumn<Date, Soporte> columnUltimaActualizacionSoporte;
    @FXML
    private TableColumn<Date, Soporte> columnFechaSolicitudSoporte;
    @FXML
    private TableColumn<Integer, Implementacion> columnHorasImplementacion;
    @FXML
    private TableColumn<Date, Implementacion> columnFechaImplementacion;
    @FXML
    private TableColumn<String, Implementacion> columnEstadoImplementacion;
    @FXML
    private TableColumn<String, Implementacion> columnEspecificacionImplementacion;
    @FXML
    private TableColumn<Integer, Implementacion> columnIdImplementacion;
    @FXML
    private TableColumn<String, Soporte> columnEstadoSoporte;

    @FXML
    private TextField txtObservacionesSoporte;
    @FXML
    private TextField txtHorasImplementacion;
    @FXML
    private TextField txtEspecificacion;
    @FXML
    private TextField txtEstadoImplementacion;
    @FXML
    private TextArea txtRespuestaSoporte;
    @FXML
    private TextField txtEstadoSoporte;

    @FXML
    private DatePicker dateFechaImplementacion;

    @FXML
    void confirmarCambios(ActionEvent event) {

    }

    @FXML
    void agregarImplementacion(ActionEvent event) {
    	if (camposImplementacionRellenos() == true && soporteSeleccionado!=null) {
    		int idSoporteSeleccionado = this.soporteSeleccionado.getId();
    		aplicacion.agregarImplementacionSoporteSeleccionado(idSoporteSeleccionado,
    				txtEspecificacion.getText(), dateFechaImplementacion.getValue(), Integer.parseInt(txtHorasImplementacion.getText()),
    				txtEstadoImplementacion.getText());
    		getLstImplementacionesSoporteSeleccionado(idSoporteSeleccionado);
    		limpiarCamposImplementacion();
		}else{
			JOptionPane.showMessageDialog(null, "Rellene todos los campos y seleccione un soporte");
		}
    }

    private void limpiarCamposImplementacion() {
		txtEspecificacion.setText("");
		txtEstadoImplementacion.setText("");
		txtHorasImplementacion.setText("");
		dateFechaImplementacion.setValue(null);
	}

	private boolean camposImplementacionRellenos() {
		if (txtEspecificacion.getText().isEmpty()) {
			return false;
		}
		if (dateFechaImplementacion.getValue() == null) {
			return false;
		}
		if (txtHorasImplementacion.getText().isEmpty()) {
			return false;
		}
		try {
			Integer.parseInt(txtHorasImplementacion.getText());
		} catch (Exception e) {
			return false;
		}
		if (txtEstadoImplementacion.getText().isEmpty()) {
			return false;
		}
		return true;
	}

	@FXML
    void eliminarImplementacion(ActionEvent event) {

    }

    @FXML
    void actualizarImplementacion(ActionEvent event) {

    }

    @FXML
    void abrirPQRSSeleccionada(ActionEvent event){
    	if (soporteSeleccionado!=null) {
    		aplicacion.showDetallePQRS(soporteSeleccionado.getId());
		}else{
			JOptionPane.showMessageDialog(null, "Seleccione un soporte");
		}
    }

    @FXML
    void volver(ActionEvent event) {
    	aplicacion.showModuleChoice();
    }

    @FXML
    void initialize() {
    	//Inicializacion de columnas de la tabla de soportes asignados
    	columnIdSoporte.setCellValueFactory( new PropertyValueFactory<>("id") );
		columnEstadoSoporte.setCellValueFactory( new PropertyValueFactory<>("estado") );
		columnFechaSolicitudSoporte.setCellValueFactory( new PropertyValueFactory<>("fecha_creacion") );
		columnUltimaActualizacionSoporte.setCellValueFactory( new PropertyValueFactory<>("fecha_ultima_actualizacion") );

		//Inicializacion de columnas de la tabla de soportes asignados
    	columnIdImplementacion.setCellValueFactory( new PropertyValueFactory<>("id") );
		columnEstadoImplementacion.setCellValueFactory( new PropertyValueFactory<>("estado") );
		columnEspecificacionImplementacion.setCellValueFactory( new PropertyValueFactory<>("especificacion") );
		columnFechaImplementacion.setCellValueFactory( new PropertyValueFactory<>("fecha_implementacion") );
		columnHorasImplementacion.setCellValueFactory( new PropertyValueFactory<>("horas_invertidas") );

		//Deteccion de soporte seleccionado
		tableSoporteAsignado.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
		    this.soporteSeleccionado = newValue;
		    getLstImplementacionesSoporteSeleccionado(newValue.getId());
		});

		//Deteccion de implementacion seleccionada
		tableImplementacionesSoporte.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
		   this.implementacionSeleccionada = newValue;
		   if (implementacionSeleccionada!=null) {
			   mostrarDatosImplementacionSeleccionada();
		   }
		});
    }

    private void mostrarDatosImplementacionSeleccionada() {
    	txtEspecificacion.setText(implementacionSeleccionada.getEspecificacion());
    	txtEstadoImplementacion.setText(implementacionSeleccionada.getEstado());
    	txtHorasImplementacion.setText(String.valueOf(implementacionSeleccionada.getHoras_invertidas()));
    	dateFechaImplementacion.setValue(implementacionSeleccionada.getFecha_implementacion().toLocalDate());
	}

	/**
     * Metodo que muestra las implementaciones del soporte seleccionado en la tabla de
     * implementaciones
     * @param newValue
     */
	private void getLstImplementacionesSoporteSeleccionado(int idSoporteSeleccionado) {
		tableImplementacionesSoporte.getItems().clear();
		lstImplementacionesSoporteData.clear();
		lstImplementacionesSoporteData.addAll(aplicacion.listaImplementacionesSoporte(idSoporteSeleccionado));
		tableImplementacionesSoporte.setItems(lstImplementacionesSoporteData);
		tableImplementacionesSoporte.refresh();
	}

	/**
	 * Metodo que muestra la lista de soportes asignados al desarroolador logueado
	 */
	private void getLstSoportes() {
		this.idDesarrolladorIngresado = 2;
		lstSoportesData.addAll(aplicacion.listaSoportesAsignados(idDesarrolladorIngresado));
		tableSoporteAsignado.setItems(lstSoportesData);
	}

	public void setMainApp(MainApp mainApp) {
		this.aplicacion = mainApp;

		getLstSoportes();
	}
}
