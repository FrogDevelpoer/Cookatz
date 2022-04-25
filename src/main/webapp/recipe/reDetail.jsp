<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		*{margin: 0; padding: 0;
			box-sizing: border-box;}
		.container .panel .panel-heading{
			height: 100px;
			widith: 640px;
		}
		.panel-heading h2{
			float: left;
			color: black;
			padding-top: 15px;
			width: 250px;
			height: 60px;
			border: 1px solid #ffc300;
			border-top-left-radius: 40px;
			font-family: 'SBAggroB';
			font-size: 24px;
			margin-top: 3px;
			
		}
		h2{
			margin-top: 5px;
		}
		.panel-title{
			background-color: #ffc300 !important;
			
		}
		.form-group{margin-bottom: 3px;}
		.form-control, .myheight{height: 25px;}	
		.con_title{
			font-size: 18px;
			background-color: #ffc300; !important;
			color: white;
			border-radius: 18px;
			padding-bottom: 10px;
			font-weight: bold;
		}
		.panel-heading{
			background-color: #009223; 
		}
		.contentList .con_title{
			margin-top: 15px;
			text-align: center;
			width: 180px;
		}
		.con{
			font-size: 18px;
			font-family: 'Noto Sans KR', sans-serif;
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
		});	
	</script>
</head>
<body>
<br/>
<div class="container">		
	<div class="panel">
		<div class="panel-heading">
			<h2 class="panel-title" align="center">
				레시피 자세히보기
			</h2>
		</div>
		<div class="panel-body">
			<div>
				<div align="center">
					<table class="table">
						<tr>
							<td align="center">
								<img id="target_image" name="main_photo" width="180" height="180" 
									class="img-rounded" src="upload/${bean.main_photo}">
									<!-- 실제로 이미지 구현 -->
							</td>
						</tr>
					</table>
					
				</div>
				<div align="center" class = "contentList">
					<table id="infotable" class="table table-hover">
						<tr>
							<td class = "con_title">글 번호</td>
							<td class = "con">&nbsp;&nbsp;${bean.seq}</td>
						</tr>	
						<tr>
							<td class = "con_title">작성 일자</td>
							<td class = "con">&nbsp;&nbsp;${bean.write_date}</td>
						</tr>			
						<tr>
							<td class = "con_title">레시피 이름</td>
							<td class = "con">&nbsp;&nbsp;${bean.recipe_title}</td>
						</tr>					
						<tr>
							<td class = "con_title">요리 소개</td>
							<td class = "con">&nbsp;&nbsp;${bean.cook_Info}</td>
						</tr>
						<tr>
							<td class = "con_title">카테고리</td>
							<td class = "con">&nbsp;&nbsp;${bean.category}</td>
						</tr>	
						<tr>
							<td class = "con_title">재료</td>
							<td class = "con">&nbsp;&nbsp;${bean.material1}/${bean.material1_1}&nbsp;&nbsp;
								${bean.material2}/${bean.material2_1}&nbsp;&nbsp;
								${bean.material3}/${bean.material3_1}&nbsp;&nbsp;
							</td>
							
						</tr>				
						<tr>
							<td class = "con_title">요리 순서</td>
							<td class = "con">&nbsp;&nbsp;${bean.cook_step}</td>
						</tr>					
						
					</table>
				</div>				
			</div>  
		</div>
	</div>
</div>
</body>
</html>




