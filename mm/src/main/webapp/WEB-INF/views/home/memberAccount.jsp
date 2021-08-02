<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="assets/vendor/bootstrap/css/bootstrap.min.css">
<link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
<link rel="stylesheet" href="assets/libs/css/style.css">
<link rel="stylesheet"
	href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
<title>Account</title>
</head>
<body>
	<!-- profile -->
	<!-- ============================================================== -->
	<div class="col-12">
		<!-- ============================================================== -->
		<!-- card profile -->
		<!-- ============================================================== -->
		<div class="card">
			<div class="card-body">
				<div class="user-avatar text-center d-block">
					<img src="assets/images/prologo.jpg" alt="User Avatar"
						class="rounded-circle user-avatar-xxl">
				</div>
				<div class="text-center">
					<h2 class="font-24 mb-0">${account.nickname }</h2>
					<p>Pocket Monster @${account.id }</p>
				</div>
			</div>
			<div class="card-body border-top">
				<h3 class="font-16">Information</h3>
				<div class="">
					<ul class="list-unstyled mb-0">
						<li class="mb-2"><i class="fas fa-fw fa-id-badge mr-2"></i>${account.name }</li>
						<li class="mb-2"><i class="fas fa-fw fa-envelope mr-2"></i>${account.email }</li>
						<li class="mb-0"><i class="fas fa-fw fas fa-cut mr-2"></i><span class="text-danger" onclick="location.href='deleteAccountForm.do'">탈퇴하기</span></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- ============================================================== -->
		<!-- end card profile -->
		<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- end profile -->
	<script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
	<!-- bootstap bundle js -->
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
	<!-- slimscroll js -->
	<script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
	<!-- main js -->
	<script src="assets/libs/js/main-js.js"></script>
</body>
</html>