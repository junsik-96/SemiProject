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

</head>

<body>


  
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
  
	<div class="my-4" style="color:rgb(138, 43, 226);">당신 목소리에, 귀울임</div>
     <pre class="intro" style="color:rgb(138, 43, 226);">
     	Welcome everyone!!
     </pre>
	
	

	<c:choose>
	<c:when test="${sessionScope.userType eq '일반회원'}">
   <div id="month_reco">상담사 추천</div>
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
          <img src="/resources/image/아무개.jfif" style="width: 100%; height: 60%; object-fit:cover;">
            <p class="card-text"> 
            <small>
            	전문분야 : ${comm1[i].listField} <br>
            	한줄소개 : ${comm1[i].listPro} 
            </small>
           </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
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
<!--           <img src="/resources/image/아무개.jfif" style="width: 100%; height: 60%; object-fit:cover;">
 -->            <p class="card-text"> 
            <small>
            	전문분야 : ${comm1[i].listField} <br>
            	한줄소개 : ${comm1[i].listPro} 
            </small>
           </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
	</c:forEach>
		</c:otherwise>
	</c:choose>

  <%--<div class="col-lg-4 mb-4">
        <div class="card h-100">
        <h6 class="card-header"> '${comm1[0].listName}'<small>(${comm1[0].type})</small>
        	<div style="float: right;"><small>예약 수 : ${comm1[0].listResCnt}</small></div>
        </h6>
        
          <div class="card-body">
          <img src="/resources/image/아무개.jfif" style="width: 100%; height: 60%; object-fit:cover;">
            <p class="card-text"> 
            <small>
            	전문분야 : ${comm1[0].listField} <br>
            	한줄소개 : ${comm1[0].listPro} 
            </small>
           </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${comm1[1].listName}'<small>(${comm1[1].type})</small>
          <div style="float: right;"><small>예약 수 :${comm1[1].listResCnt}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
           		전문분야 : ${comm1[1].listField} <br>
            	한줄소개 : ${comm1[1].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${comm1[2].listName}'<small>(${comm1[0].type})</small>
          <div style="float: right;"><small>예약 수 : ${comm1[0].listResCnt}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
       		    전문분야 : ${comm1[0].listField} <br>
            	한줄소개 : ${comm1[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
          <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${comm1[0].listName}'<small>(${comm1[0].type})</small>
          <div style="float: right;"><small>예약 수 : ${comm1[0].listResCnt}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
       		    전문분야 : ${comm1[0].listField} <br>
            	한줄소개 : ${comm1[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>    --%>   
    </div>
    <hr>
    <br><br>
    </c:when>
       	<c:otherwise>
       	</c:otherwise>
    </c:choose>    


	

 <div id="month_reco">예약수 상담사 랭킹</div>
    <div class="row">
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
        <h6 class="card-header"> '${rank1[0].listName}'<small>(${rank1[0].type})</small><br>
        	<div style="float: right;"><small>예약 수 : ${rank1[0].listResCnt}</small></div>
        </h6>
        
          <div class="card-body">
          <img src="/resources/image/아무개.jfif" style="width: 100%; height: 60%; object-fit:cover;">
            <p class="card-text"> 
            <small>
            	전문분야 : ${rank1[0].listField} <br>
            	한줄소개 : ${rank1[0].listPro} 
            </small>
           </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${rank2[0].listName}'<small>(${rank2[0].type})</small><br>
          <div style="float: right;"><small>예약 수 :${rank2[0].listResCnt}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
           		전문분야 : ${rank2[0].listField} <br>
            	한줄소개 : ${rank2[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h6 class="card-header">'${rank3[0].listName}'<small>(${rank3[0].type})</small><br>
          <div style="float: right;"><small>예약 수 : ${rank3[0].listResCnt}</small></div>
          </h6>
          <div class="card-body">
            <p class="card-text">
            <small>
       		    전문분야 : ${rank3[0].listField} <br>
            	한줄소개 : ${rank3[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
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
            	한줄소개 : ${rank4[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>      
    </div>
    <hr>
    <br><br>
   
    <div id="month_reco">추천수 상담사 랭킹</div>
    <div class="row">
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
        <h6 class="card-header"> '${rankLike1[0].listName}'<small>(${rankLike1[0].type})</small><br>
        	<div style="float: right;"><small>추천 수 : ${rankLike1[0].listLikely}</small></div>
        </h6>
        
          <div class="card-body">
          <img src="/resources/image/아무개.jfif" style="width: 100%; height: 60%; object-fit:cover;">
            <p class="card-text"> 
            <small>
            	전문분야 : ${rankLike1[0].listField} <br>
            	한줄소개 : ${rankLike1[0].listPro} 
            </small>
           </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
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
            	한줄소개 : ${rankLike2[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
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
            	한줄소개 : ${rankLike3[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
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
            	한줄소개 : ${rankLike4[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>      
    </div>
    <hr>
    <br><br>

   <div id="month_recently">신규 상담사(최신순 3명)</div>
    <div class="row">
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
        <h6 class="card-header"> '${rankReg1[0].listName}'<small>(${rankReg1[0].type})</small><br>
        	<div style="float: right;"><small>등록일 : ${rankReg1[0].listRegDate}</small></div>
        </h6>
        
          <div class="card-body">
          <img src="/resources/image/아무개.jfif" style="width: 100%; height: 60%; object-fit:cover;">
            <p class="card-text"> 
            <small>
            	전문분야 : ${rankReg1[0].listField} <br>
            	한줄소개 : ${rankReg1[0].listPro} 
            </small>
           </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
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
            	한줄소개 : ${rankReg2[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
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
            	한줄소개 : ${rankReg3[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
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
       		    전문분야 : ${rankReg4[0].listField} <br>
            	한줄소개 : ${rankReg4[0].listPro} 
            </small>
            </p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">상담사 상세보기</a>
          </div>
        </div>
      </div>
    </div>

    <hr>


    <div class="row mb-4">
      <div class="col-md-8">
      <br>
        <pre style="margin-left: 5%;">!!!</pre>
      </div>
      <div class="col-md-4">
        <a class="btn btn-lg btn-secondary btn-block" href="#" style="transform:translateY(10%);">Call to Action</a>
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