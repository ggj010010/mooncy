<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>�Խñ� ���</title>
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
 <div class="wrap">


	<div id = "side"><button class="button" onClick="location.href='/menu/main'"> ����</button></div>
	<div id = "side"><button class="button"onClick="location.href='/order/orderview'"> ���ְ���</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/quview'"> �ǸŰ���</button></div>
 	<div id = "side"><button class="button"onClick="location.href='/store/store'"> ������ </button></div>


</div>

</head>
<body>
	<c:choose>

        		<c:when test="${sessionScope.m.m_id != null}">
				<c:choose>

        			<c:when test="${sessionScope.m.m_id == '0'}">

      		    	<li><a>�����ڴ�</a></li>

        			</c:when>
        			<c:otherwise> 

                		<li><a>${sessionScope.m.m_id}��</a></li>

        			</c:otherwise>
 				</c:choose>
  				

        		<li><a href="/logout">�α׾ƿ�</a></li>

        		</c:when>
        	
 	</c:choose>
 	<br><br><br>
<div class="board-container" >
<div id = "side_rigth">
<h2>�Ǹ� ����</h2>
<table  class="type09" style = "width : 650;">
    <tr>
        <th>��ȣ</th>
        <th>����</th>
        <th>�̸�</th>
        <th>�ۼ���</th>
        <th>ó������</th>
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
   <div style="text-align:center"> 
	    <div id = "side_center">
	   <div class="text-center">
		
		<c:if test="${totalCnt/5 > 1 }">


				

				<c:forEach var="i" begin="1" end="${(totalCnt-1)/5+1}">

					<c:choose>

						<c:when test="${pageNo==i }">

							<a href="/menu/quview?pageNo=${i }">(${i}) <span class="sr-only"></span></a>

						</c:when>

						<c:otherwise>

							<a href="/menu/quview?pageNo=${i }">${i }</a>

						</c:otherwise>

					</c:choose>

				</c:forEach>




		</c:if>
		</div>
	</div>
	    </div>
	</div>
<button type="button" id="btnWrite">�۾���</button>
</div>
</div>
</body>
</html>