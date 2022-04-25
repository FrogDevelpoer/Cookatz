<%@page import="java.util.List"%>
<%@page import="cookatz.product.bean.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>    
<%
	int offset = 2; // 옵셋
	int content = twelve -(2 * offset) ;  // 내용물
	int leftside = 4 ; // 좌측
	int rightside = twelve - leftside ; // 우측
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{padding:0; margin:0;}
	@font-face {
	  font-family: 'SBAggroB';
	 src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroB.woff') format('woff');
	  font-weight: normal;
	  font-style: normal;
}
.panel_body{width: 1200px;}
.list-banner{width:100%; min-width:1200px; height:550px;
background-size:cover;
background-position-x:50%; background-position-y:50%; background-repeat-x:no-repeat; background-repeat-y:no-repeat;
background-origin: initial; ckground-clip: initial; background-color: initial;}
.banner{width:100%; min-width:1200px; height:550px;}
.list-menu 
{width: 1200px; margin: 0 auto; text-align:center; margin-top:10px; } 
.list-menu ul {width:1200px; margin: 0 auto; height: 50px; } 
.list-menu ul li 
{font-family: 'SBAggroB';float: left; width:200px; height:50px; margin-left:148px; 
 display:inline-block; padding-right: 20px; text-align: center;}
#sub1{box-sizing:border-box;  width:200px; height:50px; border:0;
padding-left:20px;padding-right:20px; background-color:#FFF; color:#black; border:1px solid black;font-weight: bolder;  font-size:20px; border-radius: 50px;}
#sub1:hover{border:1px solid #009223 ; background-color:#009223; color: #fff;}
.list-data{width:1200px;
}
.ul2 li{
display:inline-block;
box-sizing:border-box;
list-style-type: none;
width:350px;
height:350px;
margin-top:10px;
margin-left:34.5px;
}

.list-img{
position: relative;
width:350px;
height:350px;
}
.productim{
position: relative;
width:350px;
height:350px;
}
#cartbtn{
width:72px;
height: 72px;
border-radius: 50%;
display: block;
position: relative;
top:-90px;
left:260px;
border: 0; outline: 0;
}
.cartimg{
width:72px;
height: 72px;
border-radius: 50%;
border :2px solid #009223;
box-sizing:border-box;
display: block;
position: relative;
background-color: #fff ;
}
.cartimg:hover{
border :2px solid #fff;
background-color: #ffc300 ;
}
.topbtn{
width:72px;
height: 72px;
position: fixed;
bottom:20px;
right:20px;
display:scroll;
z-index: 999;
}
.btnbox{
border:1px solid black;
height:100%;
width:100px;}
h6{margin-top:5px;
margin-left:10px;
font-size: 20px;
padding-top:20px;
font-weight: bolder; font-family: 'LeferiPoint-BlackA';
}
h5{
margin-left:10px;
margin-top:10px;
font-size: 12x;
font-weight: bolder;
color:#999; font-family: 'LeferiPoint-BlackA';
}
h2{margin-left:10px;
font-size: 14px; font-family: 'LeferiPoint-BlackA';
}
#updatebtn{
width:50px;
height:25px;
position: relative;
top:-65px;
left:230px;
background-color: #ffc300 ;border: 0; outline: 0;
}
#updatebtn a{color:#FFF;}
#deletebtn{
width:50px;
height:25px;
position: relative;
top:-65px;
left:245px;
background-color: #009223; border: 0; outline: 0;
}
#deletebtn a{color:#FFF;}
</style>

	<script type="text/javascript">
		$(document).ready(function(){
	
		});	

	</script>
</head>
<body>
<br/>
<!-- 코딩은 템플릿화로 잘 정리해두면, 코딩 짜는 시간을 많이 줄일 수 있음. -->
	<div class="container col-offset col-content">	
		<div class="panel-body">
			<!-- 메인 배너화면 -->
			<div class="list-banner">
			<img class="banner" alt="배너이미지" src="<%=contextPath%>/images/${requestScope.category}.jpg">
			</div>
			
		<!-- 첫 화면은 채소인데, 메뉴에서 다른 메뉴로 누르면 카테고리에 따라 메뉴 페이지가 달라짐 -->
			 <div class="list-menu">
		        <ul class="ul1">
					<li>
						<form action="<%=yesForm%>" method="post">
						<input type="hidden" name="command" value="prVegList">
						<input type="hidden" name="category" value="veg">
							<p>
								<span>
									<input id="sub1" type="submit" value="채&nbsp소" >
								</span>
							</p>
						</form>
					</li>
					
					<li>
						<form action="<%=yesForm%>"  method="post">
						<input type="hidden" name="command" value="prVegList">
						<input type="hidden" name="category" value="fruit">
							<p>
								<span>
									<input id="sub1" type="submit" value="과&nbsp일">
								</span>
							</p>
						</form>
					</li>
					
					<li>
						<form action="<%=yesForm%>"  method="post">
						<input type="hidden" name="command" value="prVegList">
						<input type="hidden" name="category" value="meat">
							<p>
								<span>
									<input id="sub1" type="submit" value="정&nbsp육&nbsp&nbsp계&nbsp란">
								</span>
							</p>
						</form>
					</li>
		        </ul>
	   		 </div>
	   		 <div class="list-data"> <!-- 전체 div -->
	   		 	
	   		 	<ul class="ul2">
	   		 		<c:forEach var="bean" items="${requestScope.lists}">
					<li>
					<div class="list-img">
						<div class="img-div">
						<img class ="productim" src="upload/${bean.img}">
						</div>
						
						<button id="cartbtn">
							<img class="cartimg" alt="장바구니" src="<%=contextPath%>/images/cart.svg" onclick="location.href='<%=noForm%>prDetail&num=${bean.num}'">
						</button>
						<c:if test="${whologin == 2}">
						
						<button id="updatebtn" onclick="location.href='<%=noForm%>prUpdate&num=${bean.num}'">
							수정
						</button>
						
						<button id="deletebtn" onclick="location.href='<%=noForm%>prDelete&num=${bean.num}&name=${bean.name}'">
							삭제
						</button>
						</c:if>
					</div>
					<h6>${bean.name}</h6>
					<h5>${bean.content}</h5>
					<h2><fmt:formatNumber pattern="###,###"  value="${bean.price}"/>원</h2>
				</li>
					</c:forEach>
	   		 	</ul>
	   		 </div>
       	</div>
</div>

<div class="topbtn">
 	<a style="" href="#">
 		<img src="<%=contextPath%>/images/top.png" title="top" style="width:80px; height:80px; border-radius:50%;">
 	</a>
</div>
</body>
</html>










