package blood.DAOExpection;

public class DAOExpection extends Exception {
	
	private static final long serialVersionUID = -7798283981195321951L;
	
	public DAOExpection(String msg) {
		super(msg);
		
	}
	public DAOExpection(Throwable e) {
		super(e);
	}
	
}
