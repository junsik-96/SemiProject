<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;800&display=swap" rel="stylesheet">
 
	<style type="text/css">
  		.line-h2 {
  			color: #2f4f4f;
  			font-family: 'Nanum Gothic', sans-serif, bold;
  			font-size: 3rem;
  			
  		}
  		
  		.line-p {
  			color: #2f4f4f;
  			font-family: 'Nanum Gothic', sans-serif;
  		}
  		
  		.month-top {
  			font-weight: bold; 
  			font-size: 1.5rem; 
  			color: #2f4f4f;
  		}
  		
  		.col-lg-4{
			min-width: 300px;
		}
		
		.btn {
			font-size: 0.8rem;
			background-color: #482C5D;
			border-color: #482C5D;
			float: right;
		}
		
		
  		
  		
  		

  </style>

</head>

<body>


  	<br>
    <header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <!-- Slide One - Set the background image for this slide in the line below -->
        <div class="carousel-item active" style="background-image: url('/resources/image/slide2.jpg')">
          <div class="carousel-caption d-none d-md-block" style="top:50px; text-align: right;">
            <h1 class="line-h2">당신의 고민</h1><br>
            <pre class="line-p">
            	 코로나 블루, 우울증, 집단 따돌림...
            	힘들지만 누구에게도 말 못할 고민들에서부터 
            	   따뜻한 위로가 필요한 당신.
            	 	 이젠, 혼자 힘들어하지 마세요. 
            </pre>
          </div>
        </div>
        <!-- Slide Two - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url('/resources/image/slide4.jpg')">
          <div class="carousel-caption d-none d-md-block" style="top:50px; text-align: left;">
            <h1 class="line-h2">이젠, 걱정마세요!</h1><br>
            <pre class="line-p">
            	
            	세상에 사소한 고민은 없어요. 
            	 어떤 고민이든지 
            	당신에게 알맞는 상담사를 찾아드립니다. 
            </pre>
          </div>
        </div>
        <!-- Slide Three - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url('/resources/image/slide3.jpg')">
          <div class="carousel-caption d-none d-md-block" style="top:60px;">
           <h1 class="line-h2">  당신을 위한 전문가들</h1><br>
            <pre class="line-p">
            	 아무나 귀기울이지 않아요.
            	선뜻 용기내어 가기 힘들었던 병원이나 상담사들이
            	샤이토커에서 당신의 이야기를 들어드릴게요.
            </pre>
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
  
	<br>
	<hr>
	<br><br>
	
	<div class="body-contents">
	<c:choose>
	<c:when test="${sessionScope.userType eq '일반회원'}">
 <div id="month_reco" style="margin-left: 3.5%;"><small class="month-top"> '${sessionScope.user.name}' 님을 위한 상담사 추천 </small></div>
	<div class="row">
	
	<c:choose>
		<c:when test="${fn:length(comm1)-1 > 3}">
		<c:forEach var="i" begin="0" end="3" step="1">
		<div class="col-lg-4 mb-4">
        <div class="card h-100">
        <h6 class="card-header"> '${comm1[i].listName}'<small>(${comm1[i].type})  </small>
        	<div style="float: right;"><small> 추천 수 : ${comm1[i].listLikely}</small></div>
        </h6>
        
          <div class="card-body">
            <p class="card-text"> 
            <small>
            	전문분야 : ${comm1[i].listField} <br>
            	본인소개 : ${comm1[i].listPro} 
            </small>
           </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${comm1[i].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
	</c:forEach>
		</c:when>
		
		<c:otherwise>
		<c:forEach var="i" begin="0" end="${fn:length(comm1)-1}" step="1">
		<div class="col-lg-4 mb-4">
        <div class="card h-100">
        <h6 class="card-header"> '${comm1[i].listName}'<small>(${comm1[i].type})</small><br>
        	<div style="float: right;"><small>추천 수 : ${comm1[i].listLikely}</small></div>
        </h6>
        
          <div class="card-body">
           <p class="card-text"> 
            <small>
            	전문분야 : ${comm1[i].listField} <br>
            	본인소개 : ${comm1[i].listPro} 
            </small>
           </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${comm1[i].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
	</c:forEach>
		</c:otherwise>
	</c:choose>
    </div>
    <hr>
    <br><br>
    </c:when>
       	<c:otherwise>
       	</c:otherwise>
    </c:choose>    


	

 <div id="month_reco" style="margin-left: 3.5%;"><small class="month-top">인기 상담사 Top4</small></div>
    <div class="row">
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
        <h6 class="card-header"> '${rank1[0].listName}'<small>(${rank1[0].type})</small><br>
        	<div style="float: right;"><small>예약 수 : ${rank1[0].listResCnt}</small></div>
        </h6>
        
          <div class="card-body">
            <p class="card-text"> 
            <small>
            	전문분야 : ${rank1[0].listField} <br>
            	본인소개 : ${rank1[0].listPro} 
            </small>
           </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${rank1[0].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${rank2[0].listName}'<small>(${rank2[0].type})</small>
          <div style="float: right;"><small>예약 수 :${rank2[0].listResCnt}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
           		전문분야 : ${rank2[0].listField} <br>
            	본인소개 : ${rank2[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${rank2[0].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${rank3[0].listName}'<small>(${rank3[0].type})</small>
          <div style="float: right;"><small>예약 수 : ${rank3[0].listResCnt}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
       		    전문분야 : ${rank3[0].listField} <br>
            	본인소개 : ${rank3[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${rank3[0].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
          <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${rank4[0].listName}'<small>(${rank4[0].type})</small><br>
          <div style="float: right;"><small>예약 수 : ${rank4[0].listResCnt}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
       		    전문분야 : ${rank4[0].listField} <br>
            	본인소개 : ${rank4[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${rank4[0].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>      
    </div>
    <hr>
    <br><br>
   
 <div id="month_reco" style="margin-left: 3.5%;"><small class="month-top">추천 상담사 Top4</small></div>
    <div class="row">
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
        <h6 class="card-header"> '${rankLike1[0].listName}'<small>(${rankLike1[0].type})</small><br>
        	<div style="float: right;"><small>추천 수 : ${rankLike1[0].listLikely}</small></div>
        </h6>
        
          <div class="card-body">
            <p class="card-text"> 
            <small>
            	전문분야 : ${rankLike1[0].listField} <br>
            	본인소개 : ${rankLike1[0].listPro} 
            </small>
           </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${rankLike1[0].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${rankLike2[0].listName}'<small>(${rankLike2[0].type})</small><br>
          <div style="float: right;"><small>추천 수 : ${rankLike2[0].listLikely}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
           		전문분야 : ${rankLike2[0].listField} <br>
            	본인소개 : ${rankLike2[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${rankLike2[0].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${rankLike3[0].listName}'<small>(${rankLike3[0].type})</small><br>
          <div style="float: right;"><small>추천 수 : ${rankLike3[0].listLikely}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
       		    전문분야 : ${rankLike3[0].listField} <br>
            	본인소개 : ${rankLike3[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${rankLike3[0].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
          <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${rankLike4[0].listName}'<small>(${rankLike4[0].type})</small><br>
          <div style="float: right;"><small>추천 수 : ${rankLike4[0].listLikely}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
       		    전문분야 : ${rankLike4[0].listField} <br>
            	본인소개 : ${rankLike4[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${rankLike4[0].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>      
    </div>
    <hr>
    <br><br>

 <div id="month_reco" style="margin-left: 3.5%;"><small class="month-top">새로 등록된 상담사</small></div>
    <div class="row">
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
        <h6 class="card-header"> '${rankReg1[0].listName}'<small>(${rankReg1[0].type})</small><br>
        	<div style="float: right;"><small>등록일 : ${rankReg1[0].listRegDate}</small></div>
        </h6>
        
          <div class="card-body">
            <p class="card-text"> 
            <small>
            	전문분야 : ${rankReg1[0].listField} <br>
            	본인소개 : ${rankReg1[0].listPro} 
            </small>
           </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${rankReg1[0].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${rankReg2[0].listName}'<small>(${rankReg2[0].type})</small><br>
          <div style="float: right;"><small>등록일 : ${rankReg2[0].listRegDate}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
           		전문분야 : ${rankReg2[0].listField} <br>
            	본인소개 : ${rankReg2[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${rankReg2[0].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${rankReg3[0].listName}'<small>(${rankReg3[0].type})</small><br>
          <div style="float: right;"><small>등록일 : ${rankReg3[0].listRegDate}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
       		    전문분야 : ${rankReg3[0].listField} <br>
            	본인소개 : ${rankReg3[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${rankReg3[0].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
       <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${rankReg4[0].listName}'<small>(${rankReg4[0].type})</small><br>
          <div style="float: right;"><small>등록일 : ${rankReg4[0].listRegDate}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
       		    전문분야   : ${rankReg4[0].listField} <br>
            	본인소개 : ${rankReg4[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="/listener/profile?id=${rankReg4[0].listId}" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
    </div>

    <hr>
	</div>


 
</body>


  <!-- Bootstrap core JavaScript -->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

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
	

</html>