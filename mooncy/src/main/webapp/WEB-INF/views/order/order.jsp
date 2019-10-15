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

			<th>ID</th>
			<th>제품명</th>
			<th>개수</th>
			<th>처리여부</th>
			<th>날짜</th>
		</tr>
		<tr>
			<c:forEach var="ol" items="${orderList}">
			
			<tr>

				<td>${ol.m_id }</td>
				<td>${ol.p_name }</td>
				
				<td>${ol.p_count }</td>
				<c:choose>
						<c:when test="${ol.o_check == 0}">
							<td>처리중</td>
						</c:when>
						<c:when test="${ol.o_check == 1}">
							<td>처리완료</td>
						</c:when>
				</c:choose>
				<td>${ol.p_date }</td>
				

<!-- 				<td><input type="submit" id="updateRoom" value="수정"> -->


			</tr>

		</c:forEach>
		</tr>
	</table>

	   
	</div>
</div>
	<div class="text-center">
		
		<c:if test="${totalCnt/5 > 1 }">

			<ul class="pagination">

				<li class="disabled"><a href="/order/test?pageNo=${i-1 }">이전</a></li>

				<c:forEach var="i" begin="1" end="${(totalCnt-1)/5+1}">

					<c:choose>

						<c:when test="${pageNo==i }">

							<li class="active"><a href="/order/test?pageNo=${i }">${i} <span class="sr-only">(current)</span></a></li>

						</c:when>

						<c:otherwise>

							<li><a href="/order/test?pageNo=${i }">${i }</a></li>

						</c:otherwise>

					</c:choose>

				</c:forEach>

				<li class="disabled"><a href="/order/test?pageNo=${i+1 }">다음</a></li>

			</ul>

		</c:if>

	</div>
</body>
</html>