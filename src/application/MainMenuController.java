package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private AnchorPane main_page;

    @FXML
    private Button old_entry_button;

    @FXML
    private Button new_entry_button;
    
    @FXML
    private ChoiceBox<String> year_drop_down;

    @FXML
    public void initialize() throws Exception {
    	for (int i = 2013; i < 2022; i++) {
    		year_drop_down.getItems().add(""+i);
    	}
    }
    
    @FXML
    void newEntry(ActionEvent event) throws IOException {
        main_page = FXMLLoader.load(getClass().getResource("NewEntry.fxml"));// pane you are GOING TO
        Scene scene = new Scene(main_page);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    void oldEntry(ActionEvent event) {
    	System.out.println("old entry clicked");

    }

}
