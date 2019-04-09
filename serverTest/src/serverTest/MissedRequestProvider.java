package serverTest;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MissedRequestProvider extends SQLProvider <CustomerLogic>
{
	private static final String TABLE_NAME = "missed_request";
	
	

	public MissedRequestProvider() 
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
					+"RequestId integer PRIMARY KEY AUTOINCREMENT,\n"
					+"Source varchar(80),\n"
					+"Destination varchar(80),\n"
					+"TotalMoney integer);");
			if (statement.execute(sql))
			{
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
	public CustomerLogic get(int id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int id) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(CustomerLogic item) 
	{
		String query= "INSERT INTO "+TABLE_NAME + " (Source, Destination, TotalMoney)"
				+ "VALUES (?,?,?);";
		try
		{		      
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, item.getSource());
			ps.setString(2, item.getDestination());
			ps.setInt(3, item.getTotal());
			return ps.executeUpdate();		
    	}
		catch(SQLException e)
		{
			//logger.error("Unable to add missed request",e);
		}
		return 0;
	}

	@Override
	public List<CustomerLogic> selectAll() //list of cab requests that were not fulfilled
	{
		List<CustomerLogic> requests = new ArrayList<CustomerLogic>();
		try
		{
			statement = con.createStatement();
			String query = ("SELECT * FROM "+TABLE_NAME);
			result = statement.executeQuery(query);
			while(result.next()) 
			{				
				CustomerLogic request= new CustomerLogic();
				request.setId(result.getInt("RequestId"));
				request.setSource(result.getString("Source"));
				request.setDestination(result.getString("Destination"));
				request.setTotal(result.getInt("TotalMoney"));
				requests.add(request);
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
		return requests;
	}

	

}
