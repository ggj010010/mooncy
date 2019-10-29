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
	$(document).ready(function() {
		$('#radio').click(function() {
			// getter
			/* var radioVal = $('input[name="chk_info"]:checked').val(); */
			var mailTp = $(':radio[id="chk_info"]:checked').val();

			alert(mailTp);
		});

	});
</SCRIPT>
</head>
<body>


	<div class="wrap">


		<div id="side">
			<button class="button" onClick="location.href='/Manager/ManagerMain'">
				메인</button>
		</div>
		<div id="side">
			<button class="button" onClick="location.href='/order/orderview'">
				발주목록</button>
		</div>
		<div id="side">
			<button class="button"
				onClick="location.href='/Manager/manager_order'">발주관리</button>
		</div>
		<div id="side">
			<button class="button" onClick="location.href='/menu/sale'">
				판매관리</button>
		</div>
		<div id="side">
			<button class="button" onClick="location.href='/store/store'">
				재고관리</button>
		</div>


	</div>


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
	<br>
	<br>
	<div class="board-container">
		<div id="side_rigth">
			<h2>발주 관리</h2>
			<table>
				<tr>
					<td>

						<table>
							<tr>
								<th>&nbsp</th>
								<th>지점명</th>
								<th>제품명</th>
								<th>개수</th>
							</tr>
							<tr>
								<c:forEach var="ol" items="${orderList}">

									<tr>
										<td><input type="radio" name="chk_info" value="${ol.p_name }"></td>
										<td>${ol.m_name }</td>
										<td>${ol.p_name }</td>

										<td>${ol.p_count }</td>

									</tr>

								</c:forEach>
							</tr>
						</table>
					</td>
					<td>
						<table>
							<tr>

								<th>ID</th>
								<th>제품명</th>
								<th>개수</th>
							</tr>
							<tr>
								<c:forEach var="ol" items="${orderList}">

									<tr>

										<td>${ol.m_id }</td>
										<td>${ol.p_name }</td>

										<td>${ol.p_count }</td>

									</tr>

								</c:forEach>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div style="text-align: center">
				<div id="side_center">
					<div class="text-center"></div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>