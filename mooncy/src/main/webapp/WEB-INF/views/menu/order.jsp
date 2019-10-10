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

		<th><input type="button"  value="메인" onClick="location.href='/menu/main'"></th>
			<th><input type="button"  value="발주관리" onClick="location.href='/menu/order'"></th>
			<th><input type="button"  value="판매관리" onClick="location.href='/menu/sale'"></th>
			<th><input type="button"  value="재고관리" onClick="location.href='/store/store'"></th>


		</tr>




	</table>
발주넣는 페이지입니다.

</body>
</html>