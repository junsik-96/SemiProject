class AsyncResponseError extends Error{
	
	/*
	 우리 서버에서 발생한 exception 을 result.jsp 에서 처리하는데
	 브라우저로 바로 넘어가면 상관없는데
	 비동기는 받아온 페이지를 화면에 그려주지 않기때문에
	 강제로 실행시켜주기위함
	  ==>> 비동기가 브라우저가 아니기 때문
	*/
	
	response;
	constructor(response){
		super();
		this.response = response;	
	}
	
	alertMessage(){
		// 강제로 script를 읽게하기 위한 변수
		let scripts = document.scripts;
		
		this.response.then(text =>{
			document.querySelector('html').innerHTML = text;
			// 해당 페이지의 마지막 스크립트 태그에 담겨있는 
			// 		자바스크립트 코드를 실행
			new Function(scripts[scripts.length-1].innerHTML)();
		})	
	}	
}