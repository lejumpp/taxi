package serverTest;

import java.io.Serializable;

public class Request implements Serializable
{
	@Override
	public String toString() {
		return "Request [obj=" + obj + ", action=" + action + "]";
	}
	private Object obj;
	private String action;
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Request(Object obj, String action) {
		super();
		this.obj = obj;
		this.action = action;
	}
	
	public Object getObj() {
		return obj;
	}
	
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	

}
