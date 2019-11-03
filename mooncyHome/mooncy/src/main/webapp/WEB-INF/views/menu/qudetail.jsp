<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խñ� �ۼ�</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>
    $(document).ready(function(){
        $("#btnDelete").click(function(){
            if(confirm("�����Ͻðڽ��ϱ�?")){
                document.form1.action = "${path}/menu/delete.do";
                document.form1.submit();
            }
        });
        
        $("#btnUpdete").click(function(){
            //var q_title = document.form1.q_title.value; ==> name�Ӽ����� ó���� ���
            //var q_desc = document.form1.q_desc.value;
            //var m_id = document.form1.m_id.value;
            var q_title = $("#q_title").val();
            var q_desc = $("#q_desc").val();
            var m_id = $("#m_id").val();
            if(q_title == ""){
                alert("������ �Է��ϼ���");
                document.form1.q_title.focus();
                return;
            }
            if(q_desc == ""){
                alert("������ �Է��ϼ���");
                document.form1.q_desc.focus();
                return;
            }
            if(m_id == ""){
                alert("�̸��� �Է��ϼ���");
                document.form1.m_id.focus();
                return;
            }
            document.form1.action="${path}/menu/update.do"
            // ���� �Է��� �����͸� ������ ����
            document.form1.submit();
        });
    });
</script>

<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
 <div class="wrap">


	<div id = "side"><button class="button" onClick="location.href='/menu/main'"> ����</button></div>
	<div id = "side"><button class="button"onClick="location.href='/order/orderview'"> ���ְ���</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/quview'"> �ǸŰ���</button></div>
 	<div id = "side"><button class="button"onClick="location.href='/store/store'"> ������ </button></div>


</div>
</head>
<body>

<br><br><br>
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
</head>
<body>
<div class="board-container" >
<div id = "side_rigth">
<h2>�Խñ� ����</h2>
<form name="form1" method="post">
    <div>        <!-- ���ϴ� ��¥�������� ����ϱ� ���� fmt�±� ��� -->
        �ۼ����� : <fmt:formatDate value="${dto.q_date}" pattern="yyyy-MM-dd a HH:mm:ss"/>
                <!-- ��¥ ���� => yyyy 4�ڸ�����, MM ��, dd ��, a ����/����, HH 24�ð���, hh 12�ð���, mm ��, ss �� -->
    </div>
    <div>
        ó������ : ${dto.q_check}
    </div>
    <div>
        ����
        <input name="q_title" id="q_title" size="80" value="${dto.q_title}" placeholder="������ �Է����ּ���">
    </div>
    <div>
        ����
        <textarea name="q_desc" id="q_desc" rows="4" cols="80" placeholder="������ �Է����ּ���">${dto.q_desc}</textarea>
    </div>
    <div>
        �̸�
        <input name="m_id" id="m_id" value="${dto.m_id}" placeholder="�̸��� �Է����ּ���">
    </div>
    <div style="width:650px; text-align: center;">
        <!-- �Խù���ȣ�� hidden���� ó�� -->
        <input type="hidden" name="q_no" value="${dto.q_no}">
        <button type="button" id="btnUpdete">����</button>
        <button type="button" id="btnDelete">����</button>
        </div>
    </div></div>
</form>
</body>
</html>
