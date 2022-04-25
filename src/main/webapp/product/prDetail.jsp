<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
int offset = 2; // 오프셋
int content = twelve - 2 * offset; // 내용물 
int leftside = 4; // 좌측
int rightside = twelve - leftside; // 우측
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.form-group {
	margin-bottom: 3px;
}

.form-control, .myheight {
	height: 25px;
}

.tdheader {
	background-color: LightCyan;
	border: 1px solid Gainsboro;
}

.panel-title {
	font-size: 30px;
	color: white;
	padding-top: 12.5px;
}
#header {
	background-color: #009223 ;
	height: 50px;
	height: 70px;
}
#qty{
	width: 50px;
	height: 30px;
	text-align: center;
}
#order{
	width: 100px;
	height: 30px;
	background-color: #009223;
	border: none;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
$("#order").click(function(){
	$()
})

<%-- $('#order').click(function(){
	if($('#qty').val()==0){
		alert('수량을 입력해주세요');
		$("#qty").val(0);
		
	}else{
		location.href="'<%=noForm%>prDetail&num=${requestScope.bean.num}'";
	}
});
 --%>
 
	});
</script>
</head>
<body>
	<br />
	<div class="container col-md-offset-<%=offset%> col-md-<%=content%>">
		<div class="panel panel-default">
			<div class="panel-heading" id="header">
				<h3 class="panel-title" align="center">상품 주문하기</h3>
			</div>
			<div class="panel-body">
				<div class="col-md-12">
					<div class="col-md-<%=leftside%>" align="center">
						<table class="table table-bordered">
							<tr>
								<td align="center">
									<%-- 
									경로 : ${applicationScope.realPath}<br/>
									이름 : ${requestScope.bean.image}<br/>
								--%> <%-- realPath 변수는 FrontController에서 설정됩니다. --%> 
								<img	id="target_image" alt="${requestScope.bean.name}" width="180"
									height="180" class="img-rounded"
									src="upload/${requestScope.bean.img}">
								</td>
							</tr>
						</table>

					</div>
					<div class="col-md-<%=rightside%>" align="center">
						<table id="infotable" class="table table-hover">
							<tr>
								<td width="25%">상품 번호</td>
								<td width="75%">${requestScope.bean.num}</td>
							</tr>
							<tr>
								<td width="25%">상품명</td>
								<td width="75%">${requestScope.bean.name}</td>
							</tr>
							<tr>
								<td width="25%">카테고리</td>
								<td width="75%">${requestScope.bean.category}</td>
							</tr>
							<tr>
								<td width="25%">재고</td>
								<td width="75%">${requestScope.bean.stock}</td>
							</tr>
							<tr>
								<td width="25%">단가</td>
								<td width="75%">${requestScope.bean.price}</td>
							</tr>
							<tr>
								<td width="25%">입고 일자</td>
								<td width="75%">${requestScope.bean.pdate}</td>
							</tr>
							<tr>
								<td width="25%">주문 수량</td>
								<td width="75%">
									<form class="form-horizontal" role="form" action="<%=yesForm%>"
										method="post">
										<input type="hidden" name="command" value="maInsert">
										<input type="hidden" name="num"value="${requestScope.bean.num}"> 
										<input	type="hidden" name="stock" value="${requestScope.bean.stock}">
										<div class="form-group">
											<div class="col-sm-4 myheight">
												<input type="text" name="qty" id="qty" size="10"
													placeholder="구매 수량 입력" class="form-control"
													data-toggle="popover" title="수량 입력란"
													data-content="구매하실 수량을 입력하세요"
													data-placement="auto top" data-trigger="hover" value="0">
											</div>
											<div class="col-sm-3 myheight" align="left">
												<input type="submit" value="주문"
													class="form-control btn btn-info" id="order" >
											</div>
										</div>
									</form>
								</td>
							</tr>
							<!-- 시간 남으면 코멘트 부분 추가하기 -->

						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>