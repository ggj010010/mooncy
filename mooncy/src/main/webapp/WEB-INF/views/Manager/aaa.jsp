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
<title>재고</title>
<canvas id="myChart" width="400" height="300"></canvas>                                                 
<button id="sendAjax">button</button>
<script>
var data = {
    labels: [
        "1", "2", "3", "4", "5"
    ],
    datasets: [
        {
            label: 'Your Score',
            data: [
                0, 0, 0, 0, 0
            ],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',                                                               
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }
    ]
};
var options = {
    animation: {
        animateScale: true
    },
    responsive: false,
    scales: {
        yAxes: [
            {
                ticks: {
                    beginAtZero: true                                                                    
                }
            }
        ]
    }
};
var ctx = document.getElementById("myChart").getContext('2d');                                           
var myBarChart = new Chart(ctx, {
    type: 'bar',
    data: data,
    options: options
});
var button = document.getElementById("sendAjax")

button.addEventListener("click", function() {
    sendAjax('http://localhost:8181/Manager/aaa');
})
 
function sendAjax(url) {
    var oReq = new XMLHttpRequest();
 
    oReq.open('POST', url);
    oReq.setRequestHeader('Content-Type', "application/json") // json 형태로 보낸다                         
    oReq.send();
 
    oReq.addEventListener('load', function() {
        var result = JSON.parse(oReq.responseText);
        var score = result.score;
        var comp_data = data.datasets[0].data;
 
        for (var i = 0; i < comp_data.length; i++) {
            comp_data[i] = score[i];
        }
 
        data.datasets[0].data = comp_data;
        myBarChart.update();
    })
}
app.post('/', function(req, res){
	  var responseData = {};
	 
	  var query =  connection.query('select  response_id,request_id, p_name,sum(p_count) AS p_count from ORDER_MANAGEMENT WHERE response_id=3 group by p_name,response_id,request_id', function(err,rows){ 
	    alert(val.p_count);
		  responseData.score = [];
	    if(err) throw err;
	    if(rows[0]){
	      responseData.result = "ok";
	      rows.forEach(function(val){
	        responseData.score.push(val.p_count);
	      })
	    }
	    else{
	      responseData.result = "none";
	      responseData.score = "";
	    }
	    res.json(responseData);
	  });
	});

</script>


</head>
<body>

</body>
</html>