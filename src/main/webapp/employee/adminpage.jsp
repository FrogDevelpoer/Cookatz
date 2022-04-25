<%@page import="cookatz.recipe.dao.RecipeDao"%>
<%@page import="cookatz.recipe.bean.Recipe"%>
<%@page import="cookatz.CCBoard.bean.Board"%>
<%@page import="cookatz.CCBoard.dao.BoardDao"%>
<%@page import="cookatz.product.bean.Product"%>
<%@page import="cookatz.product.dao.ProductDao"%>
<%@page import="cookatz.employee.dao.EmployeeDao"%>
<%@page import="cookatz.employee.bean.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./../common/common.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
	

	body{
	width: 100%
		
	}
	.title{
	
		height:171px;
		text-align: center;
	    font-size: 40px;
	    color: #292929;
	    padding: 73px 0 50px;
	}
	
	.boxes{ /*contents 전체 틀*/
		
		
	  	box-sizing: border-box;
		margin: 0px 119.6px ;
		width:1300px;
		margin-left:200px;
	
	
	}
	
	.info{ /*box들 공통 */
	
		width:380px; height:300px;
		border:1px solid black;
		float:left;
		box-sizing: border-box;
		
	}
	 .member{
	 	
		background-color: #ffffff;
  	 	border: 6px solid #ffc300;
    	border-top-left-radius: 50px;
    	padding-top: 42px;
	}
	 .character{
		
    	padding: 0 10px;
    	background-repeat: no-repeat;
   		/*background-position: 0 0;*/
    	height: 150px;
    	width: 150px;
        text-align: center;
    	float:left;
    	padding-top:20px;
    }
     
     .name0{
     	margin-top:80px;
     }
     .name{
     	margin-top: 50px;
     	width:196px;
     	font-size: 30px;
     	text-align: left; 
     	font-family: 'LeferiPoint-BlackA';
     	
    
     }
     

    /*
    .go_view{
    	display:block;
    	border: 2px solid #ffffff;
    	font-size:16px;
    	font-weight:300;
    	position: absolute;
    	left: 50%; 
    	margin-left: -63px;
    	width:126px;
    	border-color: #999;
    	color: #999;
    	bottom: 36px;
    
    }
	*/
	.recipe{
		
		background-color: #009223;
		border: 6px solid #009223;
    	padding-top: 42px;
    	margin: 0 0 0 15px;
	}
	
	
	.class{
    	background-color: #ffc300;
  	 	border: 6px solid #ffc300;
    	border-top-right-radius: 50px;
    	padding-top: 42px;
    	margin: 0 0 0 15px;
	}
	

	.cart{
		background-color: #9631a8;
  	 	border: 6px solid #9631a8;
    	padding-top: 42px;
    	
	}
	
	.gift{
		background-color: #00a9ec;
		border: 6px solid #00a9ec;
    	padding-top: 42px;
    	margin: 0 0 0 15px;
    	
	}
	
	.gift2{
		
		background-color: #ff8300;
		border: 6px solid #ff8300;
		border-bottom-right-radius: 50px;
    	padding-top: 42px;
    	margin: 0 0 0 15px;
    	
	}
	
	h2{
		font-family: 'SBAggroB';
	}
	
	h3{
		font-size:20px;
		font-weight: bolder;
		color:#ffffff;
		margin-bottom: 20px;
		font-family: 'LeferiPoint-BlackA';
		
	}
	
	.size{ /*콘텐츠 갯수 0건 ~ */
		color:#ffffff;
		font-size: 44px;
    	font-weight: bold;
    	
	}
	
	
	a{
    	cursor: pointer;
    	color:#ffffff;
    }
     
	.btn1{
		margin-top:50px;
	}

     
  .btn{
  
    	text-align: center;
    	vertical-align: middle;
    	border-radius: 30px;
    	border: 1px solid #ffffff;
    	
    
    } 
    
   .btn1 .go_view{
   	 	color:black; 
  	 	border: 1px solid #000;
  	 	/*height: 34px;*/
   	 	text-align: center;
    	vertical-align: middle;
    	border-radius: 30px;
    	display: inline-block;
    	margin-left:-130px; 
    	margin-top:30px;
    	
    }
    

	
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
		
		});
	</script>
	<%
				EmployeeDao mdao = new EmployeeDao();
				List<Employee> lists = mdao.SelectAll();
				int list = lists.size();
				
				ProductDao pdao = new ProductDao();
				
				List<Product> lists1 = pdao.SelectAll2(); 
				int list1 = lists1.size();
				
				BoardDao bdao = new BoardDao();
				
				List<Board> lists2 = bdao.SelectAll2(); 
				int list2 = lists2.size();
				
				RecipeDao rdao = new RecipeDao();
				
				List<Recipe> lists3 = rdao.SelectAll2(); 
				int list3 = lists3.size();
				
	%>
</head>
<body>
<h2 class="title" >MY SUB</h2>
<div class="member1" align="center"> 
	<div class="boxes">
		<div class="info member" >
			<div class="name_genger"> 
				<img class="character" alt="character" src="<%=contextPath%>/images/img_profile.png">
			</div>
			<div class="name0" >
				<p class="name">
				<strong class="multiple_line"> 
					${sessionScope.loginfo.name}님
				</strong>
				</p>
			</div>
		</div>
		
		
		<div class="info recipe" >
			<h3>회원 조회</h3>
			<c:if test="${whologin != 2}">
				<div><strong class="size">
					0건
					</strong>
				</div>
			 </c:if>
			<c:if test="${whologin == 2}">
				<div><strong class="size">
					<%=list%>건
					</strong>
				</div>
			 </c:if>
			<div class="btn1">
				<a class="btn" href="<%=noForm%>emList">보러가기</a>
			</div>
		</div>
		<div class="info class" >
			<h3>상품 관련</h3>
			<div>
			<strong class="size">
				<%=list1%>건
			</strong>
			</div>
			<div class="btn1">
				<a class="btn" href="<%=noForm%>prInsert">등록하기</a>
				<a class="btn" href="<%=noForm%>prVegList">목록보기</a>
			</div>
		</div>
		<div class="info cart" >
			<h3>동영상 관련</h3>
			<div>
				<strong class="size">
					<%=list2%>건
				</strong>
			</div>
			<div class="btn1">
				<a class="btn" href="<%=noForm%>CCBoInsert">등록하기</a>
				<a class="btn" href="<%=noForm%>CCBoList">목록보기</a>
			</div>
			
		</div>
		<div class="info gift" >
			<h3>고객 게시판 조회</h3>
			<div>
				<strong class="size">
					<%=list3%>건
				</strong>
			</div>
			<div class="btn1">
				<a class="btn" href="<%=noForm%>reList">조회하기</a>
			</div>
		</div>
		<div class="info gift2" >
			<h3>시즌 준비중입니다.</h3>
			<div>
				<strong class="size">
					0건
				</strong>
			</div>
			<div class="btn1">
				<a class="btn" href="#">댓글달기</a>
			</div>
		</div>
	</div>
	
</div>
</body>
</html>