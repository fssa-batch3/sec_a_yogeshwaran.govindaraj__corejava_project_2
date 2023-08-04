package blood.ValidationException;

public class InvalidUserExecption extends Exception {

	private static final long serialVersionUID = -7798283981195321951L;
	
	public InvalidUserExecption(String msg) {
		super(msg);
	}
	
	public InvalidUserExecption(Throwable e) {
		super(e);
	}
}
