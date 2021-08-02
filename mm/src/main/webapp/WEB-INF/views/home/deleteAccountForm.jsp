<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	function handleOnClick() {
		frm.submit();
		let success = confirm("탈퇴하였습니다.");
	}
</script>
<div class="container-fluid  dashboard-content">
	<div class="row">
		<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
			<div class="page-header">
				<div class="text-center">
					<h2 class="pageheader-title">정말 탈퇴하시겠어요?</h2>
					<form id="frm" name="frm" action="deleteAccount.do" method="post">
						<span onclick="handleOnClick()">네</span>
					</form>
				</div>

			</div>
		</div>
	</div>
</div>