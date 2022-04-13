package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import application.JournalEntry;
import javafx.scene.paint.Color;

public class JournalEntryModel {
	
	private static ArrayList<JournalEntry> journalEntries = new ArrayList<>();
	
	public static void addItem(String title, String content, String date, String color) throws IOException {
		
		// Verify if item_name field is blank
		String editedContent = content.replaceAll("[\n]", " ");
		System.out.println(editedContent);
		try {
			File data = new File("data.txt");
			Scanner lineReader = new Scanner(data);
			//lineReader.useDelimiter("\\|\\-\\|");
			while(lineReader.hasNextLine()) {
				String line = lineReader.nextLine();
				String[] journalEntryObject = line.split("\\|\\-\\|");
				String titleFrFile = journalEntryObject[0];
				String contFrFile = journalEntryObject[1];
				String dateFrFile = journalEntryObject[2];
				String colorFrFile = journalEntryObject[3];
				JournalEntry newEntry = new JournalEntry(titleFrFile, contFrFile, dateFrFile, colorFrFile);
				journalEntries.add(newEntry);
				System.out.println(newEntry);
			}
			lineReader.close();
			System.out.println("closing linereader...");
			JournalEntry newEntry = new JournalEntry(title, editedContent, date, color);
			
			/* Not sure if need following if rule */
			if (journalEntries.contains(newEntry)) {
				System.out.println("the same!");
			} else {
				journalEntries.add(newEntry);
			}
			
			FileWriter dataWriter = new FileWriter("data.txt");
			PrintWriter dataPrintWriter = new PrintWriter(dataWriter);
			
			for (JournalEntry ent: journalEntries) {
				dataPrintWriter.println(ent.toString());
			}
			
			dataPrintWriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}



