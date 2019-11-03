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


	<div id="side">
		<button class="button" onClick="location.href='/menu/main'">
			����</button>
	</div>
	<div id="side">
		<button class="button" onClick="location.href='/order/orderview'">
			���ְ���</button>
	</div>
	<div id="side">
		<button class="button" onClick="location.href='/menu/sale'">
			�ǸŰ���</button>
	</div>
	<div id="side">
		<button class="button" onClick="location.href='/store/store'">
			������</button>
	</div>


</div>
</head>
<body>
	<c:choose>

		<c:when test="${sessionScope.m.m_id != null}">
			<c:choose>

				<c:when test="${sessionScope.m.m_id == '0'}">

					<li><a>�����ڴ�</a></li>

				</c:when>
				<c:otherwise>

					<li><a>${sessionScope.m.m_id}��</a></li>

				</c:otherwise>
			</c:choose>


			<li><a href="/logout">�α׾ƿ�</a></li>

		</c:when>

	</c:choose>




	<br>
	<br>
	<br>
	<div class="board-container">
		<div id="side_rigth">
			<h2>���� ����</h2>
			<table>
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
			<div style="text-align: center">
				<div id="side_center">
					<div class="text-center">

						<c:if test="${totalCnt/5 > 1 }">




							<c:forEach var="i" begin="1" end="${(totalCnt-1)/5+1}">

								<c:choose>

									<c:when test="${pageNo==i }">

										<a href="/order/orderview?pageNo=${i }">(${i}) <span
											class="sr-only"></span></a>

									</c:when>

									<c:otherwise>

										<a href="/order/orderview?pageNo=${i }">${i }</a>

									</c:otherwise>

								</c:choose>

							</c:forEach>




						</c:if>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>