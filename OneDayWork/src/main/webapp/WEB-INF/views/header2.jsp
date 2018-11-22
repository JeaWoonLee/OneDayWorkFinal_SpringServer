<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- 제이쿼리 -->
<script src="resources/js/jquery-3.3.1.min.js"></script>
<!--부트스트랩 코드-->
<script src="resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<title>하루일감</title>
<style>
html, body {width: 100%;height: 100%;margin: 0px;padding: 0px;}
.navbarDiv {margin-top: 50px;}
.mainTable {width: fit-content;height: fit-content;margin: 0 auto;margin-top: 30px;}
th{text-align: center;}
th,td{padding: 10px}
#projectComment{height: 250px}
</style>
</head>

<body id="page-top">
	<!-- Header -->
	<div class="container-fluid">
		<table class="mainTable">
			<tr>
				<td><img src="resources/img/haru.png" width="80px"
					height="80px"></td>
				<td><h1>하루일감</h1></td>
			</tr>
		</table>
	</div>
	<div class="navbarDiv">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="haruMainPage.do">하루일감</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="haruMainPage.do">홈</a></li>
					<li><a href="registration.do">일감 등록</a></li>
					<li><a href="projectList.do">일감 목록</a></li>
					<li><a href="manageCommute.do">출퇴근 관리</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<!-- //end Header -->
</body>

</html>
