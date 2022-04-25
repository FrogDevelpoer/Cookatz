<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<%
	int kcnt = 0;
	int ccnt = 0;
	int jcnt = 0;
	int fcnt = 0;
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		.cookList th{
			text-align: center;
		}
		.cookList th{
			color: #292929;
			text-decoration-line: none;
			font-size: 23px;
			font-weight: bolder;
		}
		.rgheader{
			height:136px;
			width:1050px;
			margin: 0 auto;
   			padding: 50px 0 51px;
			border: 1px solid #ccc;
			font-family: 'SBAggroB';
			text-align: center;
			
		}
		
		.active{
			color: #2E8B57
		}
		nomal{
			color: red;
		}
		.cookingList{
			width: 1000px;
			text-align: center;
		}
		table {
   		 	margin-left:auto; 
    		margin-right:auto;
		}
		table, td, th {
   			border-collapse : collapse;
		}
		.clicked{
			color: #2E8B57;
		}
		.topH3{
			font-size: 27px;
			text-align: center;
			padding-top: 50px;
		}
		th{
			font-size: 17px;
		}
		.table>thead>tr>th{
			border-bottom: 2px solid #009223;
		}
		.admin_btn{
			width: 150px;
			height: 30px;
			font-size: 15px;
			float: right;
			background-color: gray;
			color: black;
		}
		.wrapcontents{
			width: 100%;
			height: 100%;
			text-align: center;
			float: left;
		}
		.contents{
			width: 300px;
			height: 350px;
			display:inline-block;
			vertical-align:middle;
			margin-left: 30px;
			cursor: pointer;
			margin-bottom: 50px;
			border: 1px solid black;
		}
		li{
			list-style: none;
		}
		.icon{
			color: #6495ED;
		}
		/* .adbtndiv{
			float: right;
			text-align: right;
		}
		.adbtn{
			width: 110px;
			height: 25px;
			font-size: 15px;
			padding-bottom: 5px; 
			color: #292929;
			text-decoration-line: none;
			text-align: center;
		} */
		.entdiv{
			padding-top: 80px;
			border: 1px solid black;
		}
		
		.navdiv{
			position: fixed;
			right: 50%;
			top: 40%;
			margin-right: 38%;
			text-align:center;
			width: 70px;
			float: left;
			display: inline-block;
			cursor: pointer;
			
		}
		
		.navdiv ul{
			list-style: none;
			padding: 0;
			margin: 0;
			overflow: auto;
			font-size: 17px;
			
		}
		.navdiv li{
			height: 70px;
			border: 1px solid black;
			text-align: center;
			padding-top: 36%;
			background-color: green;
			margin-bottom: 5px; 
			color: white;
			display: block;
			text-decoration: none;
		}
		
		@font-face {
	  		font-family: 'SBAggroB';
		}
		.titleli{
			font-size: 20px;
			font-weight: bolder;
			font-family: 'LeferiPoint-BlackA';
			padding-top:20px;
		}
		.comli{
			font-size: 12x;
			font-weight: bolder;
			color:#999;
			font-family: 'LeferiPoint-BlackA';
		}
		#myVideo{
			width: 100%;
			height: 220px;
		}
	</style>
	<script type="text/javascript">
	/*
		
	*/
		
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<section>
		<div class="rgheader">
				<h2>쿠킹 클래스</h2>
		</div>
		<br>
		<br>
		<div class="container">
			<%-- <div class="adbtndiv">
				<c:if test="${whologin == 2}">
					<a class="adbtn" href="<%=noForm%>CCBoList">관리자용 게시물 목록 보기</a>
				</c:if>
			</div> --%>
			
			<table class="table">
				<thead>
					<tr class="cookList" align="left">
						<th id="ko">한식</th>
					</tr>
				</thead>
			</table>
			<div class="wrapcontents">
				<c:forEach var="bean" items="${requestScope.lists}">
					<c:if test="${bean.bo_category == '한식'}">
						<div class="contents"
							onclick="location.href='<%=noForm%>CCBoDetail&bo_no=${bean.bo_no}'">
							<ul>
								<li>
									<iframe src="${bean.video_upload}" oncontextmenu="return false;" id="myVideo">
									</iframe>
								</li>
								<li class="titleli">${bean.title}</li>
								<li class="comli">${bean.board_comment}</li>
								<%-- <li><span class="glyphicon glyphicon-search icon"></span>${bean.readhit}
									<span class="glyphicon glyphicon-heart icon"></span>${bean.likenum}</li> --%>
							</ul>
						</div>
					</c:if>
					<input type="hidden" value="${bean.bo_no}">
					
					
				</c:forEach>
			</div>
			
			<table class="table">
				<thead>
					<tr class="cookList">
						<th id="ch">중식</th>
					</tr>
				</thead>
			</table>
			<div class="wrapcontents">
				<c:forEach var="bean" items="${requestScope.lists}">
					<c:if test="${bean.bo_category == '중식'}">
						<div class="contents"
							onclick="location.href='<%=noForm%>CCBoDetail&bo_no=${bean.bo_no}'">
							<ul>
								<li>
									<iframe src="${bean.video_upload}" oncontextmenu="return false;" id="myVideo">
									</iframe>
								</li>
								<li class="titleli">${bean.title}</li>
								<li class="comli">${bean.board_comment}</li>
								<%-- <li><span class="glyphicon glyphicon-search icon"></span>${bean.readhit}
									<span class="glyphicon glyphicon-heart icon"></span>${bean.likenum}</li> --%>
							</ul>
						</div>
					</c:if>
					<input type="hidden" value="${bean.bo_no}">
					
					
				</c:forEach>
			</div>
			
			<table class="table">
				<thead>
					<tr class="cookList">
						<th id="ja">일식</th>
					</tr>
				</thead>
			</table>
			<div class="wrapcontents">
				<c:forEach var="bean" items="${requestScope.lists}">
					<c:if test="${bean.bo_category == '일식'}">
						<div class="contents"
							onclick="location.href='<%=noForm%>CCBoDetail&bo_no=${bean.bo_no}'">
							<ul>
								<li>
									<iframe src="${bean.video_upload}" oncontextmenu="return false;" id="myVideo">
									</iframe>
								</li>
								<li class="titleli">${bean.title}</li>
								<li class="comli">${bean.board_comment}</li>
								<%-- <li><span class="glyphicon glyphicon-search icon"></span>${bean.readhit}
									<span class="glyphicon glyphicon-heart icon"></span>${bean.likenum}</li> --%>
							</ul>
						</div>
					</c:if>
					<input type="hidden" value="${bean.bo_no}">
					
				</c:forEach>
			</div>
			
			<table class="table">
				<thead>
					<tr class="cookList">
						<th id="fr">프렌치</th>
					</tr>
				</thead>
			</table>
			<div class="wrapcontents">
				<c:forEach var="bean" items="${requestScope.lists}">
					<c:if test="${bean.bo_category == '프렌치'}">
						<div class="contents"
							onclick="location.href='<%=noForm%>CCBoDetail&bo_no=${bean.bo_no}'">
							<ul>
								<li>
									<iframe src="${bean.video_upload}" oncontextmenu="return false;" id="myVideo">
									</iframe>
								</li>
								<li class="titleli">${bean.title}</li>
								<li class="comli">${bean.board_comment}</li>
								<%-- <li>
									<span class="glyphicon glyphicon-search icon"></span>${bean.readhit}
									<span class="glyphicon glyphicon-heart icon"></span>${bean.likenum}
								</li> --%>
							</ul>
						</div>
					</c:if>
					<input type="hidden" value="${bean.bo_no}">
					
				</c:forEach>
			</div>
		</div>
	</section>
	<nav>
		<div class="navdiv">
			<ul>
		    	<li class="navli konav" onclick="location.href='#ko'">한식</li>
		        <li class="navli conav" onclick="location.href='#ch'">중식</li>
		        <li class="navli jonav" onclick="location.href='#ja'">일식</li>
		        <li class="navli fonav" onclick="location.href='#fr'">프렌치</li>
		    </ul>
	    </div>
	</nav>
	
</body>
</html>