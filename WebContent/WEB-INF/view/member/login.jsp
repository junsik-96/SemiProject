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
	button{
		width: 100%;
	}
</style>
</head>
<body>

 <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
     <a class="navbar-brand" href="/index" style="font-style: italic">Shytalker</a>
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
               <a class="dropdown-item" href="/shy/board">대나무숲</a>
              <a class="dropdown-item" href="/shy/notice">공지사항</a>
           <a class="dropdown-item" href="/shy/listenerlist">상담사 신청목록</a>
              <a class="dropdown-item" href="/shy/customerCenter">고객센터</a>
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

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Login
      <small></small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="/index">Home</a>
      </li>
      <li class="breadcrumb-item active">Login</li>
    </ol>

    <!-- Content Row -->
    <div class="row">
      <!-- Map Column -->
        <!-- Embedded Google Map -->
        <img src="../../resources/image/login.jpg" style="width: 50%; height: 50%">
    	<div style="width: 48%; height: 50%; padding-left: 2vw; padding-top: 2vw">
        <h2>로그인</h2>
        <br>
        <form name="sentMessage" id="contactForm" novalidate>
          <div class="control-group form-group">
            <div class="controls">
              <label>아이디</label>
              <input type="text" class="form-control" name="id" id="id" required data-validation-required-message="Please enter your id." placeholder="아이디를 입력하세요.">
              <p class="help-block"></p>
            </div>
          </div>
          <div class="control-group form-group">
            <div class="controls">
              <label>비밀번호</label>
              <input type="password" class="form-control" name="pw" id="pw" required data-validation-required-message="Please enter your password." placeholder="비밀번호를 입력하세요.">
            </div>
          </div>
          <div id="success"></div>
          <!-- For success/fail messages -->
          <button class="btn btn-primary" id="sendMessageButton" onclick="login()">로그인</button>
        	<hr>
        	<div style="text-align: right">
	        	<label>아직 회원이 아니신가요? |&nbsp;&nbsp;<a href="/member/join"><small>회원가입 바로가기</small></a></label>
	        </div>
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

  <!-- Bootstrap core JavaScript -->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<script type="text/javascript">
		let login = () => {
			
			const url = '/member/loginimpl';
			
			let params = {};
			params.id = id.value;
			params.pw = pw.value;
			
			//post방식으로 진행
			//헤더 설정
			let headerObj = new Headers();
			//form태그의 기본 content 타입인 application/x-www-form-urlencoded로
			//content-type을 맞춰야 서버에서 편하게 getParameter로 사용할 수 있다.
			//name=value&name=value
			headerObj.append("content-type","application/x-www-form-urlencoded");
			fetch(url,{
				method : "POST",
				headers : headerObj,
				body : "data=" + JSON.stringify(params)
			}).then(response => {
				//200번대 응답코드라면
				if(response.ok){
					return response.text();
				}else{
					throw new AsyncResponseError(response.text());
				}
			}).then(text => {
				if(text == 'fail'){
					document.querySelector('.valid_info').innerHTML = '아이디나 비밀번호를 확인하세요';
				}else if(text == 'success'){
					location.href = "/index";
					//document.querySelector('html').innerHTML = text;
				}
			}).catch((error)=>{
				error.alertMessage();
			})
		}
	</script>
</body>
</html>