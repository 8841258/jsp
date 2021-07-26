<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회원 삭제</h1>
		</div>
		<form id="frm" name="frm" action="memberDelete.do" method="POST">
			<div>
				<table border="1">
					<tr>
						<th width="250">삭제할 id를 입력하세요.</th>
						<td><input type="text" id="id" name="id"></td>
					</tr>
				</table>
			</div>
			<div>
				<input type="submit" value="삭제"> <input type="reset"
					value="취소">
			</div>
		</form>
	</div>
</body>
</html>