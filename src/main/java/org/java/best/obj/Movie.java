package org.java.best.obj;

public class Movie {

	private long id;
	private String title;
	
	public Movie(long id, String title) {
		setId(id);
		setTitle(title);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
