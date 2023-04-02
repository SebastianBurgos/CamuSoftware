package application;

import java.io.IOException;

import application.controller.ModuleChoiceController;
import application.model.Constructora;
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
    private Constructora constructora = new Constructora();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Camu Software");

        cargarIcono();
        initRootLayout();
        showModuleChoice();
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
     */
    public void showModuleChoice() {
        try {
            // Carga del fxml de eleccion de modulo.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ModuleChoiceView.fxml"));
            AnchorPane login = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(login);

            // Give the controller access to the main app.
            ModuleChoiceController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para abrir la ventana de login
     */
	public void showLogin() {

	}

	/**
	 * Metodo para abrir la ventana de registro
	 */
	public void showRegister() {
		// TODO Auto-generated method stub

	}

}
