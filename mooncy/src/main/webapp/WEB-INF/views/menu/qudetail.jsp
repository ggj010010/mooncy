<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시글 작성</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.4.min.js"></script>




<script>
	$(document).ready(function() {
		$("#btnDelete").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				document.form1.action = "${path}/menu/delete.do";
				document.form1.submit();
			}
		});

		$("#btnUpdete").click(function() {
			//var q_title = document.form1.q_title.value; ==> name속성으로 처리할 경우
			//var q_desc = document.form1.q_desc.value;
			//var m_id = document.form1.m_id.value;
			var q_title = $("#q_title").val();
			var q_desc = $("#q_desc").val();
			var m_id = $("#m_id").val();
			if (q_title == "") {
				alert("제목을 입력하세요");
				document.form1.q_title.focus();
				return;
			}
			if (q_desc == "") {
				alert("내용을 입력하세요");
				document.form1.q_desc.focus();
				return;
			}
			if (m_id == "") {
				alert("이름을 입력하세요");
				document.form1.m_id.focus();
				return;
			}
			document.form1.action = "${path}/menu/update.do"
			// 폼에 입력한 데이터를 서버로 전송
			document.form1.submit();
		});

		$("#btn_result").click(function() {

			var q_no = $
			{
				dto.q_no
			}
			;
			var r_id = $
			{
				sessionScope.m.m_id
			}
			;
			var q_r_desc = $("#q_r_desc").val();

			$.ajax({
				url : "/reply/insert",
				type : "POST",
				data : {
					"q_no" : q_no,
					"r_id" : r_id,
					"q_r_desc" : q_r_desc
				},
				//JSON.stringify()
				dataType : "json",
				//contentType:"application/json;charset=UTF-8",
				timeout : 3000,
				success : function(returndata) {
					alert("정상적으로 보내졌습니다.");
					window.location.href = "/menu/detail.do?q_no=" + $
					{
						dto.q_no
					}
					;
				},//end success
				error : function(jqXHR, textStatus, errorThrown) {
					alert("실패");

				}//end error 
			});//end ajax.productInfoWriteAction 
		});

		$(".btn_delete").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				var q_no = ${dto.q_no};
				var q_r_no = $(this).parent().children(".delete").val();

				$.ajax({
					url : "/reply/delete",
					type : "POST",
					data : {
						"q_no" : q_no,
						"q_r_no" : q_r_no,
					},
					//JSON.stringify()
					dataType : "json",
					//contentType:"application/json;charset=UTF-8",
					timeout : 3000,
					success : function(returndata) {
						alert("정상적으로 보내졌습니다.");
						window.location.href = "/menu/detail.do?q_no=" + q_no;
					},//end success
					error : function(jqXHR, textStatus, errorThrown) {
						alert("실패");

					}//end error 

				});

			}
		});

	});
</script>
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
<div class="wrap">


	<div id="side">
		<button class="button" onClick="location.href='/menu/main'">
			메인</button>
	</div>
	<div id="side">
		<button class="button" onClick="location.href='/order/orderview'">
			발주관리</button>
	</div>
	<div id="side">
		<button class="button" onClick="location.href='/menu/quview'">
			판매관리</button>
	</div>
	<div id="side">
		<button class="button" onClick="location.href='/store/store'">
			재고관리</button>
	</div>


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
	<br>
	<br>
	<br>
</head>
<body>
	<div class="board-container">
		<div id="side_rigth">
			<h2>게시글 보기</h2>
			<form name="form1" method="post">
				<div>
					<!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
					작성일자 :
					<fmt:formatDate value="${dto.q_date}"
						pattern="yyyy-MM-dd a HH:mm:ss" />
					<!-- 날짜 형식 => yyyy 4자리연도, MM 월, dd 일, a 오전/오후, HH 24시간제, hh 12시간제, mm 분, ss 초 -->
				</div>
				<div>처리여부 : ${dto.q_check}</div>
				<div>
					제목 <input name="q_title" id="q_title" size="80"
						value="${dto.q_title}" placeholder="제목을 입력해주세요">
				</div>

				<div>
					내용

					<textarea name="q_desc" id="q_desc" rows="4" cols="80"
						placeholder="내용을 입력해주세요">${dto.q_desc}</textarea>
				</div>
				<div>
					<input type="hidden" name="m_id" id="m_id" value="${dto.m_id}">
				</div>
				<div style="width: 650px; text-align: center;">
					<!-- 게시물번호를 hidden으로 처리 -->
					<input type="hidden" name="q_no" value="${dto.q_no}">
					<button type="button" id="btnUpdete">수정</button>
					<button type="button" id="btnDelete">삭제</button>
				</div>

				<div style="width: 650px; text-align: center;">
					<br>
					<!-- 로그인 한 회원에게만 댓글 작성폼이 보이게 처리 -->
					<textarea rows="2" cols="80" id="q_r_desc" placeholder="댓글을 작성해주세요"></textarea>
					<br>

					<button type="button" id="btn_result">댓글 작성</button>
				</div>
		</div>
		<!-- 댓글 작성 영역 -->
		<!-- 댓글 목록 영역 -->
		<div>
			<c:forEach var="qv" items="${dtoRep}">
				<div>
					번호 : ${qv.q_r_no} 내용 : ${qv.q_r_desc} 작성자 : ${qv.r_id} 날짜 :
					${qv.q_r_date}
					<c:if test="${sessionScope.m.m_id == '0'}">
						<button type="button" class="btn_delete">댓글 삭제</button>
						<input type="hidden" class="delete" value="${qv.q_r_no}" />


					</c:if>

				</div>
			</c:forEach>
		</div>
	</div>
	<!-- 댓글 목록 영역 -->

	</form>
</body>
</html>
