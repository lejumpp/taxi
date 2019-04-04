package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class SQLProvider <T>
{
	protected Connection con = null; // connection object to database
	protected Statement statement = null; // use to execute sql statement
	protected ResultSet result = null; // used to collect result data from
	
	private static final String DRIVER = "org.sqlite.JDBC";
	
	public SQLProvider() 
	{
		try 
		{
//			//logger.trace("Attempting to connect to database, errors may occur");
			Class.forName(DRIVER).newInstance(); // specify driver class
			
			
			//specify database path / url
			String url = "jdbc:sqlite:taxi.sqlite";  
			
			//instantiate connection object via driver manager
       		
			//String url = "jdbc:sqlite:inventory.sqlite"; 
			con = DriverManager.getConnection(url);
			
			initSQLDatabase();

			//logger.info("Connected to database");
			//logger.debug( "Connected to database");

		}// end try
		catch (SQLException ex) {
			System.out.println("Error in the SQL provider file");
			//logger.error("Could not connect to database",ex);
		}// end catch
		catch (ClassNotFoundException ex) {
			//logger.error("Failed to load JDBC/OBDC Driver",ex);
		}// end catch
		catch (NullPointerException ex) {
			//logger.error("Could not find database",ex);
		}// end catch
		catch (IllegalAccessException ex) {
			//logger.error("Unauthorized access to the database",ex);
		} catch (InstantiationException ex) {
			//logger.error("Could not create instance of database",ex);
		}

	}// end constructor



   abstract protected void initSQLDatabase();
   
   abstract public T get(int id);
   
   abstract public int update(int id);
   
   abstract public int add(T item);
   
   abstract public List<T> selectAll();
}
