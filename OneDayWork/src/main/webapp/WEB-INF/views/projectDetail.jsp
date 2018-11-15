<%@page import="com.lx.odw.vo.ProjectVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 제이쿼리 -->
<script src="resources/js/jquery-3.3.1.min.js"></script>
<!--부트스트랩 코드-->
<script src="resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- 카카오 맵 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=41450346a0e0a698000d753728111084"></script>
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
	<%ProjectVO item = (ProjectVO) request.getAttribute("prjDetail");%>
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
				<td>기간</td>
				<td><%=item.getProjectStartDate()%> ~ <%=item.getProjectEndDate()%></td>
			</tr>
			<tr>
				<td>근무시간</td>
				<td><%=item.getWorkStartTime()%> ~ <%=item.getWorkEndTime()%></td>
			</tr>
			<tr>
				<td>상세내용</td>
				<td><%=item.getProjectComment()%></td>
			</tr>
			<tr>
				<td>근무 장소</td>
				<td><label for="locationLabel">근무 장소</label>
					<div id="map" style="width: 450px; height: 350px;"></div>
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
                        </script> 
                        <input type="hidden" id="projectLat"
					name="projectLat"> <input type="hidden" id="projectLng"
					name="projectLng"></td>
			</tr>
			<tr>
				<td>
					<input type="button" class="btn btn-primary" type="button" value="신청관리">
					<input type="button" class="btn btn-primary" type="button" value="출결관리">
				</td>
			</tr>
		</table>
	</div>
	<script type="text/javascript"></script>
</body>
</html>