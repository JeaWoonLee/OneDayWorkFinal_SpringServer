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
  
  
  <link href="/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="/resources/image/icon/HalfLife.ico" rel="shortcuticon">
        <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
        <script src="//code.jquery.com/jquery.js"></script>
        <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
        <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
        <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
        <script src="/resources/bootstrap/js/respond.js"></script>    
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  
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
  

 </style>

    </style>
    <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
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

    
      $( function() {
    	    $( "#datepicker" ).datepicker();
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
    
    
    <p>Date: <input type="text" id="datepicker"></p>
    

	<div id="map" style="width:500px;height:400px; text"></div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=41450346a0e0a698000d753728111084"></script>
	<script>
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

	var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
	var mapTypeControl = new daum.maps.MapTypeControl();
	
	// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
	// daum.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
	map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT);
	
	// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
	var zoomControl = new daum.maps.ZoomControl();
	map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);
	//지도를 클릭한 위치에 표출할 마커입니다
	var marker = new daum.maps.Marker({ 
	    // 지도 중심좌표에 마커를 생성합니다 
	    position: map.getCenter() 
	}); 
	// 지도에 마커를 표시합니다
	marker.setMap(map);
	
	// 지도에 클릭 이벤트를 등록합니다
	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
	daum.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    //resultDiv.innerHTML = message;
    
});	
		
	</script>
	    
    </div>
    
    
</body>

</html>