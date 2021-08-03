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
				<li class="breadcrumb-item"><h2>
						<a href="fromBoardList.do"><br>From. Mad Monster</a>
					</h2></li>
			</ol>
		</nav>
	</div>
	<div class="content-container">
		<div class="chat-module">
			<div class="chat-module-top">
				<c:if test="${ member.author eq 'USER' }">
					<a href="toBoardList.do" class="btn btn-primary btn-block">to.
						Mad Monster</a>
				</c:if>
				<c:if test="${ member.author eq 'STAR' }">
						<form class="chat-form" id="frm" name="frm"
							action="fromBoardInsert.do" method="post">
							<textarea class="form-control" id="fromcontent"
								name="fromcontent" placeholder="Type message" rows="1"></textarea>
							<div class="chat-form-buttons">
								<button type="submit" class="btn btn-link">
									<i class="far fa-smile"></i>
								</button>
								<div class="custom-file custom-file-naked">
									<input type="file" class="custom-file-input" id="customFile">
									<label class="custom-file-label" for="customFile"> <i
										class="fas fa-paperclip"></i>
									</label>
								</div>
							</div>
						</form>
				</c:if>
				<div class="chat-module-body">
					<c:forEach var="board" items="${list }">
						<div class="col-12">
							<div class="card">
								<div class="card-header">
									<div class="row">
										<div class="col-sm-6">
											<h3 class="card-title mb-2">From. ${board.fromWriter }</h3>
											<h6 class="card-subtitle text-muted">${board.fromDate }</h6>
										</div>
										<div class="col-sm-6" align="right">
											<form id="frm" name="frm" action="fromBoardDelete.do"
												method="post">
												<span> <c:if
														test="${ member.nickname eq board.fromWriter }">
														<button type="submit" class="btn btn-sm btn-outline-light">
															<i class="far fa-trash-alt"></i>
														</button>
													</c:if>
												</span> <input type="hidden" name="fromno" value="${board.fromNo }">
												<input type="hidden" name="nickname"
													value="${board.fromWriter }">
											</form>
										</div>
									</div>
								</div>
								<!-- <img class="img-fluid" src="../assets/images/card-img.jpg"
									alt="Card image cap"> -->
								<div class="card-body">
									<p class="card-text">${board.fromContent }</p>
								</div>
							</div>
						</div>
					</c:forEach>
					<div class="row">
						<div class="col-sm-6">
							<div class="card">
								<div class="card-header">
									<div class="row">
										<div class="col-sm-6">
											<h3 class="card-title mb-2">From. TAN</h3>
											<h6 class="card-subtitle text-muted">2021-07-21</h6>
										</div>
										<div class="col-sm-6" align="right">
											<form id="frm" name="frm" action="fromBoardDelete.do"
												method="post">
												<span> <c:if
														test="${ member.nickname eq board.fromWriter }">
														<button type="submit" class="btn btn-sm btn-outline-light">
															<i class="far fa-trash-alt"></i>
														</button>
													</c:if>
												</span>
											</form>
										</div>
									</div>
								</div>
								<img class="img-fluid" src="assets/images/tan3.jpg"
									alt="Card image cap">
								<div class="card-body">
									<p class="card-text">
										김밥 먹고 있어<br>점심 먹기 전에 ~<br>중복이라서 한번 먹고 중복으로 한번 더 먹을
										계획♥<br> <br>더운데 시원한 물 많이 마셔~~♡♡
									</p>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="card">
								<div class="card-header">
									<div class="row">
										<div class="col-sm-6">
											<h3 class="card-title mb-2">From. J-HO</h3>
											<h6 class="card-subtitle text-muted">2021-07-20</h6>
										</div>
										<div class="col-sm-6" align="right">
											<form id="frm" name="frm" action="fromBoardDelete.do"
												method="post">
												<span> <c:if
														test="${ member.nickname eq board.fromWriter }">
														<button type="submit" class="btn btn-sm btn-outline-light">
															<i class="far fa-trash-alt"></i>
														</button>
													</c:if>
												</span>
											</form>
										</div>
									</div>
								</div>
								<img class="img-fluid" src="assets/images/jho3.jpg"
									alt="Card image cap">
								<div class="card-body">
									<p class="card-text">haha</p>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="card">
								<div class="card-header">
									<div class="row">
										<div class="col-sm-6">
											<h3 class="card-title mb-2">From. J-HO</h3>
											<h6 class="card-subtitle text-muted">2021-07-06</h6>
										</div>
										<div class="col-sm-6" align="right">
											<form id="frm" name="frm" action="fromBoardDelete.do"
												method="post">
												<span> <c:if
														test="${ member.nickname eq board.fromWriter }">
														<button type="submit" class="btn btn-sm btn-outline-light">
															<i class="far fa-trash-alt"></i>
														</button>
													</c:if>
												</span>
											</form>
										</div>
									</div>
								</div>
								<img class="img-fluid" src="assets/images/jho2.jpg"
									alt="Card image cap">
								<div class="card-body">
									<p class="card-text"></p>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="card">
								<div class="card-header">
									<div class="row">
										<div class="col-sm-6">
											<h3 class="card-title mb-2">From. TAN</h3>
											<h6 class="card-subtitle text-muted">2021-07-06</h6>
										</div>
										<div class="col-sm-6" align="right">
											<form id="frm" name="frm" action="fromBoardDelete.do"
												method="post">
												<span> <c:if
														test="${ member.nickname eq board.fromWriter }">
														<button type="submit" class="btn btn-sm btn-outline-light">
															<i class="far fa-trash-alt"></i>
														</button>
													</c:if>
												</span>
											</form>
										</div>
									</div>
								</div>
								<img class="img-fluid" src="assets/images/tan2.jpg"
									alt="Card image cap">
								<div class="card-body">
									<p class="card-text"></p>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="card">
								<div class="card-header">
									<div class="row">
										<div class="col-sm-6">
											<h3 class="card-title mb-2">From. TAN</h3>
											<h6 class="card-subtitle text-muted">2021-07-05</h6>
										</div>
										<div class="col-sm-6" align="right">
											<form id="frm" name="frm" action="fromBoardDelete.do"
												method="post">
												<span> <c:if
														test="${ member.nickname eq board.fromWriter }">
														<button type="submit" class="btn btn-sm btn-outline-light">
															<i class="far fa-trash-alt"></i>
														</button>
													</c:if>
												</span>
											</form>
										</div>
									</div>
								</div>
								<img class="img-fluid" src="assets/images/tan1.jpg"
									alt="Card image cap">
								<div class="card-body">
									<p class="card-text"></p>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="card">
								<div class="card-header">
									<div class="row">
										<div class="col-sm-6">
											<h3 class="card-title mb-2">From. J-HO</h3>
											<h6 class="card-subtitle text-muted">2021-07-05</h6>
										</div>
										<div class="col-sm-6" align="right">
											<form id="frm" name="frm" action="fromBoardDelete.do"
												method="post">
												<span> <c:if
														test="${ member.nickname eq board.fromWriter }">
														<button type="submit" class="btn btn-sm btn-outline-light">
															<i class="far fa-trash-alt"></i>
														</button>
													</c:if>
												</span>
											</form>
										</div>
									</div>
								</div>
								<img class="img-fluid" src="assets/images/jho1.jpg"
									alt="Card image cap">
								<div class="card-body">
									<p class="card-text"></p>
								</div>
							</div>
						</div>
					</div>
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