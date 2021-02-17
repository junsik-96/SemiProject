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
  <style type="text/css">
  	.sub{
  		height: 3vh;
  		background-color: gray;
  	}
  </style>
</head>
<body>
	 
  
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
        <form action="/member/modifyimpl" method="POST" id="user_modify" name="sentMessage" id="contactForm" novalidate>
          <div class="control-group form-group">
            <div class="controls">
              <label>아이디<br></label>
            </div>
            <div class="col-lg-9 mb-4">
            	<h5><b>${sessionScope.user.userId}</b></h5>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>이름</label>
              <input type="text" class="form-control" id="name" name="name" required data-validation-required-message="Please enter your name." placeholder="${sessionScope.user.name}">
              <p class="help-block"></p>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>이메일</label>
            </div>
            <div class="col-lg-9 mb-4">
            	<h5><b>${sessionScope.user.email}</b></h5>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>전화번호</label>
              <input type="tel" class="form-control" id="tel" name="tel" required data-validation-required-message="Please enter your phone number." placeholder="${sessionScope.user.tel}">
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>생년월일 <br></label>
            </div>
            <div class="col-lg-9 mb-4">
            	<h5><b>${sessionScope.user.birth}</b></h5>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>주 고민분야</label>
	             <select name="concern" class="form-control">
	             	<optgroup label="선택된 보기 : ${sessionScope.user.concern}">
	                	<option value="우울/불안">우울/불안</option>
	                	<option value="가족/부부">가족/부부</option>
	                	<option value="산후/육아">산후/육아</option>
	                	<option value="대인관계">대인관계</option>
	                	<option value="기타">기타</option>
	                </optgroup>
	             </select>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>선호 상담사 유형</label>
              	<select name="listType" class="form-control">
              		<optgroup label="선택된 보기 : ${sessionScope.user.listType}">
                		<option value="전문상담사">전문상담사</option>
                		<option value="의사">의사</option>
                		<option value="관련전공자">관련전공자</option>
                	</optgroup>
          		</select>
            </div>
          </div>
          <div id="success"></div>
          <!-- For success/fail messages -->
          <br>
          <button type="submit" class="btn btn-primary">수정하기</button>
        </form>
      </div>
      </div>
    </div>
    <!-- /.row -->
        
      </div>
    </div>
    <!-- /.row -->
  
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