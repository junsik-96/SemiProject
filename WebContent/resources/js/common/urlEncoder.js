let urlEncodedForm = data => {
	
	/*
		data : urlEncoded 로 포맷팅 하고싶은 데이터
		속성명 : parameter Name
		값	 : parameter value
	*/
	
	let arr = [];
	
	/* for-in : date 객체에 담겨있는 속성명을 탐색해서 반환 */
	for(key in data){
		// String 으로 받기 때문에 [] 로 속성을 불러야한다.
		let param = encodeURIComponent(key) + '=' + encodeURIComponent(data[key]);
		arr.push(param);
	}
	
	// name=value&name=value 형태로 join 되서 넘어가게 된다
	return arr.join('&');
	
}
