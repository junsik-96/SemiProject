<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/joinlis.css">
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<body>

<div class="agree_top_div"><a class="agree_top" href="/index">shytalker</a></div>

<div class="container_join">

<div class="basic_lis">
<form name="parent_form" id="lis_join">
  <fieldset>
    <legend class="request_lis">상담사 신청(자격 인증)</legend>
	<div>
	<small id="emailHelp" class="form-text text-muted">Welcome~!!</small><br>
	</div>
    
    <div class="form_gender">
      <label for="exampleInputPassword1" class="la_gender">성별</label>
      <select class="ip_gender" id="exampleSelect1" name="list_gen">
        <option>성별</option>
        <option value="man">남자</option>
        <option value="woman">여자</option>
        <option value="no">선택안함</option>
      </select>
    </div>
	
    <div class="form_uni">
      <label for="exampleInputID" class="la_uni">학교</label>
      <input type="text" name="choose_school" class="ip_uni" id="choose_school" placeholder="학교를 입력하세요" onclick="school_find();">
      <button type="button" class="check_uni" onclick="school_find()">학교검색</button>
    </div>
    
    <div class="form_class">
      <label for="exampleInputPassword1" class="la_class">학과</label>
      <input type="text" name="choose_class"class="ip_class" id="choose_class" placeholder="학과를 입력하세요" onclick="class_find()">
       <button type="button" class="check_class" onclick="class_find()">학과검색</button>
    </div>
    

    
     <div class="form_lic" id="add_lic">
      <label for="exampleInputPassword1" class="la_lic">자격증</label>
      <input type="text" name="list_licen" class="ip_lic" id="lis_lic" placeholder="자격증을 입력하세요">
       <button type="button" class="plus_lic" id="plus_btn" onclick="add_license()"> + </button>
    </div>


		
    
    <div class="form_sector" id="add_field">
      <label for="exampleInputPassword1" class="la_sector">주 분야<br></label>
	    
       <select class="ip_sector" id="sel_field">
        <option value="우울/불안">우울/불안</option>
        <option value="가족/부부">가족/부부</option>
        <option value="산후/육아">산후/육아</option>
        <option value="대인관계">대인관계</option>
        <option value="폭력/성폭력">폭력/성폭력</option>
        <option value="성적/취업">성적/취업</option>
        <option value="건강">건강</option>
        <option value="기타">기타</option>
      </select>
       <button type="button" class="plus_sec" onclick="add_field()">+</button>
	    </div>
	    
	    
    <div class="form_job">
      <label for="exampleInputPassword1" class="la_job">경력사항</label>
      <input type="text" name="com_name" class="ip_job" id="com_name" placeholder="직장 명">
      <label for="exampleInputPassword1" class="la_job_do"></label>
      <input type="text" name="job_name" class="ip_job_do" id="job_name" placeholder="경력 내용">
	 
      <label for="exampleInputPassword1" class="la_job_do"></label>
	  <input type="text" class="ip_job_do_y1" id="exampleInputPassword1" placeholder="년(4자)">
	 
	  <select class="job_date1" id="exampleSelect1">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
      </select>
      
      
      <label for="exampleInputPassword1" class="la_job_do_middle" style="transform:translate(-10%,30%);"> ~ </label>
      
       <input type="text" class="ip_job_do_y2" id="exampleInputPassword1" placeholder="년(4자)">
        
      <select class="job_date2" id="exampleSelect1">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
      </select>
    
    </div>
    
   	 

	    
	    
	   <!--  <div class="form_phone">
	      <label for="exampleInputPassword1" class="la_phone">Phone</label>
	      <input type="text" class="ip_phone" id="exampleInputPassword1" placeholder=" - 을 제외한 번호만 입력하세요.">
          <button class="check_phone">인증하기</button>
	    </div>
	    
	    
	    <div class="form_phone_check">
	       <label for="exampleInputPassword1" class="la_phone_check">인증번호 입력</label>
	      <input type="text" class="ip_phone_check" id="exampleInputPassword1" placeholder="인증번호 입력">
	    </div> -->
	    
	  
	
    <button type="button" onclick="join()" class="req_btn">신청하기</button>
  </fieldset>
</form>
</div>

</div>




<script type="text/javascript">

function join(){
	if(document.parent_form.choose_school.value ==""){
		alert("학교를 선택해주세요!");
		choose_school.focus();
	}else if(document.parent_form.choose_class.value ==""){
		alert("학과를 선택해주세요!");
		choose_class.focus();
	}else if(document.parent_form.list_licen.value ==""){
		alert("자격증을 입력해주세요!");
		list_licen.focus();
	}else if(document.parent_form.choose_school.value ==""){
		alert("상담사님의 주 분야를 선택해주세요!");
		choose_school.focus();
	}else{
		parent_form.submit();
		alert("감사합니다. 상담사 신청이 완료되었습니다!! \n확인 후 신청승인이 진행됩니다.");
		location.href = "/shy/listenerlist";
	}
	
}


function school_find(){
	let link = "http://localhost:9090/listener/findschool"
	var w = 500;
	var h = 660;
	var x = (screen.width - w) /2;
	var y = (screen.height - h) / 2;
	window.open(link,"",'left='+x+',top='+y+',width='+w+',height='+h);
}


function class_find(){
	let link = "http://localhost:9090/listener/findclass"
	var w = 500;
	var h = 660;
	var x = (screen.width - w) /2;
	var y = (screen.height - h) / 2;
	window.open(link,"",'left='+x+',top='+y+',width='+w+',height='+h);
}

function add_license(){
		
 		let plusLic = document.createElement('input');
		plusLic.placeholder = "자격증을 추가로 입력하세요.";
		plusLic.style.display="block";
		plusLic.style.width="450px";
		plusLic.style.height="40px";
		plusLic.style.marginTop="10px";
		plusLic.style.marginLeft="153px";
		plusLic.setAttribute("name","plusLicense");
		$('#add_lic').append(plusLic); 
}

function add_field(){

	/* let plusField = document.createElement('select');
	plusField.style.display="block";
	plusField.style.width="450px";
	plusField.style.height="40px";
	plusField.style.marginTop="10px";
	plusField.style.marginLeft="153px";
	plusField.setAttribute("option","우울증");
	$('#add_field').append(plusField);  */
	
	let plusField = document.createElement('select');
	plusField.style.display="block";
	plusField.style.width="450px";
	plusField.style.height="40px";
	plusField.style.marginTop="10px";
	plusField.style.marginLeft="153px";
	
	let opt1 = document.createElement("option");
	opt1.text = "우울/불안";
	opt1.value="우울/불안";
	
	let opt2 = document.createElement("option");
	opt2.text = "가족/부부";
	opt2.value="가족/부부";
	
	let opt3 = document.createElement("option");
	opt3.text = "산후/육아";
	opt3.value="산후/육아";
	
	let opt4 = document.createElement("option");
	opt4.text = "대인관계";
	opt4.value="대인관계";
	
	let opt5 = document.createElement("option");
	opt5.text = "폭력/성폭력";
	opt5.value="폭력/성폭력";
	
	let opt6 = document.createElement("option");
	opt6.text = "성적/취업";
	opt6.value="성적/취업";
	
	let opt7 = document.createElement("option");
	opt7.text = "건강";
	opt7.value="건강";
	
	let opt8 = document.createElement("option");
	opt8.text = "기타";
	opt8.value="기타";
	
	plusField.appendChild(opt1);
	plusField.appendChild(opt2);
	plusField.appendChild(opt3);
	plusField.appendChild(opt4);
	plusField.appendChild(opt5);
	plusField.appendChild(opt6);
	plusField.appendChild(opt7);
	plusField.appendChild(opt8);
	
	plusField.setAttribute("name","plusField");
	
	$('#add_field').append(plusField);
}



</script>

<footer class="py-5 bg-dark">
  
	<div class = "shy_info">
   (주) 귀울임 사업자 정보    
  <div id = "footerInfo">  
  <br>		 		
	(주) 귀울임 | 서울시 강남구 강남스타일로 123-4<br>
	대표 : 홍길동 | 개인정보보호책임 : 황진이<br>
	사업자 등록번호 : 123-45-6789<br>
	통신판매업신고 : 2021-서울강남-01234호<br>
	전화 : 02-1234-1234<br>
	email : pclass@khaca.com<br>
    </div>
	</div>
    
  </footer>

</body>
</html>