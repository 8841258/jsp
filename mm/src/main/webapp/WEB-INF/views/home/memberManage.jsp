<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="container-fluid  dashboard-content">
	<div class="row">
		<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
			<div class="page-header">
				<h2 class="pageheader-title">회원 관리</h2>
			</div>
		</div>
	</div>

	<div class="row">
		<!-- ============================================================== -->
		<!-- basic table -->
		<!-- ============================================================== -->
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">id</th>
								<th scope="col">별명</th>
								<th scope="col">이름</th>
								<th scope="col">이메일</th>
								<th scope="col">권한</th>
								<th scope="col">상태</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="member" items="${list }">
								<tr>
									<td scope="row">${member.id }</td>
									<td scope="row">${member.nickname }</td>
									<td scope="row">${member.name }</td>
									<td scope="row">${member.email }</td>
									<td scope="row">${member.author }</td>
									<td scope="row">${member.state }</td>
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

</div>