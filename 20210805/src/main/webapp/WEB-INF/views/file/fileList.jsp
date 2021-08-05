<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function fileDown(a, b) {
		frm.orgFile.value = a;
		frm.downFile.value = b;
		frm.submit();
		alert("파일이 저장되었습니다.");
	}
</script>
<body>
	<div align="center">
		<div>
			<h1>파일 목록</h1>
		</div>
		<div>
			<table border="1">
				<c:forEach var="file" items="${files }">
					<tr>
						<td width="70" align="center">내용</td>
						<td width="300"><textarea rows="7" cols="100" id="subject"
								name="subject">
					${file.subject }
				</textarea>
					</tr>
					<tr>
						<td width="70" align="center">첨부파일</td>
						<td width="300" style="cursor: pointer;"
							onclick="fileDown('${file.fileName }', '${file.downFile }')">${file.fileName }
							<input type="hidden" value="${file.downFile }">
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
		이거뜨냐${file.downFile }
			<form id="frm" name="frm" action="fileDownLoad.do" method="POST">
				<input type="hidden" id="orgFile" name="orgFile"> <input
					type="hidden" id="downFile" name="downFile">
			</form>
		</div>

	</div>
</body>
</html>