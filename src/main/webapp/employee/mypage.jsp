<%@page import="java.util.Map"%>
<%@page import="cookatz.mall.cart.CocazCartList"%>
<%@page import="cookatz.mall.cart.CocazShoppingInfo"%>
<%@page import="cookatz.mall.dao.MallDao"%>
<%@page import="cookatz.recipe.bean.Recipe"%>
<%@page import="java.util.List"%>
<%@page import="cookatz.recipe.dao.RecipeDao"%>
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
	    font-family: 'SBAggroB';
	}
	.member1{
	
	
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
     

	.recipe{
		
		background-color: #009223;
		border: 6px solid #009223;
    	padding-top: 42px;
    	
    	margin-left:15px;
	}
	
	
	

	   .cart{
     	 background-color: #9631a8;
         border: 6px solid #9631a8;
      	 padding-top: 42px;
       	 margin-left:15px;
       	 border-bottom-right-radius: 50px;
       
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
    	margin-left:25px; 
    	
    	
    }
    

	
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
		
		});
	</script>
		<%
				RecipeDao rdao = new RecipeDao();
		
				List<Recipe> lists = rdao.SelectAll();
				int list = lists.size();
				
				//MallDao madao = new MallDao();
				//List<CocazShoppingInfo> lists1 = madao.SelectAll(); 
				//int list1 = lists1.size();
				
				
				
				//CocazShoppingInfo m = new CocazShoppingInfo();//장바구니 객체
				
				
				
				/* CocazCartList lists1 = new CocazCartList();
				Map<Integer, Integer> cartItems = lists1.GetAllOrderList();
				int list1 = cartItems.size(); */
				
				MallDao madao = new MallDao();
				
				List<CocazShoppingInfo> lists1 = madao.SelectAll();
				int list1 = lists1.size();
			
				
		
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
			<div class="name0">
				<p class="name">
				<strong class="multiple_line"> 
					${sessionScope.loginfo.name}님
				</strong>
				</p>
			</div>
			<div class="btn1">
				<a class="btn go_view" href="<%=noForm%>emUpdate&id=${sessionScope.loginfo.id}">회원정보변경</a>
			</div>
		</div>
		
		
		<div class="info recipe" >
			<h3>나의 레시피</h3>
			<div>
			<strong class="size">
				<%=list%>건
			</strong>
			</div>
			<div class="btn1">
				<a class="btn" href="<%=noForm%>reInsert">작성하기</a>
			</div>
		</div>
		
		<div class="info cart" >
			<h3>장바구니</h3>
			<div><strong class="size">
				<%=list1%>건
			</strong>
			</div>
			<div class="btn1">
				<a class="btn" href="<%=noForm%>maList&id=${sessionScope.loginfo.id}">보러가기</a>
			</div>
		</div>
		
	</div>
	
</div>
</body>
</html>