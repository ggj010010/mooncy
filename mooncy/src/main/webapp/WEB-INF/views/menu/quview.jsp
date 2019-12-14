<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 목록</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
<script>
    $(document).ready(function(){
        $("#btnWrite").click(function(){
            // 페이지 주소 변경(이동)
            location.href = "/menu/write.do";
        });
    });
</script>
   <h1 align = "center"><img class="btn-img" src="/resources/js/image/rogo2.png" style="width : 301px; height : 110px;"><br>
   <button  type="button" onclick="window.open('/Manager/UserInsert', '_blank', 'toolbars=no,scrollbars=no'); return false;" 
            style="float : right; border : 0; background-color : #F6F6F6";>
            	<img class="btn-img" src="/resources/js/image/image2.png"style="cursor:pointer; width : 80px; height : 80px;">
            </button></h1><br><br><br>

        

	<c:choose>
        		<c:when test="${sessionScope.m.m_id != null}">
				<c:choose>

        			<c:when test="${sessionScope.m.m_id == '0'}">
        			 <div class="wrap">
				<div id = "side"><button class="button" onClick="location.href='/Manager/ManagerMain'"> 메인</button></div>
				<div id = "side"><button class="button"onClick="location.href='/Manager/manager_order'"> 발주관리</button></div>
				<div id = "side"><button class="button"onClick="location.href='/menu/quview'"> 판매관리</button></div>
 				<div id = "side"><button class="button"onClick="location.href='/Manager/manager_store'"> 재고관리 </button></div>
 				<c:set var="idno" value= "${sessionScope.m.m_id}"/>
</div>

      		    	<li><a>관리자님</a></li>

        			</c:when>
        			<c:otherwise> 
 <div class="wrap">


	<div id = "side"><button class="button" onClick="location.href='/menu/main'"> 메인</button></div>
	<div id = "side"><button class="button"onClick="location.href='/order/orderview'"> 발주관리</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/quview'"> 판매관리</button></div>
 	<div id = "side"><button class="button"onClick="location.href='/store/store'"> 재고관리 </button></div>


</div>

                		<li><a>${sessionScope.m.m_id}님</a></li>

 				   <c:set var="idno" value= "${sessionScope.m.m_id}"/>
        			</c:otherwise>
 				</c:choose>
  				

        		<li><a href="/logout">로그아웃</a></li>

        		</c:when>
        	
 	</c:choose>
 	</head>
<body><br><br><br>
<div class="board-container" >
<div id = "side_rigth">
<h2>판매 관리</h2>
<table  class="type09" style = "width : 650;">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>이름</th>
        <th>작성일</th>
        <th>처리여부</th>
    </tr>
    <c:forEach var="qv" items="${list}">

    <tr>
    <c:set var="name" value= "${qv.m_id}"/>
   

<c:choose>



    <c:when test="${idno== '0'}">

        <td>${qv.q_no}</td>
        <td><a href="${path}/menu/detail.do?q_no=${qv.q_no}">${qv.q_title}</a></td>
        <td>${qv.m_id}</td>
        <td>
            <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
            <fmt:formatDate value="${qv.q_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
        </td>
        <td>${qv.q_check}</td>
    </tr>     

    </c:when>


    <c:when test="${name== idno}">
        <td>${qv.q_no}</td>
        <td><a href="${path}/menu/detail.do?q_no=${qv.q_no}">${qv.q_title}</a></td>
        <td>${qv.m_id}</td>
        <td>
            <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
            <fmt:formatDate value="${qv.q_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
        </td>
        <td>${qv.q_check}</td>
    </tr>      

    </c:when>


</c:choose>


    </c:forEach>
    
    
</table>
<button type="button" id="btnWrite" class="button" style="width : 15%; height : 100%; float : right;">글쓰기</button>
</div>
</div>
</body>
</html>