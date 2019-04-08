package serverTest;

import java.io.Serializable;

public class Request<T> implements Serializable
{
	@Override
	public String toString() {
		return "Request [obj=" + obj + ", action=" + action + "]";
	}

	/**
	 * 
	 */
	private T obj;
	private String action;
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Request(T obj, String action) {
		super();
		this.obj = obj;
		this.action = action;
	}
	
	public T getObj() {
		return obj;
	}
	
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	

}
