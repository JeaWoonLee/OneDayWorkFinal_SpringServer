<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registration</title>
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
  
  #map {
        width: 600px;
        height: 400px;
        background-color: grey;
        text-align: center;
      }
 </style>

    </style>
    <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
      <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAgQnQTrVIG7rNPGo1L6nDQoVkEqCCzlQE&callback=initMap"
    async defer></script>
    <script>
    
    //메뉴 상단 바 
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
    
    
      var map;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: -34.397, lng: 150.644},
          zoom: 8
        });
      }
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
    <li><a href="registration.do">메뉴1</a></li>
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
		<div id="map"></div>

	    
    </div>
    
    
</body>

</html>