<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="../assets/vendor/bootstrap/css/bootstrap.min.css">
<link href="../assets/vendor/fonts/circular-std/style.css"
	rel="stylesheet">
<link rel="stylesheet" href="../assets/libs/css/style.css">
<link rel="stylesheet"
	href="../assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
<title>From.MM</title>
</head>

<body class="chat-body">

	<div class="navbar bg-white breadcrumb-bar border-bottom">
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.html">From. Mad
						Monster</a></li>
			</ol>
		</nav>
	</div>
	<div class="content-container">
		<div class="chat-module">
			<a href="toBoardList.do" class="btn btn-primary btn-block">to.
				Mad Monster</a>
			<div class="chat-module-top">
				<form>
					<div class="input-group input-group-round">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fas fa-search"></i>
							</span>
						</div>
						<input type="search" class="form-control filter-list-input"
							placeholder="Search messege" aria-label="Search Chat">
					</div>
				</form>
				<div class="chat-module-body">
					<c:forEach var="board" items="${list }">
						<div class="col-12">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title mb-2">From. ${board.fromWriter }</h3>
									<h6 class="card-subtitle text-muted">${board.fromDate }</h6>
								</div>
								<img class="img-fluid" src="../assets/images/card-img.jpg"
									alt="Card image cap">
								<div class="card-body">
									<p class="card-text">${board.fromContent }</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	>
	<!-- ============================================================== -->
	<!-- end main wrapper -->
	<!-- ============================================================== -->
	<!-- Optional JavaScript -->
	<script src="../assets/vendor/jquery/jquery-3.3.1.min.js"></script>
	<script src="../assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
	<script src="../assets/vendor/slimscroll/jquery.slimscroll.js"></script>

	<script src="../assets/vendor/dropzone/dropzone.js"></script>
	<script src="../assets/libs/js/main-js.js"></script>
</body>
</html>