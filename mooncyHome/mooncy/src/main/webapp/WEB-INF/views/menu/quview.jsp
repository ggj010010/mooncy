
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<q_title>게시글 목록</q_title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>
    $(document).ready(function(){
        $("#btnWrite").click(function(){
            // 페이지 주소 변경(이동)
            location.href = "/menu/write.do";
        });
    });
</script>
        <script>
        alert("${list}");
        </script>
        
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
 
</head>
<body>

<h2>게시글 목록</h2>
<button type="button" id="btnWrite">글쓰기</button>
<table border="1" width="600px">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>이름</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>
    <c:forEach var="qv" items="${list}">
    <tr>
    
        <td>${qv.q_no}</td>
        <td><a href="${path}/menu/view.do?q_no=${qv.q_no}">${qv.q_title}</a></td>
        <td>${qv.m_id}</td>
        <td>
            <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
            <fmt:formatDate value="${qv.q_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
        </td>
        <td>${qv.q_check}</td>
    </tr>    
    </c:forEach>
</table>
</body>
</html>