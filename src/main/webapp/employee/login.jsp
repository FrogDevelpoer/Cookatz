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
		    margin: 0;
		    padding: 0;
		    font-family: 'Poppins', sans-serif;
		    box-sizing: border-box;
		   
  		}
  		
  	
		.wrapper{
		    margin: 120px auto;
		    height:500px;
		    max-width: 500px; 
		    width: 100%; 
		    background-color: #fff;
		    border-radius: 5px;
		    padding: 24px;
		    border:1px solid black;
		    text-align: center;
	    }
	    
	    #memberLogin{
	    	margin-bottom:40px;
	    	color: internal-light-dark;
	    }
	    
	    .form-control{	
	    	height:50px;
	    	margin-bottom: 30px;
	    }
	    
	    .txtLogin {
	    	font-size:18px;
	    	text-align: left;
	    	color: internal-light-dark;
	    }
	 
	 	.checkLogin{
	 		margin-top:-20px;
	 		margin-left:5px;
	 		color: rgb(120, 120, 120);
	 		
	 	}
	   
	   
	    #logbtn{
	    	width:452px;
	    	heigth:50px;
	    	padding:10px 16px;
	    	font-size:18px;
	    	border-radius:3px;
	    	color: internal-light-dark;
	    	border: 1px solid #333;
	    	margin-top:30px;
	    }
	    
	    
}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			//alert('aa');	
		});
	</script>
</head>
<body>
	<section>
		<form action="<%=yesForm%>" method="post">
			<input type="hidden" name="command" value="emLogin">
			<div class="wrapper flex-container" align="center">
				<h2 id="memberLogin">회원 로그인</h2>
				<div class="form-group">
					<div>
						<h5 class="txtLogin">Id</h5>
						<input class="form-control input-lg" id="id" name="id" type="text"
							placeholder="아이디">
					</div>
					<div>
						<h5 class="txtLogin">Password</h5>
						<input class="form-control input-lg" id="password" name="password"
							type="password" placeholder="비밀번호">

						<div class="checkLogin" align="left">
							<label><input type="checkbox" id="checkLogin"
								name="checkLogin" value="">&nbsp;로그인 유지</label>
						</div>
					</div>
				</div>
				<div>
					<button id="logbtn" type="submit" class="btn btn-default">Log
						In</button>
					<!-- 로그인 성공,파라미터로 게시판페이지 가기 -->
					<h5>
						회원이 아니세요?&nbsp;&nbsp;&nbsp;<span><a href="<%=noForm%>emInsert">회원가입 하기</a></span>
					</h5>
					<!-- 파라미터로 회원가입페이지 가기-->
				</div>
			</div>
		</form>
	</section>
</body>
</html>














