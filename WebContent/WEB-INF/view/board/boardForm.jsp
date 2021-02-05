<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
            <a class="nav-link" href="find">상담사 찾기</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="diary">일기장</a>
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
         	 <c:otherwise>        	
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

<%--
	if(session.getAttribute("userId") == null) {		
		session.setAttribute("loginMsg", "게시물 작성은<br>로그인이 필요합니다.");
		response.sendRedirect("/shy/login");
		return;
	}

--%>
	  
<!-- Contact Form -->
    <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
<div>   
    <div class="container">
      <div class="col-lg-8 mb-4">
        <h3>대나무숲 글쓰기</h3>
        <form name="sentMessage" id="contactForm" novalidate>
          <div class="control-group form-group">
            <div class="controls">
              <label>제목:</label>
              <input type="text" class="form-control" id="name" required data-validation-required-message="제목을 입력해주세요.">
              <p class="help-block"></p>
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
              <label>글쓰기:</label>
              <textarea rows="10" cols="100" class="form-control" id="message" required data-validation-required-message="내용을 입력해주세요." maxlength="999" style="resize:none"></textarea>
            </div>
          </div>
          <div id="success"></div>
          <!-- For success/fail messages -->
          <button type="submit" class="btn btn-primary" id="sendMessageButton" style="justify-content:flex-end;">완료</button>
        </form>
      </div>
    </div>
</div>
    <!-- /.row -->



 
        
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
  
   <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>