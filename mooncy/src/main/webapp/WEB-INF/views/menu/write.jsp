<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
<meta charset="EUC-KR">
<title>재고</title>
<SCRIPT type="text/javascript">
	function doBlink(){
		var blink =document.all.tags("BLINK")
		for(var i=0; i<blink.length;i++)
			blink[i].style.visiblity = blink[i].style.visiblity=""?"hidden":""
	}
	function startBlink(){
		if(document.all)
			setInterval("doBlink()",800)
	}
	window.onload = startBlink;
	
</SCRIPT>

<div class="wrap">


	<div id = "side"><button class="button" onClick="location.href='/menu/main'"> 메인</button></div>
	<div id = "side"><button class="button"onClick="location.href='/order/orderview'"> 발주관리</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/sale'"> 판매관리</button></div>
 	<div id = "side"><button class="button"onClick="location.href='/store/store'"> 재고관리 </button></div>


</div>
</head>
<body>
<br><br><br>

<div class="board-container" >
<div id = "side_rigth">

<h2>게시글 작성</h2>
<form name="form1" id="form1" method="get" action="/board/insert">
	<div>
		
		<input name="b_title" id="title" style="width : 100%;" placeholder="제목을 입력해주세요">
		<br>
	</div>
	<div>
		<br>
		<textarea name="b_content" id="content" rows="4" cols="80"  style="width : 100%;" placeholder="내용을 입력해주세요"></textarea>
	</div>


			<div id = "side2"><button class ="btn hover" type="reset">취소</button></div>
		<div id = "side2"><button class ="btn hover" type="button" id="btnSave">확인</button></div>

	
</form>
</div></div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</body>
</html>