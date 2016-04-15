package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class BoardController {
	 	@FXML
	    private AnchorPane root ;
	 	
	 	@FXML
	 	private AnchorPane background;
	 	
	 	@FXML
	 	private AnchorPane overlay;
	 	
	 	@FXML
	 	private AnchorPane spaces;
	 	
	    private ChessUtil chess = new ChessUtil();

	    @FXML
	    private void peiceClick(MouseEvent event) {
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

	    public void initialize() {
	        disablePeicesToggle(chess.blackID, true);
	        ToggleOverlayTransparency();
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

	    public void disablePeicesToggle(String[] idSet, boolean disable)
	    {
	        Node peice;
	        for(int x = 0; x < 16 ;x++)
	        {
	            peice = root.lookup("#" + idSet[x]);
	            peice.setDisable(disable);
	        }

	    }
}

