<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 폼</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>파일 등록</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="fileUpload.do"
				enctype="multipart/form-data" method="POST">
				<div>
					<table border="1">
						<tr>
							<th width="100">내용</th>
							<td width="400"><textarea rows="7" cols="60" id="subject"
									name="subject"></textarea></td>
						</tr>
						<tr>
							<th width="100">파일</th>
							<td width="200"><input type="file" id="fileName"
								name="fileName" size="60">
							</td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="파일 전송">
				</div>
			</form>
		</div>


	</div>
</body>
</html>