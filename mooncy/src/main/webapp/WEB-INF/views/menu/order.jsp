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
	
</SCRIPT>
<div class="wrap">


	<div id = "side"><button class="button" onClick="location.href='/menu/main'"> ����</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/order'"> ���ְ���</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/sale'"> �ǸŰ���</button></div>
 	<div id = "side"><button class="button"onClick="location.href='/store/store'"> ������ </button></div>


</div>
</head>
<body>





<br><br><br>
<div class="board-container" >
<div id = "side_rigth">
<h2>���� ����</h2>
<table border=1 width = 50%  align = "center">
		<tr>
			<th>�۹�ȣ</th>
			<th>������</th>
			<th>�۾���</th>
			<th>ó������</th>
		</tr>
		<tr>
			<td>1</td>
			<td>�ȳ��ϼ���</td>
			<td>������</td>
			<td>X</td>
		</tr>
	</table>

	    <div id = "side_rigth_box">
			<button class="btn hover"onClick="location.href='/menu/write'"> �۾��� </button>
		</div>
	</div>
</div>

</body>
</html>