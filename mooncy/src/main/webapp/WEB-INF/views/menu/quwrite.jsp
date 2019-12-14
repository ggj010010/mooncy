<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 작성</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
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

   <h1 align = "center"><img class="btn-img" src="/resources/js/image/rogo2.png" style="width : 301px; height : 110px;"><br>
   <button  type="button" onclick="window.open('/Manager/UserInsert', '_blank', 'toolbars=no,scrollbars=no'); return false;" 
            style="float : right; border : 0; background-color : #F6F6F6";>
            	<img class="btn-img" src="/resources/js/image/image2.png"style="cursor:pointer; width : 80px; height : 80px;">
            </button></h1><br><br><br>


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
        </div>
<div class="board-container" >
<div id = "side_rigth">
<h2>게시글 작성</h2>
<form name="form1" method="post" action="/menu/insert.do">
  <table  class="type10" style = "width : 650;">
    <tr>
        <th style="width: 20%;">제목</th>
        <td colspan ="2">   <input name="q_title" id="q_title" size="100" placeholder="제목을 입력해주세요"></td>
   <tr>  <th>내용</th>
   			<td colspan ="2">   
   				<textarea name="q_desc" id="q_desc" rows="4" cols="90" placeholder="내용을 입력해주세요"></textarea>
   			</td>
   	</tr>
	<tr>
	<td>
        <td>
        	<button class="button" type="button" id="btnSave" style="width : 50%; float : right; height : 80%">확인</button>
        <td>
        	<button class="button" type="reset" style="width : 50%; height : 80%; float : center;">취소</button>
    </tr>
<input type = "hidden" name="m_id" id="m_id" value="${sessionScope.m.m_id}">
    <c:forEach var="qv" items="${list}">
    <c:set var="name" value= "${qv.m_id}"/>
    </c:forEach>
</table>
    </div></div>
</form>
</body>
</html>
