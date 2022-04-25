<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 등록</title>
<style type="text/css">
* {
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
	margin: 0; padding: 0;
}

.recipe_regi {
	background-color: white;
}

div {
	display: block;
}

.cont_pic2 {
	width: 250px;
	float: right;
	margin-right: 60px;
}

.cont_box .cont_tit4 {
	width: 140px;
	display: inline-block;
	font-size: 20px;
	font-weight: normal;
	vertical-align: top;
}
.cont_tit4{
	width: 140px;
	display: inline-block;
	font-size: 20px;
	font-weight: normal;
	vertical-align: top;
}
.cont_box p {
	padding: 0 0 0 2px;
	margin: 0 0 22px 0;
	line-height: 50px;
}

.cont_line input {
	display: inline-block;
}

.cont_box input {
	background-color: #f5f5f5;
	border: 1px solid #e1e1e1;
	font-size: 16px;
	padding-left: 15px;
	height: 50px;
	vertical-align: middle;
	margin-top: -1px;
}

.pad_b_25 {
	padding-bottom: 25px;
	!
	important; /* !important는 나중에 설정한 값이 적용되지 않게 함*/
}

.step_cont {
	display: inline-block;
	vertical-align: middle;
	background-color: #f5f5f5;
	border: 1px solid #e1e1e1;
	font-size: 16px;
	line-height: 25px;
}

.cont_box select {
	background-color: #f5f5f5;
	border: 1px solid #e1e1e1;
	font-size: 16px;
	padding: 8px 2px;
	margin: 0 2px 0 0;
	border-radius: 4px;
}

select {
	text-transform: none;
}

.cont_box .guide {
	font-size: 14px;
	display: inline-block;
	line-height: 1.8;
	margin-top: 6px;
	color: #999;
	padding: 0 0 0 20px;
	vertical-align: top;
}

.mag_b_15 {
	margin-bottom: 15px !important;
}

.mag_b_25 {
	margin-bottom: 15px !important;
}

.cont_box li {
	margin-bottom: 8px;
}

.cont_box ul, .cont_box li {
	list-style: none;
	margin: 0;
	padding: 0;
}

.cont_box ul {
	display: inline-block;
}

.divMaterialArea_1 {
	margin-block-start: 1em;
	margin-block-end: 1em;
	margin-inline-start: 0px;
	margin-inline-end: 0px;
	padding-inline-start: 40px;
}

.cont_box li input {
	display: inline-block;
	margin: 0 3px;
	vertical-align: midde;
}

.form-control {
	padding: 6px 12px;
	border-radius: 4px;
}

.divMaterialArea_1 li {
	display: list-item;
}

.btn_add {
	text-align: center;
}

.btn_add .btn span {
	color: #ffc300;
	font-size: 16px;
	margin-right: 4px;
}

.glyphicon {
	position: relative;
	top: 1px;
	display: inline-block;
	font-style: normal;
	font-weight: 400;
	line-height: 1;
}

.regi_btn {
	border: 1px solid #e6e7e8;
	background-color: #fff;
	text-align: center;
	padding: 35px 0 40px 0;
	border-top: none;
}
#recipe_title{
	display: inline-block;
	vertical-align: middle;
	background-color: #f5f5f5;
	border: 1px solid #e1e1e1;
	font-size: 16px;
	line-height: 25px;
	height: 50px;
	width: 610px;
	resize: none;
}
.sel{
	background-color: #f5f5f5;
	border: 1px solid #e1e1e1;
	font-size: 16px;
	padding: 8px 2px;
	margin: 0 2px 0 0;
	border-radius: 4px;
}
.pad_b_25{
	margin-top: 15px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('.addbtn').click(function() {
			$('#divMaterialArea_1').append('<li id = "limaterial_1_3"><input type = "text" name = "added_1" id = "added_1" class = "form-control" style = "width: 330px;" placeholder = "예) 추가 재료"><input type = "text" name = "material3_1" id = "material3_1" class = "form-control" style = "width: 280px;" placeholder = "예) 추가 재료"></li>');
				return false;
				});
			});
	function clicksave(){
         if($('.sel').val() == '-'){
            alert('카테고리 및 난이도는 필수 입력 요소 입니다.');
            return false;
         }
      }
</script>
</head>
<body>
	<div class="container recipe_regi">
		<form action="<%=yesForm%>" method="post"
			enctype="multipart/form-data">
			<h2>레시피 등록</h2>
			<input type="hidden" name="command" value="reInsert"> <input
				type="hidden" name="writer_id" id="writer_id"
				value="${sessionScope.loginfo.id}"> <input type="hidden"
				name="writer_name" id="writer_name"
				value="${sessionScope.loginfo.name}">
			<div class="cont_box pad_l_60">

				<!-- 사진 등록 -->

				<div id="divMainPhotoUpload" class="cont_pic2">

					<a href="javascript:void(0);"
						onclick="$('#imgUpload').trigger('click')" class="imgUploadBtn">
						<img class="browse_btn" src="<%=contextPath%>/images/pic_none4.gif"
						style="width: 250px; height: 250px; cursor: pointer;">
					</a> <input type="file" id="imgUpload" name="main_photo"
						id="main_photo" style="display: none" accept="image/*">

				</div>


			</div>



			<!-- 레시피 제목 -->
			<div class="cont_line">
				<p class="cont_tit4">레시피 제목</p>
				<input type="text" name="recipe_title" id="recipe_title"
					class="form-control" placeholder="예) 소고기 미역국" style="width: 610px;">
			</div>

			<!-- 요리 소개 -->
			<div class="cont_line pad_b_25">
				<p class="cont_tit4">요리 소개</p>
				<textarea name="cook_Info" id="cook_Info"
					class="form-control step_cont"
					placeholder="이 레시피의 탄생배경을 적어주세요. 예) 남편의 생일을 맞아 소고기 미역국을 끓여봤어요. 어머니로부터 배운 미역국 레시피를 남편의 입맛에 맞게 고안했습니다."
					style="height: 100px; width: 610px; resize: none;"></textarea>
			</div>

			<!-- 카테고리 -->
			<div>
				<p class="cont_tit4">카테고리</p>
				<select name="category" id="category" class = "sel">
					<option value="-">--카테고리를 선택하세요--</option>
					<option value="한식">한식</option>
					<option value="중식">중식</option>
					<option value="양식">양식</option>
					<option value="일식">일식</option>
					<option value="디저트">디저트</option>
				</select>
			</div>

			<!-- 카테고리 -->
			<div>
				<p class="cont_tit4">난이도</p>
				<select name="difficulty" id="difficulty" class = "sel">
					<option value="-">--카테고리를 선택하세요--</option>
					<option value="초급">초급</option>
					<option value="중급">중급</option>
					<option value="고급">고급</option>
				</select>
			</div>

			<!-- 재료 -->
			<div class="cont_box pad_l_60">

				<span class="guide mag_b_15" style="width: 100%;">재료가 남거나
					부족하지 않도록 정확한 계량 정보를 적어주세요.</span>
				<div class="mag_b_25 ui-sotrable" id="divMaterialGroupArea">
					<p class="cont_tit4">재료</p>
					<ul id="divMaterialArea_1" class="ui-sortable">
						<li id="limaterial_1_1"><input type="text" name="material1"
							id="material1" class="form-control" style="width: 330px;"
							placeholder="예) 돼지고기"> <input type="text"
							name="material1_1" id="material1_1" class="form-control"
							style="width: 280px;" placeholder="예) 300g"></li>
						<li id="limaterial_1_2"><input type="text" name="material2"
							id="material2" class="form-control" style="width: 330px;"
							placeholder="예) 양배추"> <input type="text"
							name="material2_1" id="material2_1" class="form-control"
							style="width: 280px;" placeholder="예) 1/2개"></li>
						<li id="limaterial_1_3"><input type="text" name="material3"
							id="material3" class="form-control" style="width: 330px;"
							placeholder="예) 참기름"> <input type="text"
							name="material3_1" id="material3_1" class="form-control"
							style="width: 280px;" placeholder="예) 1T"></li>
					</ul>

					<!-- 재료 추가 버튼 -->
					<div class="btn_add" style="width: 800px;">
						<button type="button" class="btn btn-default addbtn">
							<span class="glyphicon glyphicon-plus-sign"></span>추가
						</button>
					</div>
				</div>
			</div>
			<!-- 요리 단계 -->
			<div class="cont_box pad_l_60">
				<p class="cont_tit4">요리팁</p>
				<textarea class="form-control step_cont" name="cook_step"
					id="cook_step" style="height: 120px; width: 620px; resize: none;"></textarea>
			</div>

			<div class="regi_btn">
				<button type="submit" class="btn-lg btn-primary save" onclick="return clicksave();">저장</button>
				<button type="reset" class="btn-lg btn-danger">취소</button>
			</div>
			</form>
	</div>
	
</body>
</html>