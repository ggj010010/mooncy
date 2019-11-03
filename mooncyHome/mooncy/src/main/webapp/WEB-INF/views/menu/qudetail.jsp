<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시글 작성</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>
    $(document).ready(function(){
        $("#btnDelete").click(function(){
            if(confirm("삭제하시겠습니까?")){
                document.form1.action = "${path}/menu/delete.do";
                document.form1.submit();
            }
        });
        
        $("#btnUpdete").click(function(){
            //var q_title = document.form1.q_title.value; ==> name속성으로 처리할 경우
            //var q_desc = document.form1.q_desc.value;
            //var m_id = document.form1.m_id.value;
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
            document.form1.action="${path}/menu/update.do"
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

<br><br><br>
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
<div class="board-container" >
<div id = "side_rigth">
<h2>게시글 보기</h2>
<form name="form1" method="post">
    <div>        <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
        작성일자 : <fmt:formatDate value="${dto.q_date}" pattern="yyyy-MM-dd a HH:mm:ss"/>
                <!-- 날짜 형식 => yyyy 4자리연도, MM 월, dd 일, a 오전/오후, HH 24시간제, hh 12시간제, mm 분, ss 초 -->
    </div>
    <div>
        처리여부 : ${dto.q_check}
    </div>
    <div>
        제목
        <input name="q_title" id="q_title" size="80" value="${dto.q_title}" placeholder="제목을 입력해주세요">
    </div>
    <div>
        내용
        <textarea name="q_desc" id="q_desc" rows="4" cols="80" placeholder="내용을 입력해주세요">${dto.q_desc}</textarea>
    </div>
    <div>
        이름
        <input name="m_id" id="m_id" value="${dto.m_id}" placeholder="이름을 입력해주세요">
    </div>
    <div style="width:650px; text-align: center;">
        <!-- 게시물번호를 hidden으로 처리 -->
        <input type="hidden" name="q_no" value="${dto.q_no}">
        <button type="button" id="btnUpdete">수정</button>
        <button type="button" id="btnDelete">삭제</button>
        </div>
    </div></div>
</form>
</body>
</html>
