<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- left sidebar -->
<!-- ============================================================== -->
<div class="nav-left-sidebar sidebar-dark">
	<div class="menu-list">
		<nav class="navbar navbar-expand-lg navbar-light">
			<a class="d-xl-none d-lg-none" href="#">Dashboard</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav flex-column">

					<li class="nav-item"><a class="nav-link" onclick="location.href='home.do'"
						data-toggle="collapse" aria-expanded="false"
						data-target="#submenu-2" aria-controls="submenu-2"><i
							class="fa fa-fw fa-user-circle"></i>HOME</a></li>

					<li class="nav-item"><a class="nav-link" href="toBoardList.do"><i
							class="fas fa-fw fa-chart-pie"></i>To.MM</a></li>

					<li class="nav-item "><a class="nav-link" href=fromBoardList.do><i
							class="fab fa-fw fa-wpforms"></i>From.MM</a></li>

					<li class="nav-item"><a class="nav-link" href="freeBoardList.do"><i
							class="fas fa-fw fa-table"></i>Free Board</a></li>

				</ul>
			</div>
		</nav>
	</div>
</div>
<!-- ============================================================== -->
<!-- end left sidebar -->