<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 수학 연산을 위한 태그 라이브러리 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 숫자나 날자에 대한 서식지정을 위한 태그 라이브러리 --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- 자바의 String 클래스와 유사한 기능을 수행하기 위한 태그 라이브러리 --%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%-- 로그인 정보는 session 영역에 loginfo라는 이름으로 바인딩하겠습니다. --%>
<%-- 로그인시 id가 admin이면 관리자로 해석합니다. --%>
<%-- whologin 변수는 로그인 상태를 저장하고 있습니다. --%>
<%-- whologin : 미로그인(0), 일반 사용자(1), 관리자(2) --%>

<%-- <%@page import="model.Human" %> --%>
<%
	/* // 테스트를 위한 임시 코드 작성 예정
	Human loginfo = new Human(); */

	
	/* 
	// 일반 사용자
	loginfo.setId("hong");
	loginfo.setName("홍길동");
	session.setAttribute("loginfo", loginfo);
	 
	
	/*
	// 관리자
	loginfo.setId("admin");
	loginfo.setName("홍길동");
	session.setAttribute("loginfo", loginfo);
	*/
	
	// 미로그인은 코딩 할거 없음
%>

<c:set var="whologin" value="0"/>

<%-- 로그인이 안되어있을 때 실행 --%>
<c:if test="${not empty sessionScope.loginfo}">
	<%-- 일반사용자 --%>
	<c:if test="${sessionScope.loginfo.id != 'admin'}">
		<c:set var="whologin" value="1"/>
	</c:if>
	<%-- 관리자 --%>
	<c:if test="${sessionScope.loginfo.id == 'admin'}">
		<c:set var="whologin" value="2"/>
	</c:if>
</c:if>

<%
	// contextPath : 해당 애플리케이션의 이름(컨텍스트 이름)
	String contextPath = request.getContextPath();

	// 서블릿 맵핑 이름
	String mapping = "/Cookatz";

	// form 태그가 있는 곳에서 사용할 공용 변수
	String yesForm = contextPath + mapping;
	
	//form 태그가 없는 곳에서 사용할 공용 변수 <a>, <img>
	String noForm = yesForm + "?command=";
%>
<%
	// for BootStrap
	int twelve = 12;
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>
	<!-- for BootStrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<style type="text/css">
	
	@font-face { /*강조*/
    font-family: 'SBAggroB';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroB.woff') format('woff');
    font-weight: normal;
    font-style: normal;
	}
	
	@font-face { /*텍스트*/
    font-family: 'LeferiPoint-BlackA';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/LeferiPoint-BlackA.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
		
	
		*{
			margin: 0;
			padding: 0;
		}
		html {
            position: relative;
            min-height: 100%;
            margin: 0;
            padding-bottom: 200px;
          
         }
		body{
		
           	min-height: 100%;
           	
		}
		/* header 스타일 영역*/
		header{
			width: 100%;
			height: 230px;
			background-color: #ffffff;
			top: 0;
			border-top: 5px solid #009223;
			margin-bottom: 30px;
			border-bottom: 3px solid #ffc300;
			
			
		}
		.d{
			width:100%;height:130px;
		}
		
		.LogoDiv{
			width: 300px;
			height: 130px;
			display: block;	
			
			margin-top:-40px;
			
			text-align:center;
			box-sizing: border-box;
			margin-left:auto; margin-right:auto;
			/*float:left;*/
			/*padding-top: 30px;*/
			 /*이미지 ul 간:*/
		
		}
		
		
		.LogoDiv a{
			height:100%;
			width:100%;
			display: inline-block;
		}
		.LogoDiv img{
			height:100%;
			
		}
		
		.util-01{
			width:100%;
			height:50px;
		}
		
		.Util_Menu{
			width: 400px;
			height: 30px;
			float: right;
		    margin-right: 5%;
		    margin-top: 20px;
		}
		
		
		.Util_Menu ul li{
			list-style: none;
			float: left;
			text-align: center;
			font-size: 13px;
			margin-left: 13px;
		    display: block;
		    color: #666666;
		    font-weight: normal;
		    line-height: 30px;
		    height: 30px;
		    
		}
		.Util_Menu a{
			color: #666666;
			text-decoration-line: none;
		}
		.Util_Menu a:hover{
			cursor: pointer;
		}
		@media screen and (max-width: 850px) {
	   	 .Util_Menu {display:none;}
		}
		
		@media screen and (max-width: 900px) {
	   	 .Util_Menu {
	   	 	padding-left: 80px;
	   	 	}
		}
		.HeadNav{
			width: 100%;
			height: 45px;
			display: inline-block; 
			text-align: center;
		
			
		}
		
		a:hover, a:visited, a:link, a:active{
			text-decoration:none
		}
		
		
		.HeadNav ul{
			display: inline-block; 
			text-align: center;
			margin-top:28px;
			width:900px;
			height:60px;
		}
		.HeadNav li{
			float: left;
			list-style: none;
			font-size: 21px;
			color: #292929;
		    font-weight: bold;
		    display:inline-block;
		    text-align: center;
		    width:180px;
			margin-left:20px;
			margin-right:20px;
			margin-top:12px;
			vertical-align: middle;
			padding-top:3px;
			border-radius: 3px;
			cursor: pointer;
			text-decoration-line: none;
			height:41px;
			font-family: 'LeferiPoint-BlackA';
		}
		.HeadNav a{
			
		}
		.HeadNav li:hover{
			border:5px solid #009223;
		}
		@media screen and (max-width: 850px) {
	   	 .Util_Menu {display:none;}
		}
		
		/* footer 스타일 영역*/
		footer{
			width: 100%;
			height: 180px;
			background-color: #292929;
			border: 1px solid black;
			position: absolute;
  			bottom: 0;
  			color: #666666;
  			text-align: center;
  			font-size: 14px;
  			z-index: 1;
  			padding-top: 20px;
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
	<!--  헤더 부분 -->
	<header>
		
			<!-- 유틸메뉴 부분 -->
			<div class="util-01">
				<div class="Util_Menu">
					<ul>
					<c:if test="${whologin == 0}"> <%--로그인 안했으면 --%>
						<li>
							<c:if test="${whologin == 0}">
								<a href="<%=noForm%>emLogin">로그인<span class="glyphicon glyphicon-log-in"></span></a>
							</c:if>
						</li>
		
						<li>
							<c:if test="${whologin == 0}">
								<a href="<%=noForm%>emInsert">회원가입<span class="glyphicon glyphicon-user"></span></a>
							</c:if>
						</li>
					</c:if>
					
					<!-- 관리자 일 때 -->
					<c:if test="${whologin == 2}">
						<li>
							<font color="black">
								${sessionScope.loginfo.name}(${sessionScope.loginfo.id})님
							</font>
						</li>
						<li>
							<c:if test="${whologin == 2}">
								<a href="<%=noForm%>adPage&id=${sessionScope.loginfo.id}">관리자페이지<span class="glyphicon glyphicon-log-out"></span></a>
							</c:if>
						</li>
						<li>
							<c:if test="${whologin == 2}">
								<a href="<%=noForm%>emLogout">로그아웃<span class="glyphicon glyphicon-log-out"></span></a>
							</c:if>
						</li>
					</c:if>
					
					<!-- 회원 로그인 했을 때 -->
					<c:if test="${whologin == 1}">
						<li>
							<font color="black">
								${sessionScope.loginfo.name}(${sessionScope.loginfo.id})님
							</font>
						</li>
						<li>
							<c:if test="${whologin == 1}">
								<a href="<%=noForm%>emPage&id=${sessionScope.loginfo.id}">MySub<span class="glyphicon glyphicon-log-out"></span></a>
							</c:if>
						</li>
						<li>
							<c:if test="${whologin == 1}"><%--command고치기 --%>
								<a href="<%=noForm%>maList&id=${sessionScope.loginfo.id}">장바구니<span class="glyphicon glyphicon-shopping-cart"></span></a>
							</c:if>
						</li>
						<li>
							<c:if test="${whologin == 1}">
								<a href="<%=noForm%>emLogout">로그아웃<span class="glyphicon glyphicon-log-out"></span></a>
							</c:if>
						</li>
						</c:if>
					</ul>
				</div>
			</div>
			<!-- 로고 이미지 부분 -->
		<div class="d">
			<div class="LogoDiv" >
				<a href="<%=noForm%>main">
					<img id="logo"alt="LogoImg" src="<%=contextPath%>/images/plz2.png">
				</a>
		   </div>
		</div>
	
		<!-- 헤드 네비 메뉴 목록 -->
		<div class="HeadNav">
			<ul>
				<li onclick="location.href='<%=noForm%>CCBoMainList'">쿠킹 클래스</li>
				<li onclick="location.href='<%=noForm%>reList'">나의 레시피</li>
				<li onclick="location.href='<%=noForm%>prVegList'">오늘의 식자재</li>
				<li onclick="location.href='<%=contextPath%>/client/clientCenter.jsp'">고객 센터</li>
				<%-- <li>
					<c:if test="${whologin == 2}">
						<a href="#">관리자 페이지</a>
					</c:if>
				</li> --%>
			</ul>
		</div>
	</header>

	
	<!-- footer 부분 -->
	
	<footer>
		<div class="footerDiv">
			<ul>
				<li>
					(주) 쿡캣즈 | 대표 : 백주현 | 서울특별시 금천구 가산동 |<br>
					 ask@cookatz.com | 전화번호 : 02-000-000 | <br>
					 사업자등록번호:00-000-000 | 통신판매업신고:2022-서울금천구-0001|<br><br><br>
					주식회사 쿡캣즈는 전자상거래 등에서의 소비자보호에 관한 법률에 따른
					통신판매업과 통신판매중개업을 영위하고 있습니다.<br>
					주식회사 쿡캣즈은 통신판매중개자로서 중개하는 통신판매에 관하여서는
					 통신판매의 당사자가 아니므로 어떠한 책임도 부담하지 아니합니다.
				 </li>
			</ul>
		</div>
	</footer>
	
	<%-- message 변수는 사용자에게 어떠한 메시지를 전달하기 위하여 session 영역에 저장합니다. --%>
	<% //session.setAttribute("message", "고갱님 많이 사주셔셔 감사합니다."); %>
	<c:if test="${not empty sessionScope.message}">
		<div id="divalert" class="alert alert-info alert-dismissible">
	  		<a href="#" id="mymessage" class="close" data-dismiss="alert" aria-label="close">닫기</a>
	  		<strong>${sessionScope.message}</strong>
		</div>
	</c:if>
	<% session.removeAttribute("message"); %>	
	
	<%-- errmsg 변수는 사용자에게 어떠한 메시지를 전달하기 위하여 request 영역에 저장합니다. --%>
	<% //request.setAttribute("errmsg", "고갱님~~이러시면 안됩니다."); %>
	
	<c:if test="${not empty requestScope.errmsg}">
		<div id="divalert" class="alert alert-danger alert-dismissible">
	  		<a href="#" id="myerrmsg" class="close" data-dismiss="alert" aria-label="close">닫기</a>
	  		<strong>${requestScope.errmsg}</strong>
		</div>
	</c:if>
	<% request.removeAttribute("errmsg"); %>	
	
	
</body>
</html>