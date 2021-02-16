<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<body>

<h1 class="mt-4 mb-3">About
      <small>ListenerProfile</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="/index">Home</a>
      </li>
      <li class="breadcrumb-item active">상담사 상세페이지
      </li> 
    </ol>
    
<hr>
<div style="min-height: 500px; margin-left: 3%;">
<span style="font-size: 2vw;">${listById.listName}</span> 님의 프로필<br><br>
성별 : ${listById.listGen} <br>
유형 : ${listById.type} <br>
주 분야 : ${listById.listField} <br>
최종학력 : ${listById.listSchool} / ${listById.listClass} <br>
상담사 등록일 : ${listById.listRegDate} <br>
추천 수 : ${listById.listLikely} <br>
예약 수 : ${listById.listResCnt} <br>
상담가격 : ${listById.listAmt} <br>
자기소개 : ${listById.listPro}<br>
<a href="#" class="btn btn-primary" style="margin-top: 5%;">결제하러 가기</a>

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
</body>
</html>