<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
<meta charset="EUC-KR">
<title>���</title>
	<script src="http://malsup.github.com/jquery.form.js"></script>

<script>
function checkFileType(filePath) {
                var fileFormat = filePath.split(".");
                if (fileFormat.indexOf("xlsx") > -1) {
                    return true;
                } else {
                    return false;
                }
 
            }
 
            function check() {
                var file = $("#excelFile").val();
                if (file == "" || file == null) {
                    alert("������ �������ּ���.");
                    return false;
                } else if (!checkFileType(file)) {
                    alert("���� ���ϸ� ���ε� �����մϴ�.");
                    return false;
                }
 
                if (confirm("���ε� �Ͻðڽ��ϱ�?")) {
                    var options = {
                        success : function(data) {
                            alert("��� �����Ͱ� ���ε� �Ǿ����ϴ�.");
 
                        },
                        type : "POST"
                    };
                    $("#excelUploadForm").ajaxSubmit(options);
    
                }
            }
            function checkFileType(filePath) {
                var fileFormat = filePath.split(".");
                if (fileFormat.indexOf("xlsx") > -1) {
                    return true;
                } else {
                    return false;
                }
 
            }
 
            function check() {
                var file = $("#excelFile").val();
                if (file == "" || file == null) {
                    alert("������ �������ּ���.");
                    return false;
                } else if (!checkFileType(file)) {
                    alert("���� ���ϸ� ���ε� �����մϴ�.");
                    return false;
                }
 
                if (confirm("���ε� �Ͻðڽ��ϱ�?")) {
                    var options = {
                        success : function(data) {
                            alert("��� �����Ͱ� ���ε� �Ǿ����ϴ�.");
 
                        },
                        type : "POST"
                    };
                    $("#excelUploadForm").ajaxSubmit(options);
    
                }
            }
            </script>
<SCRIPT type="text/javascript">
	
</SCRIPT>

<div class="wrap">


	<div id = "side"><button class="button" onClick="location.href='/menu/main'"> ����</button></div>
	<div id = "side"><button class="button"onClick="location.href='/order/orderview'"> ���ְ���</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/quview'"> �ǸŰ���</button></div>
 	<div id = "side"><button class="button"onClick="location.href='/store/store'"> ������ </button></div>


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
<br>
<div class="board-container" >
<div id = "side_rigth">

<h2>���� ����</h2>
<table >
		<tr>
			<th>������</th>
			<th>�۳���</th>
			<th>�۾���</th>
		</tr>
		<tr>
			<td>�ȳ��ϼ���</td>
			<td>�ȳ��ϼ���</td>
			<td>������</td>
		</tr>
	</table>
	<h2>�Ǹ� ����</h2>
<table>
		<tr>
			<th>�۹�ȣ</th>
			<th>������</th>
			<th>�۾���</th>
		</tr>
		<tr>
			<td>1</td>
			<td>�ȳ��ϼ���</td>
			<td>������</td>
		</tr>
	</table>
</div></div>
<form id="excelUploadForm" name="excelUploadForm" enctype="multipart/form-data" method="post" 
                                action= "${pageContext.request.contextPath}/user/excelUploadAjax">
    <div class="contents">
        <div>÷�������� �Ѱ��� ��� �����մϴ�.</div>
 
        <dl class="vm_name">
                <dt class="down w90">÷�� ����</dt>
                <dd><input id="excelFile" type="file" name="excelFile" /></dd>
        </dl>        
    </div>
            
    <div class="bottom">
        <button type="button" id="addExcelImpoartBtn" class="btn" onclick="check()" ><span>�߰�</span></button> 
    </div>
</form> 
</body>
</html>