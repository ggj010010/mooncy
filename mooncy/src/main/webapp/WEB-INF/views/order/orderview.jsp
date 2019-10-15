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

			<th>ID</th>
			<th>��ǰ��</th>
			<th>����</th>
			<th>ó������</th>
			<th>��¥</th>
		</tr>
		<tr>
			<c:forEach var="ol" items="${orderList}">
			
			<tr>

				<td>${ol.m_id }</td>
				<td>${ol.p_name }</td>
				
				<td>${ol.p_count }</td>
				<c:choose>
						<c:when test="${ol.o_check == 0}">
							<td>ó����</td>
						</c:when>
						<c:when test="${ol.o_check == 1}">
							<td>ó���Ϸ�</td>
						</c:when>
				</c:choose>
				<td>${ol.p_date }</td>
				

<!-- 				<td><input type="submit" id="updateRoom" value="����"> -->


			</tr>

		</c:forEach>
		</tr>
	</table>

	   <div class="text-center">
		
		<c:if test="${totalCnt/5 > 1 }">

			<ul class="pagination">

				

				<c:forEach var="i" begin="1" end="${(totalCnt-1)/5+1}">

					<c:choose>

						<c:when test="${pageNo==i }">

							<a href="/order/orderview?pageNo=${i }">(${i}) <span class="sr-only"></span></a>

						</c:when>

						<c:otherwise>

							<a href="/order/orderview?pageNo=${i }">${i }</a>

						</c:otherwise>

					</c:choose>

				</c:forEach>


			</ul>

		</c:if>

	</div>
	</div>
	
</div>
	
</body>
</html>