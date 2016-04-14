package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;


public class Main extends Application {
	public Parent root;
	public ChessUtil chess = new ChessUtil();
	@Override
	public void start(Stage primaryStage) {
		try {
			root = FXMLLoader.load(getClass().getResource("/Chess.fxml"));
			Node peice;
			for(int x = 0; x < 16 ;x++)
			{
				peice = root.lookup("#" + chess.whiteID[x]);
				peice.addEventHandler(MouseEvent.MOUSE_CLICKED, peiceClick);
				peice = root.lookup("#" + chess.blackID[x]);
				peice.addEventHandler(MouseEvent.MOUSE_CLICKED, peiceClick);
			}
			disablePeicesToggle(chess.blackID, true);
			Scene scene = new Scene(root,740,740);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	EventHandler peiceClick = new EventHandler<InputEvent>() {
	    public void handle(InputEvent event) {
	    	String id = ((Node) event.getSource()).getId();
	    	ArrayList<String> moves = chess.findPeiceMoves(id);
	    	System.out.println(moves.size());
	    	if(moves.size() > 0)
	    	{
	    		System.out.println(moves);
	    	}
	        System.out.println("Handling event " + event.getEventType()); 
	        event.consume();
	    }
     };
    public void disablePeicesToggle(String[] idSet, boolean disable)
    {
    	Node peice;
    	for(int x = 0; x < 16 ;x++)
		{
			peice = root.lookup("#" + idSet[x]);
			peice.setDisable(disable);
		}
    	
    }
	public static void main(String[] args) {
		launch(args);
	}
}