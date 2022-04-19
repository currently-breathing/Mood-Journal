/**
 * This is controller class which handles the New Journal Entries GUI 
 * and when a user writes and saves a new journal entry
 * 
 * @author Lydia Unterreiner (mdm824)
 * @author Aldo Martinez (rgj655)
 * @author Allison Warren (rdp375)
 *
 * UTSA CS 3443 - Group 09 
 * Spring 2022
 */

package controller;

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
	// class variables
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
    	SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd-yyyy");
    	date_field.setText(formatDate.format(date));
    }
    

    /**
     * @param event
     * @throws IOException
     */
    @FXML
    void cancelEntry(ActionEvent event) throws IOException {
        main_page = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));// pane you are GOING TO
        Scene scene = new Scene(main_page);// pane you are GOING TO show
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }

    /**
     * @param event
     * @throws IOException
     */
    @FXML
    void saveEntry(ActionEvent event) throws IOException {
    	//throw exceptions
    	if (journal_title.getText().equals("") || journal_content.getText().equals("")) {
    		Alert fail = new Alert(AlertType.WARNING);
    		fail.setContentText("Missing Title or Content");
    		fail.showAndWait();
    		return;
    	}
    	// get journal entry data
    	String title = journal_title.getText();
    	String description = journal_content.getText();
    	String date = date_field.getText();
    	Color mood = mood_selector.getValue();
    	
    	// Save entry and return to main Page
    	JournalEntryModel.addJournalEntry(title, description, date, mood.toString());
        main_page = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));// pane you are GOING TO
        Scene scene = new Scene(main_page);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

}
 
