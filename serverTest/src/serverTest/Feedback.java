package serverTest;

import java.io.Serializable;

public class Feedback implements Serializable
{
	private int id,rating; 
	private String comment;
	private Taxi driver;
	
	public Feedback()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Feedback(int id, int rating, String comment, Taxi driver) {
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.driver = driver;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Taxi getDriver() {
		return driver;
	}
	public void setDriver(Taxi driver) {
		this.driver = driver;
	}
	
}
