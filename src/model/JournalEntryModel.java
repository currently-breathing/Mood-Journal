/**
 * This is controller class which handles the Viewing old journal entries GUI
 * 
 * @author Lydia Unterreiner (mdm824)
 * @author Aldo Martinez (rgj655)
 * 
 * UTSA CS 3443 - Group 09 
 * Spring 2022
 */

package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JournalEntryModel {
	
	/**
	 * @param title
	 * @param content
	 * @param date
	 * @param color
	 * @throws IOException
	 */
	public static void addJournalEntry(String title, String content, String date, String color) throws IOException {
		try {
			String month = date.substring(0, 2);
			String fileName = "journalEntries/" + month + "/"+ date + "_" + title + "_" + color + ".txt";
			
			//create file name as data_title_color.txt in journal entries folder
			File file = new File(fileName);
			boolean success = file.createNewFile();
			if (success) {
				System.out.println("File created");
			} else 
				System.out.println("File already exists.");
			
			// write content to journal entry and close 	
			FileWriter myWriter = new FileWriter(fileName);
			myWriter.write(content);
			myWriter.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}



