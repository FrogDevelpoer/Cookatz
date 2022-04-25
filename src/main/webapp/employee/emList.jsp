<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			
			for(var i=1; i< 11; i++){ //페이징 1~10
											//<li id="li1"><a href="$">1</a></li>
				$('#paginator').append('<li id="li'+i+'"><a class="mylink" href="#">'+i+'</a></li>');
				
			}
				$('#li2').addClass('active');
				$('#li4').addClass('disabled');
				
				var oldidx = 2; //지금 현재 활성화된 요소의 인덱스
				
				$('a.mylink').click(function(){
					//alert($(this).text()); //i 번호를 가져오기 위해 클래스를 만들고. text()함수를 써서 i 가져옴
					var idx = $(this).text();
					if(idx==4){ //아래if문 접근하지 않고 아래 코드 진행하여 4번 활성화
						if($('#li4').hasClass('disabled')==true){ ////비활성화된 4번눌렀을 때 return 해버림으로 아래 코드 진행 안함
							return ;
						}
					}
					$('#li'+idx).addClass('active');//방금 선택한 녀석 활성화
					$('#li'+oldidx).removeClass('active'); //이전 활성화된 요소 비활성화
					oldidx = idx; //방금 선택된 요소의 인덱스를 저장
					if(idx==10){ //10번 눌렀을 때
						$('#li4').removeClass('disabled'); //4번 활성화
						
					}
					
				});
			
		});
	</script>
</head>
<body>
<br>
<div class="container">
	 <div class="panel panel-default">
	    <div class="panel-heading"><!-- class="panel-title": 부트스트렙에 있는 panel-title 디자인이 입혀짐 -->
	    	<h2 class="panel-title" align="center">회원 목록</h2>
	    </div>
    	 <table id="infotable" class="table table-hover">
		    <thead>
		      <tr>
		        <th>아이디</th>
		        <th>이름</th>
		        <th>생년월일</th>
		        <th>성별</th>
		        <th>핸드폰번호</th>
		        <th>email</th>
		        <th>주소</th>
		        <th>mpoint</th>
		      </tr>
		    </thead>
			<tbody>
			<c:forEach var="bean" items="${requestScope.lists}" ><%--반복해서 리스트를 나열 --%>
			 	<tr>
			 		<td>${bean.id}</td>
			 		<td>${bean.name}</td>
			 		<td>${bean.birth1}-${bean.birth2}-${bean.birth3}</td>
			 		<td>${bean.gender}</td>
			 		<td>${bean.phone}</td>
			 		<td>${bean.email}</td>
			 		<td>${bean.zipcode}/${bean.address1}/${bean.address2}</td>
			 		<td>${bean.mpoint}</td>
			 	</tr>
			 </c:forEach>
			 </tbody>
		</table>
	 </div>
</div>
</body>
</html>


























