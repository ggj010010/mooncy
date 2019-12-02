<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<SCRIPT type="text/javascript">
	$j(document).ready(function() {
	});

	function checkFileType(filePath) {
		var fileFormat = filePath.split(".");
		if (fileFormat.indexOf("xls") > -1) {
			return true;
		} else if (fileFormat.indexOf("xlsx") > -1) {
			return true;
		} else {
			return false;
		}
	}

	function check() {
		var file = $j("#excel").val();
		if (file == "" || file == null) {
			alert("파일 선택해주세요");
			return false;
		} else if (!checkFileType(file)) {
			alert("엑셀 파일이 아닙니다.");
			return false;
		}
		var fileFormat = file.split(".");
		var fileType = fileFormat[1];
		if (confirm("엑셀 파일을 업로드 하시겠습니까?")) {
			$j("#excelUpForm").attr("action", "/excel/ExcelUpload");
			var options = {
				success : function(data) {
					alert("업로드 완료");
					//$j("#ajax-content").html(data);
				},
				type : "POST",
				data : {
					"excelType" : fileType
				}
			};
			$j("form").ajaxSubmit(options);
		}
	}
</script>


<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<!-- BEGIN CONTENT BODY -->
		<div class="page-content">
			<div class="page-head">
				<!-- BEGIN PAGE TITLE -->
				<div class="page-title">
					<h1>
						<span id="title"></span><small id="titleSmall"></small>
					</h1>
				</div>
				<!-- END PAGE TITLE -->
			</div>
			<div class="col-lg-10 well">
				<div class="row">
					<form id="excelUpForm" method="post" action="" role="form" enctype="multipart/form-data">
						<div class="col-sm-12">
							<div class="row" id="regGoodsImgArea">
								<div class="col-sm-4">
									<label>(INSERT)</label> 
									<input id="excel" name="excel" class="file" type="file" multiple
										data-show-upload="false" data-show-caption="true"> </input>
								</div>
							</div>
						</div>
						<button type="button" id="excelUp" onclick="check()">파일 업로드</button>
					</form>
				</div>
			</div>
			<!-- END container -->
		</div>
		<!-- END CONTENT BODY -->
	</div>
	<!-- END CONTENT -->



</body>
</html>