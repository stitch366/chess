package loader;
	

import general.Global;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application { 
	@Override
	public void start(Stage primaryStage) {
		 try {
	            Parent root = new GameSelect();
	            Scene scene = new Scene(root);
	            scene.getStylesheets().add(getClass().getResource(Global.getThemeStylesheetPath()).toExternalForm());
	            primaryStage.setScene(scene);
	            primaryStage.setWidth(1102);
	            primaryStage.setHeight(749);
	            primaryStage.setResizable(false);
	            primaryStage.show();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
