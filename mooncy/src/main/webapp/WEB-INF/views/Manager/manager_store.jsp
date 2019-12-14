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
	setTimeout("location.reload()", 6000)
</SCRIPT>

   <h1 align = "center"><img class="btn-img" src="/resources/js/image/rogo2.png" style="width : 301px; height : 110px;"><br>
   <button  type="button" onclick="window.open('/Manager/UserInsert', '_blank', 'toolbars=no,scrollbars=no'); return false;" 
            style="float : right; border : 0; background-color : #F6F6F6";>
            	<img class="btn-img" src="/resources/js/image/image2.png"style="cursor:pointer; width : 80px; height : 80px;">
            </button></h1><br><br><br>


<div class="wrap">
<div id = "side"><button class="button" onClick="location.href='/Manager/ManagerMain'"> 메인</button></div>
   <div id = "side"><button class="button"onClick="location.href='/Manager/manager_order'"> 발주관리</button></div>
   <div id = "side"><button class="button"onClick="location.href='/menu/quview'"> 판매관리</button></div>
    <div id = "side"><button class="button"onClick="location.href='/Manager/manager_store'"> 재고관리 </button></div>
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
	<br>
	<br>
	<div class="board-container">
			<h2> &nbsp</h2>

			<table style="width: 100%;">
				<tr>
				<tr>

					<th>매장</th>
					<th>딸기</th>
					<th>오렌지</th>
					<th>바나나</th>
					<th>키위</th>
					<th>파인애플</th>
					<th>한라봉</th>
					<th>수박</th>
					<th>토마토</th>
					<th>사과</th>
					<th>망고</th>
					<th>얼음</th>
					<th>빨대</th>
					<th>뚜껑</th>
					<th>컵</th>
				</tr>

				<c:forEach var="sl" items="${storeList }">


					<tr>

						<td>${sl.m_name }</td>

						<td><c:choose>
								<c:when test="${sl.ddalgi >=20}">
									<font color="green"> ${sl.ddalgi } </font>
								</c:when>
								<c:when test="${sl.ddalgi >=11}">
									<font color="orange"> ${sl.ddalgi } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.ddalgi }</span></font>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${sl.orange >=20}">
									<font color="green"> ${sl.orange } </font>
								</c:when>
								<c:when test="${sl.orange >=11}">
									<font color="orange"> ${sl.orange } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.orange }</span></font>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${sl.banana >=20}">
									<font color="green"> ${sl.banana } </font>
								</c:when>
								<c:when test="${sl.banana >=11}">
									<font color="orange"> ${sl.banana } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.banana }</span></font>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${sl.kiwi >=20}">
									<font color="green"> ${sl.kiwi } </font>
								</c:when>
								<c:when test="${sl.kiwi >=11}">
									<font color="orange"> ${sl.kiwi } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.kiwi }</span></font>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${sl.pine >=20}">
									<font color="green"> ${sl.pine } </font>
								</c:when>
								<c:when test="${sl.pine >=11}">
									<font color="orange"> ${sl.pine } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.pine }</span></font>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${sl.hanla >=20}">
									<font color="green"> ${sl.hanla } </font>
								</c:when>
								<c:when test="${sl.hanla >=11}">
									<font color="orange"> ${sl.hanla } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.hanla }</span></font>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${sl.suback >=20}">
									<font color="green"> ${sl.suback } </font>
								</c:when>
								<c:when test="${sl.suback >=11}">
									<font color="orange"> ${sl.suback } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.suback }</span></font>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${sl.tomato >=20}">
									<font color="green"> ${sl.tomato } </font>
								</c:when>
								<c:when test="${sl.tomato >=11}">
									<font color="orange"> ${sl.tomato } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.tomato }</span></font>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${sl.apple >=20}">
									<font color="green"> ${sl.apple } </font>
								</c:when>
								<c:when test="${sl.apple >=11}">
									<font color="orange"> ${sl.apple } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.apple }</span></font>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${sl.mango >=20}">
									<font color="green"> ${sl.mango } </font>
								</c:when>
								<c:when test="${sl.mango >=11}">
									<font color="orange"> ${sl.mango } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.mango }</span></font>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${sl.ice >=80}">
									<font color="green"> ${sl.ice } </font>
								</c:when>
								<c:when test="${sl.ice >=41}">
									<font color="orange"> ${sl.ice } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.ice }</span></font>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${sl.bbalde >=80}">
									<font color="green"> ${sl.bbalde } </font>
								</c:when>
								<c:when test="${sl.bbalde >=41}">
									<font color="orange"> ${sl.bbalde } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.bbalde }</span></font>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${sl.dduggung >=80}">
									<font color="green"> ${sl.dduggung } </font>
								</c:when>
								<c:when test="${sl.dduggung >=41}">
									<font color="orange"> ${sl.dduggung } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.dduggung }</span></font>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${sl.cup >=80}">
									<font color="green"> ${sl.cup } </font>
								</c:when>
								<c:when test="${sl.cup >=41}">
									<font color="orange"> ${sl.cup } </font>
								</c:when>
								<c:otherwise>
									<font color="red"><span class="blink">${sl.cup }</span></font>
								</c:otherwise>
							</c:choose></td>

					</tr>
				</c:forEach>
			</table>
	</div>

</body>
</html>