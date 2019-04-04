package database;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import taxi.SummaryReport;
import taxi.Taxi;
import vehicle.Vehicle;

public class TaxiProvider extends SQLProvider<Taxi>
{
	private static final String TABLE_NAME = "taxi_man";
	
	public TaxiProvider() 
	{
		super();
	}
	
	@Override
	protected void initSQLDatabase() 
	{
		try 
		{
			statement = con.createStatement();
			String sql=("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (\n"
					+"TaxiId integer PRIMARY KEY AUTOINCREMENT,\n"
					+"FirstName varchar(60),\n"
					+"LastName varchar(60),\n"
					+"TRN varchar(9),\n"
					+"VehicleModel varchar(30),\n"
					+"VehicleYear varchar(4),\n"
					+"Availability varchar(13),\n"
					+"Distance integer,\n"
					+"CashEarned integer);");
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
	public Taxi get(int id) 
	{
		return null;
	}
	
	public Taxi getAvailable()
	{
		Taxi driver=null;
		try
		{
			statement = con.createStatement();
			String query = "select * from "+TABLE_NAME+" where Availability = available;";
			result = statement.executeQuery(query);
			while(result.next())
			{
				driver = new Taxi(); 
				driver.setId(result.getInt("TaxiId"));
				driver.setFirstName(result.getString("FirstName"));
				driver.setLastName(result.getString("LastName"));
				driver.setTrn(result.getString("TRN"));
				driver.setVehicleInfo(new Vehicle(result.getString("VehicleModel"),result.getString("VehicleYear")));
			}
			return driver;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;
	}

	@Override
	public int update(int id) //function for decommissioning and making cab unavailable
	{
		try
		{
			String query = "UPDATE "+TABLE_NAME+ " SET Availability = ? "+ " WHERE TaxiID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "unavailable");
			ps.setInt(2, id);
			return ps.executeUpdate();		
    	}
		catch(SQLException e)
		{
			System.out.println("Something wrong with SQL");
			//logger.error("Unable to update marker with id "+id,e);
		}
		return 0;
	}
	
	public int recommission(int id)
	{
		try
		{
			String query = "UPDATE "+TABLE_NAME+ " SET Availability = ? "+ " WHERE TaxiID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "available");
			ps.setInt(2, id);
			return ps.executeUpdate();		
    	}
		catch(SQLException e)
		{
			System.out.println("Something wrong with SQL");
			//logger.error("Unable to update marker with id "+id,e);
		}
		return 0;
	}

	@Override
	public int add(Taxi driver) {
		String query= "INSERT INTO "+TABLE_NAME + " (FirstName, "
				+ "LastName, TRN, VehicleModel, VehicleYear, Availability, Distance, CashEarned)"
				+ "VALUES (?,?,?,?,?,?,?,?);";
		try
		{		      
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, driver.getFirstName());
			ps.setString(2, driver.getLastName());
			ps.setString(3, driver.getTrn());
			ps.setString(4, driver.getVehicleInfo().getVehicleModel());
			ps.setString(5, driver.getVehicleInfo().getVehicleYear());
			ps.setString(6, "available");
			ps.setInt(7, 0);
			ps.setInt(8, 0);
			return ps.executeUpdate();		
    	}
		catch(SQLException e)
		{
			//logger.error("Unable to add marker",e);
		}
		return 0;
	}

	@Override
	public List<Taxi> selectAll() 
	{
		List<Taxi> drivers = new ArrayList<Taxi>();
		try
		{
			statement = con.createStatement();
			String query = ("SELECT * FROM "+TABLE_NAME);
			result = statement.executeQuery(query);
			while(result.next()) 
			{				
				Taxi driver= new Taxi();
				Vehicle vehics=new Vehicle();
				driver.setId(result.getInt("TaxiId"));
				driver.setFirstName(result.getString("FirstName"));
				driver.setLastName(result.getString("LastName"));
				driver.setTrn(result.getString("TRN"));
				vehics.setVehicleModel(result.getString("VehicleModel"));
				vehics.setVehicleYear(result.getString("VehicleYear"));
				driver.setVehicleInfo(vehics);
				drivers.add(driver);
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
		return drivers;
	}
	
	public List<SummaryReport> summaryReport() 
	{
		List<SummaryReport> drivers = new ArrayList<SummaryReport>();
		try
		{
			statement = con.createStatement();
			String query = ("SELECT * FROM "+TABLE_NAME);
			result = statement.executeQuery(query);
			while(result.next()) 
			{	
				SummaryReport report= new SummaryReport();
				Taxi driver= new Taxi();
				Vehicle vehics=new Vehicle();
				driver.setId(result.getInt("TaxiId"));
				driver.setFirstName(result.getString("FirstName"));
				driver.setLastName(result.getString("LastName"));
				driver.setTrn(result.getString("TRN"));
				vehics.setVehicleModel(result.getString("VehicleModel"));
				vehics.setVehicleYear(result.getString("VehicleYear"));
				driver.setVehicleInfo(vehics);
				report.setTotalDistance(result.getInt("Distance"));
				report.setTotalDistance(result.getInt("CashEarned"));
				report.setDriver(driver);
				drivers.add(report);
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
		return drivers;
	}

}
