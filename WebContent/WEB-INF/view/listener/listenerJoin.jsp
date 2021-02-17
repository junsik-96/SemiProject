<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/joinlis.css">
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<body>

<div class="agree_top_div"><a class="agree_top" href="/index">shytalker</a></div>

<div class="container_join">

<div class="basic_lis">
<form action="${context}/listener/listenerjoinimpl" method="post" name="parent_form" id="lis_join">
  <fieldset>
    <legend class="request_lis">상담사 신청</legend>
	<div>
	<small id="emailHelp" class="form-text text-muted">Welcome~!!</small><br>
	</div>
    
    <div class="form_gender">
      <label for="exampleInputPassword1" class="la_gender">성별</label>
      <select class="ip_gender" id="lst_gen" name="list_gen">
        <option>성별</option>
        <option value="남자">남자</option>
        <option value="여자">여자</option>
      </select>
    </div>
    
    
    <div class="form_gender">
      <label for="exampleInputPassword1" class="la_gender">유형</label>
      <select class="ip_gender" id="list_type" name="list_type">
        <option>유형</option>
        <option value="전문가">전문가</option>
        <option value="의사">의사</option>
        <option value="대학생">대학생</option>
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
	    
       <select class="ip_sector" id="sel_field" name="lis_field">
        <option value="우울/불안">우울/불안</option>
        <option value="가족/부부">가족/부부</option>
        <option value="산후/육아">산후/육아</option>
        <option value="대인관계">대인관계</option>
        <option value="폭력/성폭력">폭력/성폭력</option>
        <option value="성적/취업">성적/취업</option>
        <option value="건강">건강</option>
        <option value="기타">기타</option>
      </select>
	    </div>
	    
	    
    <div class="form_job" id="add_job">
      <label for="exampleInputPassword1" class="la_job">경력사항</label>
      <input type="text" name="list_job" class="ip_job" id="com_name" placeholder="경력내용">    
      <button type="button" class="plus_job" id="plus_job" onclick="add_job()"> + </button>
    </div>
    
     <div class="form_lic" id="pro">
      <label for="exampleInputPassword1" class="la_lic" style="transform:translateY(-700%);">자기소개</label>
     <textarea rows="10" cols="70" placeholder="자신을 소개하는 글을 입력하세요." name="lis_pr"></textarea>
    </div>
	
	 <div class="form_lic" id="price">
      <label for="exampleInputPassword1" class="la_lic">가격</label>
      <input type="number" name="price" class="ip_lic" id="lis_lic" placeholder="상담사님과 상담을 진행할 때 필요한 가격을 입력하세요">
    </div>  
	
    <button type="submit" onclick="join()" class="req_btn">신청하기</button>
  </fieldset>
</form>
</div>

</div>




<script type="text/javascript">

function join(){
	
	document.querySelector('#lis_join').addEventListener('submit',(e)=>{
		
		if(document.parent_form.choose_school.value == ""){
			e.preventDefault();
			alert("학교를 선택해주세요!");
			choose_school.focus();
		}else if(document.parent_form.choose_class.value == ""){
			e.preventDefault();
			alert("학과를 선택해주세요!");
			choose_class.focus();
		}else if(document.parent_form.choose_school.value == ""){
			e.preventDefault();
			alert("상담사님의 주 분야를 선택해주세요!");
			choose_school.focus();
		}else{
			alert("감사합니다. 상담사 신청이 완료되었습니다!! \n친절하고 정성스러운 상담으로 많은분들에게 힘이 되어주세요!");
		}
		
	})
	
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
		plusLic.setAttribute("name","list_licen");
		$('#add_lic').append(plusLic); 
}

function add_job(){
	
		let plusJob = document.createElement('input');
		plusJob.placeholder = "경력내용을 추가로 입력하세요.";
		plusJob.style.display="block";
		plusJob.style.width="450px";
		plusJob.style.height="40px";
		plusJob.style.marginTop="10px";
		plusJob.style.marginLeft="153px";
		plusJob.setAttribute("name","list_job");
		$('#add_job').append(plusJob); 
}


</script>

<!-- Footer -->
  <footer class="py-5 bg-dark" style="background-color: #482C5D!important;">
  
	<div class = "shy_info">
   (주) 귀울임 사업자 정보    
  <div id = "footerInfo" style="font-size: 0.8rem;">  
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