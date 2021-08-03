<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
pageContext.setAttribute("replaceChar", "\n");
%>
<!-- 여기에 게시판 1개 글 보기 틀 만들기<br>
글 관련 데이터 뜨는지 확인 >>>>>>>>
${board[0].freeTitle } : ${board[0].freeDate } : ${board[0].freeWriter } : ${board[0].freeContent } : ${board[0].freeCnum }
<br>
댓글 관련 데이터 뜨는지 확인 >>>>>>>> 
<c:forEach var="board" items="${board }">
${board.freeCwriter } : ${board.freeCcontent } : ${board.freeCdate }<br>
</c:forEach> -->

<script>
	function deleteComment() {
		let confirms = confirm("댓글을 삭제하시겠습니까?")
		if (confirms) {
			alert("삭제되었습니다.")
			$("#frm").submit();
		}
	}

	function freeBoardDelete() {
		let confirms = confirm("게시글을 삭제하시겠습니까?")
		if (confirms) {
			alert("삭제되었습니다.")
			$("#frm2").submit();
		}
	}
</script>

<div class="container-fluid  dashboard-content">
	<div class="row">
		<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
			<div class="page-header">
				<h2 class="pageheader-title">자유 게시판</h2>
				<p class="pageheader-text">
					여러분이 하고 싶은 말을 자유롭게 남겨주세요!<br>욕설 및 비방성 게시글은 삼가주세요.
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<!-- ============================================================== -->
		<!-- basic table -->
		<!-- ============================================================== -->
		<div class="col-12">
			<div class="card">
				<h5 class="card-header">
					<span class="from">${board[0].freeTitle }</span>
				</h5>
				<div class="card-body">
					<div>
						<div align="right">${board[0].freeDate },
							${board[0].freeWriter }&nbsp;&nbsp;&nbsp;&nbsp;<i
								class="far fa-comment-alt"></i>&nbsp;${board[0].freeCnum }
							&nbsp;&nbsp;<i class="fas fa-eye"></i>&nbsp;${board[0].hit }
						</div>

					</div>
					<div class="mt-3">
					<c:if test="${not empty board[0].freeFile}">
						<img src="${board[0].freeFile }">
					</c:if>
					${fn:replace(board[0].freeContent, replaceChar, "<br/>") }
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-4">
			<button type="button" onclick="location.href='freeBoardList.do'"
				class="btn btn-secondary btn-sm">
				<i class="fas fa-list-ul"></i>&nbsp;&nbsp;목록
			</button>
		</div>
		<div class="col-sm-8 mb-4" align="right">
			<form name="frm2" id="frm2" action="freeBoardDelete.do"
				class="form-inline" method="post">
				<c:if test="${ member.nickname eq board[0].freeWriter }">
					<button type="button"
						onclick="location.href='freeBoardUpdateForm.do?freeno=${board[0].freeNo}'"
						class="btn btn-secondary btn-sm">
						<i class="fas fa-edit"></i>&nbsp;&nbsp;수정
					</button>
					<div>

						<input type="hidden" name="freeno" value="${board[0].freeNo}">

						<button type="button" onclick="freeBoardDelete()"
							class="btn btn-secondary btn-sm">
							<i class="fas fa-trash-alt"></i>&nbsp;&nbsp;삭제
						</button>

					</div>
				</c:if>
				<button type="button"
					onclick="location.href='freeBoardInsertForm.do'"
					class="btn btn-secondary btn-sm">
					<i class="fas fa-pencil-alt"></i>&nbsp;&nbsp;글쓰기
				</button>
			</form>
		</div>
	</div>







	<div class="row">
		<div class="col-12">
			<div class="card">
				<h5 class="card-header">
					<span class="from"><i
								class="far fa-comments"></i>&nbsp;&nbsp;댓글&nbsp;&nbsp;${board[0].freeCnum }개</span>
				</h5>
				<c:forEach var="board" items="${board }">
					<div class="card-body border-bottom">
						<div class="row">
							<div class="col-sm-6">
								<span class="font-weight-bolder">${board.freeCwriter }</span>&nbsp;&nbsp;<span
									class="small">${board.freeCdate }</span>
							</div>
							<c:if test="${ member.nickname eq board.freeCwriter }">				
								<div class="col-sm-6" align="right">
									<form name="frm" id="frm" action="freeCommentDelete.do"
										method="post">
										<input type="hidden" name="freeno" value="${board.freeNo }">
										<input type="hidden" name="freecno" value="${board.freeCno }">
										<div class="cursor_test" onclick="deleteComment()">삭제</div>
									</form>
								</div>
							</c:if>
						</div>
						<br>
						<div>${fn:replace(board.freeCcontent, replaceChar, "<br/>") }</div>
					</div>
				</c:forEach>
			</div>
			<div class="row">
				<div class="card-body">
					<form action="freeBoardCommentInsert.do">
						<textarea class="form-control mb-3" name="freeccontent"
							placeholder="댓글을 입력하세요" rows="4"></textarea>
						<input type="hidden" name="freeno" value="${board[0].freeNo}">
						<div>
							<button type="submit" class="btn btn-secondary">댓글 쓰기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


</div>




