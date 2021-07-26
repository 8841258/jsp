<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<script type="text/javascript">
	function getRecord(n) {
		frm.bTitle.value = n;
		frm.bContent.value = ;
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 수정</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="updateBoard.do" method="POST">
				<div>
					<table border="1">
						<tr>
							<th width="100">작성자</th>
							<td width="150">${board.bWriter }</td>
							<th width="100">작성일자</th>
							<td width="150">${board.bDate }</td>
						</tr>
						<tr>
							<th width="100">글제목</th>
							<td colspan="3"><input type="text" id="bTitle" name="bTitle"
								size="60" required="required" value="${board.bTitle }"></td>

						</tr>
						<tr>
							<th width="100">내용</th>
							<td colspan="3"><textarea rows="7" cols="65" id="bContent"
									name="bContent" required="required">${board.bContent }</textarea>
							</td>
							<td><input type="hidden" id="bId" name="bId" value="${board.bId }"></td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					
					<button type="button" onclick="location.href='boardList.do'">목록</button>
					&nbsp;&nbsp;&nbsp;
					<button type="submit">수정</button>
				</div>
			</form>
		</div>
		<div></div>
	</div>
</body>
</html>