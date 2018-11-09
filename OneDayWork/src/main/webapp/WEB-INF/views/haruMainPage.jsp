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
.navbar {
    display: inline-block;
    width: 100%;
    height: 40px;
    background: #f7b417;
  }
      html,body {
            width: 100%;
            height: 100%;
            margin: 0px;
            padding: 0px;
      }
      .jbTitle {
        text-align: center;
      }
      .jbMenu {
        text-align: center;
        background-color: #f7b417;
        width: 100%;
        height: 40px;

      }
      .jbContent {
        height: 2000px;
      }
      .jbFixed {
        position: fixed;
        top: 0px;
      }
          body { margin: 0; }
  
  .navbar>div { float: right; }
  .navbar>ul {
    float: left;
    margin: 0;
    padding: 0;
    list-style: none;
  }
  .navbar>ul>li {
    display: inline-block;
    padding: 0;
  }
  .navbar>after {
  height: 0px;
  }
  .navbar a {
    display: block;
    text-decoration: none;
    padding: 15px 20px;
    color: white;
  }
  .navbar a:hover { background: #03611c; }
  
  #imgSlides {
  	height: 400px;	
  	width: 1000px;
  }
  
    </style>
    <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
    <script>
      $( document ).ready( function() {
        var jbOffset = $( '.jbMenu' ).offset();
        $( window ).scroll( function() {
          if ( $( document ).scrollTop() > jbOffset.top ) {
            $( '.jbMenu' ).addClass( 'jbFixed' );
          }
          else {
            $( '.jbMenu' ).removeClass( 'jbFixed' );
          }
        });
      } );
      
    </script>
</head>

<body>
      <br>
      <br>
    <div class="jbTitle">
        <div>
            <center>
        <table>
            <tr>
                <td> <img src="resources/img/haru.png" width= "80px" height="80px"></td>
                <td><h1>하루일감</h1></td>
            </tr>
        </table>
        <div style= "float: right; margin-right: 18px;"> <p id="welcomeSign"><%=session.getAttribute("offerId")%>님 환영합니다!</p></div>
        <br>
        <br>
                </center>
     </div>
        <br>
    </div>
   <div class="jbMenu">
      <nav class="navbar">
  <ul>
    <li><a href="haruMainPage.do">홈</a></li>
    <li><a href="registration.do">일감 등록</a></li>
    <li><a href="#">메뉴2</a></li>
    <li><a href="#">메뉴3</a></li>
    <li><a href="#">메뉴4</a></li>
  </ul>
  <div><a href="#">☰</a></div>
  <div><a href="offerJoin.do">회원가입</a></div>
<div><a href="offerLogin.do">로그인</a></div>
  
</nav>
    </div>
    <br>
    
    <div class="jbContent">
   		
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
   		
   		


    </div>
    
    
</body>

</html>