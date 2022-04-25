<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
	int label = 3 ; // 양식의 label 너비
	int content = twelve - label ; // 양식의 입력 상자(input, select, textarea 등)의 너비 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>

<style type="text/css">
*{padding:0; margin:0;}
.panel-heading { /* 부트스트랩에 자동으로 들어가는 배경색 없애기 위해 강제로 색상 추가*/
  background-color: #F6F6F6 !important;}  
.container h2{ margin-left:450px; border-bottom-right-radius:40px;  font-family: 'SBAggroB'; color:black; background-color:#ffc300; border:1px solid #ffc300; padding-top:15px; width: 250px; height: 60px;}
.control-label{margin-left:20px; color:#FFF; border:1px solid #009223; background-color:#009223; border-top-left-radius:20px;  width:100px; height:35px; font-family: 'LeferiPoint-BlackA';}
.btn1{margin-right:142px;width: 100px; height: 40px;border-top-left-radius:20px; background-color:#009223;color:#fff;border:1px solid #009223;font-family: 'LeferiPoint-BlackA';}
.btn2{margin-right:0px;width: 100px; height: 40px;border-bottom-right-radius:20px;background-color:#ffc300;color:#fff;;border:1px solid #ffc300;font-family: 'LeferiPoint-BlackA';}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('option[value="${requestScope.bean.category}"]').attr('selected', true);// 셀렉트박스 사용시
	});
</script>
</head>
<body>
	<div class="container" align="center">
		<div class="col-sm-offset-2 col-sm-8 whole_div">
			<div class="panel panel-heading col-sm-12"> <!--반응형 구축 위해서 헤더에 부트스트랩 추가-->
				<h2>상품 등록하기</h2>
			</div>
			<div class="panel panel-success">
				<div class="panel-body" class="col-sm-6">
					<form class="form-horizontal" action="<%=yesForm%>" method = "post" 
						enctype="multipart/form-data">
						<input type = "hidden" name = "command" value = "prInsert">
						
							<div class="form-group">
								<label class="control-label col-sm-<%=label%>" for="name"> 상품명 : </label>
								<div class="col-sm-<%=content%>">
									<input type="text" class="form-control" id="name" name="name" placeholder = "상품명 입력">
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-<%=label%>" for="category"> 카테고리 : </label>
								<div class="col-sm-<%=content%>">
									<select class="form-control" id="category" name="category" style = "width: 150px; float: left;">
									    <option value = "-">---카테고리---</option>
									    <option value = "fruit">과일</option>
										<option value = "veg">채소</option>
										<option value = "meat">정육계란</option>			    
							  		</select>
								</div>
							</div>		
								
							<div class="form-group">
								<label class="control-label col-sm-<%=label%>" for="stock"> 가격 : </label>
								<div class="col-sm-<%=content%>">
									<input type="number" class="form-control" id="price" name="price">
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-<%=label%>" for="category"> 상품 설명 : </label>
								<div class="col-sm-<%=content%>">
									<input type="text" class="form-control" id="content" name="content">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-<%=label%>" for="img"> 이미지 : </label>
								<div class="col-sm-<%=content%>">
									<input type="file" class="form-control" id="img" name="img">
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-<%=label%>" for="stock"> 재고 : </label>
								<div class="col-sm-<%=content%>">
									<input type="number" class="form-control" id="stock" name="stock">
								</div>
							</div>
							
						<div class="btn-group">
							<div class="col-sm-offset-3 col-sm-2">
								<button id="submit" type="submit" class="btn1">등록</button>
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