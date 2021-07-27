<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../home/header.jsp" />
	<div align="center">
	<div>
		<div>
			<h1>로 그 인</h1>
		</div>
	</div>
	<form id="frm" action="login.do" method="POST">
		<div>
			<table border="1">
				<tr>
					<th width="150">아 이 디</th>
					<td width="200"><input type="text" id="id" name="id"
						placeholder="아이디 입력" required="required"></td>
				</tr>
				<tr>
					<th width="150">비밀번호</th>
					<td width="200"><input type="password" id="password"
						name="password" placeholder="비밀번호 입력" required="required"></td>
				</tr>
			</table>
		</div>
		<div>
			<br>
			<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소">
		</div>
	</form>
	</div>
</body>
</html>