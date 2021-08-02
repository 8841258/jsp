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
				<li class="breadcrumb-item"><a href="index.html">to. Mad
						Monster</a></li>
			</ol>
		</nav>
	</div>
	<div class="content-container">
		<div class="chat-module">
			<div class="chat-module-top">
				<div class="chat-module-body">
					<c:forEach var="board" items="${list }">
						<div class="media chat-item">
							<img alt="${board.toWriter }" src="../assets/images/avatar-1.jpg"
								class="rounded-circle user-avatar-lg">
							<div class="media-body">
								<div class="chat-item-title">
									<span class="chat-item-author">${board.toWriter }</span> <span>${board.toDate }</span>
								</div>
								<div class="chat-item-body">
									<form id="frm" name="frm" action="toBoardDelete.do"
										method="post">
										<span class="chat-item-author">${board.toContent }</span> <span>
											<c:if test="${ member.nickname eq board.toWriter }">
												<button type="submit" class="btn btn-sm btn-outline-light">
													<i class="far fa-trash-alt"></i>
												</button>
											</c:if>
										</span> <input type="hidden" name="tono" value="${board.toNo }">
										<input type="hidden" name="nickname"
											value="${board.toWriter }">
									</form>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="chat-module-bottom">
				<form class="chat-form" id="frm" name="frm"
					action="toBoardInsert.do" method="post">
					<textarea class="form-control" id="tocontent" name="tocontent"
						placeholder="Type message" rows="1"></textarea>
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