
<!-- 상담사 // 상담 내역 페이지 입니다. -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>샤이토커</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/modern-business.css" rel="stylesheet">

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
              <a class="dropdown-item" href="shy/board">대나무숲</a>
              <a class="dropdown-item" href="notice">공지사항</a>
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
    <h1 class="mt-4 mb-3">상담사
      <small>상담내역</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="shy/index">Home</a>
      </li>
      <li class="breadcrumb-item active">상담사 마이페이지</li>
    </ol>

    <!-- 담당맡은 상담 리스트들 -->
    <div class="row">
      <div class="couns-review-cards">
        <div class="couns-review">
          <h4 class="couns-name">김뚠뚠</h4>
          <div class="couns-contents">
            <p class="couns-body">상담내용 상담내용</p>
          </div>
          <div class="couns-footer">
            <a href="#" class="btn couns-more">더 보기</a>
          </div>
        </div>
      </div>
      <div class="couns-review-cards">
        <div class="couns-review">
          <h4 class="couns-name">나괴롭</h4>
          <div class="couns-contents">
            <p class="couns-body">상담내용 상담내용</p>
          </div>
          <div class="couns-footer">
            <a href="#" class="btn couns-more">더 보기</a>
          </div>
        </div>
      </div><div class="couns-review-cards">
        <div class="couns-review">
          <h4 class="couns-name">최고민</h4>
          <div class="couns-contents">
            <p class="couns-body">상담내용 상담내용</p>
          </div>
          <div class="couns-footer">
            <a href="#" class="btn couns-more">더 보기</a>
          </div>
        </div>
      </div>
    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

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
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>



</body>
</html>