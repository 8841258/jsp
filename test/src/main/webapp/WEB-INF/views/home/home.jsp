<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>시험과 과제</title>
<style>
.dataTr:hover {
	cursor: pointer;
	background-color: #efefef;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
	
	//조회 버튼
	$(document).on('click', '#selectMemberBtn', function() {
		$.ajax({
			url: 'SelectMemberServlet',
			type: 'POST',
			dataType: 'json',
			success: function(result) {
				if (result.length > 0){
					$('#resultTable').children().remove();
					selectListHeaderFnc();
					for (let data of result) {
						selectListFnc(data);
					}
				} else {
					alert('조회된 데이터가 없습니다.');
				}
			},
			error: function() {
				alert('ajax 오류');
			}
		})
	});
	
	//입력 버튼
	$(document).on('click', '#insertMemberBtn', function() {
		//폼에 입력된 값들
		let param = $('#frm').serialize();
		console.log(param);
		
		$.ajax({
			url: 'InsertMemberServlet',
			type: 'POST',
			dataType: 'json',
			data: param,
			success: function(result) {
					//result가 object라서 result.length는 안 먹히는 것 같다.
					alert('등록되었습니다.');
					selectListFnc(result);			

			},
			error: function() {
				alert('ajax 에러, db등록 X, 화면추가 X');
			}
		})
		
	});
	
	//삭제 버튼
	$(document).on('click', '#deleteMemberBtn', function() {
		if ($('#memberId').val() == "") {
			alert('먼저 삭제할 데이터를 선택하세요.');
		} else {
			let delNum = $('#resultTable').children('#'+$('#memberNo').val());
			console.log(delNum);
			let delete_confirm = confirm('삭제하시겠습니까?');
			if (delete_confirm) {
				$.ajax({
					url: 'DeleteMemberServlet',
					type: 'POST',
					data: {memberNo : $('#memberNo').val()},
					dataType: 'text',
					success: function(result) {
						if (result = 1) {
							alert('삭제되었습니다.');
							delNum.remove();
						}
					}
				})
				
			}
		}
		
	});
	
	//수정 버튼
	$(document).on('click', '#updateMemberBtn', function() {
		if ($('#memberId').val() == "") {
			alert('수정할 id를 입력하세요.');
		} else {
			let update_confirm = confirm('수정하시겠습니까?');
			if (update_confirm) {
				let param = $('#frm').serialize();
				$.ajax({
					url: 'UpdateMemberServlet',
					type: 'POST',
					data: param,
					dataType: 'json',
					success: updateFnc,
					error: function(result) {
						alert('ajax 에러');
					}
				})
			}
		}
		
	})
	
	//업데이트 function
	function updateFnc(data) {
		let updateTd = $('#resultTable').children('#'+$('#memberNo').val()).children();
		console.log(updateTd);
		console.log($(updateTd).eq(1));
		$(updateTd).eq(1).text(data.memberName);
		$(updateTd).eq(2).text(data.memberPhone);
		$(updateTd).eq(3).text(data.memberAddr);
		$(updateTd).eq(4).text(data.memberBirth);
	}
	
	//table의 tr 첫줄, th(헤더) 표시되는 곳
	function selectListHeaderFnc() {
		let trTag_1 = $('<tr />');
		let thTag_1 = $('<th />').text('아이디(이메일)');
		let thTag_2 = $('<th />').text('이름');
		let thTag_3 = $('<th />').text('연락처');
		let thTag_4 = $('<th />').text('주소');
		let thTag_5 = $('<th />').text('생년월일');
		
		$(trTag_1).append(thTag_1, thTag_2, thTag_3, thTag_4, thTag_5);
		$('#resultTable').append(trTag_1);
	}
	
	//for문 안에 들어갈 조회 데이터들
	function selectListFnc(data) {
		let trTag_2 = $('<tr />').addClass('dataTr').attr('id', data.memberNo);
		//데이터 한 줄을 클릭하면 인풋박스에 값을 넣는다.
		$(trTag_2).on('click', function() {
			let memberNo = $(this).attr('id');
			console.log(memberNo);
			$.ajax({
				url: 'SelectOneMemberServlet',
				type: 'POST',
				data: {memberId : data.memberId},
				dataType: 'json',
				success: function(result) {
					$('#memberId').val(result.memberId);
					$('#memberName').val(result.memberName);
					$('#memberPhone').val(result.memberPhone);
					$('#memberAddr').val(result.memberAddr);
					//알맞은 형식이 아니라서 오류가 뜨는 곳
					$('#memberBirth').val(result.memberBirth);
					$('#memberNo').val(memberNo);
				}
			});
			
		})

		let tdTag_1 = $('<td />').text(data.memberId);
		let tdTag_2 = $('<td />').text(data.memberName);
		let tdTag_3 = $('<td />').text(data.memberPhone);
		let tdTag_4 = $('<td />').text(data.memberAddr);
		let tdTag_5 = $('<td />').text(data.memberBirth);
		$(trTag_2).append(tdTag_1, tdTag_2, tdTag_3, tdTag_4, tdTag_5);
		$('#resultTable').append(trTag_2);
	}
	
	function dateFormat(test) {
		let idx = test.indexOf(" ", 0);
		let month = test.substring(0, idx-1);
		let idx2 = test.indexOf(",", 0);
		let day = test.substring(idx+1, idx2);
		let year = test.substring(idx2+2);
		let fullDay;
		if (month < 10) {
			fullDay = year+"-0" + month+"-"+day;
		} else {
			fullDay = year+"-"+month+"-"+day;
		}
		return new Date(fullDay);
	}

</script>
</head>

<body>
	<div class="container">
	<div class="row">
		<h3>윤지민</h3>
	</div>
		<div class="row">
			<form id="frm" name="frm">
				<table border="1" class="table">
					<tr>

						<th>아이디(이메일)</th>
						<td><input type="hidden" id="memberNo" name="memberNo">
							<input type="email" id="memberId" name="memberId" required></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" id="memberName" name="memberName"
							required></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input type="text" id="memberPhone" name="memberPhone"
							required></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" id="memberAddr" name="memberAddr"></td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td><input type="date" id="memberBirth" name="memberBirth"
							required></td>
					</tr>
				</table>
			</form>

		</div>

		<div class="row text-center p-3">
		<button type="button" id="insertMemberBtn" name="insertMemberBtn" class="btn btn-outline-dark">등록</button>
		<button type="button" id="selectMemberBtn" name="selectMemberBtn" class="btn btn-outline-dark">조회</button>
		<button type="button" id="updateMemberBtn" name="updateMemberBtn" class="btn btn-outline-dark">수정</button>
		<button type="button" id="deleteMemberBtn" name="deleteMemberBtn" class="btn btn-outline-dark">삭제</button>
		</div>
		
		<div class="row p-3">
			<table id="resultTable" class="table" border="1">
			</table>
		</div>
	</div>

</body>

</html>