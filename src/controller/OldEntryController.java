/**
 * This is controller class which handles the Old Journal Entries GUI 
 * and when the user views the entries for the selected month as well
 * as selects an old entry to view and transitions to a new scene
 * 
 * @author Lydia Unterreiner (mdm824)
 * 
 * UTSA CS 3443 - Group 09 
 * Spring 2022
 */

package controller;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OldEntryController {
	// class variables
	@FXML
    private AnchorPane main_page;
	
	@FXML
    private Button main_menu;
	
	@FXML
	private Button january_entries;
	
	@FXML
	private Button february_entries;
	
	@FXML
	private Button march_entries;
	
	@FXML
	private Button april_entries;
	
	@FXML
	private Button may_entries;
	
	@FXML
	private Button june_entries;
	
	@FXML
	private Button july_entries;
	
	@FXML
	private Button august_entries;
	
	@FXML
	private Button september_entries;
	
	@FXML
	private Button october_entries;

	@FXML
	private Button november_entries;
	
	@FXML
	private Button december_entries;
	
	@FXML
	private ListView<String> journal_entry_list;
	private ObservableList<String> journal_entries = FXCollections.observableArrayList();
	
	/** 
	 * @throws Exception
	 */
	@FXML
	public void initialize() throws Exception {
		january_entries.fire();
	}
	
	/**
	 * @param event
	 * @throws IOException
	 */
	@FXML
    void returnToMainMenu(ActionEvent event) throws IOException {
		main_page = FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));// pane you are GOING TO
        Scene scene = new Scene(main_page);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }
	
	/**
	 * @param event
	 */
	@FXML
    void listJanuaryEntries(ActionEvent event) {
		journal_entry_list.getItems().clear();
		
		File folder = new File("journalEntries/01");
		for (File file : folder.listFiles()) {
			String[] entry = file.getName().split("_");
			String result = entry[0] + "\t\t\t" + entry[1];
			
			journal_entries.add(result);
		}
		
		journal_entry_list.setItems(journal_entries);
    }
	
	/**
	 * @param event
	 */
	@FXML
    void listFebruaryEntries(ActionEvent event) {
		journal_entry_list.getItems().clear();
		
		File folder = new File("journalEntries/02");
		for (File file : folder.listFiles()) {
			String[] entry = file.getName().split("_");
			String result = entry[0] + "\t\t\t" + entry[1];
			
			journal_entries.add(result);
		}
		
		journal_entry_list.setItems(journal_entries);
    }
	
	/**
	 * @param event
	 */
	@FXML
    void listMarchEntries(ActionEvent event) {
		journal_entry_list.getItems().clear();
		
		File folder = new File("journalEntries/03");
		for (File file : folder.listFiles()) {
			String[] entry = file.getName().split("_");
			String result = entry[0] + "\t\t\t" + entry[1];
			
			journal_entries.add(result);
		}
		
		journal_entry_list.setItems(journal_entries);
    }

	/**
	 * @param event
	 */
	@FXML
    void listAprilEntries(ActionEvent event) {
		journal_entry_list.getItems().clear();
		
		File folder = new File("journalEntries/04");
		for (File file : folder.listFiles()) {
			String[] entry = file.getName().split("_");
			String result = entry[0] + "\t\t\t" + entry[1];
			
			journal_entries.add(result);
		}
		
		journal_entry_list.setItems(journal_entries);
    }
	
	/**
	 * @param event
	 */
	@FXML
    void listMayEntries(ActionEvent event) {
		journal_entry_list.getItems().clear();
		
		File folder = new File("journalEntries/05");
		for (File file : folder.listFiles()) {
			String[] entry = file.getName().split("_");
			String result = entry[0] + "\t\t\t" + entry[1];
			
			journal_entries.add(result);
		}
		
		journal_entry_list.setItems(journal_entries);
    }
	
	/**
	 * @param event
	 */
	@FXML
    void listJuneEntries(ActionEvent event) {
		journal_entry_list.getItems().clear();
		
		File folder = new File("journalEntries/06");
		for (File file : folder.listFiles()) {
			String[] entry = file.getName().split("_");
			String result = entry[0] + "\t\t\t" + entry[1];
			
			journal_entries.add(result);
		}
		
		journal_entry_list.setItems(journal_entries);
    }
	
	/**
	 * @param event
	 */
	@FXML
    void listJulyEntries(ActionEvent event) {
		journal_entry_list.getItems().clear();
		
		File folder = new File("journalEntries/07");
		for (File file : folder.listFiles()) {
			String[] entry = file.getName().split("_");
			String result = entry[0] + "\t\t\t" + entry[1];
			
			journal_entries.add(result);
		}
		
		journal_entry_list.setItems(journal_entries);
    }
	
	/**
	 * @param event
	 */
	@FXML
    void listAugustEntries(ActionEvent event) {
		journal_entry_list.getItems().clear();
		
		File folder = new File("journalEntries/08");
		for (File file : folder.listFiles()) {
			String[] entry = file.getName().split("_");
			String result = entry[0] + "\t\t\t" + entry[1];
			
			journal_entries.add(result);
		}
		
		journal_entry_list.setItems(journal_entries);
    }
	
	/**
	 * @param event
	 */
	@FXML
    void listSeptemberEntries(ActionEvent event) {
		journal_entry_list.getItems().clear();
		
		File folder = new File("journalEntries/09");
		for (File file : folder.listFiles()) {
			String[] entry = file.getName().split("_");
			String result = entry[0] + "\t\t\t" + entry[1];
			
			journal_entries.add(result);
		}
		
		journal_entry_list.setItems(journal_entries);
    }
	
	/**
	 * @param event
	 */
	@FXML
    void listOctoberEntries(ActionEvent event) {
		journal_entry_list.getItems().clear();
		
		File folder = new File("journalEntries/10");
		for (File file : folder.listFiles()) {
			String[] entry = file.getName().split("_");
			String result = entry[0] + "\t\t\t" + entry[1];
			
			journal_entries.add(result);
		}
		
		journal_entry_list.setItems(journal_entries);
    }
	
	/**
	 * @param event
	 */
	@FXML
    void listNovemberEntries(ActionEvent event) {
		journal_entry_list.getItems().clear();
		
		File folder = new File("journalEntries/11");
		for (File file : folder.listFiles()) {
			String[] entry = file.getName().split("_");
			String result = entry[0] + "\t\t\t" + entry[1];
			
			journal_entries.add(result);
		}
		
		journal_entry_list.setItems(journal_entries);
    }
	
	/**
	 * @param event
	 */
	@FXML
    void listDecemberEntries(ActionEvent event) {
		journal_entry_list.getItems().clear();
		
		File folder = new File("journalEntries/12");
		for (File file : folder.listFiles()) {
			String[] entry = file.getName().split("_");
			String result = entry[0] + "\t\t\t" + entry[1];
			
			journal_entries.add(result);
		}
		
		journal_entry_list.setItems(journal_entries);
    }
	
	//handle on mouse click of journal entry in list view
    /**
     * @param event
     * @throws IOException
     */
    @FXML
    void viewOldEntryClicked(MouseEvent event) throws IOException {
    	System.out.println("Journal Entry was clicked on");

    	main_page = FXMLLoader.load(getClass().getResource("../view/ViewJournalntry.fxml"));// pane you are GOING TO
        Scene scene = new Scene(main_page);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
        window.setScene(scene);
        window.show();
    }
}
