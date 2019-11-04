<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
<meta charset="EUC-KR">
<title>재고</title>
<SCRIPT>
 var p_count;
 var o_no;
 var m_id;
 $j(document).ready(function(){
		$j(document).on("click", "#btn_result", function(){
			
			var tdArr = new Array();
			
			var tr = $j(this).parent().parent();
			var td = tr.children();
			var mr_id = td.eq(0).text();
			var m_name = td.eq(1).text();
			var p_name = td.eq(2).text();
			
			/* var p_count = ${sessionScope.request_count};
			var request_id = ${sessionScope.request_id};
			var o_no = ${sessionScope.o_no};  */
			console.log("P-count : " + p_count);
			td.each(function(i) {
				tdArr.push(td.eq(i).text());
			});
			console.log("btn 배열에 담긴 값 : " + tdArr);
			$j.ajax({
				url : "/manager/response",
				type : "POST",
				data : {
					"m_id": mr_id,
					"p_name": p_name,
					"p_count": p_count,
					"request_id" : m_id,
					"o_no" : o_no
					}
				,
				//JSON.stringify()
				dataType : "json",
				//contentType:"application/json;charset=UTF-8",
				timeout : 3000,
				success : function(returndata) {
					if(returndata == 3){
						alert("정상적으로 보내졌습니다.");
						window.location.href = "/Manager/manager_order";
					}
					

					
				},//end success
				error : function(jqXHR, textStatus, errorThrown) {
					alert("실패");
					
				}//end error 
			});//end ajax.productInfoWriteAction 
			});
		});
	$j(document).ready(function(){
		// tr 태그에 마우스를 올릴때
		
		$j('table tbody tr').mouseover(function() {
			$j(this).children().css({
				'backgroundColor' : '#DCDCDC',
				'cursor' : 'pointer'
			});
		}).mouseout(function() {
			$j(this).children().css({
				'backgroundColor' : '#FFFFFF',
				'cursor' : 'default'
			});
		});
		
		$j("#request tr").click(function() {
			$j(this).children().css({
				//'color' : 'red'

			});
			var str = ""
			var tdArr = new Array(); // 배열 선언

			// 현재 클릭된 Row(<tr>)
			var tr = $j(this);
			var td = tr.children();

			// tr.text()는 클릭된 Row 즉 tr에 있는 모든 값을 가져온다.
			//console.log("클릭한 Row의 모든 데이터 : " + tr.text());

			// 반복문을 이용해서 배열에 값을 담아 사용할 수 도 있다.
			td.each(function(i) {
				tdArr.push(td.eq(i).text());
			});

			console.log("배열에 담긴 값 : " + tdArr);

			// td.eq(index)를 통해 값을 가져올 수도 있다.
			a = td.eq(0).text();
			o_no = td.eq(0).text();
			m_id = td.eq(1).text();
			var p_name = td.eq(3).text();
			p_count = td.eq(4).text();
			
			
			
			//"m_id="+m_id+"&p_name="+p_name+"&p_count="+p_count
			
			$j.ajax({
				url : "/manager/request",
				type : "POST",
				data : {
					"m_id": m_id,
					"p_name": p_name,
					"p_count": p_count,
					"o_no": o_no
					}
				,
				//JSON.stringify()
				dataType : "json",
				//contentType:"application/json;charset=UTF-8",
				timeout : 3000,
				success : function(returndata) {
					
					//하위 주소로 이동
					//이동시 보고있던 화면에 insert추가후 뿌려줌
					var list = returndata;
					//alert("성공");
					var html = "";
					$j("#reult_div").empty();
					html += "<table id='response_table'>";

					html += "<tr><th>지점</th><th>제품명</th><th>개수</th><th>&nbsp</th></tr>"
					if(list != 0){
					$j.each(list , function(idx, val) {
						
						html += "<tr><td style='display: none;'>"+val.m_id+"</td>"
						html += "<td>"+val.m_name+"</td>"
						
						html += "<td>"+p_name+"</td>"
						 if(val.ddalgi != 0){
							html += "<td>"+val.ddalgi+"</td>"
						}
						else if(val.tomato != 0){
							html += "<td>"+val.tomato+"</td>"
						}
						else if(val.apple != 0){
							html += "<td>"+val.apple+"</td>"
						}
						else if(val.kiwi != 0){
							html += "<td>"+val.kiwi+"</td>"
						}
						else if(val.hanla != 0){
							html += "<td>"+val.hanla+"</td>"
						}
						else if(val.orange != 0){
							html += "<td>"+val.orange+"</td>"
						}
						else if(val.suback != 0){
							html += "<td>"+val.suback+"</td>"
						}
						else if(val.banana != 0){
							html += "<td>"+val.banana+"</td>"
						}
						else if(val.pine != 0){
							html += "<td>"+val.pine+"</td>"
						}
						else if(val.mango != 0){
							html += "<td>"+val.mango+"</td>"
						}
						else if(val.ice != 0){
							html += "<td>"+val.ice+"</td>"
						}
						else if(val.dduggung != 0){
							html += "<td>"+val.dduggung+"</td>"
						}
						else if(val.bbalde != 0){
							html += "<td>"+val.bbalde+"</td>"
						}
						else if(val.cup != 0){
							html += "<td>"+val.cup+"</td>"
						}
						
						
						html += "<td><input type='button' id='btn_result' class='btn' value='보내기'></td></tr>"
						
						

					});
					html += "</table>";
					$j("#reult_div").append(html);
					
					}
					else{
						alert("보내줄수 있는 재고가 없습니다.")
					}

					
					
				},//end success
				error : function(jqXHR, textStatus, errorThrown) {
					alert("실패");
					
				}//end error 
			});//end ajax.productInfoWriteAction
			
		});
	
	});
	
</SCRIPT>
</head>
<body>


	<div class="wrap">


<div id = "side"><button class="button" onClick="location.href='/Manager/ManagerMain'"> 메인</button></div>
	<div id = "side"><button class="button"onClick="location.href='/Manager/manager_order'"> 발주관리</button></div>
	<div id = "side"><button class="button"onClick="location.href='/Manager/ManagerMain'"> 판매관리</button></div>
 	<div id = "side"><button class="button"onClick="location.href='/Manager/manager_store'"> 재고관리 </button></div>


	</div>


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
	<div class="board-container">
		<div id="side_rigth">
			<h2>발주 관리</h2>


			<table id="request">
				<thead>
					<tr>

						<th>지점명</th>
						<th>제품명</th>
						<th>개수</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="ol" items="${orderList}">

						<tr id="tr">
							<td style="display: none;">${ol.o_no }</td>
							<td style="display: none;">${ol.m_id }</td>
							<td>${ol.m_name }</td>
							<td>${ol.p_name }</td>
							<td>${ol.p_count }</td>

						</tr>

					</c:forEach>

				</tbody>
			</table>
			
			<div id="reult_div">
				 <!-- <table id="response_table">
					<tr>

						<th>ID</th>
						<th>제품명</th>
						<th>개수</th>
					</tr>
					
				</table> -->
			</div>
				<div style="text-align: center">
					<div id="side_center">
						<div class="text-center"></div>
					</div>
				</div>
		</div>

	</div>

</body>
</html>