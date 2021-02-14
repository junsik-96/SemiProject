<%@page import="java.io.Console"%>
<%@page import="javax.tools.DocumentationTool.Location"%>
<%@page import="semiproject.common.exception.ToAlertException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 모든 페이지에서 공통적으로 사용할 head를 작성한 페이지 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shytalker</title>
<style type="text/css">
.dropdown-item:hover{
  color: #16181b ;
  text-decoration: underline !important;
  background-color: #f8f9fa;
}
</style>
<script type="text/javascript" src="/resources/js/common/asyncResponseError.js"></script>
<script type="text/javascript" src="/resources/js/common/urlEncoder.js"></script>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

<link href="/resources/css/all.css" rel="stylesheet">
<link rel = "stylesheet" href = "/resources/css/modern-business.css">
<link rel = "stylesheet" href = "/resources/vendor/bootstrap/css/bootstrap.css">
<link rel = "stylesheet" href = "/resources/vendor/bootstrap/css/bootstrap.min.css">
<link rel = "stylesheet" href = "/resources/vendor/bootstrap/css/bootstrap-grid.css">
<link rel = "stylesheet" href = "/resources/vendor/bootstrap/css/bootstrap-grid.min.css">
<link rel = "stylesheet" href = "/resources/vendor/bootstrap/css/bootstrap-reboot.css">
<link rel = "stylesheet" href = "/resources/vendor/bootstrap/css/bootstrap-reboot.min.css">

<script type="text/javascript" src="/resources/js/contact_me.js"></script>
<script type="text/javascript" src="/resources/js/jqBootstrapValidation.js"></script>
<script type="text/javascript" src="/resources/vendor/bootstrap/js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/resources/vendor/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>


</head>

<body>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
     <a class="navbar-brand" href="/index" style="font-style: italic">Shytalker</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="/listener/all">상담사 찾기</a>
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
<!--      		  <a class="dropdown-item" href="/shy/listenerlist">상담사 신청</a>           
 -->              
             
             <c:choose>
              	<c:when test="${empty sessionScope.user}">
              	   <a class="dropdown-item" href="/member/login">상담사 신청</a>              	
              	</c:when>
              	<c:otherwise>             	
              		<c:choose>
              			<c:when test="${sessionScope.userType eq '일반회원'}">
              				<%-- 일반회원은 이용불가능하게 접근막고 alert 하기 --%>
              				<a class="dropdown-item" onclick="alertMsg()">상담사 신청</a>
              			</c:when>
              			<c:otherwise>
              			 	<a class="dropdown-item" href="/shy/listenerlist">상담사 신청</a>
              			</c:otherwise>
              		</c:choose>
            	</c:otherwise>
              </c:choose>
                          
              <a class="dropdown-item" href="/shy/customerCenter">고객센터</a>
            </div>          
          </li>
          

            <c:choose>
             <c:when test="${empty sessionScope.user}">
                 <li class="nav-item">
                  <a class="nav-link" href="/member/login">Login</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/member/join">회원가입</a>
                </li>
             </c:when>
             <c:otherwise>         
           		<c:choose>
       				<c:when test="${sessionScope.userType eq '일반회원'}">
                <li class="nav-item">
                <!-- 일반회원 마이페이지로 이동 -->
                     <a class="nav-link" href="/member/mypage">마이페이지</a>
                </li>
                 <li class="nav-item">
                     <a class="nav-link" href="/member/logout">LogOut</a>
                </li>  
                	</c:when>
               	<c:otherwise>
               	<li class="nav-item">
               		<!-- 상담사 마이페이지로 경로이동 -->
                     <a class="nav-link" href="/shy/myPageMain">마이페이지</a>
                </li>
                 <li class="nav-item">
                     <a class="nav-link" href="/member/logout">LogOut</a>
                </li>  
               	</c:otherwise>
          	  </c:choose>              
             </c:otherwise>
          </c:choose>
          
          
        </ul>
      </div>
    </div>
  </nav>

<script type="text/javascript">

	function alertMsg(){
		alert('죄송합니다.'+
				'\n일반회원 고객님은 이용하실 수 없는 페이지 입니다.' +
				'\n이전 페이지로 돌아갑니다.');
		history.forward();
	}

</script>

</body>
