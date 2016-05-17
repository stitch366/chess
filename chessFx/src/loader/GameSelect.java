package loader;

import java.io.IOException;

import general.GameFileHandler;
import general.Global;
import general.Theme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;

public class GameSelect extends AnchorPane {
	public GameSelect()
	{
		this.gfh = Global.getGameFileHandler();
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FileSelect.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	private GameFileHandler gfh;
	@FXML
    private ListView<String> SavedGames;

    @FXML
    void LoadGame(ActionEvent event) {

    }

    @FXML
    void ToMenu(ActionEvent event) {

    }
    public void initialize()
	{
		ObservableList<String> games = FXCollections.observableArrayList();
		for (String gamefile: gfh.games) {  
			games.add(gamefile);
	        }
		SavedGames.setItems(games);
		SavedGames.setStyle("-fx-font: 29px 'Arial Black';");
		
	}
}
