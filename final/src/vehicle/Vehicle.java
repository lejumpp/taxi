package vehicle;

public class Vehicle 
{
	private String vehicleModel, vehicleYear;
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle(String vehicleModel, String vehicleYear) {
		super();
		this.vehicleModel = vehicleModel;
		this.vehicleYear = vehicleYear;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleYear() {
		return vehicleYear;
	}
	public void setVehicleYear(String vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

}
