<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
	<script src="/resources/js/chart.js"></script>
	<script src="/resources/js/chart2.js"></script>
<meta charset="EUC-KR">
<title>���</title>
	<style>
	canvas {
		-moz-user-select: none;
		-webkit-user-select: none;
		-ms-user-select: none;
	}
	</style>



</head>
<script>
		   		var column = [''];
				var color = Chart.helpers.color;
				var barChartData = {
						labels: colorNames,
						datasets: [{
							label: '',
							backgroundColor: color('rgb(255,255,255)').alpha(0.5).rgbString(),
							data: [0,0,0,0,0,0,0,0,0,0,0,0,0,0]
						}]
				};
		   	 $j(document).ready(function(){
		   		
		
		   		var ctx = document.getElementById('canvas').getContext('2d');
		   		window.myBar = new Chart(ctx, {
					type: 'bar',
					data: barChartData,
					options: {
						responsive: true,
						legend: {
							position: 'top',
						},
						title: {
							display: true,
							text: 'Chart.js Bar Chart'
						},
						scales: { //X,Y�� �ɼ�
				            yAxes: [{
				                ticks: {
				                    beginAtZero:true  //Y���� ���� 0���� ����
				                }
				            }]
				        }
					}
				});
		   		
		   	}).on("click", "#asd", function(){
				start =  $j('#start').val();
				end = $j('#end').val();
				response_id = $j('#response_id').val();
				alert(response_id);
					$j.ajax({	
						url : "/Manager/managerpop",
						type : "GET",
						data : {
							"start" : start,
							"end" : end,
							"response_id" : response_id
						}, 
						//JSON.stringify()
						dataType : "json",
						contentType:"application/json;charset=UTF-8",
						timeout : 3000,
						success : function(returndata) {
							alert("����");
							for(var i  = 0;i< barChartData.datasets.length+1;i++){
								barChartData.datasets.pop();
								window.myBar.update();
							}
							var colorNames = Object.keys(window.chartColors);
							$j.each(returndata.managername , function(i, ival) {
								var colorName = colorNames[barChartData.datasets.length % colorNames.length];
								var dsColor = window.chartColors[colorName];
								var newDataset = {
										label: ival.request_id,
										backgroundColor: color(dsColor).alpha(0.5).rgbString(),
										borderColor: dsColor,
										borderWidth: 1,
										data: [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
									};
								$j.each(returndata.managerpop , function(j, jval) {
									if(ival.request_id == jval.request_id){
										if(jval.p_name == "����"){
											newDataset.data[0] = jval.p_count;
										}
										else if(jval.p_name == "������"){
											newDataset.data[1] = jval.p_count;
										}
										else if(jval.p_name == "�ٳ���"){
											newDataset.data[2] = jval.p_count;
										}
										else if(jval.p_name == "Ű��"){
											newDataset.data[3] = jval.p_count;
										}
										else if(jval.p_name == "���ξ���"){
											newDataset.data[4] = jval.p_count;
										}
										else if(jval.p_name == "�Ѷ��"){
											newDataset.data[5] = jval.p_count;
										}
										else if(jval.p_name == "����"){
											newDataset.data[6] = jval.p_count;
										}
										else if(jval.p_name == "�丶��"){
											newDataset.data[7] = jval.p_count;
										}
										else if(jval.p_name == "���"){
											newDataset.data[8] = jval.p_count;
										}
										else if(jval.p_name == "����"){
											newDataset.data[9] = jval.p_count;
										}
										else if(jval.p_name == "����"){
											newDataset.data[10] = jval.p_count;
										}
										else if(jval.p_name == "����"){
											newDataset.data[11] = jval.p_count;
										}
										else if(jval.p_name == "�Ѳ�"){
											newDataset.data[12] = jval.p_count;
										}
										else if(jval.p_name == "��"){
											newDataset.data[13] = jval.p_count;
										}
										
									}
								});
								barChartData.datasets.push(newDataset);
								window.myBar.update();
							});
								
							},//end success
						error : function(jqXHR, textStatus, errorThrown) {
							alert("����");

						}//end error 
					});//end ajax.productInfoWriteAction 
				});

		
		
	</script>
<body>

	<form  action="/Manager/managerpop">
        <input type="date" name="start" id="start" th:value="${start}" />
        <input type="date" name="end" id="end" th:value="${end}" />
        <select id="response_id" name="response_id" >
     			 <option value="1" selected>A</option> 
     			 <option value="2">B</option>
     			 <option value="3">C</option> 
      	</select>
        <input type="submit" value="Click" />
    </form>

	       
<table>		
	
			<tr>
              <th>����</a></th>
              <th>����</a></th>
              <th>��ǰ��</a></th>
              <th>����</a></th>
 			</tr>
	 <c:forEach var="cv" items="${managerpop}">
           <tr>
              <td>${cv.response_id}</a></td>
              <td>${cv.request_id}</a></td>
              <td>${cv.p_name}</a></td>
              <td>${cv.p_count}</a></td>
             
 			</tr>
		  </c:forEach>

		<div id="container" style="width: 50%;">
		<canvas id="canvas"></canvas></div>
		<tr>
		  	<td colspan = "4"><button id="asd" class="button" value="123"> asd</button></td></tr>
	</table>



</body>
</html>