package com.app.custom_exception;

@SuppressWarnings("serial")
public class CMSException extends Exception{
	public CMSException(String mesg) {
		super(mesg);
	}

}
