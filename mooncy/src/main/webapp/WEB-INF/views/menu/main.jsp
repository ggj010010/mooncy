<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���</title>
<SCRIPT type="text/javascript">
	setTimeout("location.reload()", 6000)
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
</head>
<body>
	<table border=1>

		<tr>


<th><button class="btn hover" onClick="location.href='/menu/main'"> ����</button></th>
 <th><button class="btn hover"onClick="location.href='/menu/order'"> ���ְ���</button></th>
  <th><button class="btn hover"onClick="location.href='/menu/sale'"> �ǸŰ���</button></th>
   <th><button class="btn hover"onClick="location.href='/store/store'"> ������ </button></th>


		</tr>




	</table>
�����������Դϴ�.

</body>
</html>