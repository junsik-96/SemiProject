<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Shytalker</title>

  <!-- Bootstrap core CSS -->
  <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/resources/css/modern-business.css" rel="stylesheet">
</head>
<body>
	 <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
     <a class="navbar-brand" href="index" style="font-style: italic">Shytalker</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="/shy/find">상담사 찾기</a>
          </li>          
          <li class="nav-item">
            <a class="nav-link" href="/shy/diary">일기장</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPages" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              	게시판
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPages">
               <a class="dropdown-item" href="board">대나무숲</a>
              <a class="dropdown-item" href="notice">공지사항</a>
             <a class="dropdown-item" href="listenerlist">상담사 신청목록</a>
              <a class="dropdown-item" href="customerCenter">고객센터</a>
            </div>
          </li>
          
          <c:choose>
         	 <c:when test="${empty sessionScope.user}">
          		 <li class="nav-item">
          		  <a class="nav-link" href="/shy/login">Login</a>
         		 </li>
         		 <li class="nav-item">
          		  <a class="nav-link" href="/shy/join">회원가입</a>
         		 </li>
         	 </c:when>
         	 <c:otherwise>>        		
         		 <li class="nav-item">
           			 <a class="nav-link" href="/shy/myPage">마이페이지</a>
         		 </li>
         		  <li class="nav-item">
           			 <a class="nav-link" href="/shy/logOut">LogOut</a>
         		 </li>  		  
         	 </c:otherwise>
          </c:choose>
          
        </ul>
      </div>
    </div>
  </nav>
  
<!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">MyPage
      <small></small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="/index">Home</a>
      </li>
      <li class="breadcrumb-item">
        <a href="/member/mypage">Mypage</a>
      </li>
      <li class="breadcrumb-item active">내 정보 수정</li>
    </ol>

    <!-- Content Row -->
    <div class="row">
      <!-- Sidebar Column -->
      <div class="col-lg-3 mb-4">
        <div class="list-group" style="text-align: center; padding-top: 1vw">
          <a href="/member/mypage" class="list-group-item">마이페이지</a>
          <a href="/member/user_modify" class="list-group-item">내 정보 수정</a>
          <a href="/member/hold" class="list-group-item">찜 목록</a>
          <a href="/member/reservation" class="list-group-item">예약내역</a>
          <a href="/member/payment" class="list-group-item">결제내역</a>
          <a href="/member/myboard" class="list-group-item">내 게시글</a>
        </div>
      </div>
      <!-- Content Column -->
      <div class="col-lg-9 mb-4" style="padding-top: 1vw">
        <h1>내 정보 수정</h1>
        <hr>
        <div class="row">
    	<div style="width: 70%; height: 70%; padding-left: 2vw; padding-top: 1vw; padding-bottom: 1vw">
        <form name="sentMessage" id="contactForm" novalidate>
          <div class="control-group form-group">
            <div class="controls">
              <label>아이디</label>
              <input type="text" class="form-control" id="id" required data-validation-required-message="Please enter your id." placeholder="변경 전 아이디">
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>이름</label>
              <input type="text" class="form-control" id="name" required data-validation-required-message="Please enter your name." placeholder="변경 전 이름">
              <p class="help-block"></p>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>이메일 <br><b>semi@semi.com</b></label>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>생년월일 <br><b>1990-01-01</b></label>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>주 고민분야</label>
	             <select name="concern" class="form-control">
	             	<option value="선택안함" selected>선택안함</option>
	                <option value="우울/불안">우울/불안</option>
	                <option value="가족/부부">가족/부부</option>
	                <option value="산후/육아">산후/육아</option>
	                <option value="대인관계">대인관계</option>
	                <option value="기타">기타</option>
	             </select>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>선호 상담사 유형</label>
              	<select name="ingredient" class="form-control">
                	<option value="선택안함" selected>선택안함</option>
                	<option value="전문상담사">전문상담사</option>
                	<option value="의사">의사</option>
                	<option value="관련전공자">관련전공자</option>
          		</select>
            </div>
          </div>
          <div id="success"></div>
          <!-- For success/fail messages -->
          <br>
          <button type="submit" class="btn btn-primary" id="sendMessageButton">수정하기</button>
        </form>
      </div>
      </div>
    </div>
    <!-- /.row -->
        
      </div>
    </div>
    <!-- /.row -->
  
 <!-- Footer -->
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