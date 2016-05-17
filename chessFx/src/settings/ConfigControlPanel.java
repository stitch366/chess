package settings;

import java.io.IOException;
import java.util.ArrayList;

import config.UserConfig;
import general.Global;
import general.MoveSpeed;
import general.Theme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class ConfigControlPanel extends AnchorPane {
	private UserConfig con;
	@FXML
    private ComboBox<String> themeCombo;

    @FXML
    private ToggleGroup movSpeed;
    
    @FXML
    private AnchorPane radioBtns;
    
    @FXML
    void SaveSettings(ActionEvent event) {
    	String selTheme = themeCombo.getValue();
    	String selSpeed = ((RadioButton)movSpeed.getSelectedToggle()).getId();
    	con.configure("theme", selTheme.toUpperCase());
    	con.configure("movspeed", selSpeed);
    	con.saveFile();
    }

    @FXML
    void MakeDefualt(ActionEvent event) {
    	con.revertToDefualt();
    	con.saveFile();
    	Theme currnet = Theme.valueOf(con.getValue("theme"));
		themeCombo.setValue(currnet.getComboString());
		RadioButton btn = (RadioButton) radioBtns.lookup("#"+con.getValue("movspeed"));
		btn.setSelected(true);
    	
    }
    
	public ConfigControlPanel()
	{
		con = Global.getConfig();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Config.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	public void initialize()
	{
		ObservableList<String> options = FXCollections.observableArrayList();
		for (Theme enumVal: Theme.class.getEnumConstants()) {  
			options.add(enumVal.getComboString());
	        }
		themeCombo.setItems(options);
		Theme currnet = Theme.valueOf(con.getValue("theme"));
		themeCombo.setValue(currnet.getComboString());
		RadioButton btn = (RadioButton) radioBtns.lookup("#"+con.getValue("movspeed"));
		btn.setSelected(true);
		
	}
}
