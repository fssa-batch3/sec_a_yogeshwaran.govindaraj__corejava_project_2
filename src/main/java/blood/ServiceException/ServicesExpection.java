package blood.ServiceException;

public class ServicesExpection extends Exception{
	
	private static final long serialVersionUID = -7798283981195321951L;
	
	public ServicesExpection(String msg) {
		super(msg);
	}
	
	public ServicesExpection(Throwable e) {
		super(e);
	}
	
}
