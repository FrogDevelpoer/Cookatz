<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./../common/common.jsp" %>

<%
	int label = 2; //양식의 lebel 너비
	int content = twelve - label ; //양식의 입력(input, select, textarea) 상자의 너비
%>
<%
	
	//request.setAttribute("years", years); //년도를 바인딩
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%--https://jqueryui.com/ --%>
	<%-- Ui interface 관련 링크 (ui.css,ui.js) --%>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
 	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
	<style type="text/css">
	
		*{
		    margin: 0;
		    padding: 0;
		    font-family: 'Poppins', sans-serif;
		    box-sizing: border-box;
  		}
  		
		
		.rgform1{/*회원가입 form*/
			height:1189px;
			width:1050px;
		}
		
		.rgheader{
			height:136px;
			width:1050px;
			margin: 0 auto;
   			padding: 50px 0 51px;
			border: 1px solid #ccc;
			font-family: 'SBAggroB';
		}
		
		.page_sub{
			height:27px;
			width:640px;
			line-height: 17px;
			color: #666;
			font-size: 12px;
			padding-rignt:10px;
			text-align: right;
			border-bottom: 2px solid black ;
			
		}
		.rgtable{
			width:640px;
			
		}
		.rgth{
			
			height:64px;
		    width: 259px;
		    padding: 20px 0 0 20px;
		    font-weight: 700;
		    font-size: 14px;
		    color: #333;
		    line-height: 20px;
		    vertical-align: top;
		    text-align: left;
		    padding-top: 29px;
		    border: 1px solid #ccc;
		}
		
		.rgtd{
			width:450px;
			height:74px;
			padding-left:15px;
			border: 1px solid #ccc;
		}
		
		
		.rgtd2{
			border: 1px solid #ccc;
			color:black;
		}
		
		
		.rginput{
			width:300px;
		    height: 44px;
		    padding: 0 14px;
		    border: 1px solid #ccc;
		    font-size: 14px;
		    line-height: 20px;
		    border-radius: 3px;
		    outline: none;
		    vertical-align: top;
		   
		    
		}
		
		.address{
			width:332px;
		    height: 44px;
		    padding: 0 14px;
		    border: 1px solid #ccc;
		    font-size: 14px;
		    line-height: 20px;
		    border-radius: 3px;
		   
		    outline: none;
		    vertical-align: top;
		}
		
		.ico{
			color: #ee6a7b;
		}
		
		.btn_check{
			border: 1px solid #5f0080;
		    color: #5f0080;
		    display: inline-block;
		    width: 120px;
		    height:44px;
		    margin-left: 5px;
		    vertical-align: top;
		    border-radius: 3px;
		    font-weight: 700;
		    font-size: 14px;
		    line-height: 40px;
		    text-align: center;
		    outline: none;
		}
		
		.label_default{
			width:113.76px;
			height:44px;
			font-size: 14px;
    		line-height: 22px;
    		display: inline-block;
    		padding: 10px 52px 10px 0;
    		vertical-align: top;
    		border: 1px solid #ccc;
    		
		}
	
		.marginleft{
			margin-right:125px;
		}
		
		
		.label [type="radio"]{
			width:18px;height:18px;border:1px;
			margin:0px 12px 0px 12px;
			vertical-align: top;
		}
		.text{
			font-size: 14px;
			vertical-align: top;
			color:#33333375;
		
		}
		
		.adress{
			margin-left:10px;
			margin-top:10px;
		}
		#birth{
			width:332px;
			height:44px;
			
		}
		.birth1{
			width:95px;
			height:40px;
			padding:0px 14px;
		}
		
		.btn_register{
			width: 240px;
		    height: 56px;
		    font-size: 16px;
		    line-height: 54px;
		    margin-top:20px; 
		    background-color:white;
		}
		
		#btn_delete {
			border:1px solid black;
			float:left;
			margin-left:250px;
		}
		
		#btn_update{
			margin-right:180px;
		}
		
		h2{
			font-family: 'SBAggroB';
		}
		
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			//$('.rgtd input').addClass('marginleft');
			//$('.rgtd #birth input').removeClass('marginleft');
			
			
			//월
			var months=['1','2','3','4','5','6','7','8','9','10','11','12'];
			$.each(months,function(index,item){
				console.log(item);
				optvalue = '<option value="'+ item +'">'+ item +'</option>';
				$('#birth2').append(optvalue);
			});
			
			//월 기존정보 뜨게 하기
			$('option[value="${requestScope.bean.birth2}"]').attr('selected',true);
			

	         //비밀번호

	               $('#pwNumber').hide();
	               $('#pwUnique').hide();
	               
	               $('#nowpassword').click(function(){
	                  $('#pwNumber').show();
	                  $('#pwUnique').show();
	                  
	         // 3 <= pw <= 8         
	                  var min = 3 ; var max = 8 ;
	                  var pw = $('#nowpassword').val();
	               
	                  if(pw.length >= min && pw.length <= max ){ //3보다 크거나 같고 8보다 작거나 같으면 
	                     $('#pwNumber').css("color","green"); //초록색
	                  }else{
	                     $('#pwNumber').css("color","red");
	                  }
	                  
	         //pw 특수문자      
	                  var reg = /^[a-z][a-z0-9@#$!]{2,7}$/ ;
	                  var result = reg.test(nowpassword) ;
	                  
	                  if(result = pw.indexOf("@") >= 0 
	                        || pw.indexOf("#") >= 0 
	                        || pw.indexOf("!") >= 0 
	                        || pw.indexOf("$") >= 0 )
	                  {
	                     $('#pwUnique').css("color","green"); //초록색
	                     
	                  }else{
	                     $('#pwUnique').css("color","red"); //초록색
	                  }
	                  
	                  
	                  //작성했으면 사라짐    
	                  $('#nowpassword').mouseout(function(){
	                     if($('#password').val()==0){//값이없으면 

	                        $('#pwNumber').hide();
	                        $('#pwUnique').hide();
	                     }else{ //값이 있으면 

	                        $('#pwNumber').hide();
	                        $('#pwUnique').hide();
	                     }
	                  });
	                     
	               });
	               
	            
	      
		
		
	
});
		
	</script>
</head>
<body>
<form name="myform" action="<%=yesForm%>" method="post">
<input type="hidden" name="command" value="emUpdate">
	<div class="container">
		<div class="rgform1" align="center">
			<div class="rgheader">
				<h2>개인 정보 수정</h2>
			</div>
			<p class="page_sub" ><span class="ico">*</span>필수사항입력</p>
			<table class="rgtable">
				<tr>
					<th class="rgth">아이디<span class="ico">*</span></th>
					<td class="rgtd"><%--적혀있음 --%>
						<input class="rginput" type="text" name="fakeid" id="fakeid" value="${requestScope.bean.id}" disabled="disabled">
						<input class="rginput" type="hidden" name="id" id="id" value="${requestScope.bean.id}">
					</td>
				</tr>


					<tr>
						<th class="rgth">비밀번호 변경<span class="ico">*</span></th>
						<td class="rgtd"><input class="rginput" type="password"
							name="nowpassword" id="nowpassword" value="">
							<p class="textsize" id="pwNumber">비밀 번호는 3글자 이상 8글자 이하이어야
								합니다.</p>
							<p class="textsize" id="pwUnique">특수 문자( @ # $ ! ) 중에서 반드시
								1개를 사용해야 합니다.</p></td>
					</tr>


					<%-- <tr>
				현재 비밀번호 확인 버튼 
					<th class="rgth">현재 비밀번호<span class="ico">*</span></th>
					<td class="rgtd">
						<input class="rginput" type="password" name="nowpassword" id="nowpassword" value="" >
						<button onclick="addNum();">버튼</button>
						<input class="rginput" type="button" id="pwCheck" value="비밀번호 확인" onclick="pwCheck();" > 
					</td>
				</tr>--%>
			
				<!--  
				새비밀번호 새비밀번호 확인
				<tr>
					<th class="rgth">새 비밀번호<span class="ico">*</span></th>
					<td class="rgtd">
						<input class="rginput" type="password" name="newpassword" id="newpassword"
						value="">
					</td>
				</tr>
				<tr>
					<th class="rgth">새 비밀번호 확인<span class="ico">*</span></th>
					<td class="rgtd">
						<input class="rginput" type="password" name="checkpassword" id="checkpassword"
						 value="">
					</td>
				</tr>
				 -->
				<tr>
					<th class="rgth">이름<span class="ico">*</span></th><%--적혀있기 --%>
					<td class="rgtd">
						<input class="rginput" type="text" name="name" id="name"
						 value="${requestScope.bean.name}">
					</td>
				</tr>
				<tr>
					<th class="rgth">휴대전화<span class="ico">*</span></th><%--적혀있기 --%>
					<td class="rgtd">
						<input class="rginput" type="text" name="phone" id="phone"
						 value="${requestScope.bean.phone}">
					</td>
				</tr>
				<tr>
					<th class="rgth">이메일<span class="ico">*</span></th><%--적혀있기 --%>
					<td class="rgtd"> 
						<input class="rginput" type="text" name="email" id="email"
						value="${requestScope.bean.email}">
					</td>
				</tr>
				<tr>
					<th class="rgth">성별<span class="ico">*</span></th><%--적혀있기 --%>
					<td class="rgtd2">
						<label class="label" >
							<c:if test="${requestScope.bean.gender == '남자'}">
								<input type="radio" name="gender" id="gender" value="남자" checked="checked" ><span class="text">남자</span>
							</c:if>
							<c:if test="${requestScope.bean.gender != '남자'}">
								<input type="radio" name="gender" id="gender" value="남자" ><span class="text">남자</span>
							</c:if>
						</label>
						<label class="label" >
							<c:if test="${requestScope.bean.gender == '여자'}">
								<input type="radio" name="gender" id="gender" value="여자" checked="checked" ><span class="text">여자</span>
							</c:if>
							<c:if test="${requestScope.bean.gender != '여자'}">
								<input type="radio" name="gender" id="gender" value="여자"><span class="text">여자</span>
							</c:if>
						</label>
						<%--null값 체크 --%>
						<label class="label" >
							<c:if test="${requestScope.bean.gender == 'null'}">
								<input type="radio" name="gender" id="gender" value="null" checked="checked" ><span class="text">선택안함</span>
							</c:if>
							<c:if test="${requestScope.bean.gender != 'null'}">
								<input type="radio" name="gender" id="gender" value="null"><span class="text">선택안함</span>
							</c:if>
						</label>
					</td>
				</tr>
				<tr>
					<th class="rgth">생년월일<span class="ico">*</span></th>
					<td class="rgtd">
						<div id="birth" align="left">
							<input type="text" class="birth1" name="birth1" value="${requestScope.bean.birth1}" >
						  	  <select class="birth1" id ="birth2" name="birth2">
						    	<option value="-"></option>
						  	</select>
						  	<input type="text" class="birth1" name="birth3" value="${requestScope.bean.birth3}" >
						 </div>
					</td>
				</tr>
			</table>
			<p class="page_sub"></p>
			<div>
				<div class="btn_register" id="btn_delete"  onclick="location.href='<%=noForm%>emDelete&id=${sessionScope.loginfo.id}'" style="cursor: pointer;">
					탈퇴하기
				</div>
				<button type="submit" class="btn_register" id="btn_update" >수정하기</button>
			</div>
		</div>

	</div>
</form>	 	
	
	
</body>
</html>