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
	<!-- 여기에 게시판 1개 글 보기 틀 만들기<br>
글 관련 데이터 뜨는지 확인 >>>>>>>>
${board[0].freeTitle } : ${board[0].freeDate } : ${board[0].freeWriter } : ${board[0].freeContent } : ${board[0].freeCnum }
<br>
댓글 관련 데이터 뜨는지 확인 >>>>>>>> 
<c:forEach var="board" items="${board }">
${board.freeCwriter } : ${board.freeCcontent } : ${board.freeCdate }<br>
</c:forEach> -->

	<div class="container-fluid  dashboard-content">


		<div class="row">
			<!-- ============================================================== -->
			<!-- basic table -->
			<!-- ============================================================== -->
			<div class="col-12"> 
				<div class="card">
					<h5 class="card-header">자유 게시판</h5>
					<div class="card-body">
						<div>
							<div><span>${board[0].freeTitle }</span></div>
							<div align="right">${board[0].freeDate }, ${board[0].freeWriter }&nbsp;&nbsp;&nbsp;&nbsp;<i class="far fa-comment-alt"></i>&nbsp;${board[0].freeCnum }</div>

						</div>
						<div>
							${board[0].freeContent }
						</div>
					</div>
				</div>
			</div>
		</div>

		<div align="right">
			<a href="freeBoardInsert.do" class="btn btn-secondary"><i
				class="fas fa-pencil-alt"></i>&nbsp;&nbsp;글쓰기</a>
		</div>
	</div>
</body>
</html>