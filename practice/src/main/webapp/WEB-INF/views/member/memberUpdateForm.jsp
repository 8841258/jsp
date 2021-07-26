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
			<h1>회원정보 수정</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="memberUpdate.do" method="POST">
				<table border="1">
					<tr>
						<th width="250">당신의 아이디를 입력하세요.</th>
						<td><input type="text" id="id" name="id" placeholder="아이디 입력"
							required="required"></td>
					</tr>
					<tr>
						<th width="250">변경할 패스워드를 입력하세요.</th>
						<td><input type="password" id="password" name="password"
							placeholder="패스워드 입력"></td>
					</tr>
					<tr>
						<th width="250">변경할 취미를 입력하세요.</th>
						<td><input type="checkbox" id="hobbys" name="hobbys"
							value="등산">등산 <input type="checkbox" id="hobbys"
							name="hobbys" value="낚시">낚시 <input type="checkbox"
							id="hobbys" name="hobbys" value="운동">운동 <input
							type="checkbox" id="hobbys" name="hobbys" value="독서">독서 <input
							type="checkbox" id="hobbys" name="hobbys" value="영화">영화</td>
					</tr>
				</table>
				<div>
					<input type="submit" value="수정">&nbsp;&nbsp;&nbsp; <input
						type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>