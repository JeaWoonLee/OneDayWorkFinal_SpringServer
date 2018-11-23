<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header2.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>haruMainPage</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
html, body {
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
}

.navbarDiv {
	margin-top: 50px;
}

.mainTable {
	width: fit-content;
	height: fit-content;
	margin: 0 auto;
	margin-top: 30px;
}

#imgSlides {
	height: 400px;
	width: 1000px;
}
</style>
</head>
<body>

	<div class="container">
		<h2>test1</h2>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="resources/img/seeker.PNG" alt="img1" style="width: 100%;"
						id="imgSlides">
				</div>

				<div class="item">
					<img src="resources/img/seeker2.PNG" alt="img2"
						style="width: 100%;" id="imgSlides">
				</div>

				<div class="item">
					<img src="resources/img/seeker3.PNG" alt="img3"
						style="width: 100%;" id="imgSlides">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
</body>
</html>