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
	
</SCRIPT>
<div class="wrap">


	<div id = "side"><button class="button" onClick="location.href='/menu/main'"> 메인</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/order'"> 발주관리</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/sale'"> 판매관리</button></div>
 	<div id = "side"><button class="button"onClick="location.href='/store/store'"> 재고관리 </button></div>


</div>
</head>
<body>





<br><br><br>
<div class="board-container" >
<div id = "side_rigth">
<h2>발주 관리</h2>
<table border=1 width = 50%  align = "center">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>글쓴이</th>
			<th>처리여부</th>
		</tr>
		<tr>
			<td>1</td>
			<td>안녕하세요</td>
			<td>종문디</td>
			<td>X</td>
		</tr>
	</table>

	    <div id = "side_rigth_box">
			<button class="btn hover"onClick="location.href='/menu/write'"> 글쓰기 </button>
		</div>
	</div>
</div>

</body>
</html>