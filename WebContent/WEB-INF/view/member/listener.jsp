<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/joinlis.css">
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<body>

<div class="agree_top_div"><a class="agree_top" href="/index">shytalker</a></div>

<div class="container_join">

<div class="basic_lis">
<form>
  <fieldset>
    <legend class="request_lis">상담사 신청(자격 인증)</legend>
	<div>
	<small id="emailHelp" class="form-text text-muted">Welcome~!!</small><br>
	</div>
	
    <div class="form_name">
     <label for="exampleInputPassword1" class="la_name">이름</label>
      <input type="text" class="ip_name" id="exampleInputPassword1" placeholder="이름을 입력하세요.">
    </div>
    
    <div class="form_gender">
      <label for="exampleInputPassword1" class="la_gender">성별</label>
      <select class="ip_gender" id="exampleSelect1">
        <option>성별</option>
        <option value="man">남자</option>
        <option value="woman">여자</option>
        <option value="no">선택안함</option>
      </select>
    </div>
	
    <div class="form_uni">
      <label for="exampleInputID" class="la_uni">학교</label>
      <input type="text" class="ip_uni" id="exampleInputPassword1" placeholder="학교를 입력하세요">
      <button type="button" class="check_uni">학교검색</button>
    </div>
    
    <div class="form_class">
      <label for="exampleInputPassword1" class="la_class">학과</label>
      <input type="text" class="ip_class" id="exampleInputPassword1" placeholder="학과를 입력하세요">
       <button type="button" type="button"class="check_class">학과검색</button>
    </div>
    

    
     <div class="form_lic">
      <label for="exampleInputPassword1" class="la_lic">자격증</label>
      <input type="text" class="ip_lic" id="exampleInputPassword1" placeholder="자격증을 입력하세요">
       <button type="button" class="plus_lic">+</button>
       <button type="button" class="del_lic">-</button>
    </div>


		
	    
	    <div class="form_sector">
	      <label for="exampleInputPassword1" class="la_sector">주 분야<br>(다중선택가능)</label>
	    
       <select class="ip_sector" id="exampleSelect1">
        <option value="우울증">우울증</option>
         <option value="심리치료">심리치료</option>
        <option value="가정폭력">가정폭력</option>
        <option value="학교폭력">학교폭력</option>
        <option value="성폭력">성폭력</option>
        <option value="학교성적">학교성적</option>
        <option value="건강">건강</option>
        <option value="취업">취업</option>
        <option value="기타">기타</option>
      </select>
       <button type="button" class="plus_sec">+</button>
       <button type="button" class="del_sec">-</button>
	    </div>
	    
	    
    <div class="form_job">
      <label for="exampleInputPassword1" class="la_job">경력사항</label>
      <input type="text" class="ip_job" id="exampleInputPassword1" placeholder="회사 명">
      <label for="exampleInputPassword1" class="la_job_do"></label>
      <input type="text" class="ip_job_do" id="exampleInputPassword1" placeholder="경력 내용">
	 
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
    
       <button type="button" class="plus_job">+</button>
       <button type="button" class="del_job">-</button>
    </div>
    
   	 

	    
	    
	    <div class="form_phone">
	      <label for="exampleInputPassword1" class="la_phone">Phone</label>
	      <input type="text" class="ip_phone" id="exampleInputPassword1" placeholder=" - 을 제외한 번호만 입력하세요.">
          <button class="check_phone">인증하기</button>
	    </div>
	    
	    
	    <div class="form_phone_check">
	       <label for="exampleInputPassword1" class="la_phone_check">인증번호 입력</label>
	      <input type="text" class="ip_phone_check" id="exampleInputPassword1" placeholder="인증번호 입력">
	    </div>
	    
	  
	
    <button type="button" onclick="join()" class="req_btn">신청하기</button>
  </fieldset>
</form>
</div>

</div>

<script type="text/javascript">

function join(){
	alert("감사합니다. 신청되셨습니다! \n확인 후 신청승인이 진행됩니다.");
	location.href = "/shy/listenerlist";
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