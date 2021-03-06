<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Login 09</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/style.css">

<script>
	function loginConfirm(n){
		frm.submit();
		alert(n);
	}
</script>

</head>
<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">"Mad sound, All around"</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap py-5">
						<div class="img d-flex align-items-center justify-content-center"
							style="background-image: url(images/bg.jpg);"></div>
						<h3 class="text-center mb-0">Welcome</h3>
						<p class="text-center">Sign in by entering the information
							below</p>
						<form action="login.do" class="login-form" method="post">
							<div class="form-group">
								<div
									class="icon d-flex align-items-center justify-content-center">
									<span class="fa fa-user"></span>
								</div>
								<input type="text" name="id" class="form-control"
									placeholder="Id" required>
							</div>
							<div class="form-group">
								<div
									class="icon d-flex align-items-center justify-content-center">
									<span class="fa fa-lock"></span>
								</div>
								<input type="password" name="password" class="form-control"
									placeholder="Password" required>
							</div>
							<div class="form-group">

								<!-- 								<button type="submit"
									class="btn form-control btn-primary rounded submit px-3">로그인</button> -->
								<button type="submit" 
									class="btn form-control btn-primary rounded submit px-3">로그인</button>


							</div>
						</form>
						<div class="w-100 text-center mt-4 text">
							<p class="mb-0">Don't have an account?</p>
							<a href="memberInsertForm.do">회원가입</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>

