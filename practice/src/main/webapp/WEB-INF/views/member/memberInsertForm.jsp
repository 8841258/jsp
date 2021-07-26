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
			<h1>회원가입</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="memberInsert.do" method="POST">
				<div>
					<table border="1">
						<tr>
							<th width="150">아이디</th>
							<td width="400"><input type="text" id="id" name="id"
								placeholder="아이디 입력" required="required"></td>
						</tr>
						<tr>
							<th width="150">패스워드</th>
							<td width="400"><input type="password" id="password"
								name="password" placeholder="패스워드 입력" required="required"></td>
						</tr>
						<tr>
							<th width="150">패스워드</th>
							<td width="400"><input type="password" id="passcheck"
								name="passcheck" placeholder="패스워드 확인" required="required"></td>
						</tr>
						<tr>
							<th width="150">이름</th>
							<td width="400"><input type="text" id="name" name="name"
								placeholder="이름 입력" required="required"></td>
						</tr>
						<tr>
							<th width="150">나이</th>
							<td width="400"><input type="text" id="age" name="age"
								placeholder="나이 입력" required="required"></td>
						</tr>
						<tr>
							<th width="150">취미 입력</th>
							<td width="400">
								<input type="checkbox" id="hobbys" name="hobbys" value="등산">등산
								<input type="checkbox" id="hobbys" name="hobbys" value="낚시">낚시
								<input type="checkbox" id="hobbys" name="hobbys" value="운동">운동
								<input type="checkbox" id="hobbys" name="hobbys" value="독서">독서
								<input type="checkbox" id="hobbys" name="hobbys" value="영화">영화
							</td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>