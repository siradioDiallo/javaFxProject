package application;
	
import controllers.DbConnection;
import controllers.MainController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import models.Etudiant;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
	MainController controller = new MainController();
	
	}
	
	@Override
	public void init() throws Exception {
		super.init();
		if(!DbConnection.getInstance().open()) {
			System.out.println("FATAL ERROR: Couldn't connect to database");
			Platform.exit();
		}
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		DbConnection.getInstance().close();
		Platform.exit();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
