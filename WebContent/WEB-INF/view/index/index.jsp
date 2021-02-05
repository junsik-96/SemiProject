<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>


<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Modern Business - Start Bootstrap Template</title>

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
  
    <header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <!-- Slide One - Set the background image for this slide in the line below -->
        <div class="carousel-item active" style="background-image: url('http://placehold.it/1900x1080')">
          <div class="carousel-caption d-none d-md-block">
            <h3>First Slide</h3>
            <p>This is a description for the first slide.</p>
          </div>
        </div>
        <!-- Slide Two - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url('http://placehold.it/1900x1080')">
          <div class="carousel-caption d-none d-md-block">
            <h3>Second Slide</h3>
            <p>This is a description for the second slide.</p>
          </div>
        </div>
        <!-- Slide Three - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url('http://placehold.it/1900x1080')">
          <div class="carousel-caption d-none d-md-block">
            <h3>Third Slide</h3>
            <p>This is a description for the third slide.</p>
          </div>
        </div>
      </div>
      <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  </header>
  
	<div class="my-4">당신 목소리에, 귀울임</div>
     <pre class="intro">
     	Welcome everyone!!
     </pre>
    
   

    <div id="month_res">예약건수 상담사 랭킹</div>
    <div class="row">
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h5 class="card-header">상담사 이름</h5>
          <div class="card-body">
            <p class="card-text">1등 상담사 소개</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 개인페이지로 이동</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h5 class="card-header">상담사 이름</h5>
          <div class="card-body">
            <p class="card-text">2등 상담사 소개</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 개인페이지로 이동</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h5 class="card-header">상담사 이름</h5>
          <div class="card-body">
            <p class="card-text">3등 상담사 소개</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 개인페이지로 이동</a>
          </div>
        </div>
      </div>
    </div>
   
    <div id="month_reco">추천수 상담사 랭킹</div>
    <div class="row">
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h5 class="card-header">상담사 이름</h5>
          <div class="card-body">
            <p class="card-text">1등 상담사 소개</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 개인페이지로 이동</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h5 class="card-header">상담사 이름</h5>
          <div class="card-body">
            <p class="card-text">2등 상담사 소개</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 개인페이지로 이동</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h5 class="card-header">상담사 이름</h5>
          <div class="card-body">
            <p class="card-text">3등 상담사 소개</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 개인페이지로 이동</a>
          </div>
        </div>
      </div>
    </div>

    <h4>상담사 추천 -> 누르면 개인페이지 이동</h4>

      <div id="month_recently">신규 상담사(최신순 3명)</div>
    <div class="row">
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h5 class="card-header">상담사 이름</h5>
          <div class="card-body">
            <p class="card-text">상담사 소개</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 개인페이지로 이동</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h5 class="card-header">상담사 이름</h5>
          <div class="card-body">
            <p class="card-text">상담사 소개</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 개인페이지로 이동</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h5 class="card-header">상담사 이름</h5>
          <div class="card-body">
            <p class="card-text">상담사 소개</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 개인페이지로 이동</a>
          </div>
        </div>
      </div>
    </div>

    <hr>


    <div class="row mb-4">
      <div class="col-md-8">
        <p>귀울임은 ~~~한 페이지입니다. </p>
      </div>
      <div class="col-md-4">
        <a class="btn btn-lg btn-secondary btn-block" href="#">Call to Action</a>
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