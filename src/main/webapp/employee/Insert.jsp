<%@page import="cookatz.employee.dao.EmployeeDao"%>
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
 	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js">
 	</script>
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
			
			height:74px;
		    width: 159px;
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
			width:481px;
			height:74px;
			text-align: center;
			border: 1px solid #ccc;
		}
		
		
		.rgtd2{
			border: 1px solid #ccc;
			color:black;
		}
		
		.rgtd3{
			width:481px;
			height:180px;
			text-align: center;
			border: 1px solid #ccc;
		}
		.rginput{
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
			margin:0px 12px 0px 5px;
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
			padding:0px 0px 0px 18px;
			
		}
		.birth1{
			width:84px;
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
		#idnull, #idlength,#pwNumber ,#pwUnique, #pwRecheck1, #nameGet, #phoneGet, #emailGet, #findpost , #genderGet ,#birth1Get, #birth2Get ,#birth3Get{
		color:red;
		}
		#pwRecheck2, #emailGet1,#goodAdress,#nameGet1, #genderGet1{
		color:green;
		}
		
		.textsize{
			font-size:11px;
			text-align: left;
			line-height: 10px;
			margin-left:20px;
			margin-top:5px;
		}
		
		h2{
			font-family: 'SBAggroB';
		}
	</style>

	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$('.rgtd input').not(':first').addClass('marginleft');
		$('.rgtd #birth input').removeClass('marginleft');
		
		var months=['1','2','3','4','5','6','7','8','9','10','11','12'];
		$.each(months,function(index,item){
			console.log(item);
			optvalue = '<option value="'+ item +'">'+ item +'</option>';
			$('#birth2').append(optvalue);
		});
		
		/*
			<span id="idnull">아이디를 입력하세요.</span><br>
						 <span id="idlength">아이디는 4글자이상 10글자 이하 입력하세요</span> 
		*/
		
//아이디
			$('#idnull').hide();
			$('#idlength').hide();
			
			var min = 4 ; var max = 10;
			$('#id').click(function(){
				$('#idnull').show();
				$('#idlength').show();
				
				if($('#id').val().length != 0){ //id가 값이 있으면 
					$('#idnull').css("color","green"); //red -> green
				}else{ //없으면
					$('#idnull').css("color","red");
				}
				
				if($('#id').val().length >= min && $('#id').val().length <= max){ //id 길이가 4이상, 10글자 미만
					$('#idlength').css("color","green");
				}else{
					$('#idlength').css("color","red");
				}
				
				
			//작성했으면 사라짐 	
				$('#id').mouseout(function(){
					if($('#id').val()!=0){//값이있음
						$('#idnull').hide();
						$('#idlength').hide();
					}
				});
				

				
		});
			
			
//비밀번호


		$('#pwNumber').hide();
		$('#pwUnique').hide();
		
		$('#password').click(function(){
			$('#pwNumber').show();
			$('#pwUnique').show();
			
// 3 <= pw <= 8			
			var min = 3 ; var max = 8 ;
			var pw = $('#password').val();
		
			if(pw.length >= min && pw.length <= max ){ //3보다 크거나 같고 8보다 작거나 같으면 
				$('#pwNumber').css("color","green"); //초록색
			}else{
				$('#pwNumber').css("color","red");
			}
			
//pw 특수문자		
			var reg = /^[a-z][a-z0-9@#$!]{2,7}$/ ;
			var result = reg.test(password) ;
			
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
			$('#password').mouseout(function(){
				if($('#password').val()==0){//값이없으면 

					$('#pwNumber').hide();
					$('#pwUnique').hide();
				}else{ //값이 있으면 

					$('#pwNumber').hide();
					$('#pwUnique').hide();
				}
			});
				
		});
		
	
		
//pwRecheck
			
				$('#pwRecheck1').hide(); //같지 x 
				$('#pwRecheck2').hide(); //같
				
			$('#passwordcheck').click(function(){
				if($('#passwordcheck').val() == 0){ //값이 없으면 
					$('#pwRecheck1').show(); //같지 x 
					
					
				}else{ //값이 있으면
					if($('#password').val() == $('#passwordcheck').val()){
						$('#pwRecheck1').hide();
						$('#pwRecheck2').show(); //같
					}else{
						$('#pwRecheck2').hide(); //같
						$('#pwRecheck1').show();
					}
					
				}
				
				//작성했으면 사라짐 	
				$('#passwordcheck').mouseout(function(){
					if($('#passwordcheck').val()==0){//값이없으면 
						$('#pwRecheck1').hide(); //같지 x 
						$('#pwRecheck2').hide(); //같
					}else{ //값이 있으면 
						$('#pwRecheck1').hide(); //같지 x 
						$('#pwRecheck2').hide(); //같
					}
				});	
				
		
	});
				
	
// 이름 체크기		

		$('#nameGet').hide(); //이름 없
		
		$('#name').click(function(){ //마우스에 올렸을 때
			if($('#name').val() == 0){ //값이 없으면 
				$('#nameGet').show(); //입력해주세요
			}else{  //이름있으면 
				$('#nameGet').show();
				$('#nameGet').css("color","green"); 
				
			}
			
			$('#name').mouseout(function(){
				if($('#name').val() == 0){
					$('#nameGet').hide();
				}else{
					$('#nameGet').hide();
				}
		
			});
		
});


// 전화번호 체크기		


	$('#phoneGet').hide();
	$('#phone').click(function(){
		if($('#phone').val() == 0){
			$('#phoneGet').show();
		}else{ //값이 있고
			if($('#phone').val().length >= 11){
				$('#phoneGet').show();
				$('#phoneGet').css("color","green"); //red -> green
			}
			
		}
		
		$('#phone').mouseout(function(){
			if($('#phone').val() == 0){
				$('#phoneGet').hide();
			}else{
				$('#phoneGet').hide();
			}
	
		});
		
});


//이메일 체크기

	
	
	$('#emailGet').hide();
	$('#emailGet1').hide();
	$('#email').click(function(){
		
		var reg =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i ;
		var result = reg.test($('#email').val());
		
		if(result == false){ //입력값이 틀렸으면 
			$('#emailGet').show(); //같지 않음
			
		}else{ //입력값이 맞으면
			$('#emailGet').hide(); 
			$('#emailGet1').show(); //맞음
		
		}
		
		$('#email').mouseout(function(){
			if($('#email').val() == 0){ //값이 없으면 
				$('#emailGet').hide();
			}else{ //값이 있으면 
				$('#emailGet1').hide();
			}
	
		});
			
		
});
	
	
//주소

	$('#findpost').hide(); //주소입력해주세요
	$('#goodAdress').hide(); //올바른 주소입니다.
	
	$('#c').click(function(){ //마우스를 올렸을 때
		
		if($('#zipcode').val().length == 0 || $('#address2').val().length ==0 ){ //우편주소가 없고 엇으면 
			$('#findpost').show();
				
		}else{ //주소와 상세주소가 있으면
			$('#findpost').hide();
			$('#goodAdress').show();
		}
		
		$('#address2').mouseout(function(){
			if($('#zipcode').val().length != 0 && $('#address2').val().length !=0 ){ //값이 있으면
				$('#goodAdress').hide();
			}else{ //값이 없으면
				$('#findpost').hide();
			}
		});
	});



				
	$('#genderGet').hide();	
	$('#genderGet1').hide();
	
	$('#radioCheck').click(function(){
		if($('input:radio[name=gender]').is(":checked")==false){
			$('#genderGet').show();
		}else{
			$('#genderGet').hide();	
			$('#genderGet1').show();
		}
	
		$('#radioCheck').mouseout(function(){
			if($('input:radio[name=gender]').is(":checked")==false){ //체크가 안되었으면
				$('#genderGet').hide();
			}else{ //값이 있으면 
				$('#genderGet1').hide();
			}
	
		});
		
		
	});
	
	


	
	$('#birth1Get').hide();	
	$('#birth2Get').hide();	
	$('#birth3Get').hide();
	
	
	$('#birthCheck').click(function(){
	
		var birth1 = myform.birth1.value ;
		if(!(birth1.length == 4)){ //값이 4가 아니면
			$('#birth1Get').show();	
		}else{
			$('#birth1Get').show();	
			$('#birth1Get').css("color","green");	
			
		}
	
	});
	
	$('#birthCheck').click(function(){
		
		// 생년월일 체크기(월)
		var birth2 = myform.birth2.value ;
		
		if(birth2 == "-"){
			$('#birth2Get').show();	
			
		}else{
			$('#birth2Get').show();	
			$('#birth2Get').css("color","green");
			
		}

	});
	
	
	$('#birthCheck').click(function(){
		
		// 생년월일 체크기(월)
		var birth3 = myform.birth3.value ;
		
		if(!(birth3.length >= 2)){
			$('#birth3Get').show();
			
		}else{
			$('#birth3Get').show();	
			$('#birth3Get').css("color","green");
		}

	});
	
	
	
	$('#birthCheck').mouseout(function(){
		if($('#birth1').val() != 0 && $('#birth2').val() != 0 && $('#birth3').val() != 0){
			$('#birth1Get').hide();	
			$('#birth2Get').hide();	
			$('#birth3Get').hide();
		}else{
			$('#birth1Get').hide();	
			$('#birth2Get').hide();	
			$('#birth3Get').hide();
		}

	});
	
	
		
				
				
});
	

	
		//우편번호찾기
		function kakaopost() {
		    new daum.Postcode({
		        oncomplete: function(data) {
		           document.querySelector("#zipcode").value = data.zonecode;
		           document.querySelector("#address1").value = data.address;
		        }
		    }).open();
		}
		
		
		function idcheck(){
			
			//중복검사
			var id = $('#id').val();
			var url = '<%=contextPath%>/employee/IdCheck.jsp?id=' + id ; //파라미터를 던져주는 이유 
			var options = 'left=750, right=500,top=50, height=100,width=400,status=yes,scollbars=yes';
			window.open(url,'check',options);
			window.resizeTo(100, 100);
			
		};
		
		function clicksave(){
	         if($('.rginput').val().length == 0 || $('.checkrad').val() == '' || $('.checkrad1').val() == 00){
	            alert('입력되지 않은 값이 존재합니다.');
	            return false;
	         }
	      }
	
	</script>
</head>
<body>
<form name="myform" action="<%=yesForm%>" method="post">
<input type="hidden" name="command" value="emInsert">
	<div class="container">
		<div class="rgform1" align="center">
			<div class="rgheader">
				<h2>회원가입</h2>
			</div>
			<p class="page_sub" ><span class="ico">*</span>필수사항입력</p>
			<table class="rgtable">
				<tr>
					<th class="rgth">아이디<span class="ico">*</span></th>
					<td class="rgtd">
						<input class="rginput" type="text" name="id" id="id"
						placeholder="3 ~ 12 이하의 영문 숫자 특수문자" value="">
						<!-- <input type="button" id="ddd" value="이거 눌러"> -->
						 <a class="btn_check" id="aaa" onclick="return idcheck();" >중복확인</a> 
						 <p class="textsize" id="idnull">아이디를 입력하세요.</p>
						 <p class="textsize"  id="idlength">아이디는 4글자이상 10글자 이하 입력하세요</p> 
					</td>
				</tr>
				
			
				
				<tr>
					<th class="rgth">비밀번호<span class="ico">*</span></th>
					<td class="rgtd">
						<input class="rginput" type="password" name="password" id="password"
						placeholder="비밀번호를 입력해주세요" value="" >
						<p class="textsize" id="pwNumber">비밀 번호는 3글자 이상 8글자 이하이어야 합니다.</p>
						<p class="textsize" id="pwUnique">특수 문자( @ # $ ! ) 중에서 반드시 1개를 사용해야 합니다.</p>
					</td>
				</tr>
				
				
				
				<tr>
					<th class="rgth">비밀번호확인<span class="ico">*</span></th>
					<td class="rgtd">
						<input class="rginput" type="password" name="passwordcheck" id="passwordcheck"
						placeholder="비밀번호를 한번 더 입력해주세요" value="">
						<p class="textsize" id="pwRecheck2">비밀 번호가 같습니다.</p>
						<p class="textsize" id="pwRecheck1">비밀 번호가 같지 않습니다.</p>
					</td>
				</tr>				
				
				<tr>
					<th class="rgth">이름<span class="ico">*</span></th>
					<td class="rgtd">
						<input class="rginput" type="text" name="name" id="name"
						placeholder="이름을 입력해주세요" value="">
						<p class="textsize" id="nameGet">이름을 입력해주세요</p>
						
					</td>
				</tr>
				<tr>
					<th class="rgth">휴대전화<span class="ico">*</span></th>
					<td class="rgtd">
						<input class="rginput" type="text" name="phone" id="phone"
						placeholder="숫자만 입력해주세요" value="">
						<p class="textsize" id="phoneGet">'010-1111-2222'형식으로 작성해주세요</p>
					</td>
				</tr>
				<tr>
					<th class="rgth">이메일<span class="ico">*</span></th>
					<td class="rgtd">
						<input class="rginput" type="text" name="email" id="email"
						placeholder="so4380@naver.com" value="">
						<p class="textsize" id="emailGet">이메일 양식이 맞지 않습니다.</p>
						<p class="textsize" id="emailGet1">이메일 양식이 맞습니다.</p>
					</td>
				</tr>
				<tr>
					<th class="rgth">주소<span class="ico">*</span></th>
					<td class="rgtd3" >
						<div id="c">
							<input class="rginput" type="text" name="zipcode" id="zipcode" placeholder="우편번호" size="7" readonly value=""> 
							<input class="btn_check rginput" type="button" value="우편번호찾기"  onclick="kakaopost();">
						</div>
						<div class="adress" align="left">
							<input class="rginput" type="text" name="address1" id="address1"  placeholder="주소" size="70" value="">
							
						</div>
						<div class="adress" align="left">
							<input class="rginput" type="text" name="address2" id="address2"  placeholder="상세 주소" size="70" value="">
						</div>
					
						<p class="textsize" id="findpost">우편번호를 검색하세요</p>
						<p class="textsize" id="goodAdress">주소가 올바르게 작성 되었습니다.</p>
						
					</td>
				</tr>

				<tr>
					<th class="rgth">성별<span class="ico">*</span></th>
					<td class="rgtd2" id="radioCheck">
						<label class="label" >
							<input type="radio" name="gender" id="gender" value="남자"><span class="text">남자</span>
						</label>
						<label class="label" >
							<input type="radio" name="gender" id="gender" value="여자"><span class="text">여자</span>
						</label>
						<label class="label" >
							<input type="radio" name="gender" id="gender" value="null" checked="checked"><span class="text">선택안함</span>
						</label>
						<p class="textsize" id="genderGet">성별을 체크해주세요</p><p class="textsize" id="genderGet1">체크 완료!</p>
					</td>
				</tr>
				<tr>
					<th class="rgth">생년월일<span class="ico">*</span></th>
					<td class="rgtd" id="birthCheck">
						<div id="birth" align="left">
							<input type="text" class="birth1 checkrad" name="birth1" placeholder="YYYY" value="">
						  	  <select class="birth1 checkrad1" id ="birth2" name="birth2">
						    	<option value="00">MM</option>
						  	</select>
						  	<input type="text" class="birth1 checkrad" name="birth3" placeholder="DD" value="">
						</div>
						
						<p class="textsize" id="birth1Get">출생년도의 입력은 숫자형식의 4자리 입니다.</p>
						<p class="textsize" id="birth2Get">출생(월)을 선택 하셔야 합니다.</p>
						<p class="textsize" id="birth3Get" >출생(일)의 입력은 2자리의 숫자입니다. 예시) 01, 02, 03, 11, 12, 13</p>
					</td>
				</tr>
			</table>
			<p class="page_sub" ></p>
			<button class="btn_register" type="submit" onclick="return clicksave();">가입하기</button> 
			
		</div>
	
	
	
	
	</div>
</form>	 	
	
	
</body>
</html>