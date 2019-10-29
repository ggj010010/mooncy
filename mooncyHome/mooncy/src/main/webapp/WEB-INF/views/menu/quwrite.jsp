<%@ page language="java" q_descType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" q_desc="text/html; charset=UTF-8">
<q_title>게시글 작성</q_title>
<script>
    $(document).ready(function(){
        $("#btnSave").click(function(){
            //var q_title = document.form1.q_title.value; ==> name속성으로 처리할 경우
            //var q_desc = document.form1.q_desc.value;
            //var m_id = document.form1.m_id.value;
            var q_title = $("#q_title").val();
            var q_desc = $("#q_desc").val();
            var m_id = $("#m_id").val();
            if(q_title == ""){
                alert("제목을 입력하세요");
                document.form1.q_title.focus();
                return;
            }
            if(q_desc == ""){
                alert("내용을 입력하세요");
                document.form1.q_desc.focus();
                return;
            }
            if(m_id == ""){
                alert("이름을 입력하세요");
                document.form1.m_id.focus();
                return;
            }
            // 폼에 입력한 데이터를 서버로 전송
            document.form1.submit();
        });
    });
</script>
</head>
<body>
<h2>게시글 작성</h2>
<form name="form1" method="post" action="/menu/insert.do">
    <div>
        제목
        <input name="q_title" id="q_title" size="80" placeholder="제목을 입력해주세요">
    </div>
    <div>
        내용
        <textarea name="q_desc" id="q_desc" rows="4" cols="80" placeholder="내용을 입력해주세요"></textarea>
    </div>
    <div>
        이름
        <input name="m_id" id="m_id" placeholder="이름을 입력해주세요">
    </div>
    <div style="width:650px; text-align: center;">
        <button type="button" id="btnSave">확인</button>
        <button type="reset">취소</button>
    </div>
</form>
</body>
</html>
