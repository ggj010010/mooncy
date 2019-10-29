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
	<div id = "side"><button class="button"onClick="location.href='/order/orderview'"> 발주관리</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/sale'"> 판매관리</button></div>
 	<div id = "side"><button class="button"onClick="location.href='/store/store'"> 재고관리 </button></div>


</div>
</head>
<body>
	<c:choose>

        		<c:when test="${sessionScope.m.m_id != null}">
				<c:choose>

        			<c:when test="${sessionScope.m.m_id == '0'}">

      		    	<li><a>관리자님</a></li>

        			</c:when>
        			<c:otherwise> 

                		<li><a>${sessionScope.m.m_id}님</a></li>

        			</c:otherwise>
 				</c:choose>
  				

        		<li><a href="/logout">로그아웃</a></li>

        		</c:when>
        	
 	</c:choose>
<br>
<div class="board-container" >
<div id = "side_rigth">

<h2>발주 관리</h2>
<table >
		<tr>
			<th>글제목</th>
			<th>글내용</th>
			<th>글쓴이</th>
		</tr>
		<tr>
			<td>안녕하세요</td>
			<td>안녕하세요</td>
			<td>종문디</td>
		</tr>
	</table>
	<h2>판매 관리</h2>
<table>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>글쓴이</th>
		</tr>
		<tr>
			<td>1</td>
			<td>안녕하세요</td>
			<td>종문디</td>
		</tr>
	</table>
</div></div>

</body>
</html>