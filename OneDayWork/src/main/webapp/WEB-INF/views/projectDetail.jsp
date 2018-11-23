<%@page import="com.lx.odw.vo.JobVO"%>
<%@page import="com.lx.odw.vo.ProjectDetailVO"%>
<%@page import="com.lx.odw.vo.ProjectVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 카카오 맵 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=41450346a0e0a698000d753728111084"></script>
<style>
.container {
	width: fit-content;
	height: fit-content;
	margin: 0 auto;
	margin-top: 50px;
}
.title {text-align: center;}
.item {text-align: center;}
</style>
<title>하루일감: 상세정보</title>
</head>
<body>
	<%ProjectDetailVO detailVO = (ProjectDetailVO) request.getAttribute("prjDetail");
	ProjectVO item = detailVO.getProjectVO();
	List<JobVO> jobList = detailVO.getJobList();
	%>
	<div class="container">
		<h3 style="text-align: center;">상세정보</h3>
		<table class="table table-border">
			<tr class="row">
				<th class="col-sm-2 title">일감 이름</th>
				<td><%=item.getProjectName()%></td>
			</tr>
			<tr class="row">
				<th class="col-sm-2 title">일감 분류</th>
				<td><%=item.getProjectSubject()%></td>
			</tr>
			<tr class="row">
				<th class="col-sm-2 title">일감 기간</th>
				<td><%=item.getProjectStartDate()%> ~ <%=item.getProjectEndDate()%></td>
			</tr>
			<tr class="row">
				<th class="col-sm-2 title">근무 시간</th>
				<td><%=item.getWorkStartTime()%> ~ <%=item.getWorkEndTime()%></td>
			</tr>
			<tr class="row">
				<th class="col-sm-2 title">상세내용</th>
				<td><%=item.getProjectComment()%></td>
			</tr>
			<tr class="row">
				<th class="col-sm-2 title">요구사항</th>
				<td><%
					if(item.getRequestPicture()!=null)out.print("사진&nbsp;");
					if(item.getConstCertificate()!=null)out.print("건설안전교육이수증");
					 %>
			</tr>
			<tr class="row">
				<th class="col-sm-2 title">제공사항</th>
				<td><%
				if(item.getMorning()!=null)out.print("아침&nbsp;&nbsp;");
				if(item.getLaunch()!=null)out.print("점심&nbsp;&nbsp;");
				if(item.getEvening()!=null)out.print("저녁&nbsp;&nbsp;");
				if(item.getCommute()!=null)out.print("통근 차량&nbsp;&nbsp;");
				if(item.getOffWork()!=null)out.print("퇴근 차량&nbsp;&nbsp;");
				%></td>
			</tr>
			<tr class="row">
				<th class="col-sm-2 title">일감 위치</th>
				<td>
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
			<tr class="row">
				<th class="col-sm-2 title">모집 직군</th>
				<td>
					<table class="table table-hover">
						<thead>
							<tr class="row">
								<th class="col-sm-1">#</th>
								<th class="col-sm-2">직군 이름</th>
								<th class="col-sm-3">모집 기간</th>
								<th class="col-sm-2">모집 정원</th>
								<th class="col-sm-2">요구 자격</th>
								<th class="col-sm-2"></th>
							</tr>
						</thead>
						<tbody>
						<%for(int i = 0 ; i < jobList.size(); i ++) {%>
							<tr class="row">
								<td class="col-sm-1 item"><%=i+1%></td>
								<td class="col-sm-2 item"><%=jobList.get(i).getJobName()%></td>
								<td class="col-sm-3 item"><%=jobList.get(i).getJobStartDate()+jobList.get(i).getJobEndDate()%></th>
								<td class="col-sm-2 item"><%=jobList.get(i).getJobLimitCount()%></td>
								<td class="col-sm-2 item"><%=jobList.get(i).getJobRequirement()%></td>
								<td class="col-sm-2 item"><a class="btn btn-primary" href="seekerList.do?jobNumber=<%=jobList.get(i).getJobNumber()%>">신청관리</a></td>
							</tr>
						<%}%>
						</tbody>
					</table>
				</td>
			</tr>
			<tr class="row">
				<td>					
					<input type="button" class="btn btn-primary" type="button" value="인력관리">
				</td>
			</tr>
		</table>
	</div>
	<script type="text/javascript"></script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>