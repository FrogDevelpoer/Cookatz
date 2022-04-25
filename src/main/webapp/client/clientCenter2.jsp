<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./../common/common.jsp"%>

<%
	int label = 2; //양식의 lebel 너비
	int content = twelve - label; //양식의 입력(input, select, textarea) 상자의 너비
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script type="text/javascript">
	 $(document).ready(function(){
			$(".panel-heading").click(function(){
				$('.panel-body').slideToggle("fast");		
			});
		});
 </script>
<style type="text/css">
*{
    margin: 0;
    padding: 0;
}
a{
    text-decoration: none;
    color: #000000;
    font-family : 'Noto Sans KR', sans-serif;
}
body{
    /* e9f8ff */
    background-color: #f4f5f6;;
}
.container{
    width: 90%;
    margin: 0 auto;
}
.panel-question{
    margin-bottom: 20px;
    background-color: #fff;
}
.panel-heading{
    font-weight: bold;
    padding: 5px;
    background-color: #ffce32;
    color: #fff;
    cursor: pointer;
    color: black;
}
.panel-body{
    padding: 15px;
}

</style>
</head>
<body>
    
    <div class="container">  
        <h2>FAQ</h2>
        <p>제목을 누르면 내용이 보입니다.</p>
        <section>
        
            <div class="panel-question active">
                <div class="panel-heading"> 
                    Q : 쿡캣츠는 어떤 서비스를 제공하나요?   
                </div>
                <div class="panel-body" id="thisone">
                    <p>A : 요리를 잘하는 사람이나, 못하는 사람이나 모두 정보를 공유하고 얻으면서 요리에 대한
                    정보를 얻을 수 있습니다. 
                    </p>    
                </div>
            </div>

            <div class="panel-question">
                <div class="panel-heading"> 
                    Q : 게시글을 신고 하고싶습니다.   
                </div> 
                <div class="panel-body">
                    <p>A : 고객센터에 직접 문의주시면 담당자가 빠른 시일내에 처리하며
                        확인 후 삭제 및 조치를 취하겠습니다.
                    </p> 
                </div>
            </div>

            <div class="panel-question">
                <div class="panel-heading"> 
                    Q : 문의를 하고 싶은데 어떻게하면 되나요?  
                </div> 
                <div class="panel-body">
                    <p>A : 메인 페이지의 하단 아래부분에 전화(02-000-000) 및
                        이메일 ask@cookatz.com으로 문의주시면 됩니다.
                    </p> 
                </div>
            </div>

            <div class="panel-question">
                <div class="panel-heading"> 
                    Q : 회원 탈퇴를 하고싶습니다.  
                </div> 
                <div class="panel-body">
                    <p>A :마이페이지에서 회원탈퇴를 클릭하시면 됩니다.
                    </p> 
                </div>
            </div>
            <div class="panel-question">
                <div class="panel-heading"> 
                    Q : 레시피게시판에서 중복되는 요리를 올려도 되나요?
                </div> 
                <div class="panel-body">
                    <p>A : 저희 쿡캣츠의 목적은 같은 요리라도 다른 방법을 공유하고 학습하는데에 있습니다.<br>
                        같은 요리더라도 다른사람에게는 도움이 될 수 있을거라고 생각합니다.
                    </p> 
                </div>
            </div>
            
            <div class="panel-question">
                <div class="panel-heading"> 
                    Q : 오프라인에서 진행되는 요리 수강도 있나요?
                </div> 
                <div class="panel-body">
                    <p>A : 현재는 COVID-19 바이러스로 대면 클래스는 제공되지 않습니다.</p> 
                </div>
            </div>
            
            <div class="panel-question">
                <div class="panel-heading"> 
                    Q : 요리교실의 모든 컨텐츠는 모두 무료인가요?
                </div> 
                <div class="panel-body">
                    <p>A : 현재는 모두 무료입니다. 추후 변경될 수 있는 점 양해 부탁드립니다.</p> 
                </div>
            </div>
        </section>    
    </div>     
</body>
</html>