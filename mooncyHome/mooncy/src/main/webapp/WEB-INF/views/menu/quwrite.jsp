<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<q_title>�Խñ� �ۼ�</q_title>c
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>
    $(document).ready(function(){
        $("#btnSave").click(function(){
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
            // ���� �Է��� �����͸� ������ ����
            document.form1.submit();
        });
    });
</script>
</head>
<body>
<h2>�Խñ� �ۼ�</h2>
<form name="form1" method="post" action="/menu/insert.do">
    <div>
        ����
        <input name="q_title" id="q_title" size="80" placeholder="������ �Է����ּ���">
    </div>
    <div>
        ����
        <textarea name="q_desc" id="q_desc" rows="4" cols="80" placeholder="������ �Է����ּ���"></textarea>
    </div>
    <div>
        �̸�
        <input name="m_id" id="m_id" value="1">
    </div>
    <div style="width:650px; text-align: center;">
        <button type="button" id="btnSave">Ȯ��</button>
        <button type="reset">���</button>
    </div>
</form>
</body>
</html>
