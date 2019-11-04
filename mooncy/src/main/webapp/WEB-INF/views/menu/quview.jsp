<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 목록</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>
    $(document).ready(function(){
        $("#btnWrite").click(function(){
            // 페이지 주소 변경(이동)
            location.href = "/menu/write.do";
        });
    });
</script>

        
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
 <div class="wrap">


	<div id = "side"><button class="button" onClick="location.href='/menu/main'"> 메인</button></div>
	<div id = "side"><button class="button"onClick="location.href='/order/orderview'"> 발주관리</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/quview'"> 판매관리</button></div>
 	<div id = "side"><button class="button"onClick="location.href='/store/store'"> 재고관리 </button></div>


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
 	<br><br><br>
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
    
        <td>${qv.q_no}</td>
        <td><a href="${path}/menu/detail.do?q_no=${qv.q_no}">${qv.q_title}</a></td>
        <td>${qv.m_id}</td>
        <td>
            <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
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
<button type="button" id="btnWrite">글쓰기</button>
</div>
</div>
</body>
</html>