<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>재고</title>
</head>
<body>

<table border = 1>
	
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