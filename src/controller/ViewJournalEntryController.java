/**
 * This is controller class which handles the Viewing old journal entries GUI
 * 
 * @author Lydia Unterreiner (mdm824)
 * @author Aldo Martinez (rgj655)
 * @author Allison Warren (rdp375)
 * UTSA CS 3443 - Group 09 
 * Spring 2022
 */

package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewJournalEntryController {
    // class variables
	@FXML
    private TextArea journal_content;

    @FXML
    private AnchorPane main_page;

    @FXML
    private Button main_menu;
    
    @FXML
    private Button old_entries;

    @FXML
    private Label journal_title;

    @FXML
    private Label date_field;

    /**
     * @param event
     * @throws IOException
     */
    @FXML
    void returnToMainMenu(ActionEvent event) throws IOException {
    	main_page = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));// pane you are GOING TO
        Scene scene = new Scene(main_page);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }
    
    /**
     * @param event
     * @throws IOException
     */
    @FXML
    void returnToOldEntries(ActionEvent event) throws IOException {
    	main_page = FXMLLoader.load(getClass().getResource("../view/OldEntry.fxml"));// pane you are GOING TO
        Scene scene = new Scene(main_page);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }
    
    /**
     * @param title
     */
    public void setTitle(String title, String content) {
    	System.out.println(title);
    	journal_title.setText(title);
    	journal_content.setText(content);;
    }
}
