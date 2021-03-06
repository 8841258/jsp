<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid  dashboard-content">
	<div class="row">
		<!-- ============================================================== -->
		<!-- basic table -->
		<!-- ============================================================== -->
		<div class="col-12">
			<form name="frm"
				action="freeBoardInsert.do" method="post">
				<div class="card">
					<h5 class="card-header">자유 게시판</h5>
					<div class="card-body">
						<div class="form-group">
							<input id="freetitle" name="freetitle"
								type="text" class="form-control" placeholder="제목">
						</div>
						<div class="form-group">
							<textarea class="form-control"
								id="freecontent" name="freecontent" rows="10"
								placeholder="여기에 내용을 입력하세요"></textarea>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col"></div>
					<div class="col" align="center">
						<button type="submit" class="btn btn-secondary btn-sm">
							<i class=" fas fa-check"></i>&nbsp;&nbsp;등록
						</button>
						<button type="button" onclick="location.href='freeBoardList.do' "
							class="btn btn-secondary btn-sm">
							<i class="fas fa-undo-alt"></i>&nbsp;&nbsp;취소
						</button>
					</div>
					<div class="col"></div>
				</div>
			</form>
		</div>
	</div>
</div>