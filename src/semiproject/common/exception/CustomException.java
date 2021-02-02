package semiproject.common.exception;

import semiproject.common.code.ErrorCode;

public class CustomException extends RuntimeException{

	private static final long serialVersionUID = -8601797238351405640L;
	
	public ErrorCode error;

	public CustomException(ErrorCode error) {
		this.error = error;
		//stackTrace를 공백으로 초기화
		this.setStackTrace(new StackTraceElement[0]);
	}
	
	public CustomException(ErrorCode error, Exception e) {
		this.error = error;
		// 콘솔에 log 작성
		e.printStackTrace();
	}
	
	
}
