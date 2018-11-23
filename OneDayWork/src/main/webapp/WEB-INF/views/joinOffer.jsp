<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>



<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>

<script type="text/javascript">
	var isOverlapCheck = false;

	$(function() {
		$('#offerJoinButton').on("click", function() {
			var offerIdHidden = $('#offerIdHidden').val();
			var offerPw = $('#offerPw').val();
			var pwReInput = $('#pwReInput').val();
			var offerName = $('#offerName').val();
			var offerEmail = $('#offerEmail').val();
			var companyName = $('#companyName').val();
			var companyNo = $('#companyNo').val();
			var offerAccount = $('#offerAccount').val();

			if (offerPw != pwReInput) {
				alert('패스워드를 다르게 입력하셨습니다');
				return;
			}

			$.ajax({
				method : 'POST',
				url : 'joinOffer.do',
				data : {
					offerId : offerIdHidden,
					offerPw : offerPw,
					offerName : offerName,
					offerEmail : offerEmail,
					companyName : companyName,
					companyNo : companyNo,
					offerAccount : offerAccount
				},
				success : function(data) {
					if (data.response == 1) {
						alert('회원가입 성공');
						document.location.href = "haruMainPage.do";
					} else {
						alert('회원가입 실패');
					}
				}
			});
		});
		$('#checkOverlapButton').on("click", checkOverlap);
	});

	function checkOverlap() {
		var offerId = $('#offerId').val();

		$.ajax({
			method : 'POST',
			url : 'checkOfferOverlap.do',
			data : {
				userId : offerId
			},
			success : function(data) {
				if (data.response == 1) {
					alert('이미 해당 아이디가 존재합니다');
				} else {
					alert('해당 아이디는 사용 가능합니다');
					isOverlapCheck = true;
					$('#offerId').attr("disabled", true);
					$('#checkOverlapButton').attr("disabled", true);
					$('#offerIdHidden').attr('value', offerId);
					$('#offerJoinButton').attr('disabled', false);
				}
			}
		});
	}
</script>

<!-- 가운데로 오게함 -->

<title>하루일감: 회원가입</title>



</head>
<body>

	<div class="container">
		<h3 class="text-center">회원가입</h3>
		<form class="form-horizontal" action="joinOffer.do" method="POST">


			<div class="form-group">
				<label class="control-label col-sm-3" type="text" id="offerId "
					name="offerId" maxlength="20">아이디:</label> <input type="hidden"
					id="offerIdHidden">
				<div class="col-sm-5">
					<input type="text" class="form-control" id="id" name="userId">
					
				</div>
				<div class="col-sm-1">
					
					<span><button type="button" class="btn btn-danger btn-sm"
						id="checkOverlapButton">중복확인</button></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3">비밀번호:</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="offerPw"
						maxlength="20" name="offerPw">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-3">비밀번호 확인:</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="pwReInput"
						name="pwReInput">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-3">이름:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="offerName"
						name="offerName">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-3">이메일:</label>
				<div class="col-sm-5">
					<input type="email" class="form-control" id="offerEmail"
						name="offerEmail">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-3">회사명:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="companyName"
						name="companyName">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-3">사업자 번호:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="companyNo"
						name="companyNo">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-3">계좌:</label>


				<div class="col-sm-1">
				
						<select name="offerAccount" id="offerAccount" required>
							<option value="">은행</option>
							<option value="신한은행">신한은행</option>
							<option value="국민은행">국민은행</option>
							<option value="농협">농협</option>
							<option value="기업은행">기업은행</option>
							<option value="하나은행">하나은행</option>
							<option value="기업은행">기업은행</option>
						</select>
					
				</div>
				
				<div class="col-sm-4" style="padding-left: 40px;">
					<input type="text" class="form-control" id="bank" name="bank">
				</div>


			</div>

			<div class="form-group">
				<label class="control-label col-sm-3"></label>
				<div class="col-sm-6">
					<button type="submit" class="btn btn-block btn-info" id="offerJoinButton"
						name="offererLogin" disabled=true>회원가입</button>
				</div>
			</div>
	</div>
 



	</div>

	</form>
	
	<!-- 
	<div class="container">
		<h3 style="text-align: center;">회원가입</h3>
		<form method="get" action="joinOffer.do">
			<table>
				<tbody>
					<tr>
						<td>아이디</td>
						<td>
							<input type="text" id="offerId" name="offerId" maxlength="20">
							<input type="hidden" id="offerIdHidden">
							<button type="button" id="checkOverlapButton" class="btn btn-danger btn-sm">중복확인</button>
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" id="offerPw" name="offerPw" maxlength="20"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" id="pwReInput" name="pwReInput" maxlength="20"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" id="offerName" name="offerName" maxlength="20"></td>						
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="email" id="offerEmail" name="offerEmail" maxlength="20"></td>
					</tr>
					<tr>
						<td>회사명</td>
						<td><input type="text" id="companyName" name="companyName" maxlength="20"></td>
					</tr>
					<tr>
						<td>사업자 번호</td>
						<td> <input type="text" id="companyNo" name="companyNo" maxlength="20"></td>
					</tr>
					<tr>
						<td>계좌</td>
						<td class="dropdown">
							<button class="btn btn-default btn-sm" type="button" data-toggle="dropdown">은행 <span class="caret"></span></button>
							<ul class="dropdown-menu">
								<li><a href="#">신한은행</a></li>
								<li><a href="#">국민은행</a></li>
								<li><a href="#">기업은행</a></li>
							</ul> <input type="text" id="offerAccount" name="offerAccount" maxlength="20">
						</td>
					</tr>
					<tr>
						<td><input type="button" id="offerJoinButton" value="회원가입" class="btn btn-warning" disabled=true></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	-->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>