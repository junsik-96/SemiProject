<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

<style type="text/css">
.btnnn{
  color: #fff;
  background-color: #007bff;
  border-color: #007bff;
  position: inherit;
  width:20%;
  margin-right: 625px;
}

.total{
	text-align: center;
	margin-right:635px;
}

.won{
	font-size:xx-large;
}

@Footer{
	position:absolute;
}
</style>

  <title>결제하기</title>

  <!-- Bootstrap core CSS -->
  <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/css/modern-business.css" rel="stylesheet">

</head>
<body>
 
  
  <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">결제하기
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">Home</a>
      </li>
      <li class="breadcrumb-item active">결제 완료</li>
    </ol>
<br>
<br>
<br>

<p>&nbsp;</p>
<!-- Intro Content -->
<div class="row">
<div class="col-lg-6"><img id="i" class="img-fluid rounded mb-4" style="display: block; margin-left: auto; margin-right: auto;" src="http://placehold.it/200x200" alt="" /></div>
<div class="col-lg-6" style="text-align: center;">
<h2 style="text-align: center;">결제가 완료되었습니다.</h2>
<br /><br /><br /><br /><br /></div>
</div>
<div class="pay" style="text-align: right;"><button id="sendMessageButton" class="btnnn" type="submit" onclick="location.href='http://localhost:9090/index'">홈으로</button></div>
<p><br /><br /></p>
<p><br /><br /><br /></p>
  

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

  <!-- Bootstrap core JavaScript -->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>