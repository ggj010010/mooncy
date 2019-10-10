<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>재고</title>
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


<th><button class="btn hover" onClick="location.href='/menu/main'"> 메인</button></th>
 <th><button class="btn hover"onClick="location.href='/menu/order'"> 발주관리</button></th>
  <th><button class="btn hover"onClick="location.href='/menu/sale'"> 판매관리</button></th>
   <th><button class="btn hover"onClick="location.href='/store/store'"> 재고관리 </button></th>


		</tr>




	</table>
메인페이지입니다.

</body>
</html>