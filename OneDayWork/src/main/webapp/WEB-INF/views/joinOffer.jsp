<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>

<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
	
	<div class="container">
		<form method="get" action="joinOffer.do">
			<table>
				<thead>
					<tr>
						<th><h1>회원가입</h1></th>
					</tr>
				</thead>
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
							<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">은행 <span class="caret"></span></button>
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
</body>
</html>