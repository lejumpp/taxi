package serverTest;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FeedbackProvider extends SQLProvider <Feedback> implements Serializable
{
	private static final String TABLE_NAME = "taxi_feedback";
	
	public FeedbackProvider() {
		super();
	}

	@Override
	protected void initSQLDatabase() 
	{
		try 
		{
			statement = con.createStatement();
			String sql=("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (\n"
					+"FeedbackId integer PRIMARY KEY AUTOINCREMENT,\n"
					+"Rating integer,\n"
					+"Comment varchar(60),\n"
					+"TaxiId integer,\n"
					+"TaxiFirstName varchar(30),\n"
					+"TaxiLastName varchar(30));");
			if (statement.execute(sql))
			{
				//autoincrement increments for you automatically pay attention for project
				//logger.debug("ITEM table created");
				System.out.println("Table Created");
			} 
			else
			{
				//logger.debug("ITEM table does not need to be created");
				System.out.println("table does not need to be Created");
			}
			//logger.debug("ITEM table exists");
		}
		catch (SQLException e) 
		{
			//logger.error("Unable to initialize SQL Database", e);
			System.out.println("Unable to initialize database");
		}	
	}

	@Override
	public Feedback get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int add(Taxi obj,Feedback item) 
	{
		String query= "INSERT INTO "+TABLE_NAME + " (Rating, Comment, TaxiId, TaxiFirstName, TaxiLastName)"
				+ "VALUES (?,?,?,?,?);";
		try
		{		      
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, item.getRating());
			ps.setString(2, item.getComment());
			ps.setInt(3, obj.getId());
			ps.setString(4, obj.getFirstName());
			ps.setString(5, obj.getLastName());
			return ps.executeUpdate();		
    	}
		catch(SQLException e)
		{
			//logger.error("Unable to add marker",e);
		}
		return 0;
	}

	@Override
	public List<Feedback> selectAll() 
	{
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		try
		{
			statement = con.createStatement();
			String query = ("SELECT * FROM "+TABLE_NAME);
			result = statement.executeQuery(query);
			while(result.next()) 
			{				
				Taxi driver= new Taxi();
				Feedback feedback=new Feedback();
				feedback.setId(result.getInt("FeedbackId"));
				feedback.setRating(result.getInt("Rating"));
				feedback.setComment(result.getString("Comment"));
				driver.setId(result.getInt("TaxiId"));
				driver.setFirstName(result.getString("TaxiFirstName"));
				driver.setLastName(result.getString("TaxiLastName"));
				feedback.setDriver(driver);
				feedbacks.add(feedback);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error in select all function");
		}
		catch(Exception e)
		{
			System.out.println("Some Error in select all function");
		}
		return feedbacks;
	}

	@Override
	public int add(Feedback item) {
		// TODO Auto-generated method stub
		return 0;
	}

}
