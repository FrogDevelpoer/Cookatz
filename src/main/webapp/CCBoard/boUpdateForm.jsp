<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
	int label = 3 ; // 양식의 label 너비
	int content = twelve - label ; // 양식의 입력 상자(input, select, textarea 등)의 너비 
%>
<%
	//Human managers = new Human();

	//request.setAttribute("managers", managers) ; // 관리자 목록을 바인딩
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  
	<style type="text/css">
		@font-face {
	  		font-family: 'SBAggroB';
		}
		.panel-heading { /* 부트스트랩에 자동으로 들어가는 배경색 없애기 위해 강제로 색상 추가*/
			background-color: #F6F6F6 !important;
		}  
		.container h2{ 
			float: right;
		 	border-bottom-right-radius:40px; 
		 	font-family: 'SBAggroB';
		 	color:black;
		 	background-color:#ffc300;
		 	border:1px solid #ffc300;
		 	padding-top:15px;
		 	width: 270px;
		 	height: 60px;
	 	}
		.control-label{
			margin-left:20px;
			color:#FFF;
			border:1px solid #009223;
			background-color:#009223;
			border-top-left-radius:20px;
			width:100px;
			height:35px;
			font-family: 'LeferiPoint-BlackA';
			text-align: center;
			}
		
		.btn1{
			margin-right:142px;
			width: 100px;
			height: 40px;
			border-top-left-radius:20px;
			background-color:#009223;
			color:#fff;border:1px solid #009223;
			font-family: 'LeferiPoint-BlackA';
		}
		.btn2{
			margin-right:0px;
			width: 100px;
			height: 40px;
			border-bottom-right-radius:20px;
			background-color:#ffc300;
			color:#fff;
			;border:1px solid #ffc300;
			font-family: 'LeferiPoint-BlackA';
		}
		.setext{
			width: 245px;
			float: left;
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function() {
			$("option[value='${requestScope.bean.writer}']").attr("selected", true);
		});
	</script>
</head>
<body>
	<div class="container" align="center">
		<div class="col-sm-offset-2 col-sm-8 whole_div">
			<div class="panel panel-heading col-sm-12">
				<!--반응형 구축 위해서 헤더에 부트스트랩 추가-->
				<h2>게시물 등록하기</h2>
			</div>
			<div class="panel panel-success">
				<div class="panel-body" class="col-sm-6">
					<form class="form-horizontal" action="<%=yesForm%>" method="post"
						enctype="multipart/form-data">

						<input type="hidden" name="command" value="CCBoUpdate"> <input
							type="hidden" name="num" value="${requestScope.bean.bo_no}">

						<div class="form-group">
							<label class="control-label col-sm-<%=label%>" for="writer">작성자</label>
							<div class="col-sm-<%=content%>">

								<select class="form-control setext" id="writer" name="writer">
									<option value="-">작성한 관리자를 선택해 주세요.</option>
									<option value="admin">admin</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-<%=label%>" for="bo_category">
								카테고리 </label>
							<div class="col-sm-<%=content%>">

								<select class="form-control setext" id="bo_category"
									name="bo_category">
									<option value="-">카테고리를 선택해 주세요.</option>
									<option value="한식">한식</option>
									<option value="일식">일식</option>
									<option value="중식">중식</option>
									<option value="프렌치">프렌치</option>
								</select>

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-<%=label%>" for="title">
								글제목 </label>
							<div class="col-sm-<%=content%>">
								<input type="text" class="form-control" id="title" name="title"
									value="${requestScope.bean.title}">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-<%=label%>" for="video_upload">
								URL </label>
							<div class="col-sm-<%=content%>">
								<input type="text" class="form-control" id="video_upload"
									name="video_upload" value="${requestScope.bean.video_upload}">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-<%=label%>"
								for="board_comment"> 글내용 </label>
							<div class="col-sm-<%=content%>">
								<input type="text" class="form-control" id="board_comment"
									name="board_comment" value="${requestScope.bean.board_comment}">
							</div>
						</div>

						<div class="btn-group">
							<div class="col-sm-offset-3 col-sm-2">
								<button id="submit" type="submit" class="btn1">수정 하기</button>
							</div>

							<div class="col-sm-offset-1 col-sm-2">
								<button type="reset" class="btn2">취소</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>