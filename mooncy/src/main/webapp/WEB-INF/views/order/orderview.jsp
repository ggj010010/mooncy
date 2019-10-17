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





<br><br><br>
<div class="board-container" >
<div id = "side_rigth">
<h2>발주 관리</h2>
<table >
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
 	    <div style="text-align:center"> 
	    <div id = "side_center">
	   <div class="text-center">
		
		<c:if test="${totalCnt/5 > 1 }">


				

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




		</c:if>
		</div>
	</div>
	    </div>
	</div>
	
</div>
	
</body>
</html>