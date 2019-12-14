<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script> -->
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
	<script src="/resources/js/chart.js"></script>
	<script src="/resources/js/chart2.js"></script>
<meta charset="EUC-KR">
<title>재고</title>



<SCRIPT>
 var p_count;
 var o_no;
 var m_id;
 $j(document).ready(function(){
	 $j(document).on("click", "#btn_manager_result", function(){
			
			var tdArr = new Array();
			
			var tr = $j("#request tbody tr");
			var td = tr.children();
			var mr_id = "0";
			var m_name = td.eq(2).text();
			var p_name = td.eq(3).text();
			/* var p_count = ${sessionScope.request_count};
			var request_id = ${sessionScope.request_id};
			var o_no = ${sessionScope.o_no};  */
			console.log("P-count : " + p_count);
			td.each(function(i) {
				tdArr.push(td.eq(i).text());
			});
			console.log("btn 배열에 담긴 값 : " + tdArr);
			$j.ajax({
				url : "/manager/manager_response",
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
					if(returndata == 4){
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
		
		$j('#request tbody tr').mouseover(function() {
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
		
		$j("#request tbody tr").click(function() {
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
						var html = "";
						alert("보내줄수 있는 재고가 없습니다.");
						
						html += "<table id='response_table'>"
						html += "<tr><th>보내줄수 있는 재고가 없습니다</th></tr>"
						html += "<tr><td><input type='button' class='btn' id='btn_manager_result' value='본사에서 보내기'></td></tr>"
						html += "</table>";
						$j("#reult_div").append(html);
					}

					
					
				},//end success
				error : function(jqXHR, textStatus, errorThrown) {
					alert("실패");
					
				}//end error 
			});//end ajax.productInfoWriteAction
			
		});
	
	});

</SCRIPT>
   <h1 align = "center"><img class="btn-img" src="/resources/js/image/rogo2.png" style="width : 301px; height : 110px;"><br>
   <button  type="button" onclick="window.open('/Manager/UserInsert', '_blank', 'toolbars=no,scrollbars=no'); return false;" 
            style="float : right; border : 0; background-color : #F6F6F6";>
            	<img class="btn-img" src="/resources/js/image/image2.png"style="cursor:pointer; width : 80px; height : 80px;">
            </button></h1><br><br><br>


<div class="wrap">
<div id = "side"><button class="button" onClick="location.href='/Manager/ManagerMain'"> 메인</button></div>
   <div id = "side"><button class="button"onClick="location.href='/Manager/manager_order'"> 발주관리</button></div>
   <div id = "side"><button class="button"onClick="location.href='/menu/quview'"> 판매관리</button></div>
    <div id = "side"><button class="button"onClick="location.href='/Manager/manager_store'"> 재고관리 </button></div>
</div>  

</head>


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
	<div class="board-container">
		<div id="side_rigth">
			<h2>발주 관리</h2>
			<table>
				
				<tr>
					<td>

						<table id="request">
							<%
								int count = 0;
							%>
							<c:forEach var="ol" items="${select_User_Order}">
								<c:if test="${ ol.o_check eq 0}">
									<%
										count++;
									%>

								</c:if>

							</c:forEach>
							<c:set var="count" value="<%=count%>" />
							<c:choose>
								<c:when test="${count == 0}">
									<thead>
										<tr>
											<th rowspan='3'>발주 내역이 없습니다</th>
										</tr>
									</thead>
								</c:when>
								<c:otherwise>
									<thead>
										<tr>
											<th>지점명</th>
											<th>제품명</th>
											<th>개수</th>
										</tr>
									</thead>
								</c:otherwise>
							</c:choose>

							<tbody>
								<c:forEach var="ol" items="${select_User_Order}">
									<c:choose>
										
										<c:when test="${ol.o_check == 0}">
											<tr id="tr">
												<td style="display: none;">${ol.o_no }</td>
												<td style="display: none;">${ol.m_id }</td>
												<td>${ol.m_name }</td>

												<td>${ol.p_name }</td>
												<td>${ol.p_count }</td>

											</tr>
										</c:when>
									</c:choose>


								</c:forEach>

							</tbody>
						</table>
					</td>
					<td>
						<div id="reult_div"></div>
					</td>
				</tr>
				<tr>
					<td>
						<h2>처리 완료</h2>
						<table style="width: 500px; height:300px;">
							<thead>
								<tr>
									<th>지점명</th>
									<th>제품명</th>
									<th>개수</th>
									<th>날짜</th>
								</tr>
							</thead>

							<c:forEach var="ol" items="${orderList}">
								<c:choose>
									<c:when test="${ol.o_check == 1}">
										<tr>
											<td style="display: none;">${ol.o_no }</td>
											<td style="display: none;">${ol.m_id }</td>
											<td>${ol.m_name }</td>
											<td>${ol.p_name }</td>
											<td>${ol.p_count }</td>
											<td>${ol.p_date }</td>
										</tr>
									</c:when>
								</c:choose>
							</c:forEach>
						</table>
						<div style="text-align: center">
							<div id="side_center">
								<div class="text-center">
									<c:if test="${totalCnt/10 > 1 }">
										<%	String pageNo2 = "1";
										 if(request.getParameter("pageNo2") != null){
												pageNo2 = request.getParameter("pageNo2");
											}
										%>
										<c:forEach var="i" begin="1" end="${(totalCnt-1)/10+1}">
											<c:choose>
												<c:when test="${pageNo==i }">
													<a href="/Manager/manager_order?pageNo=${i }&pageNo2=<%=pageNo2%>">(${i}) 
													<span class="sr-only"></span></a>
												</c:when>
												<c:otherwise>
													<a href="/Manager/manager_order?pageNo=${i }&pageNo2=<%=pageNo2%>">${i }</a>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:if>
								</div>
							</div>
						</div>
					</td>
					<td>
						<h2>발주</h2>
						<table style="width: 700px;">
							<thead>
								<tr>

									<th>받음</th>
									<th>보냄</th>
									<th>제품명</th>
									<th>개수</th>
									<th>날짜</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="om" items="${order_managementList}">
									<tr>
										<td>${om.request_name }</td>
										<td>${om.response_name }</td>
										<td>${om.p_name }</td>
										<td>${om.p_count }</td>
										<td>${om.om_date }</td>

									</tr>

								</c:forEach>

							</tbody>
						</table>
						 <div style="text-align: center">
							<div id="side_center">
								<div class="text-center">
									<c:if test="${totalCnt2/10 > 1 }">
										<%	String pageNo1 = "1";
										 if(request.getParameter("pageNo") != null){
												pageNo1 = request.getParameter("pageNo");
											}
										%>
										<c:forEach var="i" begin="1" end="${(totalCnt2-1)/10+1}">
											<c:choose>
												<c:when test="${pageNo2==i }">
														<a href="/Manager/manager_order?pageNo=<%=pageNo1%>&pageNo2=${i}">(${i})<span class="sr-only"></span></a>
												</c:when>
												<c:otherwise>
														<a href="/Manager/manager_order?pageNo=<%=pageNo1%>&pageNo2=${i}">${i}<span class="sr-only"></span></a>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:if>
								</div>
							</div>
						</div> 
					</td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>