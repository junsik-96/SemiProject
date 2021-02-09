package semiproject.common.code;

public enum ErrorCode {
	
	IM01("회원정보를 입력하는 도중 에러가 발생하였습니다.","/member/join"),
	SM01("회원정보를 조회하는 도중 에러가 발생하였습니다.","/member/login"),
	SM02("아이디나 패스워드가 틀렸습니다.","/member/login"),
	UM01("회원정보 수정 중 에러가 발생하였습니다."),
	AUTH01("접근 권한이 없는 페이지 입니다."),
	IB01("게시판 정보를 입력하는 중 에러가 발생하였습니다"),
	SB01("게시판 정보를 조회하는 중 에러가 발생하였습니다."),
	MAIL01("이메일 발송 중 에러가 발생하였습니다."),
	HTTP01("HTTP 통신 중 에러가 발생하였습니다."),
	SL01("상담사 랭킹을 조회하는 중 에러가 발생하였습니다."),
	FS01("학교를 조회하는 중 에러가 발생하였습니다."),
	CS01("학과를 조회하는 중 에러가 발생하였습니다."),
	CD_404("존재하지 않는 경로입니다."),
	PAY_404("결제에 실패하였습니다."),
	IF01("파일정보를 입력하는 중 에러가 발생하였습니다"),
	SF01("파일정보를 조회하는 중 에러가 발생하였습니다"),
	NOLIST("존재하지 않는 상담사 입니다."),
	NORES("예약에 실패하였습니다.");
	
	public String errMsg;
	public String url = "/index";
	
	// 에러발생시 index로 이동
	ErrorCode(String errMsg){
		this.errMsg = errMsg;
	}
	
	// 에러발생시 지정한 페이지로 이동
	ErrorCode(String errMsg,String url){
		this.errMsg = errMsg;
		this.url = url;
	}

	
}
