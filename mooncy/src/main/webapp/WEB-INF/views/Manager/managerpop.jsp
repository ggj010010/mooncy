<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
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
<body>

    <p th:text="${msg}">wait.</p>
<form  action="/Manager/managerpop.do">
        <input type="date" name="start" th:value="${start}" />
        <input type="date" name="end" th:value="${end}" />
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
		   		<script>

		var MONTHS = ['����', '������', '�ٳ���', 'Ű��', '���ξ���', '�Ѷ��', '����', '�丶��', '���', '����', '�󻡶���'];
		var color = Chart.helpers.color;
		var barChartData = 'asd';
		function button1_click() {
			var ctx = document.getElementById('canvas').getContext('2d');
			window.myBar = new Chart(ctx, {
				type: 'bar',
				data: {
					labels: [barChartData, '������', '�ٳ���', 'Ű��', '���ξ���', '�Ѷ��', '����', '�丶��', '���', '����', '�󻡶���'],
					datasets: [{
						label: '1',
						backgroundColor: color(window.chartColors.red).alpha(0.5).rgbString(),
						borderColor: window.chartColors.red,
						borderWidth: 1,
						data: [1,2,3,4,5,6,7,8,9,10,11
						]
					}, {
						label: '2',
						backgroundColor: color(window.chartColors.blue).alpha(0.5).rgbString(),
						borderColor: window.chartColors.blue,
						borderWidth: 1,
						data: [1,2,3,4,5,6,7,8,9,10,-11
						]
					}]
				},
				options: {
					responsive: true,
					legend: {
						position: 'top',
					},
					title: {
						display: true,
						text: '123'
					}
				}
			});
		};
	</script>
		<div id="container" style="width: 100%;">
		<canvas id="canvas"></canvas></div>
		<tr>
		  	<td colspan = "4"><button class="button" onclick="button1_click();" value="123"> asd</button></td></tr>
	</table>



</body>
</html>