<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>haruMainPage</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>

    html,body {
            width: 100%;
            height: 100%;
            margin: 0px;
            padding: 0px;
    }
    .navbarDiv{
    	margin-top: 50px;
    }
	.mainTable{
            width: fit-content; height:fit-content; margin: 0 auto; margin-top: 30px;
        }
  
  	#imgSlides {
  			height: 400px;	
  			width: 1000px;
  	}
  	
  
 </style>
<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>

</head>

<body>
      <br>
      <br>
    <div>
           <table class="mainTable">
                <tr>
                    <td> <img src="resources/img/haru.png" width= "80px" height="80px"></td>
                    <td><h1>하루일감</h1></td>
                </tr>
            </table> 
        </div>
        <div class="navbarDiv">
            <nav class="navbar navbar-default">
          <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand" href="#">하루일감</a>
            </div>
            <ul class="nav navbar-nav">
              <li><a href="haruMainPage">홈</a></li>
              <li><a href="registration.do">일감 등록</a></li>
              <li><a href="#">일감 보기</a></li>
              <li><a href="#">전자근로계약서</a></li>
            </ul>
            <ul class="nav navbar-nav" style="float:right">
              <li><a href="offerLogin.do">로그인</a></li>
              <li><a href="joinOffer.do">회원가입</a></li>
            </ul>
          </div>
</nav>
        </div>
   		
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
        <img src="resources/img/seeker.PNG" alt="img1" style="width:100%;" id= "imgSlides">
      </div>

      <div class="item">
        <img src="resources/img/seeker2.PNG" alt="img2" style="width:100%;" id= "imgSlides">
      </div>
    
      <div class="item">
        <img src="resources/img/seeker3.PNG" alt="img3" style="width:100%;" id= "imgSlides">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</body>

</html>