<!-- 예약 하기 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>게시판</title>

  <!-- Bootstrap core CSS -->
  <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/css/modern-business.css" rel="stylesheet">

</head>

<body>
 






	 <h1 class="mt-4 mb-3">Booking</h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item active">상담 예약하기  	
      </li>
   </ol>
   <br>
	<br>
   
	<br>
	<br>
	<p style="text-align: center;">상담사 이름 : ${resById.listName}<label></label></p>
	<p style="text-align: center;">상담 가격 : ${resById.listAmt}<label></label></p>
	
<form action="${context}/payment/view?id=${resById.listId}" method="POST">
<h4 style="text-align: center;">날짜를 선택해주세요.</h4>
<br>
<p style="text-align: center;"><input type="date" name="day" /> <input type="time" name="time"/> 
<br><br>
<button type="submit" onclick="reservation()">예약하기</button></p>
</form>
 	<br>
 	<br>
 	<br>
	<br>
  
  
  
  
  
  
  
  
  <script type="text/javascript">
  
  function reservation(){
	  alert('예약 완료되었습니다');
	  location.href="/payment/view?id=${resById.listId}";  
  }
  
  </script>
  
  
  
  
  
  <footer class="py-5 bg-dark">
   <div class="container_footer">
   (주) 귀울임 사업자 정보 
  <pre id = "footerInfo">  		 		
(주) 귀울임 | 서울시 강남구 강남스타일로 123-4
대표 : 홍길동 | 개인정보보호책임 : 황진이
사업자 등록번호 : 123-45-6789
통신판매업신고 : 2021-서울강남-01234호
전화 : 02-1234-1234
email : pclass@khaca.com
    </pre>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>