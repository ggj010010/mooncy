<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script type="text/javascript">
	$(document)
			.ready(
					function() {


						/* --------------- 댓글 관련 -------------- */
						// 1. 댓글 입력
						$("#btnReply")
								.click(
										function() {
											var replytext = $("#replytext")
													.val();
											//var writer = $(#writer").val();
											if (replytext == "") {
												alert("댓글을 입력하세요");
												document.form1.title.focus();

											} else {
												reply(); // 폼데이터 형식으로 입력
												location.href = "/menu/quview?q_no=${quVO.q_no}&curPage=${curPage}&searchOption=${searchOption}&keyword=${keyword}";
											}
										});

						// 2. 댓글 목록
						listReply("1"); // 댓글 목록 불러오기
						//listReply2(); // json 리턴방식
						/* listReplyRest("1"); // rest방식 */

					});

	/* --------------- 댓글 관련 -------------- */

	// 1_1. 댓글 입력 함수(폼 데이터 방식)
	function reply() {

		var json = {

			replytext : $("#replytext").val(),
			bno : "${dto.m_id}",
			// 비밀댓글 체크여부
		// 태그.is(":속성") 체크여부 true/false

		};
		// 비밀댓글 파라미터 추가
		//var param="replytext="+replytext+"&bno="+bno+"&secretReply="+secretReply;

		listReply("1");
	}



	// 2_1. 댓글 목록 - 전통적인 Controller방식
	function listReply(num) {
		$.ajax({
			type : "get",
			url : "${path}/reply/list?bno=${dto.q_no}&curPage=" + num,
			success : function(result) {
				// responseText가 result에 저장됨.
				$("#listReply").html(result);
			}
		});
	}

	// 2_2. 댓글 목록 - RestController를 이용 json형식으로 리턴
	function listReply2() {
		$.ajax({
			type : "get",
			//contentType: "application/json", ==> 생략가능(RestController이기때문에 가능)
			url : "${path}/reply/listJson?bno=${dto.q_no}",
			success : function(result) {
				console.log(result);
				var output = "<table>";
				for ( var i in result) {
					output += "<tr>";
					output += "<td>" + result[i].userName;
					output += "(" + changeDate(result[i].b_date) + ")<br>";
					output += result[i].replytext + "</td>";
					output += "<tr>";
				}
				output += "</table>";
				$("#listReply").html(output);
			}
		});
	}
	// 2_2. 댓글 목록 - 날짜 형식 변환 함수 작성
	function changeDate(date) {
		date = new Date(parseInt(date));
		year = date.getFullYear();
		month = date.getMonth();
		day = date.getDate();
		hour = date.getHours();
		minute = date.getMinutes();
		second = date.getSeconds();
		strDate = year + "-" + month + "-" + day + " " + hour + ":" + minute
				+ ":" + second;
		return strDate;
	}


	// 댓글 수정화면 생성 함수
	function showReplyModify(rno) {
		$.ajax({
			type : "get",
			url : "${path}/reply/detail/" + rno,
			success : function(result) {
				$("#modifyReply").html(result);
				// 태그.css("속성", "값")
				$("#modifyReply").css("visibility", "visible");
			}
		})
	}
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
    
    	<div style="width: 650px; text-align: center;">
				<br>
				<!-- 로그인 한 회원에게만 댓글 작성폼이 보이게 처리 -->
				<c:if test="${sessionScope.m.m_id != null}">
					<textarea rows="2" cols="80" id="replytext"
						placeholder="댓글을 작성해주세요"></textarea>
					<br>
					
					<button type="button" id="btnReply">댓글 작성</button>

				</c:if>
			</div>
			<!-- 댓글 작성 영역 -->
	<!-- 댓글 목록 영역 -->

	<div id="listReply"></div>
	<!-- 댓글 목록 영역 -->
    
</form>
</body>
</html>
