<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/find.css">
<%@ include file="/WEB-INF/view/include/findHead.jsp" %>
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
	<div><hr> <%= school %> </div>
	

	<form action="${context}/listener/listenerjoin" method="post" name="child_school">
 	<div>
 	<br>
 		<c:forEach var="schoolName" items="${uniList}" varStatus="status">
 			<ul>
 			<li style="list-style:circle; color: purple;"><input type="submit" class="choose_sc" id="choose_sc" name="choose"  value="${schoolName}" onclick="closeSchool()"><br>
 			</ul>
 		</c:forEach>	
 		
 	</div>

	</form>
	
	<script type="text/javascript">

 	function closeSchool(){
		opener.document.getElementById("choose_school").value = event.target.value
		self.close();	
	} 

	</script>
</body>
</html>