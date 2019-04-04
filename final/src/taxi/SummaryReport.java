package taxi;

public class SummaryReport 
{
	private Taxi driver;
	private int totalDistance,totalMoneyEarned;
	
	public SummaryReport() {
		super();
	}
	
	public Taxi getDriver() {
		return driver;
	}
	
	public void setDriver(Taxi driver) {
		this.driver = driver;
	}
	
	public int getTotalDistance() {
		return totalDistance;
	}
	
	public void setTotalDistance(int totalDistance) {
		this.totalDistance = totalDistance;
	}
	
	public int getTotalMoneyEarned() {
		return totalMoneyEarned;
	}
	
	public void setTotalMoneyEarned(int totalMoneyEarned) {
		this.totalMoneyEarned = totalMoneyEarned;
	}

	@Override
	public String toString() {
		return "SummaryReport [driver=" + driver + ", totalDistance=" + totalDistance + ", totalMoneyEarned="
				+ totalMoneyEarned + "]\n";
	}
}
