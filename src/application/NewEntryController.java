package application;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.JournalEntryModel;

public class NewEntryController {

    @FXML
    private Button cancel_button;

    @FXML
    private Button save_button;

    @FXML
    private TextArea journal_content;

    @FXML
    private AnchorPane main_page;

    @FXML
    private TextField journal_title;

    @FXML
    private Label date_field;
    
    @FXML
    private ColorPicker mood_selector;

    public void initialize() throws Exception {
    	Date date = new Date();
    	SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
    	date_field.setText(formatDate.format(date));
    }
    

    @FXML
    void cancelEntry(ActionEvent event) throws IOException {
        main_page = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));// pane you are GOING TO
        Scene scene = new Scene(main_page);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

    @FXML
    void saveEntry(ActionEvent event) throws IOException {
    	if (journal_title.getText().equals("") || journal_content.getText().equals("")) {
    		Alert fail = new Alert(AlertType.WARNING);
    		fail.setContentText("Missing Title or Content");
    		fail.showAndWait();
    		return;
    		
    	}
    	String title = journal_title.getText();
    	String description = journal_content.getText();
    	String date = date_field.getText();
    	Color mood = mood_selector.getValue();
    	JournalEntryModel.addItem(title, description, date, mood.toString());
        main_page = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));// pane you are GOING TO
        Scene scene = new Scene(main_page);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

}
 