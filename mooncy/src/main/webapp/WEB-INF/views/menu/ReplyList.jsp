<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

    <script src="/resources/js/jquery3.3.1.min.js"></script>
    <script src="/resources/js/semantic.min.js"></script>

</head>
<body>
	<table style="width:700px">
		<!-- 댓글 목록 -->
		<c:forEach var="row" items="${list}">
		<tr>	
			<td>
				${row.q_r_date }
				<br>
				${row.r_id}님-${row.q_r_desc}
				<br>
				<!-- 본인 댓글만 수정버튼 생성되도록 처리 -->
				<c:if test="${sessionScope.m.m_id == row.r_id}">
					<input type="button" id="btnModify" value="수정" onclick="showReplyModify('${row.q_r_no}')">

				</c:if>
				<hr>
			</td>
		</tr>
		</c:forEach>
		
		<!-- 페이징 -->
		<tr style="text-align: center;">
			<td>
				<!-- 현재 페이지 블럭이 1보다 크면 처음페이지로 이동 -->
				<c:if test="${replyPager.curBlock > 1}">
					<a href="javascript:listReply('1')">[처음]</a>
				</c:if>
				<!-- 현재 페이지 블럭이 1보다 크면 이전 페이지 블럭으로 이동 -->
				<c:if test="${replyPager.curBlock > 1}">
					<a href="javascript:listReply('${replyPager.prevPage}')">[이전]</a>
				</c:if>
				<!-- 페이지 블럭 처음부터 마지막 블럭까지 -->
				<c:forEach var="num" begin="${replyPager.blockBegin}" end="${replyPager.blockEnd}">
					<c:choose>
						<c:when test="${num == replyPager.curPage}">
							${num}&nbsp;
						</c:when>
						<c:otherwise>
							<a href="javascript:listReply('${num}')">${num}</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<!-- 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 다음페이지로 이동 -->
				<c:if test="${replyPager.curBlock <= replyPager.totBlock}">
					<a href="javascript:listReply('${replyPager.nextPage}')">[다음]</a>
				</c:if>
				<!-- 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 끝으로 이동 -->
				<c:if test="${replyPager.curBlock <= replyPager.totBlock}">
					<a href="javascript:listReply('${replyPager.totPage}')">[끝]</a>
				</c:if>
			</td>
		</tr>
	</table>
	
	<!-- 댓글 수정 영역-->
	<div id="modifyReply"></div>
</body>
</html>