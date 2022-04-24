/**
 * This is controller class which handles the Viewing old journal entries GUI
 * 
 * @author Lydia Unterreiner (mdm824)
 * @author Aldo Martinez (rgj655)
 * @author Orlando Jones (aqv663)
 * @author Allison Warren (rdp375)
 * UTSA CS 3443 - Group 09 
 * Spring 2022
 */

package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class JournalEntryModel {
	
	/** add a journal entry data when new entry is submitted
	 * @param title
	 * @param content
	 * @param date
	 * @param color
	 * @throws IOException
	 */
	public static void addJournalEntry(String title, String content, String date, String color) throws IOException {
		//update jounral entries data
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
		//update color mood data
		try (FileWriter f = new FileWriter("journalEntries/color_mood.txt", true);
                BufferedWriter b = new BufferedWriter(f);
                PrintWriter p = new PrintWriter(b);) {

            p.println(color);

        } catch (IOException i) {
            i.printStackTrace();
        }
	}
	
	/** read in colors submitted from previous journal entries to hashmap
	 * @param dirPath
	 * @param color_map
	 * @return number of total mood colors ever submitted
	 */
	public static float mapOfColors(File dirPath, HashMap<String, Integer> color_map){ //helper function for implementing the pie graph  
		float num_moods = 0;
		BufferedReader br;
		
		try {
			br = new BufferedReader(new FileReader(dirPath));
			String st;
			
			while ((st = br.readLine()) != null) {
				num_moods++;
				if(color_map.containsKey(st))
					color_map.put(st, color_map.get(st) + 1);
				else
					color_map.put(st, 1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num_moods;
	}
		
}



