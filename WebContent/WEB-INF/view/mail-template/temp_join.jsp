<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="semiproject.common.code.Code" %>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
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