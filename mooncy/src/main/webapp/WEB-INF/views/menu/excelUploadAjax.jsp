<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://malsup.github.com/jquery.form.js"></script>

 <form id="excelUploadForm" name="excelUploadForm" enctype="multipart/form-data"
    method="post" action= "excelUploadAjax.do">
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
<script>

  function checkFileType(filePath) {
    var fileFormat = filePath.split(".");

    if (fileFormat.indexOf("xls") > -1 || fileFormat.indexOf("xlsx") > -1) {
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


</body>
</html>