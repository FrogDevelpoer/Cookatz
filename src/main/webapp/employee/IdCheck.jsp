<%@page import="cookatz.employee.bean.Employee"%>
<%@page import="cookatz.employee.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
	
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
<%
	
	String id = request.getParameter("id");
	EmployeeDao mdao = new EmployeeDao() ; 
	
	boolean result = mdao.confirmId(id); //db에 있는 id 
	
	if(result) { %> <!-- result = true -->
		<div>
			<br><br>
			<h4>이미 사용중인 ID 입니다.</h4>	
		</div>
	<%} else { %>
		<div>
			<br><br>
			<h4>입력하신 "<%=id%>" 는 사용 가능한 ID 입니다. </h4>	
		</div>
	<% } %>

</body>
</html>