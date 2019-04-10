package serverTest;

import java.io.Serializable;

public class Taxi implements Serializable
{
	private int id;
	private String firstName, lastName, trn;
	private Vehicle vehicleInfo;
	private Object obj;
	
	public Taxi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Taxi(int id, String firstName, String lastName, String trn, Vehicle vehicleInfo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.trn = trn;
		this.vehicleInfo = vehicleInfo;
	}
	
	/*public Taxi(int id)
	{
		this.id=id;
		this.firstName=" ";
		this.lastName=" ";
		this.trn=" ";
		this.vehicleInfo=null;
	}*/
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTrn() {
		return trn;
	}
	public void setTrn(String trn) {
		this.trn = trn;
	}
	public Vehicle getVehicleInfo() {
		return vehicleInfo;
	}
	public void setVehicleInfo(Vehicle vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "Taxi [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", trn=" + trn
				+ ", vehicleInfo=" + vehicleInfo.getVehicleModel() +","+ vehicleInfo.getVehicleYear() +"]";
	}
}
