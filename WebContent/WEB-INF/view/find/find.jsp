<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

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

	 <h1 class="mt-4 mb-3">About
      <small>Listener</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index">Home</a>
      </li>
      <li class="breadcrumb-item active">상담사 찾기   	
      </li>
      <li>
      	<form action="${context}/shy/find" method="post" >
     	 <input type="search" class="search_lis">
     	 <button class="search_btn"><i class="fas fa-search"></i></button>
      	</form>
      </li>
      
    </ol>
	
	
	<div>'${searchlist}' 에 대한 검색 결과 입니다.</div>
	
	<form action="${context}/find/search">
		
		<div class="check_info">
			<pre> *원하시는 항목을 선택하여 주세요. (중복선택 가능)</pre>
		</div>
		
		<div class="choose_lis">
		<div class="box_div">
			<div class="sector_lis">상담사 유형</div>
			<div class="box_list">
			 	<ul class="sector_li">
			 		<li><input type="checkbox" name="job" value="expert">전문가</li>
			 		<li><input type="checkbox" name="job" value="doctor">의사</li>
			 		<li><input type="checkbox" name="job" value="student">대학생</li>
			 	</ul>
			</div>
		</div>
						
		<div class="box_div">
		<div class="sector_lis">상담사 성별</div>
		<div class="box_list">
		 	<ul class="sector_li">
		 		<li><input type="checkbox" name="sector" value="woman">여성</li>
		 		<li><input type="checkbox" name="sector" value="man">남성</li>
		 		<li><input type="checkbox" name="sector" value="both">상관없음</li>
		 	</ul>
		</div>
		</div>
		
		<div class="box_div">
		<div class="sector_lis">상담사 나이</div>
		<div class="box_list">
		 	<ul class="sector_li">
		 		<li><input type="checkbox" name="sector" value="woman">20대</li>
		 		<li><input type="checkbox" name="sector" value="man">30대</li>
		 		<li><input type="checkbox" name="sector" value="both">40대</li>
		 		<li><input type="checkbox" name="sector" value="both">50대</li>
		 		<li><input type="checkbox" name="sector" value="both">상관없음</li>
		 	</ul>
		</div>
		</div>
		
		<div class="box_div">
			<div class="sector_lis">가격</div>
			<div class="box_list">
			 	<ul class="sector_li">
			 		<li><input type="checkbox" name="price" value="service">무료</li>
			 		<li><input type="checkbox" name="price" value="ten">~10,000원</li>
			 		<li><input type="checkbox" name="price" value="ten_plus">10,000 ~ 30,000원</li>
			 		<li><input type="checkbox" name="price" value="else">30,000 ~</li>
			 	</ul>
			</div>
		</div>
				
		<div class="box_div">
			<div class="sector_lis">분야</div>
			<div class="box_list">
			 	<ul class="sector_li">
			 		<li><input type="checkbox" name="sector" value="sad">우울증</li>
			 		<li><input type="checkbox" name="sector" value="people">인간관계</li>
			 		<li><input type="checkbox" name="sector" value="family">가족관계</li>
			 		<li><input type="checkbox" name="sector" value="grade">학교성적</li>
			 		<li><input type="checkbox" name="sector" value="health">건강</li>
			 		<li><input type="checkbox" name="sector" value="hit">폭력</li>
			 		<li><input type="checkbox" name="sector" value="etc">기타</li>
			 	</ul>
			</div>
		</div>
		
		</div>
		
		<button class="btn_search_clear" style="width: 70px">초기화</button>
		<button class="btn_search_lis" style="width: 70px">검색</button>
 	</form>
 	
 	 <div class="find_row">
      <div class="col-lg-4 col-sm-6 portfolio-item find_result">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project One</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt?</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item find_result">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Two</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt?</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item find_result">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Three</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt?</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item find_result">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Four</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt?</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item find_result">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Five</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt?</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item find_result">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project Six</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt?</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item find_result">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project One</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt?</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item find_result">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project One</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt?</p>
          </div>
        </div>
      </div>
            <div class="col-lg-4 col-sm-6 portfolio-item find_result">
        <div class="card h-100">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="#">Project One</a>
            </h4>
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt?</p>
          </div>
        </div>
      </div>
    </div>
	
	<!--  page 이동 -->
 	<div>
	  <ul class="pagination">
	    <li class="page-item disabled">
	      <a class="page-link" href="#">&laquo;</a>
	    </li>
	    <li class="page-item active">
	      <a class="page-link" href="#">1</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">2</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">3</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">4</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">5</a>
	    </li>
	    <li class="page-item">
	      <a class="page-link" href="#">&raquo;</a>
	    </li>
	  </ul>
	</div>



 
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