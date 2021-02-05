<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/find.css">
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<body>

	<form action="${context}/listener/findschool" method="post">
	 <div class="search_school">
      <label for="exampleInputPassword1" class="la_school">학교 검색</label>
      <input type="text" class="ip_school" name="school" placeholder="학교를 입력하세요.">
      <button type="submit" class="search_school_btn"> 검색하기 </button>
    </div>

	</form>
	
		<% 
		String school = "";
		if(request.getParameter("school") == null){
			school = "";
		}else{
			school = "'"+request.getParameter("school")+"'"+"에 대한 검색 결과 입니다.";
		}
		%>
	<div><%= school %></div>
	
	<div> ${requestScope.schoolList} </div>
	
</body>
</html>