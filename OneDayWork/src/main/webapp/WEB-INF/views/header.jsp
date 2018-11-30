<%@page import="com.lx.odw.vo.OfferVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>하루일감</title>

<!-- Theme Made By www.w3schools.com - No Copyright -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>


body {font: 400 15px/1.8 Lato, sans-serif; color: #777;}
h3, h4 {margin: 10px 0 30px 0; letter-spacing: 10px; font-size: 30px; color: #111;}
.container {padding: 80px 120px;}
.person {border: 10px solid transparent;margin-bottom: 25px;width: 80%;height: 80%;opacity: 0.7;}
.person:hover {border-color: #f1f1f1;}
.carousel-inner img {-webkit-filter: grayscale(90%);filter: grayscale(90%);/* make all photos black and white */width: 100%; /* Set width to 100% */margin: auto;}
.carousel-caption h3 {color: #fff !important;}
@media ( max-width : 600px) {.carousel-caption {display: none;/* Hide the carousel text when the screen is less than 600 pixels wide */}}
.bg-1 {background: #2d2d30;color: #bdbdbd;}
.bg-1 h3 {color: #fff;}
.bg-1 p {font-style: italic;}
.list-group-item:first-child {border-top-right-radius: 0;border-top-left-radius: 0;}
.list-group-item:last-child {border-bottom-right-radius: 0;border-bottom-left-radius: 0;}
.thumbnail {padding: 0 0 15px 0;border: none;border-radius: 0;}
.thumbnail p {margin-top: 15px;color: #555;}


.modal-header, h4, .close {background-color: #333;color: #fff !important;text-align: center;font-size: 30px;}
.modal-header, .modal-body {padding: 40px 50px;}
.nav-tabs li a {color: #777;}
#googleMap {width: 100%;height: 400px;-webkit-filter: grayscale(100%);filter: grayscale(100%);}
.navbar {font-family: Montserrat, sans-serif;margin-bottom: 0;background-color: #2d2d30;border: 0;font-size: 12px !important;letter-spacing: 3px;opacity: 0.9;line-height: 1.42857143 !important;border-radius: 0;z-index: 9999;}
.navbar li a, .navbar .navbar-brand {color: #d5d5d5 !important;}
.navbar-nav li a:hover {color: #fff !important;}
.navbar-nav li.active a {color: #fff !important;background-color: #29292c !important;}
.navbar-default .navbar-toggle {border-color: transparent;}
.open .dropdown-toggle {color: #fff;background-color: LightGray !important;}
.dropdown-menu li a {color: #000 !important;}
.dropdown-menu li a:hover {background-color: LightGray !important;}
footer {background-color: #2d2d30;color: #f5f5f5;padding: 32px;font-size: 12px;bottom: 0;width: 100%;

    margin: 0 auto;

}
footer a {color: #f5f5f5;}
footer a:hover {color: #777;text-decoration: none;}

.form-control {border-radius: 0;}
textarea {resize: none;}
.jumbotron { background-image: url("resources/img/header.png");color: #fff;font-family: Montserrat, sans-serif;opacity: 0.9;}
h5{color: black; font-size: 30px;}
td{color:black; font-size : 20px; font-style: inherit;}
h1{color: black; font-size: 30px;}
.form-control{color:black; font-size: 20px;}
.btn{color:black; font-size:20px;}
li{font-size:20px;font-weight: bold;}
.active{font-size:20px;font-weight: bold;}
#myNavbar{height: 150px;}
</style>

</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

	<!-- header -->
	<!-- navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="haruMainPage.do">하 루 일 감</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-center">
					<li class="active"><a href="haruMainPage.do">Home</a></li>
					<li><a href="registration.do">일감 등록</a></li>
					<li><a href="projectList.do">일감 목록</a></li>
					<li><a href="manageCommute.do">출퇴근 관리</a></li>
					
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<%OfferVO userInfo = (OfferVO) session.getAttribute("loginInfo");
				if(userInfo == null){ %>
					<li><a href="offerLogin.do"><span class="glyphicon glyphicon-log-in"></span>로그인</a></li>
					<li><a href="joinOffer.do"><span class="glyphicon glyphicon-user"></span>회원가입</a></li>
				<%} else {%>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>회원 정보 수정</a></li>
					<li><a href="logout.do"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a></li>
				<%}%>
				</ul>
			</div>
		</div>
	</nav>
	
	<!-- jumbotron -->
	<div class="jumbotron text-center">
		
		<h1>
			<img src="resources/img/harulogo_w.png" width="20%">
		</h1>

	</div>
	<!-- header -->

</body>
</html>