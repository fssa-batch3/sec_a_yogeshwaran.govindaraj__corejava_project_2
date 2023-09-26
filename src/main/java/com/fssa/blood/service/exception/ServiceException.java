package com.fssa.blood.service.exception;

public class ServiceException extends Exception{
	
	private static final long serialVersionUID = -7798283981195321951L;
	
	public ServiceException(String msg) {
		super(msg);
	}
	
	public ServiceException(Throwable e) {
		super(e);
	}
	
}
