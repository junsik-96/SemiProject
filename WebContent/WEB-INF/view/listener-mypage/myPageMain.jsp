
<!-- 상담사 마이페이지 // 메인 입니다. -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Bootstrap core CSS -->
  <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/css/modern-business.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
  
  <style type="text/css">
  		.list-main-body{
  			text-align: center;
   			font-size: 1.5rem;
    		color: darkorchid;
    		margin: 100px;
  		}
  		
  		.list-main-body > a {
  			margin : 30px;
  			padding: 10px;
  		
  		}
  
  
  </style>
</head>



<body>

	
 

  <!-- Page Content -->
  <div class="container">

    <!-- 페이지 제목 -->
    <h2 class="mt-4 mb-3"> ${sessionScope.user.name} 상담사님의 마이페이지 </h2>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index">Home</a>
      </li>
       <li class="breadcrumb-item active"><a href="/shy/myPageMain">마이페이지</a></li>
    </ol>

	<div class="list-main">
 	
	<div class="list-main-body">
		<a class="go-to-counsReview" href="/shy/counsReview">
			<span style="color:navy"><i class="fas fa-notes-medical">  상담내역</i></span>
		</a><br><br>
		<a class="go-to-mySchedule" href="/shy/mySchedule">
			<span style="color:navy"><i class="fas fa-calendar-alt">  나의 예약스케줄</i></span>
		</a><br><br>
		<a class="go-to-resConfirm" href="/shy/resConfirm">
			<span style="color:navy"><i class="fas fa-clipboard-list">  예약스케줄 관리</i></span>
		</a><br><br>
		<a class="go-to-reviews" href="/shy/listMypageReview">
		<span style="color:navy"><i class="fas fa-address-card">  평가내역</i></span>
		</a><br><br>
		<a class="go-to-reviews" href="/listener/updateintroduce">
		<span style="color:navy"><i class="fas fa-address-card">  정보 수정</i></span>
		</a><br><br>
		<a class="go-to-reviews" href="/listener/updateprofile">
		<span style="color:navy"><i class="fas fa-address-card">  프로필 수정</i></span>
		</a><br><br>
	</div>
	</div>	

	













    
    

  </div>
  <!-- Footer -->
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

  <!-- Bootstrap core JavaScript -->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

   
</body>
</html>