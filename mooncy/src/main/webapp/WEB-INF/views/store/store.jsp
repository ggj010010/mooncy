<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���</title>
<SCRIPT type="text/javascript">
	setTimeout("location.reload()", 6000)
	function doBlink(){
		var blink =document.all.tags("BLINK")
		for(var i=0; i<blink.length;i++)
			blink[i].style.visiblity = blink[i].style.visiblity=""?"hidden":""
	}
	function startBlink(){
		if(document.all)
			setInterval("doBlink()",800)
	}
	window.onload = startBlink;
	
</SCRIPT>
</head>
<body>

	<table border=1>

		<tr>

			<th>����</th>
			<th>����</th>
			<th>������</th>
			<th>�ٳ���</th>
			<th>Ű��</th>
			<th>���ξ���</th>
			<th>�Ѷ��</th>
			<th>����</th>
			<th>�丶��</th>
			<th>���</th>
			<th>����</th>
			<th>����</th>
			<th>����</th>
			<th>�Ѳ�</th>
			<th>��</th>
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
							<font color="red"><blink><b>${sl.ddalgi }</b></blink></font>
						</c:otherwise>
					</c:choose></td>
				<td>
				<font color="blue"> <c:if test="${sl.orange >=0}">
				${sl.orange }
				</c:if></font>
				</td>

				<td>${sl.banana }</td>
				<td>${sl.kiwi }</td>

				<td>${sl.pine }</td>
				<td>${sl.hanla }</td>
				<td>${sl.suback }</td>
				<td>${sl.tomato }</td>
				<td>${sl.apple }</td>

				<td>${sl.mango }</td>
				<td>${sl.ice }</td>
				<td>${sl.bbalde }</td>
				<td>${sl.dduggung }</td>
				<td>${sl.cup }</td>
			</tr>
		</c:forEach>


	</table>


</body>
</html>