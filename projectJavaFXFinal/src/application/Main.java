package application;
	
import controllers.DbConnection;
import controllers.MainController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Etudiant;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
	//MainController controller = new MainController();
		
		try {
			//	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/home/fxml/Main.fxml"));
				Parent root = FXMLLoader.load(getClass().getResource("/views/Main.fxml"));
				 Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
				primaryStage.initStyle(StageStyle.DECORATED);
				
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
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
		DbConnection.getInstance().close();
		Platform.exit();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
