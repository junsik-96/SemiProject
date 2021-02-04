<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="semiproject.common.code.Code" %>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<body>
<h1>회원가입을 완료해주세요!</h1>
<h1>반갑습니다. ${param.userId}님.</h1>
<h1>아래의 링크를 클릭해 회원가입을 완료해주세요.</h1>
<a href="<%= Code.DOMAIN %>/member/joinimpl">회원가입완료</a><br>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTWTJR1Cvgyuo4ULny16MCYlcvGojgcGN-YKQ&usqp=CAU"/>
</body>
</html>