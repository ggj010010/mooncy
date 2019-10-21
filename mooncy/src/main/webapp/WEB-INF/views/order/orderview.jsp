<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
<meta charset="EUC-KR">
<title>犁绊</title>
<SCRIPT type="text/javascript">
	
</SCRIPT>
<div class="wrap">


	<div id = "side"><button class="button" onClick="location.href='/menu/main'"> 皋牢</button></div>
	<div id = "side"><button class="button"onClick="location.href='/order/orderview'"> 惯林包府</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/sale'"> 魄概包府</button></div>
 	<div id = "side"><button class="button"onClick="location.href='/store/store'"> 犁绊包府 </button></div>


</div>
</head>
<body>





<br><br><br>
<div class="board-container" >
<div id = "side_rigth">
<h2>惯林 包府</h2>
<table >
		<tr>

			<th>ID</th>
			<th>力前疙</th>
			<th>俺荐</th>
			<th>贸府咯何</th>
			<th>朝楼</th>
		</tr>
		<tr>
			<c:forEach var="ol" items="${orderList}">
			
			<tr>

				<td>${ol.m_id }</td>
				<td>${ol.p_name }</td>
				
				<td>${ol.p_count }</td>
				<c:choose>
						<c:when test="${ol.o_check == 0}">
							<td>贸府吝</td>
						</c:when>
						<c:when test="${ol.o_check == 1}">
							<td>贸府肯丰</td>
						</c:when>
				</c:choose>
				<td>${ol.p_date }</td>
				

<!-- 				<td><input type="submit" id="updateRoom" value="荐沥"> -->


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