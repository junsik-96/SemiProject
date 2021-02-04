
<!-- 상담사 // 평가내역 페이지 입니다 -->

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

  <!-- Custom styles for this template -->
  <link href="css/modern-business.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
  <style type="text/css">
  		
  		.review-card {
    	
    		.review-block {
       		 .cust-img {
           		 width: 50px;
           		 height: 50px;
       	 }

        > div {
            padding-top: 25px;
            padding-bottom: 25px;
            margin-left: 0;
            margin-right: 0;
            padding-left: 5px;
            padding-right: 5px;

            &:hover {
                background-color: transparentize($primary-color, 0.9);
            }
        }
    }
}
  		

  </style>

</head>


<body>

	
  <!-- 상단 고정 바  -->
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
  
  <!-- Page Content -->
  <div class="container">
  
  <h1 class="mt-4 mb-3">상담사
      <small>평가내역</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index">Home</a>
      </li>
       <li class="breadcrumb-item active"><a href="/shy/myPageMain">상담사 마이페이지</a></li>
    </ol>

     <!-- review start -->
            <div class="col-lg-8 col-md-12">
                <div class="card table-card review-card" style="width: 800px;
    		margin-left: 20%;">
                    <div class="card-header borderless ">
                        <h5>평가 후기</h5>
                    </div>
                    
                    <!-- 후기 카드 -->
                    <div class = "card">
                    <div class="card-body">
                        <div class="review-block">
                            <div class="row">
                 
                                <div class="col">
                                    <h6 class="m-b-15">김뚠뚠 <span class="float-right f-13 text-muted"> 20/11/11</span></h6>
                                    <a href="#!"><i class="fas fa-star"></i></a>
                                    <a href="#!"><i class="fas fa-star"></i></a>
                                    <a href="#!"><i class="fas fa-star"></i></a>
                                    <a href="#!"><i class="fas fa-star"></i></a>
                                    <a href="#!"><i class="far fa-star"></i></a>
                                    <p class="m-t-15 m-b-15 text-muted">상담을 너무 잘해주셔서 많이 나아졌습니다. 
                                    친절하시고 상담시간 이외에도 가끔 톡으로 물어봐주셔서 더 케어받는 마음이 들었어요.
                                    감사합니다! </p>
                                </div>
                            </div>
                            <br><br>
                            <div class="row">
                               
                                <div class="col">
                                     <h6 class="m-b-15">고민없어요 <span class="float-right f-13 text-muted"> 20/12/12</span></h6>
                                    <a href="#!"><i class="fas fa-star"></i></a>
                                    <a href="#!"><i class="fas fa-star"></i></a>
                                    <a href="#!"><i class="fas fa-star"></i></a>
                                    <a href="#!"><i class="fas fa-star"></i></a>
                                    <a href="#!"><i class="fas fa-star"></i></a>
                                    <p class="m-t-15 m-b-15 text-muted">상담을 너무 잘해주셔서 많이 나아졌습니다. 
                                    친절하시고 상담시간 이외에도 가끔 톡으로 물어봐주셔서 더 케어받는 마음이 들었어요.
                                    감사합니다! </p>
                                </div>
                                    
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="text-right  m-r-20">
                            <a href="#!" class="b-b-primary text-primary">리뷰 더 보기</a>
                        </div>
                    </div>
                </div>
                <br>
                <br>
    			</div>

   
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
</div>
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