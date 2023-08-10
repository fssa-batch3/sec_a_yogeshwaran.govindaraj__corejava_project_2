package bloodserviceexception;

public class ServicesException extends Exception{
	
	private static final long serialVersionUID = -7798283981195321951L;
	
	public ServicesException(String msg) {
		super(msg);
	}
	
	public ServicesException(Throwable e) {
		super(e);
	}
	
}
