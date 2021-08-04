<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			글 제목 : ${list[0].sTitle }<br>글 내용 : ${list[0].sContents }<br>
		</div>

		<div>
			<c:forEach var="comment" items="${list }">
				작성자 : ${comment.cName }<br>
				내용 : ${comment.cSubject }<br>
			</c:forEach>
		</div>
	</div>
</body>
</html>