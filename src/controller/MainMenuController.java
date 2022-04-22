/**
 * This is controller class which handles the Main Menu GUI and all its 
 * variables as well as user actions
 * 
 * @author Lydia Unterreiner (mdm824)
 * @author Aldo Martinez (rgj655)
 * @author Orlando Jones (aqv663)
 *@author Allison Warren (rdp375) 
 * UTSA CS 3443 - Group 09 
 * Spring 2022
 */

package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.JournalEntryModel;

public class MainMenuController {
	//class variables 
    @FXML
    private AnchorPane main_page;

    @FXML
    private Button old_entry_button;

    @FXML
    private Button new_entry_button;

    @FXML
    private PieChart journal_mood_chart;
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    
    /** 
     * @throws Exception
     */
    @FXML
    public void initialize() throws Exception {

    	//read in color moods for pie chart.
    	File file = new File("journalEntries/color_mood.txt");
    	HashMap<String, Integer> color_map = new HashMap<>();
    	
    	float num_moods = JournalEntryModel.mapOfColors(file, color_map);	
    	for (String name: color_map.keySet()) {
    		
    		float value = Integer.parseInt(color_map.get(name).toString());
    		value = (value / num_moods) * 100;
    		
    		PieChart.Data s1 = new PieChart.Data(name.toString(), value);
        	journal_mood_chart.getData().add(s1);
 
    	}
    	journal_mood_chart.setLabelsVisible(false);
    	journal_mood_chart.setLegendVisible(false);
    }
    
    /**
     * @param event
     * @throws IOException
     */
    @FXML
    void newEntry(ActionEvent event) throws IOException {
        main_page = FXMLLoader.load(getClass().getResource("../view/NewEntry.fxml"));// pane you are GOING TO
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
    void oldEntry(ActionEvent event) throws IOException {
    	main_page = FXMLLoader.load(getClass().getResource("../view/OldEntry.fxml"));// pane you are GOING TO
        Scene scene = new Scene(main_page);// pane you are GOING TO show
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();// pane you are ON
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }
}
