<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>시험과 과제</title>
	<script>

	</script>	
</head>

<body>
	<div align="center">
		<div>
			<table border="1">
				<form>
					<tr>
						<th>아이디(이메일)</th>
						<td><input type="email" id="memberId" name="memberId"></td>
					</tr>
					<tr>
						<th>회원이름</th>
						<td><input type="text" id="memberName" name="memberName"></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input type="text" id="memberPhone" name="memberPhone"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" id="memberAddr" name="memberAddr"></td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td><input type="date" id="memberBirth" name="memberBirth"></td>
					</tr>
				</form>
			</table>

		</div>

		<br><br>
		<button type="button" id="insertMember" name="insertMember">등록</button>
		<button type="button" id="selectMember" name="selectMember">조회</button>
		<button type="button" id="updateMember" name="updateMember">수정</button>
		<button type="button" id="deleteMember" name="deleteMember">삭제</button>
		<br><br><br>
		<div>
			<table border="1">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>연락처</th>
					<th>주소</th>
					<th>생년월일</th>
				</tr>
			</table>

		</div>
	</div>

</body>

</html>