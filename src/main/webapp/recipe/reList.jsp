<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		*{
		  font-family: 'Poppins', sans-serif;
		}
		#titlehead{
			text-align: center;
			height: 40px;
			margin-bottom: 15px;
		}
		.rgheader{
			height:136px;
			width:1050px;
			margin: 0 auto;
   			padding: 50px 0 51px;
			border: 1px solid #ccc;
			font-family: 'SBAggroB';
			
		}
		
		.regibtn{
			list-style: none;
			font-weight: bold;
			font-size: 18px;
		}
		#search{
			margin-left: 450px;
		}
		.listTitle{
			border-top: 2px solid #009223;
		}
		.listTitle th{
			text-align: center;
		}
		.pageTotal{
			float: right;
		}
		.opt #keyword{
			background-color:  #f5f5f5;
		}
		.relist{
			text-align: center;
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
				
		});
		
		function search(){
			if($('#mode').val() == 'all'){
				
				alert('검색항목을 선택 해주세요.');
				return false;
			}
		}
		
		function searchAll(){
			location.href='<%=noForm%>reList';
		}
		
		
		function notwriteForm(){
	        alert('로그인 후 글쓰기');
        }
      	function writeForm(){
         	location.href='<%=noForm%>reInsert';
        }
	</script>
</head>
<body>
	<br>
	<div class="container">
		<div>
		<div class="rgheader" align="center">
				<h2>만개가 될 레시피</h2>
			</div>
			<table class="table table-hover" id = "infotable">
				<thead>
					<tr>
						<td colspan="10" align="center">
							<form class="form-inline" action="<%=yesForm%>" method="get">
								<input type="hidden" name="command" value="reList">
								<input type="hidden" name="pageNumber" value="${requestScope.pageInfo.pageNumber}">
								<input type="hidden" name="pageSize" value="${requestScope.pageInfo.pageSize}">
								
								<div class="form-group" id = "search">
									<select class="form-control btn-xs opt" name="mode" id="mode">
										<option value="all" >-- 검색할 항목을 선택하세요.
										<option value="writer_name" >작성자
										<option value="recipe_title" >제목
										<option value="cook_info" >글 내용
									</select>
								</div>								
								<div class="form-group">
									<input type="text" class="form-control btn-xs" id="keyword"
										name="keyword" placeholder="검색 키워드 입력">
								</div>
								<button class="btn btn-default" type="submit" onclick="return search();">검색</button>
								
								<button class="btn btn-default" type="button" onclick="searchAll();">전체 검색</button>

								<c:if test="${whologin == 0}">
									<button class="btn btn-info write" type="button"
										onclick="notwriteForm();">글 쓰기</button>
								</c:if>
								<c:if test="${whologin != 0}">
									<button class="btn btn-info write" type="button"
										onclick="writeForm();">글 쓰기</button>
								</c:if>
								&nbsp;&nbsp;&nbsp;&nbsp;

								<p class="form-control-static pageTotal">${requestScope.pageInfo.pagingStatus}</p> 
							</form>
						</td>
					</tr>
					<tr class = "listTitle">
						<th>글 번호</th>
						<th>레시피 제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>상세보기</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "bean" items = "${requestScope.lists}">
						<tr class="relist">
							<td>${bean.seq}</td>
							<td>${bean.recipe_title}</td>
							<td>${bean.writer_name}</td>
							<td>${bean.write_date}</td>
							<td>
								<a href = "<%=noForm%>reDetail&seq=${bean.seq}">레시피 보기</a>
							</td>
							<td>
								<c:if test="${sessionScope.loginfo.id == bean.writer_id}">
									<a href="<%=noForm%>reUpdate&seq=${bean.seq}">레시피 수정</a>
								</c:if>
								
								<c:if test="${sessionScope.loginfo.id != bean.writer_id}">
									레시피 수정
								</c:if>
							</td>
							
							<td>
								<c:if test="${sessionScope.loginfo.id == bean.writer_id}">
									<a href="<%=noForm%>reDelete&seq=${bean.seq}">삭제</a>
								</c:if>
								
								<c:if test="${sessionScope.loginfo.id != bean.writer_id}">
									삭제
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div align = "center">
			${requestScope.pageInfo.pagingHtml}
		</div>
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
</body>
</html>