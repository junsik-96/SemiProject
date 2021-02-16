<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="semiproject.common.code.Code" %>
<%@page import="java.io.Console"%>
<%@page import="javax.tools.DocumentationTool.Location"%>
<%@page import="semiproject.common.exception.ToAlertException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Welcome to ShyTalker!
      <small></small>
    </h1>

    <!-- Content Row -->
    <div class="row">
      <!-- Map Column -->
        <!-- Embedded Google Map -->
        <img src="<%= Code.DOMAIN %>/resources/image/login.jpg" style="width: 50%; height: 50%">
    	<div style="width: 48%; height: 50%; padding-left: 2vw; padding-top: 2vw">
        <h2>회원가입</h2>
          <div class="control-group form-group">
            <div class="controls">
              회원가입을 완료해 주세요!
              
              반갑습니다. ${param.userId}님.
     	아래의 버튼을 클릭해 회원가입을 완료해 주세요.
            </div>
          </div>
          <br>
          <a href='<%= Code.DOMAIN %>/member/joinimpl'>회원가입 완료하기</a>
      </div>
      </div>
    </div>
    <!-- /.row -->
</body>
</html>