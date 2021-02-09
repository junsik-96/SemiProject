<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/find.css">    
<%@ include file="/WEB-INF/view/include/findHead.jsp" %>
<body>

<form action="${context}/listener/findclass" method="post">
	 <div class="search_class">
      <label for="exampleInputPassword1" class="la_class">학교 검색</label>
      <input type="text" class="ip_class" name="class" placeholder="학과를 입력하세요.">
      <button type="submit" class="search_class_btn"> 검색하기 </button>
    </div>

	</form>
	
		<% 
		String class1 = "";
		if(request.getParameter("class") == null){
			class1 = "";
		}else{
			class1 = "'"+request.getParameter("class")+"'"+"에 대한 검색 결과 입니다.";
		}
		%>
	<div><hr> <%= class1 %> </div>
	

	<form action="${context}/listener/listenerjoin" method="post" name="child_class">
 	<div>
 	<br>
 		<c:forEach var="className" items="${claList}" varStatus="status">
 			<ul>
 			<li style="list-style:circle; color: purple;"><input type="submit" class="choose_cl" id="choose_cl" name="choose"  value="${className}" onclick="closeClass()"><br>
 			</ul>
 		</c:forEach>	
 		
 	</div>

	</form>
	
	<script type="text/javascript">

 	function closeClass(){
		opener.document.getElementById("choose_class").value = event.target.value
		self.close();	
	} 

	</script>

</body>
</html>