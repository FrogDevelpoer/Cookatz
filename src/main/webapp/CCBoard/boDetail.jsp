<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<%
	int offset = 2 ; // 오프셋
	int content = twelve - 2 * offset ; // 내용물 
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		@font-face {
	  		font-family: 'SBAggroB';
		}
		.vidiv{
			padding-top: 20px;
			text-align: center;
			margin: 0 auto;
		}
		.video{
			width: 700px;
			height: 430px;
		}
		
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			
		});	
	</script>
</head>
<body>
<br/>
	<div class="vidiv">
		<iframe class="video" src="${bean.video_upload}" oncontextmenu="return false"> 
		</iframe>
	</div>
</body>
</html>

