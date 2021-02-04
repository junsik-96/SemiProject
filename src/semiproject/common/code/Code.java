package semiproject.common.code;

public enum Code {
	
	//DOMAIN("https://www.pclass.com");
	DOMAIN("http://localhost:9090"),
	EMAIL("jihyon2775@naver.com"),
	//UPLOAD("C:\\CODE\\E_SERVLET\\resources\\upload");
	UPLOAD("C:\\CODE\\E_SERVLET\\resources\\upload\\");
	
	public String desc;
	
	Code(String desc){
		this.desc = desc;
	}
	
	public String toString() {
		return desc;
	}
}
