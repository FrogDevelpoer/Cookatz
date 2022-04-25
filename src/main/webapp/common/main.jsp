<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		.carousel-inner img{
			width: 100%;
		}
		
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			//alert('aa');	
		});
	</script>
</head>
<body>
	<!-- id, data-tagrget, href 이름 통일  -->
<div class="container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- carousel-indicators : 동그라미 세개-->
    <ol class="carousel-indicators"><!--data-target과 div의 id이름 같이 하기  -->
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <a href="<%=noForm%>CCBoMainList">
        <img src="<%=contextPath %>/images/ccboard.jpg" alt="쿠킹클래스">
        </a>
      </div>

      <div class="item">
      	<a href="<%=noForm%>reList">
        <img src="<%=contextPath %>/images/recipe.jpg" alt="레시피">
        </a>
      </div>
    
      <div class="item">
      	<a href="<%=noForm%>prVegList">
        <img src="<%=contextPath %>/images/cm.jpg" alt="식자재">
        </a>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span><!-- <  -->
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span><!-- < -->
    </a>
  </div>
</div>
</body>
</html>