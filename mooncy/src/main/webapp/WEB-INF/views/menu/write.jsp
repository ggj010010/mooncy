<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 작성</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>
    $(document).ready(function(){
        $("#btnSave").click(function(){
            var q_title = $("#q_title").val();
            var q_desc = $("#q_desc").val();
            var m_id = $("#m_id").val();
            if(q_title == ""){
                alert("제목을 입력하세요");
                document.form1.q_title.focus();
                return;
            }
            if(q_desc == ""){
                alert("내용을 입력하세요");
                document.form1.q_desc.focus();
                return;
            }
            if(m_id == ""){
                alert("이름을 입력하세요");
                document.form1.m_id.focus();
                return;
            }
            // 폼에 입력한 데이터를 서버로 전송
            document.form1.submit();
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
</head>
<body>

<br><br><br>
<div class="board-container" >
<div id = "side_rigth">
<h2>게시글 작성</h2>
<form name="form1" method="post" action="/menu/insert.do">
    <div>
        제목
        <input name="q_title" id="q_title" size="80" placeholder="제목을 입력해주세요">
    </div>
    <div>
        내용
        <textarea name="q_desc" id="q_desc" rows="4" cols="80" placeholder="내용을 입력해주세요"></textarea>
    </div>
    <div>
        id : 
        
 		<c:set var="idno" value= "${sessionScope.m.m_id}"/>
        <input name="m_id" id="m_id" type="text" readonly value="${idno}">
    </div>
    <div style="width:650px; text-align: center;">
        <button type="button" id="btnSave">확인</button>
        <button type="reset">취소</button></div>
    </div></div>
</form>
</body>
</html>
