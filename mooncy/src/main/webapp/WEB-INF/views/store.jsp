<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���</title>
</head>
<body>

<table border = 1>
	
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
				<td>${sl.ddalgi }</td>
				<td>${sl.orange }</td>
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