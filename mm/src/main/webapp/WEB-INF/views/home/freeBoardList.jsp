<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid  dashboard-content">


	<div class="row">
		<!-- ============================================================== -->
		<!-- basic table -->
		<!-- ============================================================== -->
		<div class="col-12">
			<div class="card">
				<h5 class="card-header">Basic Table</h5>
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
							<c:forEach var="board" items="list">
								<tr>
									<th scope="row">${board.freeNo }</th>
									<td>${board.freeTitle }</td>
									<td>${board.freeDate }</td>
									<td>@${board.freeWriter }</td>
									<td>@${board.hit }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>

</div>