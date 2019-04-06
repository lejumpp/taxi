package serverTest;

public class Response <T>
{
	private boolean isError;
	private String erorr;
	private T obj;
	
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Response(boolean isError, String erorr, T obj) {
		super();
		this.isError = isError;
		this.erorr = erorr;
		this.obj = obj;
	}
	
	public boolean isError() {
		return isError;
	}
	
	public void setError(boolean isError) {
		this.isError = isError;
	}
	
	public String getErorr() {
		return erorr;
	}
	
	public void setErorr(String erorr) {
		this.erorr = erorr;
	}
	
	public T getObj() {
		return obj;
	}
	
	public void setObj(T obj) {
		this.obj = obj;
	}

}
