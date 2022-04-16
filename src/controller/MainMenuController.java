/**
 * This is controller class which handles the Main Menu GUI and all its 
 * variables as well as user actions
 * 
 * @author Lydia Unterreiner (mdm824)
 * 
 * UTSA CS 3443 - Group 09 
 * Spring 2022
 */

package controller;

import java.io.IOException;

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
import javafx.stage.Stage;

public class MainMenuController {
	//class variables 
    @FXML
    private AnchorPane main_page;

    @FXML
    private Button old_entry_button;

    @FXML
    private Button new_entry_button;
    
    @FXML
    private ChoiceBox<String> year_drop_down;

    @FXML
    private PieChart journal_mood_chart;
    //ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    
    /** 
     * @throws Exception
     */
    @FXML
    public void initialize() throws Exception {
    	for (int i = 2013; i < 2022; i++) {
    		year_drop_down.getItems().add(""+i);
    	}
    	
    	//example pie chart
    	ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Executed", 60),
                new PieChart.Data("Passed", 25),
                new PieChart.Data("Fails", 15));

    	journal_mood_chart.setData(pieChartData);
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
        window.setScene(scene);
        window.show();
    }
}
