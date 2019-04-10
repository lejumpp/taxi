package serverTest;

import java.io.Serializable;

public class Response <T> implements Serializable
{
	private boolean isError;
	private String error;
	private T obj;
	
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Response(boolean isError, String erorr, T obj) {
		super();
		this.isError = isError;
		this.error = erorr;
		this.obj = obj;
	}
	
	public Response(T obj)
	{
		this.isError=false;
		this.error= "";
		this.obj=obj;
	}
	
	public boolean isError() {
		return isError;
	}
	
	public void setError(boolean isError) {
		this.isError = isError;
	}
	
	public String getErorr() {
		return error;
	}
	
	public void setErorr(String erorr) {
		this.error = erorr;
	}
	
	public T getObj() {
		return obj;
	}
	
	public void setObj(T obj) {
		this.obj = obj;
	}

}
