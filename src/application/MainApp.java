package application;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import application.controller.AsignacionPQRSController;
import application.controller.DetallePQRSController;
import application.controller.EnvioPQRSController;
import application.controller.GestionPQRSAsignadasController;
import application.controller.LoginController;
import application.controller.ModuleChoiceController;
import application.model.PQRS;
import application.model.Implementacion;
import application.model.Modulo;
import application.model.Plataforma;
import application.model.Soporte;
import application.model.TipoPQRS;
import application.model.Usuario;
import application.services.DesarrolladorService;
import application.services.ImplementacionService;
import application.services.SoporteAsignadoService;
import application.services.SoporteService;
import application.services.UsuarioService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Camu Software");

        cargarIcono();
        initRootLayout();
        showModuleChoice(null, null, 0);

//        Descomentar para prueba funcional rapida de gestion pqrs
//        showGestionPQRSAsignadas(2, "erochelle1@guardian.co.uk");
    }

	/**
	 * Returns the main stage.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Metodo que muestra el icono en la ventana que se este mostrando
     */
    private void cargarIcono() {
    	Image logoImage = new Image(getClass().getResource("view/images/logo.png").toExternalForm());
        this.primaryStage.getIcons().add(logoImage);
	}

	/**
     * Inicializa el layout raiz.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra la pantalla inicial para iniciar el módulo de soporte
     * @param email
     * @param rol
     * @param id_desarrollador
     */
    public void showModuleChoice(String rol, String email, int id) {
    	try {
            // Carga del fxml de eleccion de modulo.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ModuleChoiceView.fxml"));
            AnchorPane moduleChoice = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.

            primaryStage.setMinHeight(380);
            primaryStage.setMinWidth(660);
            rootLayout.setCenter(moduleChoice);

            // Give the controller access to the main app.
            ModuleChoiceController controller = loader.getController();
            controller.setMainApp(this, rol, email, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para abrir la ventana de login
     */
	public void showLogin() {
		try {
            // Carga del fxml de eleccion de modulo.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LoginView.fxml"));
            AnchorPane moduleChoice = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.

            primaryStage.setMinHeight(400);
            primaryStage.setMinWidth(580);
            primaryStage.setMaxHeight(400);
            primaryStage.setMaxWidth(580);
            rootLayout.setCenter(moduleChoice);

            // Give the controller access to the main app.
            LoginController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void showRegister() {
		// TODO Auto-generated method stub

	}

	public void showGestionPQRSAsignadas(int id_desarrollador, String email){

		try {
            // Carga del fxml de eleccion de modulo.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/GestionSolicitudes.fxml"));
            AnchorPane gestionPQRS = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            primaryStage.setMinHeight(680);
            primaryStage.setMinWidth(1025);
            rootLayout.setCenter(gestionPQRS);

            // Give the controller access to the main app.
            GestionPQRSAsignadasController controller = loader.getController();
            controller.setMainApp(this, id_desarrollador, email);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void showDetallePQRS(int idSoporte){

		try {
            // Carga del fxml de eleccion de modulo.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/DetallePQRSView.fxml"));
            AnchorPane detallePQRS = (AnchorPane) loader.load();

    		// Create the dialog Stage.
    		Stage dialogStage = new Stage();
    		dialogStage.setTitle("Edit Person");
    		dialogStage.getIcons().add( new Image(getClass().getResource("view/images/logo.png").toExternalForm()) );
    		dialogStage.initOwner(primaryStage);
    		Scene scene = new Scene(detallePQRS);
    		dialogStage.setScene(scene);

            // Give the controller access to the main app.
            DetallePQRSController controller = loader.getController();
            controller.setMainApp(this, idSoporte);

            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void showEnvioPQRS(String email_usuario_ingresado) {
		try {
            // Carga del fxml de eleccion de modulo.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EnvioPQRSView.fxml"));
            AnchorPane gestionPQRS = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            primaryStage.setMinHeight(540);
            primaryStage.setMinWidth(780);
            rootLayout.setCenter(gestionPQRS);

            // Give the controller access to the main app.
            EnvioPQRSController controller = loader.getController();
            controller.setMainApp(this, email_usuario_ingresado);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void showAsignacionPQRS(String email_asignador_ingresado) {
		try {
            // Carga del fxml de eleccion de modulo.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AsignacionPQRSView.fxml"));
            AnchorPane gestionPQRS = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            primaryStage.setMinHeight(620);
            primaryStage.setMinWidth(1000);
            rootLayout.setCenter(gestionPQRS);

            // Give the controller access to the main app.
            AsignacionPQRSController controller = loader.getController();
            controller.setMainApp(this, email_asignador_ingresado);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	/**
	 * Metodo para obtener la lista de osportes asignados a un desarrollador segun su id
	 * @param id_desarrollador
	 * @return
	 */
	public ArrayList<Soporte> listaSoportesAsignados(int id_desarrollador){
		return SoporteAsignadoService.listaSoportesAsignados(id_desarrollador);
	}

	public ArrayList<Implementacion> listaImplementacionesSoporte(int id_soporte){
		return ImplementacionService.listaImplementacionesSoporte(id_soporte);
	}

	public void agregarImplementacionSoporteSeleccionado(int idSoporteSeleccionado,
			String especificacion, LocalDate fecha, int horas, String estado) {
		ImplementacionService.agregarImplementacionSoporteSeleccionado(idSoporteSeleccionado,
				especificacion, fecha, horas, estado);
	}

	public void actualizarImplementacionSeleccionada(int idImplementacionSeleccionada, int idSoporteSeleccionado,
			String especificacionNew, LocalDate fechaNew, int horasNew, String estadoNew) {
		ImplementacionService.actualizarImplementacionSeleccionada(idImplementacionSeleccionada, idSoporteSeleccionado,
				especificacionNew, fechaNew, horasNew, estadoNew);
	}

	public void eliminarImplementacionSeleccionada(int idImplementacionSeleccionada) {
		ImplementacionService.eliminarImplementacionSeleccionada(idImplementacionSeleccionada);
	}

	public Usuario obtenerUsuarioSoporte(int idSoporte) {
		return SoporteService.obtenerUsuario(idSoporte);
	}

	public Plataforma obtenerPlataformaSoporte(int idSoporte) {
		return SoporteService.obtenerPlataforma(idSoporte);
	}

	public Modulo obtenerModuloSoporte(int idSoporte) {
		return SoporteService.obtenerModulo(idSoporte);
	}

	public TipoPQRS obtenerTipoPQRSSoporte(int idSoporte) {
		return SoporteService.obtenerTipoPQRS(idSoporte);
	}

	public PQRS obtenerPQRSSoporte(int idSoporte) {
		return SoporteService.obtenerPQRSSoporte(idSoporte);
	}

	public boolean ingresarUsuario(String email, String password) {
		return UsuarioService.ingresar(email, password);
	}

	public boolean ingresarDesarrollador(String email, String password) {
		return DesarrolladorService.ingresar(email, password);

	}

	public int buscarDesarrolladorEmail(String email) {
		return DesarrolladorService.buscarDesarrolladorEmail(email);
	}

	public void agregarRespuestaSoporte(int idSoporteSeleccionado, String respuesta, String estadoNew) {
		SoporteService.agregarRespuestaSoporte(idSoporteSeleccionado, respuesta, estadoNew);
	}

}
