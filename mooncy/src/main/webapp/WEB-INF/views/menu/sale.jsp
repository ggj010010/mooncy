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

   <h1 align = "center"><img class="btn-img" src="/resources/js/image/rogo2.png" style="width : 301px; height : 110px;"><br>
   <button  type="button" onclick="window.open('/Manager/UserInsert', '_blank', 'toolbars=no,scrollbars=no'); return false;" 
            style="float : right; border : 0; background-color : #F6F6F6";>
            	<img class="btn-img" src="/resources/js/image/image2.png"style="cursor:pointer; width : 80px; height : 80px;">
            </button></h1><br><br><br>


<div class="wrap">
<div id = "side"><button class="button" onClick="location.href='/menu/main'"> 메인</button></div>
   <div id = "side"><button class="button"onClick="location.href='/order/orderview'"> 발주관리</button></div>
   <div id = "side"><button class="button"onClick="location.href='/menu/quview'"> 판매관리</button></div>
    <div id = "side"><button class="button"onClick="location.href='/store/store'"> 재고관리 </button></div>
</div>  
</head>
<body>







<br><br><br>
<div class="board-container" >
<div id = "side_rigth">
<h2>판매 관리</h2>
<table  class="type09" style = "width : 650;">

		<tr>
			<th scope="cols">번호</th>
			<th scope="cols">제목</th>
			<th scope="cols">작성자</th>
			<th scope="cols">날짜</th>
			<th scope="cols">처리여부</th>
		</tr>


		<tr>
			<td>1</td>
			<td><a href="view">안녕하세요</td>
			<td>종문디</td>
			<td>2019-10-15</td>
			<td>처리 중</td>
		</tr>
	</table>

	    <div id = "side_rigth_box">
			<button class="btn hover"onClick="location.href='/menu/write'"> 글쓰기 </button>
		</div>
	

	</div>
</div>
</body>
</body>
</html>