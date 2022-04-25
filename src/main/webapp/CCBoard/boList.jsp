<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		@font-face {
	  		font-family: 'SBAggroB';
		}
		.headfont{
			background-color: #009223;
			height: 40px;
		}
		.headfont h3{
			color: #ffffff;
			font-size: 27px;
			padding-top: 7px;
		}
		.container{
			padding-top: 40px;
		}
		.new_btndiv{
			float: right;
			text-align: right;
		}
		.new_btn{
			width: 110px;
			height: 25px;
			font-size: 15px;
			padding-bottom: 5px; 
			color: #292929;
			text-decoration-line: none;
			text-align: center;
		}
		#shdiv{
			display: inline-block;
			text-align: center;
		}
		.catdiv{
			font-size: 15px;
			text-align: center;
		}
		.btn1{
			width: 70px;
			font-size: 15px;
		}
		.btn2{
			width: 110px;
			font-size: 15px;
		}
		.totalp{
			font-size: 15px;
			padding-left: 7px;
		}
		.headth th{
			font-size: 15px;
			text-align: center;
		}
		.bodytd{
			text-align: center;
		}
		a{
			color: #292929;
		}
		a:hover{
			color: #009223;
		}
	</style>
	<script type="text/javascript">
	/*
		
	*/
		$(document).ready(function(){
				
		});
		function search(){
			if($('#mode').val() == 'all'){
				alert('검색 항목을 선택해 주세요.') ;
				return false ;
			}
		}
		function searchAll(){
			location.href='<%=noForm%>CCBoList';
		}
		
		function writeForm(){
			location.href='<%=noForm%>CCBoInsert';
		}
	</script>
</head>
<body>
	<%-- 관리자용 게시판 리스트 --%>
	<br>
	<div class="container">
		<%-- <div class="new_btndiv">
			<a class="new_btn" href="<%=noForm%>CCBoInsert">게시글작성</a>
		</div> --%>
		<div class="headfont">
			<div>
				<h3 align="center">게시글 목록</h3>
			</div>
		</div>
		<table id="infotable" class="table table-hover">
			<thead>
				<tr>
					<td colspan="10" align="center">
						<form class="form-inline" action="<%=yesForm%>" method="get">
							<input type="hidden" name="command" value="CCBoList"> 
							<input type="hidden" name="pageNumber1" value="${requestScope.pageInfo.pageNumber}"> 
							<input type="hidden" name="pageSize1" value="${requestScope.pageInfo.pageSize}">

							<div id="shdiv" align="center">
								<div class="form-group">
									<select class="form-control btn-xs catdiv" name="mode" id="mode">
										<option value="all">검색할 항목을 선택하세요.
										<option value="bo_category">카테고리
										<option value="title">제목
										<option value="board_comment">글 내용
									</select>
							</div>
							
								<div class="form-group">
									<input type="text" class="form-control btn-xs catdiv" id="keyword"
										name="keyword" placeholder="검색 키워드 입력">
								</div>
								<button class="btn btn-default btn1" type="submit"
									onclick="return search();">검색</button>
	
								<button class="btn btn-default btn2" type="button"
									onclick="searchAll();">전체 검색</button>
	
								<!-- <button class="btn btn-default btn-info" type="button"
									onclick="writeForm();">글 쓰기</button> -->
								<p class="form-control-static totalp">${requestScope.pageInfo.pagingStatus}</p>
								
							</div>
						</form>
					</td>
				</tr>
				<tr class="headth">
					<th>글번호</th>
					<th>작성자</th>
					<th>카테고리</th>
					<th>작성일</th>
					<th>글제목</th>
					<th>동영상</th>
					<th>글내용</th>
					<%-- <th>조회수</th> 
					<th>추천수</th>--%>
					<th>영상보기</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<%-- 리스트 목록을 불러와서 forEach 문장으로 tr, td 생성 --%>
				<c:forEach var="bean" items="${requestScope.lists}">
					<tr class="bodytd">
						<td>${bean.bo_no}</td>
						<td>${bean.writer}</td>
						<td>${bean.bo_category}</td>
						<td>${bean.regdate}</td>
						<td>${bean.title}</td>
						<td>${bean.video_upload}</td>
						<td>${bean.board_comment}</td>
						<%-- <td>${bean.readhit}</td>
						<td>${bean.likenum}</td> --%>
						<td><a href="<%=noForm%>CCBoDetail&bo_no=${bean.bo_no}">상세보기</a>
						</td>
						<td>
							<c:if test="${sessionScope.loginfo.id == bean.writer}">
								<a href="<%=noForm%>CCBoUpdate&bo_no=${bean.bo_no}">수정</a>
							</c:if> 
							<c:if test="${sessionScope.loginfo.id != bean.writer}">
									수정
							</c:if>
						</td>

						<td>
							<c:if test="${sessionScope.loginfo.id == bean.writer}">
								<a href="<%=noForm%>CCBoDelete&bo_no=${bean.bo_no}">삭제</a>
							</c:if> 
							<c:if test="${sessionScope.loginfo.id != bean.writer}">
									삭제
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div align="center">
			${requestScope.pageInfo.pagingHtml}
		</div>
	<script type="text/javascript">
		/* 사용자가 선택한 항목을 그대로 보여 주기 */	
		$('#mode option').each(function(){
			if($(this).val() == '${requestScope.pageInfo.mode}'){
				$(this).attr('selected', 'selected') ;
			}
		});
		$('#keyword').val('${requestScope.pageInfo.keyword}');
	</script>
	</div>
</body>
</html>