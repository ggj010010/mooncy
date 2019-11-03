<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<q_title>�Խñ� ���</q_title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>
    $(document).ready(function(){
        $("#btnWrite").click(function(){
            // ������ �ּ� ����(�̵�)
            location.href = "/menu/write.do";
        });
    });
</script>

        
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
 
</head>
<body>

<h2>�Խñ� ���</h2>
<button type="button" id="btnWrite">�۾���</button>
<table border="1" width="600px">
    <tr>
        <th>��ȣ</th>
        <th>����</th>
        <th>�̸�</th>
        <th>�ۼ���</th>
        <th>��ȸ��</th>
    </tr>
    <c:forEach var="qv" items="${list}">

    <tr>
    
        <td>${qv.q_no}</td>
        <td><a href="${path}/menu/detail.do?q_no=${qv.q_no}">${qv.q_title}</a></td>
        <td>${qv.m_id}</td>
        <td>
            <!-- ���ϴ� ��¥�������� ����ϱ� ���� fmt�±� ��� -->
            <fmt:formatDate value="${qv.q_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
        </td>
        <td>${qv.q_check}</td>
    </tr>    
    </c:forEach>
</table>
</body>
</html>