<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>	  
    <!--부트스트랩 코드-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!--부트스트랩 코드-->

    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
    
<head>
<meta charset="UTF-8">
<title>registration</title>

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
        .registration{
        	width: fit-content; height:fit-content; margin: 0 auto;
        }
        #projectComment{
            width:450px;
            height:350px;
        }
        #projectName, #projectSubject, #projectEnrollDate{
            width: 450px;
        }
        #projectStartDate,#workStartTime {
            width: 222px;
        }
        #projectEndDate, #workEndTime {
            width: 222.9px;
        }
        #insertProject{
            width : 450px;
        }


</style>

   
<script type="text/javascript">
$(function(){
	console.log("onLoad 실행됨");
	$("#insertProject").on("click",function(){
		console.log('insertProject이 실행됨');
		var projectName= $('#projectName').val();
		var projectStartDate= $('#projectStartDate').val();
		var projectEndDate= $('#projectEndDate').val();
		var clickLatlng= $('#clickLatlng').val();
		var projectComment= $('#projectComment').val();
		var certificate= $('#certificate').val();
		var picture= $('#picture').val();
		var workStartTime= $('#workStartTime').val();
		var workEndTime= $('#workEndTime').val();
		var projectSubject= $('#projectSubject').val();
		var projectEnrollDate= $('#projectEnrollDate').val();
		var lat = $('#lat').val();
		var lng = $('#lng').val();
		console.log('projectName'+projectName);
		console.log('projectStartDate'+projectStartDate);
		console.log('projectEndDate'+projectEndDate);
		console.log('clickLatlng'+lat + ", "+lng);
		console.log('projectComment'+projectComment);
		console.log('certificate'+certificate);
		console.log('picture'+picture);
		console.log('workStartTime'+workStartTime);
		console.log('workEndTime'+workEndTime);
		console.log('projectSubject'+projectSubject);
		console.log('projectEnrollDate'+projectEnrollDate);
		
		return false;

	});
});
			
</script>
</head>
<body>

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
              <a class="navbar-brand" href="haruMainPage.do">하루일감</a>
            </div>
            <ul class="nav navbar-nav">
              <li class="active"><a href="haruMainPage.do">홈</a></li>
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
	
<form action="registration.do" method="get">
        <div class="registration">
            <table class="table table-bordered" id="registrationTable" style="width:450px;">
                <tr>
                    <td><h3 style="text-align: center;">일감 등록</h3></td>
                </tr>
                <tr>
                    <td>
                        <label for="projectlabel">일감</label>
                        <input type="text" placeholder=" 사업명" id="projectName" name="projectName" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dateLabel">일감 시작~마감일</label>
                        <br>
                        <input type="date" name="projectStartDate" id="projectStartDate" required>
                        <input type="date" name="projectEndDate" id="projectEndDate" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="locationLabel">근무 장소</label>
                        <div id="map" style="width:450px; height:350px;"></div>
                        <p><em>근무 위치를 클릭해주세요!</em></p>
                        <div id="clickLatlng"></div>
	
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
						$('#lat').attr("value",latlng.getLat());
						$('#lng').attr("value",latlng.getLng());
                        var resultDiv = document.getElementById('clickLatlng'); 
                        resultDiv.innerHTML = message;

                    });	

                        </script>
						<input type="hidden" id="projectLat" name="projectLat">						
						<input type="hidden" id="projectLng" name="projectLng">
                    </td>
                </tr>
                <tr>
                    <td><label for="locationLabel">업무 상세 내용</label>
                        <textarea id="projectComment" name="projectComment" placeholder=" 업무 상세 내용" required></textarea> </td>
                </tr>
                <tr>
                	<td><label for="demandLabel">업무 요구 사항</label>
                	<br>
                		<input type="checkbox" name="certificate" value="안전교육이수증">안전교육이수증
                		&nbsp;
						<input type="checkbox" id="requestPicture" name="requestPicture" value="사진">사진
                	</td>
                </tr>
                <tr>
                    <td>
                        <label for="TimeLabel">업무 시작~마감시간</label>
                        <br>
                              <input type="time" name="workStartTime" id="workStartTime" required>
                              <input type="time" name="workEndTime" id="workEndTime" required>
                    </td>
                </tr>
                <tr>
                    <td><label for="subjectLabel">업종 분류</label>
                        <select name="projectSubject" id="projectSubject" required>
                            <option value="">사업분류</option>
                            <option value="건설">건설</option>
                            <option value="건설현장">건설현장</option>
                            <option value="공장">공장</option>
                            <option value="조선" >조선</option>
                            <option value="실내공사">실내공사</option>
                            <option value="토목" >토목</option>
                        </select>
                    </td>
                </tr>
                <script>
					document.getElementById('projectEnrollDate').valueAsDate = new Date();
				</script>
                <tr>
                    <td>
                        <label for="enrollDateLabel">사업 등록일</label>
                        <input type="date" name="projectEnrollDate" id="projectEnrollDate" required>
                    </td>
                </tr>
                <tr>
                    <td>
                    <input type="button" value="일감 등록" id="insertProject" name="insertProject"></td>
                </tr>
                <tr>
                    <td></td>        
                </tr>
                
            </table>
        </div>
        </form>   
</body>

</html>