package model;

import java.io.Serializable;

import javafx.scene.paint.Color;

public class JournalEntry implements Serializable{
	private String title;
	private String description;
	private String date;
	private String moodColor;
	
	public JournalEntry(String title, String description, String date, String moodColor) {
		this.title = title;
		this.description = description;
		this.date = date;
		this.moodColor = moodColor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMoodColor() {
		return moodColor;
	}

	public void setMoodColor(String moodColor) {
		this.moodColor = moodColor;
	}
	
	@Override
	public String toString() {
		return getTitle() + "|-|" + getDescription() +
				"|-|" + getDate() + "|-|" + getMoodColor();
	}
	
}
