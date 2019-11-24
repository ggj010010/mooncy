<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/js/default.css">
<meta charset="EUC-KR">
<title>재고</title>
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
                    alert("파일을 선택해주세요.");
                    return false;
                } else if (!checkFileType(file)) {
                    alert("엑셀 파일만 업로드 가능합니다.");
                    return false;
                }
 
                if (confirm("업로드 하시겠습니까?")) {
                    var options = {
                        success : function(data) {
                            alert("모든 데이터가 업로드 되었습니다.");
 
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
                    alert("파일을 선택해주세요.");
                    return false;
                } else if (!checkFileType(file)) {
                    alert("엑셀 파일만 업로드 가능합니다.");
                    return false;
                }
 
                if (confirm("업로드 하시겠습니까?")) {
                    var options = {
                        success : function(data) {
                            alert("모든 데이터가 업로드 되었습니다.");
 
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


	<div id = "side"><button class="button" onClick="location.href='/menu/main'"> 메인</button></div>
	<div id = "side"><button class="button"onClick="location.href='/order/orderview'"> 발주관리</button></div>
	<div id = "side"><button class="button"onClick="location.href='/menu/quview'"> 판매관리</button></div>
 	<div id = "side"><button class="button"onClick="location.href='/store/store'"> 재고관리 </button></div>


</div>
</head>
<body>
	<c:choose>

        		<c:when test="${sessionScope.m.m_id != null}">
				<c:choose>

        			<c:when test="${sessionScope.m.m_id == '0'}">

      		    	<li><a>관리자님</a></li>

        			</c:when>
        			<c:otherwise> 

                		<li><a>${sessionScope.m.m_id}님</a></li>

        			</c:otherwise>
 				</c:choose>
  				

        		<li><a href="/logout">로그아웃</a></li>

        		</c:when>
        	
 	</c:choose>
<br>
<div class="board-container" >
<div id = "side_rigth">

<h2>발주 관리</h2>
<table >
		<tr>
			<th>글제목</th>
			<th>글내용</th>
			<th>글쓴이</th>
		</tr>
		<tr>
			<td>안녕하세요</td>
			<td>안녕하세요</td>
			<td>종문디</td>
		</tr>
	</table>
	<h2>판매 관리</h2>
<table>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>글쓴이</th>
		</tr>
		<tr>
			<td>1</td>
			<td>안녕하세요</td>
			<td>종문디</td>
		</tr>
	</table>
</div></div>
<form id="excelUploadForm" name="excelUploadForm" enctype="multipart/form-data" method="post" 
                                action= "${pageContext.request.contextPath}/user/excelUploadAjax">
    <div class="contents">
        <div>첨부파일은 한개만 등록 가능합니다.</div>
 
        <dl class="vm_name">
                <dt class="down w90">첨부 파일</dt>
                <dd><input id="excelFile" type="file" name="excelFile" /></dd>
        </dl>        
    </div>
            
    <div class="bottom">
        <button type="button" id="addExcelImpoartBtn" class="btn" onclick="check()" ><span>추가</span></button> 
    </div>
</form> 
</body>
</html>