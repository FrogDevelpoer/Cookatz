<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#header {
	background-color: #009223 ;
	height: 50px;
	height: 70px;
}

.panel-title {
	font-size: 30px;
	color: white;
	padding-top: 12.5px;
}

.shopping {
	text-align: center;
	width: 125px;
	height: 42px;
	border: 2px solid black;
	border-radius: 8px;
	font-size: 16.5px;
	padding-top: 8px;
}
tr th{
	font-size: 18px;
	padding-top: 5px;
}

.shopping:hover {
	background-color: #ffc300;
}

th {
	text-align: center;
}
#a1{
	padding-right: 80px;
}
.updatebtn{
	width: 70px;
	height: 35px;
	margin-top: -20px;
	float: right;
}
.qtytext{
	width: 70px;
	margin-left: 50px;
	float: left;
}

#change{
margin-left:-10px;
box-sizing: border-box;
}

.tablewrap{
	text-align: center;
	
}
.tablewrap td{
	text-align: center;
	
}

</style>
<script type="text/javascript">
	$(document).ready(function() {
$("#a").click(function(){
	  alert("구매가 완료되었습니다.");
	});
	});
</script>
</head>
<body>
	<br />
	<div class="container">
		<div class="panel panel-info">
			<div class="panel-heading" id="header">
				<h2 class="panel-title" align="center">
					<b>장바구니 목록 확인하기</b>
				</h2>
			</div>
			<table id="infotable" class="table table-hover">
				<thead align="center">
					<tr>
						<th>송장 번호</th>
						<th>상품명(이미지)</th>
						<th>수량</th>
						<th>단가</th>
						<th>금액</th>
						<th>변경</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bean" items="${sessionScope.shopList}">
						<tr class="tablewrap">
							<td width="10%" align="center" valign="middle">${bean.pnum}</td>
							<td width="15%" align="center"><img alt="${bean.pname}" width="36"
								height="36" class="img-rounded"
								src="upload/${bean.img}"> <br />
								${bean.pname}</td>
							<td width="15%" align="center" valign="middle">${bean.qty}개</td>
							<td width="15%" align="center" valign="middle"><fmt:formatNumber
									value="${bean.price}" pattern="###,###" /> 원</td>
							<td width="15%" align="center" valign="middle"><fmt:formatNumber
									value="${bean.price*bean.qty}" pattern="###,###" /> 원</td>
							<!-- 수량 -->
							<td width="20%">
								<form class="form-horizontal" action="<%=yesForm%>"
									method="post">
									<input type="hidden" name="command" value="maUpdate"> <input
										type="hidden" name="pnum" value="${bean.pnum}">
									<div class="form-group" id="change">
										<input class="form-control qtytext" type="number" min="1" max="1000"
											name="qty"> <br /> 
										<input class="updatebtn" type="submit" value="변경">
									</div>
								</form>
							</td>
							<td width="10%" align="center" valign="middle"><a
								href="<%=noForm%>maDelete&pnum=${bean.pnum}"> 삭제 </a></td>
						</tr>
					</c:forEach>
					<tr>
						<td align="right" colspan="8">총금액 : <fmt:formatNumber
								value="${sessionScope.totalAmount}" pattern="###,###" /> 원
						</td>
					</tr>
					<tr>
						<td align="center" colspan="4">
							<!--maCalculate를 바꿔야 합니다. 넘어가는 페이지로   -->
							<div class="shopping" id="a" onclick="location.href='<%=noForm%>maCalculate'" style="cursor: pointer;">
								구매하기
							</div>
						</td>
						<td id="a1" align="left" colspan="4">
							<!--prList를 바꿔야 합니다. 넘어가는 페이지로   -->
							<div class="shopping" id="a" onclick="location.href='<%=noForm%>prVegList'" style="cursor: pointer;">
								추가주문
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>