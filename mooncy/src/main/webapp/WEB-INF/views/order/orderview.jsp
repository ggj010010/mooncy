<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<SCRIPT type="text/javascript">
$j(document).ready(function(){
	var now = new Date();
    var today = now.getFullYear() + '-' + (now.getMonth() + 1) + '-' + now.getDate();
	$j('#startDate').val(today);
	$j('#endDate').val(today);
	
	$j('#startDate').change(function() {
		var startDate = $j(this).val();
		var endDate = $j('#endDate').val();
		if(startDate == ""){
			alert("날짜를 입력해주세요");
			var now = new Date();
		    var today = now.getFullYear() + '-' + (now.getMonth() + 1) + '-' + now.getDate();
		    //alert(today);
			$j('#startDate').val(today);
		}
		if(startDate > endDate){
			alert("종료 날짜보다 높을수 없습니다.");
			$j('#startDate').val(endDate);
		}
		else{	    
	    	$j.ajax({
				url : "/order/responseDate",
				type : "GET",
				data : {
					"startDate": startDate,
					"endDate": endDate
					}
				,
				//JSON.stringify()
				dataType : "json",
				//contentType:"application/json;charset=UTF-8",
				timeout : 3000,
				success : function(returndata) {
						//console.log(returndata.count);
						if(returndata.count == "N"){
							var html = "";
							$j("#reult_div").empty();
							var User_Group = returndata.ResponseDate_User_Group;
							var ResponseDate_Group = returndata.ResponseDate_Group;
							$j.each(User_Group , function(idx, Ugval) {
									html += "<div><p>"+Ugval.request_name+"</p>"
								$j.each(returndata.ResponseDate_Group , function(idx, Gval) {
									if(Ugval.request_name == Gval.request_name){
										html += "<pre>"+Gval.p_name+":"+Gval.p_count+"</pre>"
									}
								});
							});
							
							html += "</div>";
							$j("#reult_div").append(html); 
						} 
						else{
							var html = "";
						
							$j("#reult_div").empty();
							html += "<table id='response_date_table'>";
							html += "<tr><th>보냄</th><th>제품명</th><th>개수</th><th>날짜</th></tr>";
							
							var Date_User = returndata.ResponseDate_User;
							$j.each(Date_User , function(idx, val) {
								
								html += "<tr><td style='display: none;'>"+val.m_id+"</td>"
								html += "<td>"+val.request_name+"</td>"
								
								html += "<td>"+val.p_name+"</td>"
								html += "<td>"+val.p_count+"</td>"
								html += "<td>"+val.om_date+"</td></tr>"
								
								
								
								
							});
							html += "</table>";
							$j("#reult_div").append(html);
						}
				},//end success
				error : function(jqXHR, textStatus, errorThrown) {
				 	if(textStatus=="timeout") {

			        	alert("시간이 초과되어 데이터를 수신하지 못하였습니다.");

			        } 
				 	else {

			        	alert(jqXHR.status+jqXHR.responseText+textStatus+errorThrown+"데이터 전송에 실패했습니다. 다시 시도해 주세요");

			        } 
				
				}//end error 
			});//end ajax.productInfoWriteAction 
		}
	    
	});
	$j('#endDate').change(function() {
		var startDate = $j('#startDate').val();
		var endDate = $j(this).val();
		if(endDate == ""){
			alert("날짜를 입력해주세요");
			var now = new Date();
		    var today = now.getFullYear() + '-' + (now.getMonth() + 1) + '-' + now.getDate();
		    //alert(today);
			$j('#endDate').val(today);
		}
		if(startDate > endDate){
			alert("시작 날짜보다 작아질수 없습니다");
			$j('#endDate').val(startDate);
		}
		else{	    
	    	$j.ajax({
				url : "/order/responseDate",
				type : "GET",
				data : {
					"startDate": startDate,
					"endDate": endDate
					}
				,
				//JSON.stringify()
				dataType : "json",
				//contentType:"application/json;charset=UTF-8",
				timeout : 3000,
				success : function(returndata) {
						if(returndata.count == 'N'){
							var html = "";
							$j("#reult_div").empty();
							
							$j.each(returndata.ResponseDate_User_Group , function(idx, Ugval) {
									html += "<div><p>"+Ugval.request_name+"</p>"
								$j.each(returndata.ResponseDate_Group , function(idx, Gval) {
									if(Ugval.request_name == Gval.request_name){
										html += "<pre>"+Gval.p_name+":"+Gval.p_count+"</pre>"
									}
								});
							});
							
							html += "</div>";
							$j("#reult_div").append(html); 
						} 
						else{
							var html = "";
							
							$j("#reult_div").empty();
							html += "<table id='response_date_table'>";
							html += "<tr><th>보냄</th><th>제품명</th><th>개수</th><th>날짜</th></tr>";
							
							var Date_User = returndata.ResponseDate_User;
							$j.each(Date_User , function(idx, val) {
								
								html += "<tr><td style='display: none;'>"+val.m_id+"</td>"
								html += "<td>"+val.request_name+"</td>"
								
								html += "<td>"+val.p_name+"</td>"
								html += "<td>"+val.p_count+"</td>"
								html += "<td>"+val.om_date+"</td></tr>"
								
								
								
								
							});
							html += "</table>";
							$j("#reult_div").append(html);
						}
				},//end success
				error : function(jqXHR, textStatus, errorThrown) {
				 	if(textStatus=="timeout") {

			        	alert("시간이 초과되어 데이터를 수신하지 못하였습니다.");

			        } 
				 	else {

			        	alert("데이터 전송에 실패했습니다. 다시 시도해 주세요");

			        } 
				
				}//end error 
			});//end ajax.productInfoWriteAction 
		}
	});
});
</SCRIPT>
<head>
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
<meta charset="EUC-KR">
<title>재고</title>

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
	<div class="board-container">
		<div id="side_rigth">
					<h2>발주 관리</h2>

			<table style="width: 1600;">

				<tr>
					<td>
						<table class="type09" style="width: 800;">
							<tr>

								<th>ID</th>
								<th>제품명</th>
								<th>개수</th>
								<th>처리여부</th>
								<th>날짜</th>
							</tr>
							<tr>
								<c:forEach var="ol" items="${orderList}">

									<tr>

										<td>${ol.m_id }</td>
										<td>${ol.p_name }</td>

										<td>${ol.p_count }</td>
										<c:choose>
											<c:when test="${ol.o_check == 0}">
												<td>처리중</td>
											</c:when>
											<c:when test="${ol.o_check == 1}">
												<td>처리완료</td>
											</c:when>
										</c:choose>
										<td>${ol.p_date }</td>


										<!-- 				<td><input type="submit" id="updateRoom" value="수정"> -->


									</tr>

								</c:forEach>
							</tr>
						</table>
						<div style="text-align: center">
							<div id="side_center">
								<div class="text-center">

									<c:if test="${totalCnt/5 > 1 }">




										<c:forEach var="i" begin="1" end="${(totalCnt-1)/5+1}">

											<c:choose>

												<c:when test="${pageNo==i }">

													<a href="/order/orderview?pageNo=${i }">(${i}) <span
														class="sr-only"></span></a>

												</c:when>

												<c:otherwise>

													<a href="/order/orderview?pageNo=${i }">${i }</a>

												</c:otherwise>

											</c:choose>

										</c:forEach>

									</c:if>
								</div>
							</div>
						</div>
					</td>
					<td>

						<table style="width: 800;" border="1">
							<tr>
								<td><input id='startDate' type='date' /></td>
								<td><p>~</p></td>
								<td><input id='endDate' type='date' /></td>
							</tr>
						</table>
						<div id = "reult_div">
							<c:choose>
								<c:when test="${count <= 10}">


									<table id="response_table" style="width: 800;">
										<tr>

											<th>보냄</th>
											<th>제품명</th>
											<th>개수</th>
											<th>날짜</th>
										</tr>

										<tr>
											<c:forEach var="orl" items="${orderResponseList}">
												<tr>
													<td>${orl.request_name }</td>
													<td>${orl.p_name }</td>
													<td>${orl.p_count }</td>
													<td>${orl.om_date }</td>
												</tr>

											</c:forEach>
										</tr>
									</table>
								</c:when>

								<c:otherwise>

									<c:forEach var="user" items="${user}">
										<p>${user.request_name}</p>
										<c:forEach var="orgl" items="${orderResponseGroupList}">

											<c:if test="${orgl.request_name == user.request_name}">
												<pre>${orgl.p_name}:${orgl.p_count}</pre>
											</c:if>

										</c:forEach>
									</c:forEach>

								</c:otherwise>
							</c:choose>
						</div>
					</td>
				</tr>

			</table>
		</div>

	</div>
</body>
</html>