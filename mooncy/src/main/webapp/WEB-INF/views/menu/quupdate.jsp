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
<!--게시글 수정삭제-->
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
		<!--댓글 수정삭제-->

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
					<table  class="type09" style = "width : 650;" border="0px";>
					<div style="width: 650px; text-align: center;">
		<tr>
		
			<form name="form1" method="post">
				<div>
					<!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
					<th style= "width : 50; float : right;">${dto.q_no}</th>
					
					<th colspan="3"><div>
					
					<input name="q_title" id="q_title" size="95"
						value="${dto.q_title}" placeholder="제목을 입력해주세요">
				</div></th><th>
					<fmt:formatDate value="${dto.q_date}"
						pattern="yyyy-MM-dd HH:mm:ss" />
					<!-- 날짜 형식 => yyyy 4자리연도, MM 월, dd 일, a 오전/오후, HH 24시간제, hh 12시간제, mm 분, ss 초 -->
				</div>
				</th>
</tr>
<tr><td colspan = "5">
				<div>
					

					<textarea name="q_desc" id="q_desc" rows="10" cols="130"
						placeholder="내용을 입력해주세요">${dto.q_desc}</textarea>
				</div></td>
				<div>
					<input type="hidden" name="m_id" id="m_id" value="${dto.m_id}">
				</div>
				<div style="width: 650px; text-align: center;">
					<!-- 게시물번호를 hidden으로 처리 -->
					<input type="hidden" name="q_no" value="${dto.q_no}">
					
				</div>
				<tr>
				<td></td><td></td><td></td>
					<td><button type="button" class="button" id="btnUpdete" style="align : right; width : 30%; height : 100%;">수정</button></td>
					<td><button type="button"  class="button" 
					onClick="location.href='${path}/menu/detail.do?q_no=${dto.q_no}'"
					style="width : 100%;height : 100%;">취소</button></td>
				</tr>

</div>
		</table>

		</div>
	</div>
					</div>
		</div>
	<!-- 댓글 목록 영역 -->

	</form>
</body>
</html>
