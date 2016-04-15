package application;

import java.util.ArrayList;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Path;
import javafx.util.Duration;


public class BoardController {
	 	@FXML
	    private AnchorPane root ;
	 	
	 	@FXML
	 	private AnchorPane background;
	 	
	 	@FXML
	 	private AnchorPane overlay;
	 	
	 	@FXML
	 	private AnchorPane spaces;
	 	
	 	@FXML
	 	private Region w1;
	 	@FXML
	 	private Region w2;
	 	@FXML
	 	private Region w3;
	 	@FXML
	 	private Region w4;
	 	@FXML
	 	private Region w5;
	 	@FXML
	 	private Region w6;
	 	@FXML
	 	private Region w7;
	 	@FXML
	 	private Region w8;
	 	@FXML
	 	private Region w9;
	 	@FXML
	 	private Region w10;
	 	@FXML
	 	private Region w11;
	 	@FXML
	 	private Region w12;
	 	@FXML
	 	private Region w13;
	 	@FXML
	 	private Region w14;
	 	@FXML
	 	private Region w15;
	 	@FXML
	 	private Region w16;
	 	
	 	@FXML
	 	private Region b1;
	 	@FXML
	 	private Region b2;
	 	@FXML
	 	private Region b3;
	 	@FXML
	 	private Region b4;
	 	@FXML
	 	private Region b5;
	 	@FXML
	 	private Region b6;
	 	@FXML
	 	private Region b7;
	 	@FXML
	 	private Region b8;
	 	@FXML
	 	private Region b9;
	 	@FXML
	 	private Region b10;
	 	@FXML
	 	private Region b11;
	 	@FXML
	 	private Region b12;
	 	@FXML
	 	private Region b13;
	 	@FXML
	 	private Region b14;
	 	@FXML
	 	private Region b15;
	 	@FXML
	 	private Region b16;
	 	
	    private ChessUtil chess = new ChessUtil();
	    
	    private MoveInfo mov = new MoveInfo();
	    
	    private PathTransition pathTransition;

	    @FXML
	    private void peiceClick(MouseEvent event) {
	        String id = ((Node) event.getSource()).getId();
	        ArrayList<String> moves = chess.findPeiceMoves(id);
	        if(moves.size() > 0)
	        {
	        	mov.setPeiceId(id);
	        	mov.setOpts(moves);
	        	for(int x = 0; x < moves.size(); x++)
	        	{
	        		if(chess.checkForPeice( moves.get(x)))
	        		{
	        			setMoveStyle(moves.get(x), 'c');
	        		}
	        		else
	        		{
	        			setMoveStyle(moves.get(x), 'm');
	        		}
	        	}
	        	ToggleOverlayTransparency();
	        	disablePeicesToggle(moves, false);
	            System.out.println(moves);
	        }
	        System.out.println("Handling event " + event.getEventType()); 
	        event.consume();
	    }
	    
	    @FXML
	    private void moveClick(MouseEvent event) {
	        String id = ((Node) event.getSource()).getId();
	        Path p = chess.getPath(mov.getPeiceId(), id);
	        setPathTransition(mov.getPeiceId(), p);
	        pathTransition.setInterpolator(Interpolator.LINEAR);
	        pathTransition.setOnFinished(e->OutPut());
	        for(int x = 0; x < mov.getOpts().size(); x++)
	        {
	        	setMoveStyle(mov.getOpts().get(x), 'r');
	        }
        	disablePeicesToggle(mov.getOpts(), true);
        	ToggleOverlayTransparency();
        	pathTransition.playFromStart();
	        System.out.println("Handling event " + event.getEventType()); 
	        event.consume();
	    }
	    
	    public void setPathTransition(String id, Path p)
	    {
	    	switch(id)
	    	{
		    	case "w1":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w1);
		    		break;
		    	case "w2":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w2);
		    		break;
		    	case "w3":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w3);
		    		break;
		    	case "w4":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w4);
		    		break;
		    	case "w5":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w5);
		    		break;
		    	case "w6":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w6);
		    		break;
		    	case "w7":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w7);
		    		break;
		    	case "w8":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w8);
		    		break;
		    	case "w9":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w9);
		    		break;
		    	case "w10":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w10);
		    		break;
		    	case "w11":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w11);
		    		break;
		    	case "w12":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w12);
		    		break;
		    	case "w13":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w13);
		    		break;
		    	case "w14":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w14);
		    		break;
		    	case "w15":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w15);
		    		break;
		    	case "w16":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, w16);
		    		break;
		    	case "b1":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b1);
		    		break;
		    	case "b2":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b2);
		    		break;
		    	case "b3":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b3);
		    		break;
		    	case "b4":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b4);
		    		break;
		    	case "b5":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b5);
		    		break;
		    	case "b6":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b6);
		    		break;
		    	case "b7":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b7);
		    		break;
		    	case "b8":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b8);
		    		break;
		    	case "b9":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b9);
		    		break;
		    	case "b10":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b10);
		    		break;
		    	case "b11":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b11);
		    		break;
		    	case "b12":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b12);
		    		break;
		    	case "b13":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b13);
		    		break;
		    	case "b14":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b14);
		    		break;
		    	case "b15":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b15);
		    		break;
		    	case "b16":
		    		pathTransition = new PathTransition(Duration.millis(4000), p, b16);
		    		break;
	    	}
	    }
	    public void OutPut()
	    {
	    	System.out.println("Animation is 'Runnung'.");
	    }
	    public void initialize() {
	        disablePeicesToggle(chess.blackID, true);
	        disablePeicesToggle(chess.spaceID, true);
	        ToggleOverlayTransparency();
	        System.out.println(chess.spaceID); 
	    }
	    public void ToggleOverlayTransparency()
	    {
	    	if(overlay.isMouseTransparent())
	    	{
	    		overlay.setMouseTransparent(false);
	    	}
	    	else
	    	{
	    		overlay.setMouseTransparent(true);
	    	}
	    }
	    public void setMoveStyle(String id, char styleCode)
	    {
	    	Node location = root.lookup("#" + id);
	    	switch(styleCode)
	    	{
		    	case 'm':
		    		location.setStyle("-fx-background-color:rgba(255,255,0,.5);");
		    		break;
		    	case 'c':
		    		location.setStyle("-fx-background-color:rgba(255,0,0,.5);");
		    		break;
		    	case 'r':
		    	default:
		    		location.setStyle("-fx-background-color:rgba(255,255,255,0);");
	    			
	    	}
	    }
	    public void disablePeicesToggle(String[] idSet, boolean disable)
	    {
	        Node peice;
	        for(int x = 0; x < idSet.length ;x++)
	        {
	            peice = root.lookup("#" + idSet[x]);
	            peice.setDisable(disable);
	        }

	    }
	    public void disablePeicesToggle(ArrayList<String> idSet, boolean disable)
	    {
	        Node peice;
	        for(int x = 0; x < idSet.size(); x++)
	        {
	            peice = root.lookup("#" + idSet.get(x));
	            peice.setDisable(disable);
	        }

	    }
}

