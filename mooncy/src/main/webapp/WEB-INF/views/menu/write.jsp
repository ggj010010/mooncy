<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
<meta charset="EUC-KR">
<title>���</title>
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


	<div id = "side"><button class="button" onClick="location.href='/menu/main'"> ����</button></div>
	<div id = "side"><button class="button"onClick="location.href='/order/orderview'"> ���ְ���</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/sale'"> �ǸŰ���</button></div>
 	<div id = "side"><button class="button"onClick="location.href='/store/store'"> ������ </button></div>


</div>
</head>
<body>
<br><br><br>

<div class="board-container" >
<div id = "side_rigth">

<h2>�Խñ� �ۼ�</h2>
<form name="form1" id="form1" method="get" action="/board/insert">
	<div>
		
		<input name="b_title" id="title" style="width : 100%;" placeholder="������ �Է����ּ���">
		<br>
	</div>
	<div>
		<br>
		<textarea name="b_content" id="content" rows="4" cols="80"  style="width : 100%;" placeholder="������ �Է����ּ���"></textarea>
	</div>


			<div id = "side2"><button class ="btn hover" type="reset">���</button></div>
		<div id = "side2"><button class ="btn hover" type="button" id="btnSave">Ȯ��</button></div>

	
</form>
</div></div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</body>
</html>