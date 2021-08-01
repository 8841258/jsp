<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-fluid  dashboard-content">
	<div class="row">
		<!-- ============================================================== -->
		<!-- basic table -->
		<!-- ============================================================== -->
		<div class="col-12">
			<form name="frm" action="freeBoardUpdate.do" method="post">
				<div class="card">
					<h5 class="card-header">자유 게시판</h5>
					<div class="card-body">
						<div class="form-group">
							<input id="inputText3" id="freetitle" name="freetitle"
								type="text" class="form-control" value="${update.freeTitle }">
							<input type="hidden" name="freeno" value="${update.freeNo }">
						</div>
						<div class="form-group">
							<textarea class="form-control" id="exampleFormControlTextarea1"
								id="freecontent" name="freecontent" rows="10">${update.freeContent }</textarea>
						</div>
						<div class="custom-file mb-3">
							<input type="file" class="custom-file-input" id="customFile">
							<label class="custom-file-label" for="customFile">사진
								선택하기...</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
					</div>
					<div class="col" align="center">
						<button type="submit" class="btn btn-secondary btn-sm">
							<i class="fas fa-edit"></i>&nbsp;&nbsp;수정
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