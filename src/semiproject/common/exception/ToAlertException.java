package semiproject.common.exception;

import semiproject.common.code.ErrorCode;

public class ToAlertException extends CustomException{

	private static final long serialVersionUID = 2808666389883932686L;

	public ToAlertException(ErrorCode error) {
		// TODO Auto-generated constructor stub
		super(error);
	}
	
	public ToAlertException(ErrorCode error, Exception e) {
		// TODO Auto-generated constructor stub
		super(error,e);
	}
	
}
