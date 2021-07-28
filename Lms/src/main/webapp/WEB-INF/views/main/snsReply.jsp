<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">${list[0].sTitle }</h1>
	<p class="mb-4">${list[0].sDate }</p>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">${list[0].sWriter }</h6>
		</div>
		<div class="card-body">${list[0].sContents }</div>
	</div>
	<c:forEach var="list" items="${list }">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">${list.cName }</h6>
		</div>
		<div class="card-body">${list.cSubject }</div>
	</div>
	</c:forEach>
</div>

<!-- /.container-fluid -->



<!-- Page level plugins -->
<script src="vendor/datatables/jquery.dataTables.min.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>