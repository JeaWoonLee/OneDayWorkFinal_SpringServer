<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Date"%>
<%@page import="com.lx.odw.vo.JobCandidateVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.lx.odw.model.CandidateMapResponseModel"%>
<%@page import="com.lx.odw.vo.SeekerVO"%>
<%@page import="java.util.List"%>
<%@page import="com.lx.odw.vo.ProjectVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 카카오 맵 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=41450346a0e0a698000d753728111084"></script>
<style>
#map-container{text-align: center;}
#map{display: inline-block;}
th{color:black; font-size : 20px; font-style: inherit; text-align: center;}
span{color:black; font-size : 20px; font-style: inherit; text-align: center;}
</style>
<title>하루일감: 신청 관리</title>

</head>
<body>
<%
CandidateMapResponseModel candidateModel = (CandidateMapResponseModel) request.getAttribute("seekerList");
HashMap<String,List<JobCandidateVO>> map = candidateModel.getResult();
List<JobCandidateVO> headerList = candidateModel.getTargetDateList();
String targetDate = "";
ArrayList<JobCandidateVO> sortedHeaderList = new ArrayList<JobCandidateVO>();
ArrayList<String> targetDateList = new ArrayList<String>();
for (JobCandidateVO item : headerList) {
    if (!targetDateList.contains(item.getTargetDate())) {
        targetDateList.add(item.getTargetDate());
        sortedHeaderList.add(item);
    }
}

%><!-- 요청해서 받은 empList를 list에 담는다. -->
			
	<div class="container">
	<h3 style="text-align: center;">신청관리</h3>
			<table class="table table-striped">
			<%for(JobCandidateVO header : sortedHeaderList) {
				if(targetDate == header.getTargetDate()){
					break;
				}else {
					targetDate = header.getTargetDate();
				}
				%>
				<tr class="row">
					<th class="col-sm-2">
						<%=header.getTargetDate()%><br>
						<%="구인현황<br> ( " + header.getRecruit() + " / " + header.getJobLimitCount() + " )" %>
					</th>
					<td class="col-sm-10">
						<table class="table table-hover">
						<%List<JobCandidateVO> list = map.get(header.getTargetDate());
						List<JobCandidateVO> sortedItemList = new ArrayList<JobCandidateVO>();
						List<String> seekerNameList = new ArrayList<String>();
						for(JobCandidateVO item : list) {
							if(!seekerNameList.contains(item.getSeekerId())){
								seekerNameList.add(item.getSeekerId());
								sortedItemList.add(item);
							}
						}
						for(JobCandidateVO item : sortedItemList) {%>
							<tr class="row">
								<td class="col-sm-1"><%=item.getSeekerId()%></td>
								<td class="col-sm-1"><%=item.getSeekerSex()%></td>
								<td class="col-sm-1"><%
								Date date = Date.valueOf(item.getSeekerBirth());
				                Calendar today = Calendar.getInstance();
				                Calendar seekerCalendar = Calendar.getInstance();
				                seekerCalendar.setTime(date);
				                int todayYear = today.get(Calendar.YEAR);
				                int seekerYear = seekerCalendar.get(Calendar.YEAR);
				                int old = todayYear - seekerYear + 1;
									out.print(old);%></td>
								<td class="col-sm-3"><%="신뢰도 "+(int)(((double)item.getOffWork()/(double)item.getTotal())*100)+"% ("+item.getOffWork()+"/"+item.getTotal()+")"%></td>
								<td class="col-sm-1"><a href="#" id="showCandidateDetail" class="btn btn-primary btn-sm" onclick='showCandidateDetail("<%=item.getSeekerId()%>")' data-toggle="modal" data-target="#seekerDetailModal">상세정보</a></td>
								<td class="col-sm-1"><a href="#" onClick='refuseCandidate("<%=item.getCandidateNumber()%>")' class="btn btn-danger btn-sm">신청 거절</a></td>
								<td class="col-sm-1"><a href="#" onClick='acceptCandidate("<%=item.getCandidateNumber()%>")' class="btn btn-success btn-sm">신청 수락</a></td>
							</tr>
						<% }%>
						</table>
					</td>
				</tr>
			<%}%>
			</table>
	</div>
	<!-- 상세정보 모달창-->
  	<div class="modal fade" id="seekerDetailModal" role="dialog">
    	<div class="modal-dialog">
    
      		<!-- Modal content-->
      		<div class="modal-content">
        		<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal">×</button>
          	 		<h4 class="modal-title">구직자 상세정보</h4>
        		</div>
        		<div class="modal-body">
        			<span><strong>기본정보</strong></span>
          			<table class="table table-boder">
          				<tr class="row">
          					<td class="col-sm-1"></td>
          					<th class="col-sm-3">아이디</th>
          					<td class="col-sm-7" id="seekerIdOutput"></td>
          					<td class="col-sm-1"></td>
          				</tr>
          				<tr class="row">
          					<td class="col-sm-1"></td>
          					<th class="col-sm-3">이름</th>
          					<td class="col-sm-7" id="seekerNameOutput"></td>
          					<td class="col-sm-1"></td>
          				</tr>
          				<tr class="row">
          					<td class="col-sm-1"></td>
          					<th class="col-sm-3">성별</th>
          					<td class="col-sm-7" id="seekerSexOutput"></td>
          					<td class="col-sm-1"></td>
          				</tr>
          				<tr class="row">
          					<td class="col-sm-1"></td>
          					<th class="col-sm-3">생년월일</th>
          					<td class="col-sm-7" id="seekerBirthOutput"></td>
          					<td class="col-sm-1"></td>
          				</tr>
          				<tr class="row">
          					<td class="col-sm-1"></td>
          					<th class="col-sm-3">이메일</th>
          					<td class="col-sm-7" id="seekerEmailOutput"></td>
          					<td class="col-sm-1"></td>
          				</tr>
          				<tr class="row">
          					<td class="col-sm-1"></td>
          					<th class="col-sm-3">소개글</th>
          					<td class="col-sm-7" id="seekerInfoOutput"></td>
          					<td class="col-sm-1"></td>
          				</tr>
          			</table>
          			<span><strong>이력정보</strong></span>&nbsp;&nbsp;&nbsp;<span id="seekerReliability"></span>
          			<table class="table table-hover">
          				<tbody id="recordOutput"></tbody>
          			</table>
          			<span><strong>자격 및 경력 정보</strong></span>
          			<table class="table table-hover">
          				<tbody id="certificateOutput"></tbody>
          			</table>
          			<span><strong>활동 위치&nbsp;&nbsp;</strong></span><input class="btn btn-primary" id="openButton" type="button" value="펼치기" onclick="relayout()">
          			<table class="table">
          				<tr class="row">
          					<td class="col-sm-12" id="map-container">
          						<div id="map"></div>
          					</td>
          				</tr>
          			</table>
          			
          			<span><strong>사진 정보</strong></span>
          			<div id="seekerPictureOutput"></div>
          			
        		</div>
        		<div class="modal-footer">
        			<button type="button" class="btn btn-primary" data-dismiss="modal">닫기</button>
        		</div>
      		</div>
		</div>
	</div>
	<!-- //end 상세정보 모달창-->
<!-- 상세정보 스크립트 -->
<script type="text/javascript">
var map;
var mapContainer;
var Lat;
var Lng;
function acceptCandidate (candidateNumber){
	$.ajax({
		url : "requestAcceptCandidateByCandidateNumber.do",
		method : "post",
		data : {candidateNumber:candidateNumber},
		success : function(data) {
			if(data == 1) {
				window.location.reload();
			}else {
				console.log('수락실패');
			}
		}
	});
}
function refuseCandidate(candidateNumber){
	console.log('refuseCandidate : ' + candidateNumber);
	$.ajax({
		url : "requestRefuseCandidateByCandidateNumber.do",
		method : "post",
		data : {candidateNumber:candidateNumber},
		success : function(data) {
			if(data == 1) {
				window.location.reload();
			}else{
				console.log('거절실패');
			}
		}
	});
}
function showCandidateDetail(seekerId) {
	var seekerId = seekerId;
	console.log(seekerId);
	$.ajax({
		url:'requestSeekerDetailPopup.do',
		method:'post',
		data:{seekerId:seekerId},
		success:function(data){
			var seekerVO = data.seekerVO;
			setSeekerDetailInfo(seekerVO);
			var record = data.record;
			setSeekerRecordList(record);
			var certificate = data.certificate;
			setCertificateList(certificate);
			}
	});
}
//기본 정보 처리
function  setSeekerDetailInfo (seekerVO){
	$('#map').css({height : 0});
	console.log('seekerVO');
	console.log(seekerVO);
	$('#seekerIdOutput').html(seekerVO.seekerId);
	$('#seekerNameOutput').html(seekerVO.seekerName);
	$('#seekerSexOutput').html(seekerVO.seekerSex);
	$('#seekerBirthOutput').html(seekerVO.seekerBirth);
	$('#seekerEmailOutput').html(seekerVO.seekerEmail);
	$('#seekerInfoOutput').html(seekerVO.seekerInfo);
	//지도정보 처리
	if (seekerVO.seekerLatitude == 0 && seekerVO.seekerLongitude == 0) {
		$('#openButton').hide();
		shrinkLayout();
		$('#map').html(`<span>위치정보를 등록하지 않았습니다.</span>`);
	} else if(seekerVO.openLocationInfo != '공개') {
		$('#openButton').hide();
		shrinkLayout();
		$('#map').html(`<span>위치정보를 공개하지 않았습니다.</span>`);
	} else {
		$('#openButton').show();
		showDaumMap(seekerVO.seekerLatitude,seekerVO.seekerLongitude);
	}
	//사진 정보 처리
	if (seekerVO.seekerPicture == null) {
		$('#seekerPictureOutput').html(`<span>사진정보를 등록하지 않았습니다.</span>`);
	} else if(seekerVO.openPictureInfo != '공개') {
		$('#seekerPictureOutput').html(`<span>사진정보를 공개하지 않았습니다.</span>`);
	} else {
		$('#seekerPictureOutput').html(`<img src=`+seekerVO.seekerPicture+` width=300 height=300 style="transform:rotate(90deg);">`);
	}
}
//다음 맵 해당 좌표에 마커를 찍어주고 보여줌
function showDaumMap(lat,lng) {
	Lat = lat;
	Lng = lng;
	mapContainer = document.getElementById('map'); // 지도를 표시할 div 
	var mapOption = { 
        center: new daum.maps.LatLng(lat, lng), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };
    map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
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
}
function shrinkLayout(){
	mapContainer.style.width = '0x';
    mapContainer.style.height = '0px';
}
function relayout(){
	mapContainer.style.width = '500px';
    mapContainer.style.height = '500px';
    map.relayout();
    map.setCenter(new daum.maps.LatLng(Lat, Lng));
}
//이력 정보 처리
function  setSeekerRecordList (record){
	console.log('record');
	console.log(record);
	if(record != null) {
		var table = '';
		//정상퇴근 횟수 - 신뢰도 계산
		var offWorkCount = 0.0;
		for(var i = 0 ; i < record.length ; i ++ ) {
			//신뢰도 계산
			var candidateStatus = record[i].candidateStatus;
			if(candidateStatus == 4) offWorkCount ++;
			
			//이력 정보(candidateStatus) 처리
			var candidateStatus = '';
			switch (record[i].candidateStatus) {
				case 4:
					candidateStatus = '<font color="blue">퇴근</font>';
					break;
				case 5:
					candidateStatus = '<font color="red">무단이탈</font>';
					break;
				case 6:
					candidateStatus = '<font color="red">결근</font>';
					break;
			}
			//평가점수(score) 처리
			var score = '';
			if(record[i].score != null) {
				score = record[i].score;
			}
			//출력 문자열 만들기
			table += `<tr class="row">`+
						`<td class="col-sm-3">`+record[i].jobName+`</td>`+
						`<td class="col-sm-4">`+record[i].targetDate+`</td>`+
						`<td class="col-sm-2">`+score+`</td>`+
						`<td class="col-sm-2">`+candidateStatus+`</td>`+
					 `</tr>`;
		}
		
		//신뢰도 출력
		var reliability = ( offWorkCount / record.length ) * 100;
		var recordStr = "신뢰도 : " + parseInt(reliability) + "% (" + offWorkCount + " / " + record.length + " )";
		$('#seekerReliability').html(recordStr);
		
		//테이블 출력
		$('#recordOutput').html(table);
		
	}
}

//자격 정보 처리
function  setCertificateList (certificate){
	console.log('certificate');
	console.log(certificate);
	if(certificate != null) {
		var table = '';
		for(var i = 0 ; i < certificate.length ; i ++ ){
			table += 
				`<tr class="row">`+
					`<td class="col-sm-4">`+certificate[i].certificateName +`</td>`+
					`<td class="col-sm-4">`+certificate[i].seekerCertificateNumber +`</td>`+
				`</tr>`;
		}
		$('#certificateOutput').html(table);
	}
}
</script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>