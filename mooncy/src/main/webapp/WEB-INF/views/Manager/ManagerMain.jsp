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
<title>Insert title here</title>
   <style>
   canvas {
      -moz-user-select: none;
      -webkit-user-select: none;
      -ms-user-select: none;
   }
   canvas2 {
      -moz-user-select: none;
      -webkit-user-select: none;
      -ms-user-select: none;
   }
   </style>
<script>
var colorNames2 = [
   '����',
   '������',
   '�ٳ���',
   'Ű��',
   '���ξ���',
   '�Ѷ��',
   '����',
   '�丶��',
   '���',
   '����'
   
];
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
            var barChartData2 = {
                  labels: colorNames2,
                  datasets: [{
                     label: '',
                     backgroundColor: color('rgb(255,255,255)').alpha(0.5).rgbString(),
                     data: [0,0,0,0,0,0,0,0,0,0]
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
               
               var ctx2 = document.getElementById('canvas1').getContext('2d');
               window.myBar2 = new Chart(ctx2, {
               type: 'bar',
               data: barChartData2,
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
            if(start==""){
               start="0001-01-01";
            }
            end = $j('#end').val();
            if(end==""){
               end="9999-12-30";
            }
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
            })
            
            .on("click", "#search", function(){
               start =  $j('#start2').val();
               if(start==""){
                  start="0001-01-01";
               }
               end = $j('#end2').val();
               if(end==""){
                  end="9999-12-30";
               }
               m_id = $j('#m_id').val();
               alert(response_id);
                  $j.ajax({   
                     url : "/Manager/search",
                     type : "GET",
                     data : {
                        "start" : start,
                        "end" : end,
                        "m_id" : m_id
                     }, 
                     //JSON.stringify()
                     dataType : "json",
                     contentType:"application/json;charset=UTF-8",
                     timeout : 3000,
                     success : function(returndata) {
                        alert("����");
                        for(var i  = 0;i< barChartData2.datasets.length+1;i++){
                           barChartData2.datasets.pop();
                           window.myBar2.update();
                        }
                        var colorNames = Object.keys(window.chartColors);
                           var colorName = colorNames[barChartData2.datasets.length % colorNames.length];
                           var dsColor = window.chartColors[colorName];
                           var newDataset = {
                                 label: $j('#m_id option:selected').text(),
                                 backgroundColor: color(dsColor).alpha(0.5).rgbString(),
                                 borderColor: dsColor,
                                 borderWidth: 1,
                                 data: [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
                              };
                           $j.each(returndata.selectSale , function(j, jval) {
                                 if(jval.p_name == "����"){
                                    newDataset.data[0] = jval.p_money;
                                 }
                                 else if(jval.p_name == "������"){
                                    newDataset.data[1] = jval.p_money;
                                 }
                                 else if(jval.p_name == "�ٳ���"){
                                    newDataset.data[2] = jval.p_money;
                                 }
                                 else if(jval.p_name == "Ű��"){
                                    newDataset.data[3] = jval.p_money;
                                 }
                                 else if(jval.p_name == "���ξ���"){
                                    newDataset.data[4] = jval.p_money;
                                 }
                                 else if(jval.p_name == "�Ѷ��"){
                                    newDataset.data[5] = jval.p_money;
                                 }
                                 else if(jval.p_name == "����"){
                                    newDataset.data[6] = jval.p_money;
                                 }
                                 else if(jval.p_name == "�丶��"){
                                    newDataset.data[7] = jval.p_money;
                                 }
                                 else if(jval.p_name == "���"){
                                    newDataset.data[8] = jval.p_money;
                                 }
                                 else if(jval.p_name == "����"){
                                    newDataset.data[9] = jval.p_money;
                                 }
                                 
                           });
                           barChartData2.datasets.push(newDataset);
                           window.myBar2.update();
                           
                        },//end success
                     error : function(jqXHR, textStatus, errorThrown) {
                        alert("����");

                     }//end error 
                  });//end ajax.productInfoWriteAction 
               });

      
      
   </script>
   <h1 align = "center"><img class="btn-img" src="/resources/js/image/rogo2.png" style="width : 301px; height : 110px;"><br>
   <button  type="button" onclick="window.open('/Manager/UserInsert', '_blank', 'toolbars=no,scrollbars=no'); return false;" 
            style="float : right; border : 0; background-color : #F6F6F6;">
            	<img class="btn-img" src="/resources/js/image/image2.png"style="cursor:pointer; width : 80px; height : 80px;">
            </button></h1><br><br><br>


<div class="wrap">
<div id = "side"><button class="button" onClick="location.href='/Manager/ManagerMain'"> ����</button></div>
   <div id = "side"><button class="button"onClick="location.href='/Manager/manager_order'"> ���ְ���</button></div>
   <div id = "side"><button class="button"onClick="location.href='/menu/quview'"> �ǸŰ���</button></div>
    <div id = "side"><button class="button"onClick="location.href='/Manager/manager_store'"> ������ </button></div>
</div>  

</head>
<body>     
	<c:choose>

        		<c:when test="${sessionScope.m.m_id != null}">
				<c:choose>

        			<c:when test="${sessionScope.m.m_id == '0'}">

      		    	<li><a>�����ڴ�</a></li>

        			</c:when>
        			<c:otherwise> 

                		<li><a>${sessionScope.m.m_id}��</a></li>

        			</c:otherwise>
 				</c:choose>
  				

        		<li><a href="/logout">�α׾ƿ�</a></li>

        		</c:when>
        	
 	</c:choose>
<br><br><br>
<div style="width : 48%; float : left;">
<h2 style="text-align : center;">�ԡ���� ����</h2>
      <form action="/Manager/managerpop">
      <table style="width : 100%;">
         <tr><th><input type="date" name="start" id="start" th:value="${start}" /> 
         <input type="date" name="end" id="end" th:value="${end}" /> 
         <select id="response_id" name="response_id">

            <c:forEach var="sc" items="${selectCustomer}">
               <c:if test="${sc.m_id != 0}">
                  <option value="${sc.m_id}">${sc.m_name}</option>
               </c:if>
            </c:forEach>
         </select></th>
         


            <tr>
               <td>
                     <canvas id="canvas"></canvas>
                  </td>
            </tr>
         </table>
         
      </form>
               <button id="asd" class="button" value="123">�˻�</button>
   </div>
   <div style="width : 48%; float : right;">
      <h2 style="text-align : center;">���� ����</h2>
      <table style="width : 100%;">
         <tr><th><input type="date" name="start2" id="start2" th:value="${start2}" /> 
         <input type="date" name="end2" id="end2" th:value="${end2}" /> 
         <select id="m_id" name="m_id">
            <option value="all">��ü����</option>
            <c:forEach var="sc" items="${selectCustomer}">
               <c:if test="${sc.m_id != 0}">
                  <option value="${sc.m_id}">${sc.m_name}</option>
               </c:if>
            </c:forEach>
         </select></th>
         


            <tr>
               <td>
                     <canvas id="canvas1"></canvas>
                  </td>
            </tr>
         </table>
               <button id="search" class="button" value="search" >�˻�</button>
   </div>
       
</body>
</html>