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

<title>User Insert</title>
<script>
var check = 0;
$j(document).ready(function() {
}).on("click", "#btnSearch", function() {
				var m_id = $j("#m_id").val();
				if(m_id != ""){
					$j.ajax({
						url : "/UesrCheck",
						type : "GET",
						data : {
								"m_id" : m_id
							}
						, 
						//JSON.stringify()
						dataType : "json",
						//contentType:"application/json;charset=UTF-8",
						timeout : 3000,
						success : function(returndata) {
								//console.log(returndata.count)
								if(returndata == 1){
									check = 0;
									alert("중복된 아이디 입니다.");
									$j('#m_id').val('');
								}else{
									alert("사용가능한 아이디입니다.");
									check = 1; 
									alert(check);
									$j('#m_id').css('background', '#87FF93');

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
				else{
					alert("ID를 입력해주세요!")
				}
	
    	  
	
});

$j(document).ready(function() {
}).on("click", "#btnInsert", function() {
				if(check == 1){
					var m_id = $j('#m_id').val();
					var m_pw = $j('#m_pw').val();
					var m_name = $j('#m_name').val();
					alert(m_id+","+m_pw+","+m_name);
					$j.ajax({
						url : "/UesrInsert",
						type : "GET",
						data : {
								"m_id" : m_id,
								"m_pw" : m_pw,
								"m_name" : m_name
							}
						, 
						//JSON.stringify()
						dataType : "json",
						//contentType:"application/json;charset=UTF-8",
						timeout : 3000,
						success : function(returndata) {
								//console.log(returndata.count)
								if(returndata == 2){
									alert("매장이 등록되었습니다.");
									window.close();
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
				else{
					alert("중복확인을 해주세요");
				}
});
</script>
</head>
<body onresize="parent.resizeTo(680,600)" onload="parent.resizeTo(680,600)">

	<table style="width : 100%;">
	<tr>
		<th colspan="4">매장 등록</th>
	</tr>
	<tr>
		<td>ID</td>

		<td colspan="3"style ="font-size : 20px;">
		<input type="text" id="m_id" name="m_id" size="15" style="width : 30%;">
		<button id = "btnSearch" class ="button" type="button" style = "width : 50px; height : 70%">중복 검사</button> 
	</tr>
	<tr>
		<td>PW</td>
		<td colspan="3">
			<input type="text" id="m_pw" name="m_pw" size="15" style="width : 30%;">
		</td>
	</tr>
	<tr>
		<td>매장명</td>
		<td colspan="3">
			<input type="text" id="m_name" name="m_name" size="15" style="width : 30%;">
		</td>
	</tr>
	
	<tr>
		<td colspan="4"><button id = "btnInsert" class ="button" type="button" style = "width : 40%;"> 등록하기 </button></td>
	</tr>
</table>

</body>
</html>