<%@page import="com.lx.odw.vo.ProjectVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<style>
.container {
	width: fit-content;
	height: fit-content;
	margin: 0 auto;
	margin-top: 150px;
}
</style>
<title>하루일감: 상세정보</title>

</head>
<body>
	<%ProjectVO item = (ProjectVO) session.getAttribute("projectVO");%>
	<div class="container">
		<h1>상세정보</h1>
		<table class="table table-hover">
			<tr>
				<td>일감</td>
				<td><%=item.getProjectName()%></td>
			</tr>
			<tr>
				<td>업종분류</td>
				<td><%=item.getProjectSubject()%></td>
			</tr>
			<tr>
				<td>시작 일 ~ 마감 일</td>
				<td><%=item.getProjectStartDate()%> ~ <%=item.getProjectEndDate()%></td>
			</tr>
			<tr>
				<td>시작 시간 ~ 마감 시간</td>
				<td><%=item.getWorkStartTime()%> ~ <%=item.getWorkEndTime()%></td>
			</tr>
			<tr>
				<td>상세내용</td>
				<td><%=item.getProjectComment()%></td>
			</tr>

			<td>근무 장소</td>
			<td><label for="locationLabel">근무 장소</label>
				<div id="map" style="width: 450px; height: 350px;"></div>
				
				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=41450346a0e0a698000d753728111084"></script>
				<script>

                        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                        mapOption = { 
                            center: new daum.maps.LatLng(<%=item.getProjectLat()%>, <%=item.getProjectLng()%>), // 지도의 중심좌표
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

                        </script> <input type="hidden" id="projectLat"
				name="projectLat"> <input type="hidden" id="projectLng"
				name="projectLng"></td>

			</tr>

		</table>
	</div>
</body>
</html>