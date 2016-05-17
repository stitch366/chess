package board;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DialogController extends AnchorPane {

	@FXML
	private ToggleGroup Promotion;
	
	@FXML
	private Label label;
	
	private PieceType selection;
	
	public DialogController()
	{
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/PromoteDialog.fxml"));
		 fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	public void setSelection()
	{
		String selected =((RadioButton) Promotion.getSelectedToggle()).getText();
		switch(selected)
		{
		case "Queen":
			this.selection = PieceType.QUEEN;
			break;
		case "Rook":
			this.selection = PieceType.ROOK;
			break;
		case "Knight":
			this.selection = PieceType.KNIGHT;
			break;
		case "Bishop":
			this.selection = PieceType.BISHOP;
			break;
		}
		((Stage) this.label.getScene().getWindow()).close();
	}
	
	public PieceType getSelection()
	{
		return this.selection;
	}
}
