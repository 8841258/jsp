<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<h5 class="card-header">
					<span class="from">자유 게시판</span>
				</h5>
				<div class="card-body">
					<div>
						<div>
							<span>${board[0].freeTitle }</span>
						</div>
						<div align="right">${board[0].freeDate },
							${board[0].freeWriter }&nbsp;&nbsp;&nbsp;&nbsp;<i
								class="far fa-comment-alt"></i>&nbsp;${board[0].freeCnum }
							&nbsp;&nbsp;<i class="fas fa-eye"></i>&nbsp;${board[0].hit }
						</div>

					</div>
					<div>${board[0].freeContent }</div>
				</div>
			</div>
		</div>
	</div>


	<div class="email-list-item email-list-item--unread">
		<div class="email-list-actions">
			<label class="custom-control custom-checkbox"> <input
				class="custom-control-input checkboxes" type="checkbox" value="1"
				id="one"><span class="custom-control-label"></span>
			</label><a class="favorite active" href="#"><span><i
					class="fas fa-star"></i></span></a>
		</div>
		<div class="email-list-detail">
			<span class="date float-right"><span class="icon"><i
					class="fas fa-paperclip"></i> </span>28 Jul</span><span class="from">Penelope
				Thornton</span>
			<p class="msg">Urgent - You forgot your keys in the class room,
				please come imediatly!</p>
		</div>
	</div>


	<div align="right">
		<button type="button" onclick="location.href='freeBoardInsertForm.do'"
			class="btn btn-secondary btn-sm">
			<i class="fas fa-pencil-alt"></i>&nbsp;&nbsp;글쓰기
		</button>
	</div>
</div>