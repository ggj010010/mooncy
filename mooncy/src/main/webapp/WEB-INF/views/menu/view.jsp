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
<h2>Q&A 게시판</h2>
<table  class="a">
<tr>

					<th>1&nbsp&nbsp</th>
					<th>안녕하세요&nbsp&nbsp</th>
					<th>2019-10-15 &nbsp&nbsp</th>

					<th>종문디</th>
				</tr>
		<tr height="20" >
		<th  scope="cols">번호</th><td>1</td>

			<th scope="cols">제목</th><td>안녕하세요</td>
			</tr><tr>
			<th scope="cols">작성자</th><td>종문디</td>
			<th scope="cols">날짜</th><td>2019-10-15</td>
			
			</tr><tr height="200" >
			<th scope="cols">내용</th><td colspan = 7>안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요</td>
			</tr><tr>
			<th scope="cols">처리여부</th><td colspan = 7>처리 중</td>
		</tr>



	</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr><!-- BOARD TITLE -->
				<td colspan="2" align="center"><h2>JSP_BOARD VIEW</h2></td>
			</tr>
			
			<tr height="40"><!-- BOARD CONTENTS -->
				<th>SUBJECT</th>
				<td>asd</td>
			</tr>
			
			<tr height="200">
				<th>CONTENT</th>
				<td valign="top" style="border: 1px solid #000">asd</td>
			</tr>
			
			<tr height="40">
				<th>첨부파일</th>
				<td>

				</td>
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