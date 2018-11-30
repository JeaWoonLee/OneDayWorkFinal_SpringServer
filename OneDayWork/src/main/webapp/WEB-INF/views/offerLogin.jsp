<%@page import="com.lx.odw.vo.OfferVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String loginResult = (String) request.getAttribute("loginResult");
if(loginResult == null){
	loginResult = "none";
}
%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>offerer Login</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"
	numberegrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<style>
.control-label{font-size: 20px;}
</style>
<script type="text/javascript">
	$(function(){
		var checkLoginFail = $("#checkLoginFail").val();
		if(checkLoginFail != "none"){
			alert("로그인에 실패했습니다!");
		}
	});
</script>
</head>
<body>
	<input id="checkLoginFail" type="hidden" value="<%=loginResult%>">
	<%List<OfferVO> list = (List<OfferVO>) request.getAttribute("userId"); %>

<!-- 로그인 화면 -->
	<div class="container">
		<h3 class="text-center">로그인</h3>
		<form class="form-horizontal" action="offerLogin.do" method="post">
			<div class="form-group">
				<label class="control-label col-sm-3" for="email">아이디:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="id"
						placeholder="아이디를 입력하세요" name="userId">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="pwd">비밀번호:</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="pw"
						placeholder="비밀번호를 입력하세요" name="userPw">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3"></label>
				<div class="col-sm-6">
					<button type="submit" class="btn btn-block btn-info" id="offererLogin"
						name="offererLogin">로그인</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>