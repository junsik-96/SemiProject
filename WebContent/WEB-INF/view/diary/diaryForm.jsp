<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %><body>

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
        <h3>일기 쓰기</h3>
        <form action="${context}/diary/upload"  method="post" 
        	 enctype="multipart/form-data" name="sentMessage" id="contactForm" novalidate>
          <div class="control-group form-group">
            <div class="controls">
              <label>제목:</label>
              <input type="text" class="form-control" id="name" required data-validation-required-message="제목을 입력해주세요.">
              <p class="help-block"></p>
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
  
   <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>