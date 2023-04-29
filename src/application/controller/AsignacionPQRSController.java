package application.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.MainApp;
import application.model.Desarrollador;
import application.model.PQRS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AsignacionPQRSController {
	private MainApp aplicacion;
	private String email_asignador_ingresado;
	private ObservableList<PQRS> lstSolicitudesData = FXCollections.observableArrayList();
	private ObservableList<Desarrollador> lstDesarrolladorData = FXCollections.observableArrayList();
	private ObservableList<Desarrollador> lstDesarrolladorAsignadoData = FXCollections.observableArrayList();
	private PQRS PQRSSeleccionado;
	private Desarrollador desarrolladorSeleccionado;
	private Desarrollador desAsignadoSeleccionado;
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TableView<PQRS> tableSolicitudes;
    @FXML
    private TableColumn<String, PQRS> columnSolicitudAsunto;
    @FXML
    private TableColumn<String, PQRS> columnSolicitudTipo;
    @FXML
    private TableColumn<Date, PQRS> columnSolicitudFecha;
    @FXML
    private TableColumn<String, PQRS> columnSolicitudModulo;
    @FXML
    private TableColumn<String, PQRS> columnSolicitudPlataforma;
    @FXML
    private TableColumn<String, PQRS> columnSolicitudEstado;
    @FXML
    private TableColumn<String, PQRS> columnSolicitudUsuario;
    @FXML
    private TableColumn<String, PQRS> columnSolicitudId;
    @FXML
    private TableColumn<String, PQRS> columnSolicitudDetalles;
   
    @FXML
    private TableView<Desarrollador> tableDesAsignados;
    @FXML
    private TableColumn<Integer, Desarrollador> columnIdDesAsignado;
    @FXML
    private TableColumn<String, Desarrollador> columnNombreDesAsignado;
    @FXML
    private TableColumn<String, Desarrollador> columnCedulaDesAsignado;
    @FXML
    private TableColumn<String, Desarrollador> columnEstadoDesAsignado;

    
    @FXML
    private TableView<Desarrollador> tableDesarrolladores;  
    @FXML
    private TableColumn<Integer, Desarrollador> columnIdDes;
    @FXML
    private TableColumn<String, Desarrollador> columnEstadoDes;
    @FXML
    private TableColumn<String, Desarrollador> columnCedulaDes;
    @FXML
    private TableColumn<String, Desarrollador> columnNombreDes;

    @FXML
    private TextField labelInfoAsig;

    @FXML
    void finalizarAsignacion(ActionEvent event) {
    	tableDesAsignados.getItems().clear();
    	labelInfoAsig.setText("Soporte asignado");
    }

    @FXML
    void iniciarAsignacion(ActionEvent event) {
    	labelInfoAsig.setText("En asignacion");
    }

    @FXML
    void asignarDesarrollador(ActionEvent event) {
    	if ( PQRSSeleccionado != null && desarrolladorSeleccionado != null ) {
    		int idPQRSSeleccionado = this.PQRSSeleccionado.getId();
    		int idDesSeleccionado = this.desarrolladorSeleccionado.getId();
    		aplicacion.asignarSoporte(idPQRSSeleccionado,idDesSeleccionado );
    		getLstDesAsignadosSelecionado(idPQRSSeleccionado);
    		
		}else{
			JOptionPane.showMessageDialog(null, "Seleccione una PQRS y Un desarrollador");
		}
    }


    @FXML
    void desasignarDesarrollador(ActionEvent event) {
    	if ( PQRSSeleccionado != null && desAsignadoSeleccionado != null ) {
    		int idPQRSSeleccionado = this.PQRSSeleccionado.getId();
    		int idDesAsignadoSeleccionado = this.desAsignadoSeleccionado.getId();
    		aplicacion.desasignarSoporte(idPQRSSeleccionado,idDesAsignadoSeleccionado );
    		getLstDesAsignadosSelecionado(idPQRSSeleccionado);
		}else{
			JOptionPane.showMessageDialog(null, "Seleccione una PQRS y Un desarrollador");
		}
    }

    @FXML
    void volver(ActionEvent event) {
    	aplicacion.showModuleChoice("Usuario", email_asignador_ingresado, 0);
    }
    
    @FXML
    void initialize() {
    	//Inicializacion de columnas de la tabla de PQRS
    	columnSolicitudId.setCellValueFactory( new PropertyValueFactory<>("id") );
    	columnSolicitudUsuario.setCellValueFactory( new PropertyValueFactory<>("id_usuario") );
    	columnSolicitudPlataforma.setCellValueFactory( new PropertyValueFactory<>("id_plataforma") );
    	columnSolicitudModulo.setCellValueFactory( new PropertyValueFactory<>("id_modulo") );
    	columnSolicitudTipo.setCellValueFactory( new PropertyValueFactory<>("id_tipo") );
    	columnSolicitudDetalles.setCellValueFactory( new PropertyValueFactory<>("detalles") );
    	columnSolicitudAsunto.setCellValueFactory( new PropertyValueFactory<>("asunto") );
    	columnSolicitudFecha.setCellValueFactory( new PropertyValueFactory<>("fecha_solicitud") );
    	columnSolicitudEstado.setCellValueFactory( new PropertyValueFactory<>("estado") );
    	//Inicializacion de columnas de la tabla de Desarrolladores
    	columnIdDes.setCellValueFactory( new PropertyValueFactory<>("id") );
    	columnNombreDes.setCellValueFactory( new PropertyValueFactory<>("nombre") );
    	columnCedulaDes.setCellValueFactory( new PropertyValueFactory<>("cedula") );
    	columnEstadoDes.setCellValueFactory( new PropertyValueFactory<>("id_estado") );
    	//Inicializacion de columnas de la tabla de Desarrolladores Asignados
    	columnIdDesAsignado.setCellValueFactory( new PropertyValueFactory<>("id") );
    	columnNombreDesAsignado.setCellValueFactory( new PropertyValueFactory<>("nombre") );
    	columnCedulaDesAsignado.setCellValueFactory( new PropertyValueFactory<>("cedula") );
    	columnEstadoDesAsignado.setCellValueFactory( new PropertyValueFactory<>("id_estado") );
    	//Deteccion de PQRS
		tableSolicitudes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
		    this.PQRSSeleccionado = newValue;
		    getLstDesAsignadosSelecionado(newValue.getId());
		});
    	//Deteccion de Desarrolldor
		tableDesarrolladores.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
		    this.desarrolladorSeleccionado = newValue;
		});		
    	//Deteccion de Desarrolldor asignado
		tableDesAsignados.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
		    this.desAsignadoSeleccionado = newValue;
		});

    }
	private void getLstPQRS() {
		lstSolicitudesData.addAll(aplicacion.listaPQRS());
		tableSolicitudes.getItems().clear();
		tableSolicitudes.setItems(lstSolicitudesData);
	}
	private void getLstDes() {
		lstDesarrolladorData.addAll(aplicacion.listaDesarrolladores());
		tableDesarrolladores.getItems().clear();
		tableDesarrolladores.setItems(lstDesarrolladorData);
	}
	
	private void getLstDesAsignadosSelecionado(int idPQRSSeleccionada) {
		tableDesAsignados.getItems().clear();
		lstDesarrolladorAsignadoData.clear();
		lstDesarrolladorAsignadoData.addAll(aplicacion.listaDesAsignados(idPQRSSeleccionada));	
		tableDesAsignados.setItems(lstDesarrolladorAsignadoData);
		tableDesAsignados.refresh();
	}
	public void setMainApp(MainApp mainApp, String email_usuario_ingresado) {
		this.aplicacion = mainApp;
		this.email_asignador_ingresado = email_usuario_ingresado;
		getLstPQRS();
		getLstDes();
	}
}
