<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	function getRecord(n) {
		frm.freeNo.value=n;
		frm.submit();
	}
</script>
<div class="container-fluid  dashboard-content">


	<div class="row">
		<!-- ============================================================== -->
		<!-- basic table -->
		<!-- ============================================================== -->
		<div class="col-12">
			<div class="card">
				<h5 class="card-header">자유 게시판</h5>
				<div class="card-body">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">제목</th>
								<th scope="col">날짜</th>
								<th scope="col">글쓴이</th>
								<th scope="col">조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="board" items="${list }">
								<tr onclick="getRecord(${board.freeNo})">
									<th scope="row">${board.freeNo }</th>
									<td><span>${board.freeTitle }</span><span
										class="badge badge-secondary float-right">${board.freeCnum }</span></td>
									<td>${board.freeDate }</td>
									<td>${board.freeWriter }</td>
									<td>${board.hit }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div>
			<form id="frm" action="freeBoardSelect.do" method="POST">
				<input type="hidden" id="freeNo" name="freeNo">
			</form>
		</div>
	</div>

	<div align="right">
		<button type="button" onclick="location.href='freeBoardInsertForm.do'"
			class="btn btn-secondary btn-sm">
			<i class="fas fa-pencil-alt"></i>&nbsp;&nbsp;글쓰기
		</button>
	</div>

</div>