package application;

import java.util.ArrayList;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Path;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;


public class BoardController {
	 	@FXML
	    private AnchorPane root;
	 	
	 	@FXML
	 	private Button KingSide;
	 	
	 	@FXML
	 	private Button QueenSide;
	 	
	 	@FXML
	    private AnchorPane board;
	 	
	 	@FXML
	    private AnchorPane TurnPanel;
	 	
	 	@FXML
	    private AnchorPane dialogArea;
	 	
	 	@FXML
	 	private AnchorPane background;
	 	
	 	@FXML
	 	private AnchorPane overlay;
	 	
	 	@FXML
	 	private AnchorPane spaces;
	 	
	 	@FXML
	    private Button TurnProcesser;
	 	
	 	@FXML
	    private Button TurnProcesser2;
	 	
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
	    
	    private ArrayList<String> capturedPeices = new ArrayList<String> ();
	    
	    private String CurrentTurn = "White";
	    
	    private PathTransition pathTransition;
	    
	    private PathTransition pathTransition2;


	    @FXML
	    private void peiceClick(MouseEvent event) {
	        String id = ((Node) event.getSource()).getId();
	        ((Node) event.getSource()).toFront();
	        ArrayList<String> moves = chess.findPeiceMoves(id);
	        if(moves.size() > 0)
	        {
	        	mov.setPeiceId(id);
	        	mov.setOpts(moves);
	        	setMoveStyle(chess.getPeiceLocation(id), 'p');
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
	        mov.setLocation(id);
	        setMoveStyle(chess.getPeiceLocation(mov.getPeiceId()), 'r');
	        Path p = chess.getPath(mov.getPeiceId(), id);
	        if(chess.checkForPeice(id))
	        {
	        	mov.setCapturedPeice(chess.getSpacePeice(id));
	        }
	        setPathTransition(mov.getPeiceId(), p);
	        chess.doMove(mov.getPeiceId(), id);
	        
	        pathTransition.setInterpolator(Interpolator.LINEAR);
	        pathTransition.setOnFinished(e->AfterPeiceMove());
	        for(int x = 0; x < mov.getOpts().size(); x++)
	        {
	        	setMoveStyle(mov.getOpts().get(x), 'r');
	        }
        	disablePeicesToggle(mov.getOpts(), true);
        	ToggleOverlayTransparency();
        	//ChangeTurn();
        	pathTransition.playFromStart();
	        System.out.println("Handling event " + event.getEventType()); 
	        event.consume();
	    }
	    
	    public void RemovePeice(String id)
	    {
	    	chess.removeCapturedPeice(id);
	    	switch(id)
	    	{
		    	case "w1":
		    		w1.toBack();
		    		w1.setVisible(false);
		    		w1.setManaged(false);
		    		break;
		    	case "w2":
		    		w2.toBack();
		    		w2.setVisible(false);
		    		w2.setManaged(false);
		    		break;
		    	case "w3":
		    		w3.toBack();
		    		w3.setVisible(false);
		    		w3.setManaged(false);
		    		break;
		    	case "w4":
		    		w4.toBack();
		    		w4.setVisible(false);
		    		w4.setManaged(false);
		    		break;
		    	case "w5":
		    		w5.toBack();
		    		w5.setVisible(false);
		    		w5.setManaged(false);
		    		break;
		    	case "w6":
		    		w6.toBack();
		    		w6.setVisible(false);
		    		w6.setManaged(false);
		    		break;
		    	case "w7":
		    		w7.toBack();
		    		w7.setVisible(false);
		    		w7.setManaged(false);
		    		break;
		    	case "w8":
		    		w8.toBack();
		    		w8.setVisible(false);
		    		w8.setManaged(false);
		    		break;
		    	case "w9":
		    		w9.toBack();
		    		w9.setVisible(false);
		    		w9.setManaged(false);
		    		break;
		    	case "w10":
		    		w10.toBack();
		    		w10.setVisible(false);
		    		w10.setManaged(false);
		    		break;
		    	case "w11":
		    		w11.toBack();
		    		w11.setVisible(false);
		    		w11.setManaged(false);
		    		break;
		    	case "w12":
		    		w12.toBack();
		    		w12.setVisible(false);
		    		w12.setManaged(false);
		    		break;
		    	case "w13":
		    		w13.toBack();
		    		w13.setVisible(false);
		    		w13.setManaged(false);
		    		break;
		    	case "w14":
		    		w14.toBack();
		    		w14.setVisible(false);
		    		w14.setManaged(false);
		    		break;
		    	case "w15":
		    		w15.toBack();
		    		w15.setVisible(false);
		    		w15.setManaged(false);
		    		break;
		    	case "w16":
		    		w16.toBack();
		    		w16.setVisible(false);
		    		w16.setManaged(false);
		    		break;
		    	case "b1":
		    		b1.toBack();
		    		b1.setVisible(false);
		    		b1.setManaged(false);
		    		break;
		    	case "b2":
		    		b2.toBack();
		    		b2.setVisible(false);
		    		b2.setManaged(false);
		    		break;
		    	case "b3":
		    		b3.toBack();
		    		b3.setVisible(false);
		    		b3.setManaged(false);
		    		break;
		    	case "b4":
		    		b4.toBack();
		    		b4.setVisible(false);
		    		b4.setManaged(false);
		    		break;
		    	case "b5":
		    		b5.toBack();
		    		b5.setVisible(false);
		    		b5.setManaged(false);
		    		break;
		    	case "b6":
		    		b6.toBack();
		    		b6.setVisible(false);
		    		b6.setManaged(false);
		    		break;
		    	case "b7":
		    		b7.toBack();
		    		b7.setVisible(false);
		    		b7.setManaged(false);
		    		break;
		    	case "b8":
		    		b8.toBack();
		    		b8.setVisible(false);
		    		b8.setManaged(false);
		    		break;
		    	case "b9":
		    		b9.toBack();
		    		b9.setVisible(false);
		    		b9.setManaged(false);
		    		break;
		    	case "b10":
		    		b10.toBack();
		    		b10.setVisible(false);
		    		b10.setManaged(false);
		    		break;
		    	case "b11":
		    		b11.toBack();
		    		b11.setVisible(false);
		    		b11.setManaged(false);
		    		break;
		    	case "b12":
		    		b12.toBack();
		    		b12.setVisible(false);
		    		b12.setManaged(false);
		    		break;
		    	case "b13":
		    		b13.toBack();
		    		b13.setVisible(false);
		    		b13.setManaged(false);
		    		break;
		    	case "b14":
		    		b14.toBack();
		    		b14.setVisible(false);
		    		b14.setManaged(false);
		    		break;
		    	case "b15":
		    		b15.toBack();
		    		b15.setVisible(false);
		    		b15.setManaged(false);
		    		break;
		    	case "b16":
		    		b16.toBack();
		    		b16.setVisible(false);
		    		b16.setManaged(false);
		    		break;  
	    	}
	    	
	    	System.out.println(this.capturedPeices);
	    	
	    }
	    public void ChangeTurn()
	    {
	    	boolean inCheck;
	    	boolean isMate = false;
	    	if(this.CurrentTurn == "White")
	    	{
	    		this.CurrentTurn = "Black";
	    		disablePeicesToggle(chess.whiteID, true);
	    		inCheck = chess.isInCheck(CurrentTurn);
	    		setTurn(CurrentTurn);
	    		
	    		if(inCheck)
	    		{
	    			isMate = chess.isMate(CurrentTurn);
	    			if(!isMate)
	    			{
		    			Node peice = root.lookup("#b1");
			            peice.setDisable(false);
		            }
		            
	    		}
	    		else
	    		{
	    			disablePeicesToggle(chess.blackID, false);
	    		}
	    	}
	    	else
	    	{
	    		this.CurrentTurn = "White";
	    		disablePeicesToggle(chess.blackID, true);
	    		inCheck = chess.isInCheck(CurrentTurn);
	    		setTurn(CurrentTurn);
	    		if(inCheck)
	    		{
	    			isMate = chess.isMate(CurrentTurn);
	    			if(isMate)
	    			{
	    				Node peice = root.lookup("#w1");
	    				peice.setDisable(false);
		            }
	    		}
	    		else
	    		{
	    			disablePeicesToggle(chess.whiteID, false);
	    		}
	    	}
	    	setCheckedMessage(inCheck, isMate);
	    	
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
	    public void setPathTransition2(String id, Path p)
	    {
	    	switch(id)
	    	{
		    	case "w1":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w1);
		    		break;
		    	case "w2":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w2);
		    		break;
		    	case "w3":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w3);
		    		break;
		    	case "w4":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w4);
		    		break;
		    	case "w5":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w5);
		    		break;
		    	case "w6":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w6);
		    		break;
		    	case "w7":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w7);
		    		break;
		    	case "w8":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w8);
		    		break;
		    	case "w9":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w9);
		    		break;
		    	case "w10":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w10);
		    		break;
		    	case "w11":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w11);
		    		break;
		    	case "w12":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w12);
		    		break;
		    	case "w13":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w13);
		    		break;
		    	case "w14":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w14);
		    		break;
		    	case "w15":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w15);
		    		break;
		    	case "w16":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, w16);
		    		break;
		    	case "b1":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b1);
		    		break;
		    	case "b2":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b2);
		    		break;
		    	case "b3":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b3);
		    		break;
		    	case "b4":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b4);
		    		break;
		    	case "b5":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b5);
		    		break;
		    	case "b6":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b6);
		    		break;
		    	case "b7":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b7);
		    		break;
		    	case "b8":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b8);
		    		break;
		    	case "b9":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b9);
		    		break;
		    	case "b10":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b10);
		    		break;
		    	case "b11":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b11);
		    		break;
		    	case "b12":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b12);
		    		break;
		    	case "b13":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b13);
		    		break;
		    	case "b14":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b14);
		    		break;
		    	case "b15":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b15);
		    		break;
		    	case "b16":
		    		pathTransition2 = new PathTransition(Duration.millis(4000), p, b16);
		    		break;
	    	}
	    }
	    public void AfterPeiceMove()
	    {
	    	Platform.runLater(new Runnable(){
	    	    @Override
	    	    public void run() {
	    	    	TurnProcesser.fire();            
	    	    }           
	    	});
	    }
	    
	    @FXML
	    public void CastleKingSide(ActionEvent event)
	    {
	    	String KingId = chess.getKingSideKID();
	    	String RookId = chess.getKingSideRID();
	    	String KingMov = chess.getKingSideKMoveTo();
	    	String RookMov = chess.getKingSideRMoveTo();
	    	Path kPath = chess.getPath(KingId, KingMov);
	    	Path rPath = chess.getPath(RookId, RookMov);
	    	Node p = root.lookup("#" + RookId);
	    	ToggleOverlayTransparency();
	    	p.toFront();
	    	p = root.lookup("#" + KingId);
	    	p.toFront();
	    	setPathTransition(KingId, kPath);
	    	setPathTransition2(RookId, rPath);
	    	pathTransition.setInterpolator(Interpolator.LINEAR);
	    	pathTransition2.setInterpolator(Interpolator.LINEAR);
	    	pathTransition.setOnFinished(e->AfterPeiceMove2());
	    	pathTransition2.setOnFinished(e->playNextTrnasiton());
	    	pathTransition2.play();
	    	chess.doMove(KingId, KingMov);
	    	chess.doMove(RookId, RookMov);
	    	event.consume();
	    }
	    
	    @FXML
	    public void CastleQueenSide(ActionEvent event)
	    {
	    	String KingId = chess.getQueenSideKID();
	    	String RookId = chess.getQueenSideRID();
	    	String KingMov = chess.getQueenSideKMoveTo();
	    	String RookMov = chess.getQueenSideRMoveTo();
	    	Path kPath = chess.getPath(KingId, KingMov);
	    	Path rPath = chess.getPath(RookId, RookMov);
	    	Node p = root.lookup("#" + RookId);
	    	ToggleOverlayTransparency();
	    	p.toFront();
	    	p = root.lookup("#" + KingId);
	    	p.toFront();
	    	setPathTransition(KingId, kPath);
	    	setPathTransition2(RookId, rPath);
	    	pathTransition.setInterpolator(Interpolator.LINEAR);
	    	pathTransition2.setInterpolator(Interpolator.LINEAR);
	    	pathTransition.setOnFinished(e->AfterPeiceMove2());
	    	pathTransition2.setOnFinished(e->playNextTrnasiton());
	    	pathTransition2.play();
	    	chess.doMove(KingId, KingMov);
	    	chess.doMove(RookId, RookMov);
	    	event.consume();
	    }
	    
	    public void playNextTrnasiton()
	    {
	    	pathTransition.play();
	    }
	    public void AfterPeiceMove2()
	    {
	    	Platform.runLater(new Runnable(){
	    	    @Override
	    	    public void run() {
	    	    	TurnProcesser2.fire();            
	    	    }           
	    	});
	    }
	    @FXML
	    public void PostMoveProcessing(ActionEvent event)
	    {
	    	if((mov.getLocation().charAt(0) == 'h' || mov.getLocation().charAt(0) == 'a') && chess.getPeiceType(mov.getPeiceId()) == PeiceType.PAWN)
	    	{
	    		Premote(mov.getPeiceId());
	    	}
	    	if(mov.getCapturedPeice() != "")
	    	{
	    		RemovePeice(mov.getCapturedPeice());
	    	}
	    	ChangeTurn();
	    	chess.setCastleMoves(CurrentTurn);
	    	toggleKingSide();
	    	toggleQueenSide();
	    	mov = new MoveInfo();
	    	event.consume();
	    }
	    
	    @FXML
	    public void PostMoveProcessing2(ActionEvent event)
	    {
	    	ToggleOverlayTransparency();
	    	ChangeTurn();
	    	chess.setCastleMoves(CurrentTurn);
	    	toggleKingSide();
	    	toggleQueenSide();
	    	mov = new MoveInfo();
	    	event.consume();
	    }
	    public void toggleKingSide()
	    {
	    	if(chess.canKingSideCastle() && KingSide.isDisabled() && (!chess.isInCheck(CurrentTurn)))
	    	{
	    		KingSide.setDisable(false);
	    		KingSide.setVisible(true);
	    	}
	    	else
	    	{
	    		KingSide.setDisable(true);
	    		KingSide.setVisible(false);
	    	}
	    }
	    public void toggleQueenSide()
	    {
	    	if(chess.canQueenSideCastle() && QueenSide.isDisabled() && (!chess.isInCheck(CurrentTurn)))
	    	{
	    		QueenSide.setDisable(false);
	    		QueenSide.setVisible(true);
	    	}
	    	else
	    	{
	    		QueenSide.setDisable(true);
	    		QueenSide.setVisible(false);
	    	}
	    }
	    public void Premote(String id)
	    {
	    	PeiceType t = OpenDialog();
	    	chess.setPeiceType(id, t);
	    	Node p = root.lookup("#" + id);
	    	ObservableList<String> c = p.getStyleClass();
	    	p.getStyleClass().removeAll(c);
	    	String sClass = "";
	    	switch(t)
	    	{
		    	case KNIGHT:
		    		sClass = id.charAt(0) + "Knight";
		    		break;
				case BISHOP:
					sClass = id.charAt(0) + "Bishop";
					break;
				case KING:
					break;
				case PAWN:
					break;
				case QUEEN:
					sClass = id.charAt(0) + "Queen";
					break;
				case ROOK:
					sClass = id.charAt(0) + "Rook";
					break;
				default:
					break;
	    	}
	    	p.getStyleClass().add(sClass);
	    }
	    
	    @FXML
	    private Region BishopIcon;

	    @FXML
	    private Region KnightIcon;

	    @FXML
	    private Region QueenIcon;

	    @FXML
	    private Label turnLabel;

	    @FXML
	    private Region RookIcon;

	    @FXML
	    private Label MessageBox2;

	    @FXML
	    private Region KingIcon;

	    @FXML
	    private Region PawnIcon;

	    @FXML
	    private AnchorPane Image;

	    @FXML
	    private Label MessageBox;
	    
	    private String[] peiceTypes = new String[6];
	    
	    public void setTurn(String TurnColor)
	    {
	    	String l = (TurnColor == "White")? "w" : "b";
	    	turnLabel.setText(TurnColor + "'s Turn");
	    	setPeiceIconClasses(l); 
	    }
	    
	    private void setPeiceIconClasses(String l)
	    {
	    	ObservableList<String> c = KingIcon.getStyleClass();
	    	if(c.size() > 0)
	    	{
	    		KingIcon.getStyleClass().removeAll(c);
	    	}
	    	KingIcon.getStyleClass().add(l+peiceTypes[0]);
	    	
	    	c = QueenIcon.getStyleClass();
	    	if(c.size() > 0)
	    	{
	    		QueenIcon.getStyleClass().removeAll(c);
	    	}
	    	QueenIcon.getStyleClass().add(l+peiceTypes[1]);
	    	
	    	c = BishopIcon.getStyleClass();
	    	if(c.size() > 0)
	    	{
	    	    BishopIcon.getStyleClass().removeAll(c);
	    	}

	    	BishopIcon.getStyleClass().add(l+peiceTypes[2]);
	    	
	    	c = KnightIcon.getStyleClass();
	    	if(c.size() > 0)
	    	{
	    	    KnightIcon.getStyleClass().removeAll(c);
	    	}
	    	KnightIcon.getStyleClass().add(l+peiceTypes[3]);
	    	
	    	c = RookIcon.getStyleClass();
	    	if(c.size() > 0)
	    	{
	    	    RookIcon.getStyleClass().removeAll(c);
	    	}
	    	RookIcon.getStyleClass().add(l+peiceTypes[4]);
	    	
	    	c = PawnIcon.getStyleClass();
	    	if(c.size() > 0)
	    	{
	    	    PawnIcon.getStyleClass().removeAll(c);
	    	}
	    	PawnIcon.getStyleClass().add(l+peiceTypes[5]);
	    	
	    }
	    public void setCheckedMessage(boolean inCheck, boolean checkmate)
	    {
	    	if(checkmate)
	    	{
	    		MessageBox.setText("Checkmate!");
	    		MessageBox2.setText("You Lose!");
	    	}
	    	else
	    	{
	    		if(inCheck)
		    	{
		    		MessageBox.setText("Your King is in Check!");
		    		MessageBox2.setText("You Must Move Your King!");
		    	}
		    	else
		    	{
		    		MessageBox.setText("");
		    		MessageBox2.setText("");
		    	}
	    	}
	    	
	    }
	    public void initialize() {
	    	this.peiceTypes[0] = "King";
	        this.peiceTypes[1] = "Queen";
	        this.peiceTypes[2] = "Bishop";
	        this.peiceTypes[3] = "Knight";
	        this.peiceTypes[4] = "Rook";
	        this.peiceTypes[5] = "Pawn";
	    	setTurn("White");
	    	KingSide.setDisable(true);
    		KingSide.setVisible(false);
    		QueenSide.setDisable(true);
    		QueenSide.setVisible(false);
	    	System.out.println(KingIcon.getStyleClass().get(0));
	        disablePeicesToggle(chess.blackID, true);
	        disablePeicesToggle(chess.spaceID, true);
	        ToggleOverlayTransparency();
	        ToggleDialogDisplayTransparency();
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
	    public void ToggleDialogDisplayTransparency()
	    {
	    	if(dialogArea.isMouseTransparent())
	    	{
	    		dialogArea.setMouseTransparent(false);
	    	}
	    	else
	    	{
	    		dialogArea.setMouseTransparent(true);
	    	}
	    }
	    public void setMoveStyle(String id, char styleCode)
	    {
	    	Node location = root.lookup("#" + id);
	    	ObservableList<String> c = location.getStyleClass();
	    	switch(styleCode)
	    	{
		    	case 'm':
		    		location.getStyleClass().add("canMove");
		    		break;
		    	case 'c':
		    		location.getStyleClass().add("canCapture");
		    		break;
		    	case 'p':
		    		location.getStyleClass().add("selectedPeice");
		    		break;
		    	case 'r':
		    	default:
		    		location.getStyleClass().removeAll(c);
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
	    public PeiceType OpenDialog()
	    {
	    	DialogController page = new DialogController();
	    	Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Person");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(this.overlay.getScene().getWindow());
	        Scene scene = new Scene(page);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        dialogStage.setScene(scene);
	        while(page.getSelection() == null)
	        {
	        	dialogStage.showAndWait();
	        }
	        
	        return ((DialogController) dialogStage.getScene().getRoot()).getSelection();

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

