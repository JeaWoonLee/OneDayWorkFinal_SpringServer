<%@page import="com.lx.odw.vo.OfferVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String loginResult = (String) request.getAttribute("loginResult");
if(loginResult == null){
	loginResult = "none";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>offerer Login</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<style>
html, body {
	margin: 0;
	padding: 0;
	height: 100%;
	width: 100%;
}

#id, #pw {
	width: 400px;
	height: 30px;
}

#offererLogin {
	width: 405px;
	height: 40px;
	background-color: #03611c;
	color: white;
	font-size: 13pt;
}
.container {width: fit-content; height:fit-content; margin: 0 auto; margin-top: 200px}
.loginLogo{width: fit-content; height:fit-content; margin: 0 auto;}
.offerLoginTitle{width: fit-content; height:fit-content; margin: 0 auto; }
</style>
<script type="text/javascript">
	$(function(){
		var checkLoginFail = $('#checkLoginFail').val();
		if(checkLoginFail != 'none'){
			alert('로그인에 실패했습니다!');
		}
	});
</script>
</head>
<body>
	<input id="checkLoginFail" type="hidden" value="<%=loginResult%>">
	<%List<OfferVO> list = (List<OfferVO>) request.getAttribute("userId"); %>
	<div class="container">
		<table class="loginLogo">
			<tr>
				<td><img src="resources/img/haru.png" width="80px"
					height="80px"></td>
				<td><h1>하루일감</h1></td>
			</tr>
		</table>
		<h4 class="offerLoginTitle">[구인자 로그인]</h4>
		<br>
		<form action="offerLogin.do" method="post">

			<table>
				<tr>
					<td><input type="text" id="id" name="userId" placeholder=" ID">
					</td>
				</tr>
				<tr>
					<td><input type="password" id="pw" name="userPw"
						placeholder=" PassWord"></td>
				</tr>
			</table>
			<br>
			<div>
				<input type="submit" value="로그인" id="offererLogin"
					name="offererLogin">
			</div>
		</form>
	</div>

</body>
</html>