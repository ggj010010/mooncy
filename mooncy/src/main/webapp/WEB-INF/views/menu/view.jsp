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
<h2>Q&A �Խ���</h2>
<table  class="a">
<tr>

					<th style="text-align: left;">1</th>
					<th style="text-align: left;">�ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���</th>
					<th style="text-align: right;">2019-10-15</th>

					<th style="text-align: center;">������</th>
				</tr>
<tr height="200">
			<td colspan = 8	 style="text-align: left;">�ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���</td>
			</tr><tr>
			<th scope="cols">ó������</th><td colspan = 7>ó�� ��</td>
		</tr>



	</table>
<br>
<input name="reple" type="text" style="width:100%;" placeholder="����� �Է����ּ���."  />

	    <div id = "side_rigth_box">
			<button class="btn hover"onClick="location.href='/menu/write'"> ��۴ޱ� </button>
		</div>
	

	</div>
</div>
</body>
</body>
</html>