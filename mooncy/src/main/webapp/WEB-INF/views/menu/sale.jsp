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

   <h1 align = "center"><img class="btn-img" src="/resources/js/image/rogo2.png" style="width : 301px; height : 110px;"><br>
   <button  type="button" onclick="window.open('/Manager/UserInsert', '_blank', 'toolbars=no,scrollbars=no'); return false;" 
            style="float : right; border : 0; background-color : #F6F6F6";>
            	<img class="btn-img" src="/resources/js/image/image2.png"style="cursor:pointer; width : 80px; height : 80px;">
            </button></h1><br><br><br>


<div class="wrap">
<div id = "side"><button class="button" onClick="location.href='/menu/main'"> ����</button></div>
   <div id = "side"><button class="button"onClick="location.href='/order/orderview'"> ���ְ���</button></div>
   <div id = "side"><button class="button"onClick="location.href='/menu/quview'"> �ǸŰ���</button></div>
    <div id = "side"><button class="button"onClick="location.href='/store/store'"> ������ </button></div>
</div>  
</head>
<body>







<br><br><br>
<div class="board-container" >
<div id = "side_rigth">
<h2>�Ǹ� ����</h2>
<table  class="type09" style = "width : 650;">

		<tr>
			<th scope="cols">��ȣ</th>
			<th scope="cols">����</th>
			<th scope="cols">�ۼ���</th>
			<th scope="cols">��¥</th>
			<th scope="cols">ó������</th>
		</tr>


		<tr>
			<td>1</td>
			<td><a href="view">�ȳ��ϼ���</td>
			<td>������</td>
			<td>2019-10-15</td>
			<td>ó�� ��</td>
		</tr>
	</table>

	    <div id = "side_rigth_box">
			<button class="btn hover"onClick="location.href='/menu/write'"> �۾��� </button>
		</div>
	

	</div>
</div>
</body>
</body>
</html>