<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Bootstrap core CSS -->
  <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/css/modern-business.css" rel="stylesheet">

</head>
<body>
  

	 <h1 class="mt-4 mb-3">About
      <small>Listener</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="/index">Home</a>
      </li>
      <li class="breadcrumb-item active">상담사 찾기 	
      </li>
      <li>
      	<form action="${context}/listener/search" method="post" >
     	 <input type="search" class="search_lis" name="searchlis">
     	 <button type="button" class="search_btn"><i class="fas fa-search"></i></button>
      	</form>
      </li>  
    </ol>
	
	<% 
		String name = "";
		if(request.getParameter("searchlis") == null){
			name = "";
		}else{
			name = "'"+request.getParameter("searchlis")+"'"+"에 대한 검색 결과 입니다.";
		}
	%>
    
	<div><%=name%></div>
	
	<form id="check_form" action="${context}/listener/findlist">
		
		<div class="check_info">
			<div style="font-size: 13px;"> *원하시는 항목을 선택하여 주세요. (중복선택 가능)</div>
		</div>
		
		<div class="choose_lis">
		<div class="box_div">
			<div class="sector_lis">상담사 유형</div>
			<div class="box_list">
			 	<ul class="sector_li">
			 		<li><input type="checkbox" id="job1" name="job" value="전문가">전문의</li>
			 		<li><input type="checkbox" id="job2" name="job" value="의사">의사</li>
			 		<li><input type="checkbox" id="job3" name="job" value="대학생">대학생</li>			
			 	</ul>
			</div>
		</div>
						
		<div class="box_div">
		<div class="sector_lis">상담사 성별</div>
		<div class="box_list">
		 	<ul class="sector_li">
		 		<li><input type="checkbox" id="gender1" name="gender" value="여자">여성</li>
		 		<li><input type="checkbox" id="gender2" name="gender" value="남자">남성</li>
		 	</ul>
		</div>
		</div>
		
		<div class="box_div">
		<div class="sector_lis">상담사 나이</div>
		<div class="box_list">
		 	<ul class="sector_li">
		 		<li><input type="checkbox" id="age1" name="age" value="20">20대</li>
		 		<li><input type="checkbox" id="age2" name="age" value="30">30대</li>
		 		<li><input type="checkbox" id="age3" name="age" value="40">40대</li>
		 		<li><input type="checkbox" id="age4" name="age" value="50">50대</li>
		 		<li><input type="checkbox" id="age5" name="age" value="60">60대</li>
		 	</ul>
		</div>
		</div>
		
		<div class="box_div">
			<div class="sector_lis">가격</div>
			<div class="box_list">
			 	<ul class="sector_li">
			 		<li><input type="checkbox" class="price1" id="price_self" name="price" value="0" onclick="priceSelf()">무료</li>
			 		<li><input type="checkbox" class="price2" id="price" name="price" value="29999" onclick="priceAllCancel()">1 ~ 29,900원</li>
			 		<!-- <li><input type="checkbox" class="price3" id="price" name="price" value="39999" onclick="priceAllCancel()">20,000 ~ 39,900원</li> -->
			 		<li><input type="checkbox" class="price4" id="price_all" name="price" value="999999" onclick="priceAll()">상관없음</li>
			 	</ul>
			</div>
		</div>
				
		<div class="box_div">
			<div class="sector_lis">분야</div>
			<div class="box_list">
			 	<ul class="sector_li">
			 		<li><input type="checkbox" id="field1" name="sector" value="우울/불안">우울/불안</li>
			 		<li><input type="checkbox" id="field2" name="sector" value="가족/부부">가족/부부</li>
			 		<li><input type="checkbox" id="field3" name="sector" value="산후/육아">산후/육아</li>
			 		<li><input type="checkbox" id="field4" name="sector" value="대인관계">대인관계</li>
			 		<li><input type="checkbox" id="field5" name="sector" value="폭력/성폭력">폭력/성폭력</li>
			 		<li><input type="checkbox" id="field6" name="sector" value="성적/취업">성적/취업</li>
			 		<li><input type="checkbox" id="field7" name="sector" value="건강">건강</li>
			 		<li><input type="checkbox" id="field8" name="sector" value="기타">기타</li>
			 	</ul>
			</div>
		</div>
		</div>	
		<button type="button" class="btn_search_clear" style="width: 70px" onclick="del()">초기화</button>
		<button type="button" class="btn_search_lis" style="width: 70px">검색</button>
 	</form>
 	
 	
 <div class="find_row" id="result_lis">
      

	<c:choose>
      		<c:when test="${fn:length(result) > 0}">
      			<c:forEach var="i" begin="0" end="${fn:length(result)-1}" step="1">
      			<div class="col-lg-4 col-sm-6 portfolio-item find_result">
			        <div class="card h-100">
			          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
			          <div class="card-body">
		            <small class="card-title">
		               이름 : ${result[i].listName}<br>
		               번호 : ${result[i].listPhone}
		            </small>
		            <p class="card-text"></p>
		          </div>
		        </div>
		      </div> 
		      </c:forEach>
      		</c:when>
      		<c:when test="${fn:length(checkLis) > 0}">
			<c:forEach var="i" begin="0" end="${fn:length(checkLis)-1}" step="1">
      			<div class="col-lg-4 col-sm-6 portfolio-item find_result">
			        <div class="card h-100">
			          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
			          <div class="card-body">
		            <small class="card-title">
		               이름 : ${checkLis[i].listName}<br>
		               번호 : ${checkLis[i].listPhone}<br>
		           	   가격 : ${checkLis[i].listAmt} 
		            </small>
		            <p class="card-text"></p>
		          </div>
		        </div>
		      </div> 
		      </c:forEach>
      		</c:when>
      		<c:otherwise>
   		
      		</c:otherwise>
      	</c:choose>
      	
    
  
    </div>
	
	<!--  page 이동 -->
 	<div>
	  <ul class="pagination">
	    <li class="page-item disabled">
	      <a class="page-link" href="#">&laquo;</a>
	    </li>
	    <li class="page-item active">
	      <a class="page-link" href="#">1</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">2</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">3</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">4</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">5</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">&raquo;</a>
	    </li>
	  </ul>
	</div>



 
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

<script type="text/javascript">

function del(){
	$("input[type=checkbox]").prop("checked",false);
}


 	document.addEventListener("DOMContentLoaded",function(){
	    
      $(".btn_search_lis").click(function(){    
   		   if($("#job1").is(":checked") == false &&
		      $("#job2").is(":checked") == false &&
			  $("#job3").is(":checked") == false){
  	              alert("상담을 희망하는 상담사의 유형을 선택해주세요.");
   	              return;
   	          }else if($("#gender1").is(":checked") == false &&
   	        		   $("#gender2").is(":checked") == false){
   	              alert("상담을 희망하는 상담사의 성별을 선택해주세요.");
   	              return;
   	          }else if($("#age1").is(":checked") == false &&
   	        		   $("#age2").is(":checked") == false &&
   	        		   $("#age3").is(":checked") == false &&
   	        	   	   $("#age4").is(":checked") == false &&
   	        		   $("#age5").is(":checked") == false){
   	              alert("상담을 희망하는 상담사의 나이를 선택해주세요.");
   	              return;
   	          }else if($(".price1").is(":checked") == false &&
   	        		   $(".price2").is(":checked") == false &&
   	        		   $(".price3").is(":checked") == false &&
   	        		   $(".price4").is(":checked") == false ){
   	              alert("상담 가격을 선택해주세요.");
   	              return;
   	          }else if($("#field1").is(":checked") == false &&
	   	        	   $("#field2").is(":checked") == false &&
	   	        	   $("#field3").is(":checked") == false &&
	   	        	   $("#field4").is(":checked") == false &&
	   	        	   $("#field5").is(":checked") == false &&
	   	        	   $("#field6").is(":checked") == false &&
	   	        	   $("#field7").is(":checked") == false &&
	   	        	   $("#field8").is(":checked") == false ){
   	              alert("상담을 희망하는 상담사의 분야을 선택해주세요.");
   	              return;
   	          }else{
   	              $("#check_form").submit();
   	          }       
      });    
  }); 

	function priceAll(){
		if( $('#price_all').is(':checked')){
			$("input[id=price]").prop("checked",false);
			$("input[id=price_self]").prop("checked",false);
		}
	}
	
	function priceSelf(){
		if( $('#price_self').is(':checked')){
			$("input[id=price]").prop("checked",false);
			$("input[id=price_all]").prop("checked",false);
		}
	}
	
	function priceAllCancel(){
		if( 
			$('.price2').is(':checked') ||
			$('.price3').is(':checked')){
			$("input[id=price_all]").prop("checked",false);
			$("input[id=price_self]").prop("checked",false);
		}
	}
	
</script>

  <!-- Bootstrap core JavaScript -->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>