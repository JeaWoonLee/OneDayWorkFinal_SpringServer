<%@page import="java.util.ArrayList"%>
<%@page import="com.lx.odw.vo.JobCandidateVO"%>
<%@page import="java.util.Map"%>
<%@page import="com.lx.odw.vo.JobVO"%>
<%@page import="java.util.List"%>
<%@page import="com.lx.odw.vo.OfferWorkVO"%>
<%@page import="com.lx.odw.vo.CommuteInfoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<%CommuteInfoVO vo = (CommuteInfoVO) request.getAttribute("CommuteInfoVO");
String projectName = (String) request.getAttribute("projectName");
OfferWorkVO offerWorkVO = vo.getOfferWorkVO();
List<JobVO> jobList = vo.getJobList();
Map<Integer,List<JobCandidateVO>> candidateMap = vo.getCandidateMap();
//각 근무 상태별 근로자
ArrayList<JobCandidateVO> offWorkList = new ArrayList<JobCandidateVO>();
ArrayList<JobCandidateVO> workingList = new ArrayList<JobCandidateVO>();
ArrayList<JobCandidateVO> commuteList = new ArrayList<JobCandidateVO>();
ArrayList<JobCandidateVO> notCommuteList = new ArrayList<JobCandidateVO>();
ArrayList<JobCandidateVO> absentList = new ArrayList<JobCandidateVO>();
ArrayList<JobCandidateVO> runList = new ArrayList<JobCandidateVO>();

//하나의 job 마다 jobName, jobLimitCount, attendance, recruit 를 구하자
for (JobVO jobVO : jobList){
    List<JobCandidateVO> candidateList = candidateMap.get(jobVO.getJobNumber());
    //구인 된 인원을 jobPay 에 임시로 넣어둠
    assert candidateList != null;
    jobVO.setJobPay(candidateList.size());
    int attendanceCount = 0;
    for (JobCandidateVO jobCandidateVO : candidateList) {
        //1 수락(미출근) / 2 출근 / 3 근무중 / 4 퇴근 / 5 무단이탈 / 6 결근
        //수락과 결근을 제외한 인원들의 숫자를 센다
        int candidateStatus = jobCandidateVO.getCandidateStatus();

        if (candidateStatus>=1 && candidateStatus <= 6) {
            attendanceCount ++;
        }
        //각 근무 상태의 인원들을 분류/ 정렬한다
        if (candidateStatus == 1) notCommuteList.add(jobCandidateVO);
        else if (candidateStatus == 2) commuteList.add(jobCandidateVO);
        else if (candidateStatus == 3) workingList.add(jobCandidateVO);
        else if (candidateStatus == 4) offWorkList.add(jobCandidateVO);
        else if (candidateStatus == 5) runList.add(jobCandidateVO);
        else if (candidateStatus == 6) absentList.add(jobCandidateVO);
    }
    //출근 인원을 jobNumber 에 임시로 담는다
    jobVO.setJobNumber(attendanceCount);
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
td{vertical-align: middle;}
.starR1{
    background: url('resources/img/ico_review.png') no-repeat -52px 0;
    background-size: auto 100%;
    width: 15px;
    height: 30px;
    float:left;
    text-indent: -9999px;
    cursor: pointer;
}
.starR2{
    background: url('resources/img/ico_review.png') no-repeat right 0;
    background-size: auto 100%;
    width: 15px;
    height: 30px;
    float:left;
    text-indent: -9999px;
    cursor: pointer;
}
.starR1.on{background-position:0 0;}
.starR2.on{background-position:-15px 0;}
.starRev{margin-bottom: 50px;margin-left: 30px;}
#evaluate{width: 300px ; height: 215px;}
.center{margin-left: auto; margin-right: auto;text-align: center;display: inherit;}
th{color:black;font-size:20px;font-weight: bold;}
.modal-title{color:white;font-size:30px;font-weight: bold;}
p{color:black;font-size:25px;font-weight: bold;}
h1{font-weight: bold;}
</style>
<!-- 카카오 맵 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=41450346a0e0a698000d753728111084"></script>
<title><%=projectName%></title>
</head>
<body>
	<div class="container">
		<h1 class="text-center"><%=projectName%></h1>
		<!-- 기본정보 -->
		<table class="table table-boder" id="basic-info">
			<tr class="row">
				<td class="col-sm-1"></td>
				<td class="col-sm-3">모집률</td>
				<td class="col-sm-7"><%="( "+offerWorkVO.getRecruit() + " / " + offerWorkVO.getTotal()+" )" %></td>
				<td class="col-sm-1"></td>
			</tr>
			<tr class="row">
				<td class="col-sm-1"></td>
				<td class="col-sm-3">출석률</td>
				<td class="col-sm-7"><%="( "+offerWorkVO.getCommute() + " / " +offerWorkVO.getRecruit() +" )"%></td>
				<td class="col-sm-1"></td>
			</tr>
			<tr class="row">
				<td class="col-sm-1"></td>
				<td class="col-sm-3">근무시간</td>
				<td class="col-sm-7"><%=offerWorkVO.getWorkStartTime() + " - " + offerWorkVO.getWorkEndTime()%></td>
				<td class="col-sm-1"></td>
			</tr>
			<tr class="row">
				<td class="col-sm-1"></td>
				<td class="col-sm-3">직종별 출석 현황</td>
				<td class="col-sm-7" id="basic-info">
					<table class="table table-hover" id="basic-info">
						<%for(JobVO jobVO : jobList){
							 //구인된 인원(Recruit) 은 jobPay 에서 꺼내온다
            				int recruit = jobVO.getJobPay();
            				//출근 인원(Attendance) 을 jobNumber 에서 꺼낸다
            				int attendance = jobVO.getJobNumber();%>
							<tr class="row" id="basic-info">
								<td class="col-sm-3"><%=jobVO.getJobName()%></td>
								<td class="col-sm-4"><%="모집 인원 ( " + recruit + " / " + jobVO.getJobLimitCount() + " )"%></td>
								<td class="col-sm-4"><%="출석률 ( " + attendance + " / " + recruit + " )"%></td>
							</tr>
						<%} %>
					</table>
				</td>
				<td class="col-sm-1"></td>
			</tr>
		</table>
		<!-- //end 기본정보 -->
		
		<!-- 퇴근자 인원 목록 -->
		<h5 class="text-center">[퇴근자 인원 목록]</h5>
		<table class="table table-hover alert alert-success">
			<%for(JobCandidateVO item :offWorkList){ %>
				<tr class="row">
					<td class="col-sm-2"><%=item.getJobName()%></td>
					<td class="col-sm-2"><%=item.getSeekerName()%></td>
					<td class="col-sm-1"></td>
					<td class="col-sm-2"><input class="btn btn-warning btn-lg" onclick='showCandidateDetail("<%=item.getSeekerId()%>")' type="button" value="정보" data-toggle="modal" data-target="#seekerDetailModal"></td>
					<%if(item.getEvaluate()==null){ %>
					<td class="col-sm-2"><input class="btn btn-lg btn-info" type="button" value="평가" data-toggle="modal" data-target="#seekerEvaluateModal" onclick="evaluating(<%=item.getCandidateNumber()%>)"></td>
					<%} else{%>
					<td class="col-sm-2"></td>
					<%} %>
					<td class="col-sm-2"><input class="btn btn-lg btn-info" type="button" value="근로계약서" onclick="showContract(<%=item.getCandidateNumber()%>)"></td>
				</tr>
			<%} %>
		</table>
		<!-- //end 퇴근자 인원 목록 -->
		
		<!-- 근무중 인원 목록 -->
		<h5 class="text-center">[근무중 인원 목록]</h5>
		<table class="table table-hover alert alert-success">
			<%for(JobCandidateVO item :workingList){ %>
				<tr class="row">
					<td class="col-sm-2"><%=item.getJobName()%></td>
					<td class="col-sm-2"><%=item.getSeekerName()%></td>
					<td class="col-sm-1"></td>
					<td class="col-sm-2"><input class="btn btn-warning btn-lg" onclick='showCandidateDetail("<%=item.getSeekerId()%>")' type="button" value="정보" data-toggle="modal" data-target="#seekerDetailModal"></td>
					<td class="col-sm-2"><input class="btn btn-lg btn-info" type="button" value="퇴근" onclick="offWork(<%=item.getCandidateNumber()%>)"></td>
					<td class="col-sm-2"><input class="btn btn-lg btn-info" type="button" value="근로계약서" onclick="showContract(<%=item.getCandidateNumber()%>)"></td>				
				</tr>
			<%} %>
		</table>
		<!-- //end 근무중 인원 목록 -->
		
		<!-- 출근 인원 목록 -->
		<h5 class="text-center">[출근 인원 목록]</h5>
		<table class="table table-hover alert alert-success">
			<%for(JobCandidateVO item :commuteList){ %>
				<tr class="row">
					<td class="col-sm-2"><%=item.getJobName()%></td>
					<td class="col-sm-2"><%=item.getSeekerName()%></td>
					<td class="col-sm-1"></td>
					<td class="col-sm-2"><input class="btn btn-warning btn-lg" onclick='showCandidateDetail("<%=item.getSeekerId()%>")' type="button" value="정보" data-toggle="modal" data-target="#seekerDetailModal"></td>
					<td class="col-sm-2"><input class="btn btn-lg btn-info" type="button" value="출근 확인" onclick="working(<%=item.getCandidateNumber()%>)"></td>
					<td class="col-sm-2"></td>
				</tr>
			<%} %>
		</table>
		<!-- //end 출근 인원 목록 -->
		
		<!-- 미출근 인원 목록 -->
		<h5 class="text-center">[미출근 인원 목록]</h5>
		<table class="table table-hover alert alert-success">
			<%for(JobCandidateVO item :notCommuteList){ %>
				<tr class="row">
					<td class="col-sm-2"><%=item.getJobName()%></td>
					<td class="col-sm-2"><%=item.getSeekerName()%></td>
					<td class="col-sm-1"></td>
					<td class="col-sm-2"><input class="btn btn-warning btn-lg" onclick='showCandidateDetail("<%=item.getSeekerId()%>")' type="button" value="정보" data-toggle="modal" data-target="#seekerDetailModal"></td>
					<td class="col-sm-2"><input class="btn btn-lg btn-info" type="button" value="결근" onclick="absent(<%=item.getCandidateNumber()%>)"></td>
					<td class="col-sm-2"></td>
				</tr>
			<%} %>
		</table>
		<!-- //end 미출근 인원 목록 -->
		
		<!-- 결근 인원 목록 -->
		<h5 class="text-center">[결근 인원 목록]</h5>
		<table class="table table-hover alert alert-success">
			<%for(JobCandidateVO item :absentList){ %>
				<tr class="row">
					<td class="col-sm-2"><%=item.getJobName()%></td>
					<td class="col-sm-2"><%=item.getSeekerName()%></td>
					<td class="col-sm-1"></td>
					<td class="col-sm-2"><input class="btn btn-warning btn-lg" onclick='showCandidateDetail("<%=item.getSeekerId()%>")' type="button" value="정보" data-toggle="modal" data-target="#seekerDetailModal"></td>
					<td class="col-sm-2"></td>
					<td class="col-sm-2"></td>
				</tr>
			<%} %>
		</table>
		<!-- //end 결근 인원 목록 -->
		
		<!-- 무단 이탈 인원 목록 -->
		<h5 class="text-center">[무단이탈 인원 목록]</h5>
		<table class="table table-hover alert alert-success">
			<%for(JobCandidateVO item :runList){ %>
				<tr class="row">
					<td class="col-sm-2"><%=item.getJobName()%></td>
					<td class="col-sm-2"><%=item.getSeekerName()%></td>
					<td class="col-sm-1"></td>
					<td class="col-sm-2"><input class="btn btn-warning btn-lg" onclick='showCandidateDetail("<%=item.getSeekerId()%>")' type="button" value="정보" data-toggle="modal" data-target="#seekerDetailModal"></td>
					<td class="col-sm-2"></td>
					<td class="col-sm-2"></td>
				</tr>
			<%} %>
		</table>
		<!-- //end 무단 이탈 인원 목록 -->
	</div>

	<!-- 상세정보 모달창-->
  	<div class="modal fade" id="seekerDetailModal" role="dialog">
    	<div class="modal-dialog">
      		<!-- Modal content-->
      		<div class="modal-content">
        		<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal">×</button>
          	 		<h5 class="modal-title">구직자 상세정보</h5>
        		</div>
        		<div class="modal-body">
        			<p><strong>기본정보</strong></p>
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
          			<p><strong>이력정보</strong></span>&nbsp;&nbsp;&nbsp;<span id="seekerReliability"></p>
          			<table class="table table-hover">
          				<tbody id="recordOutput"></tbody>
          			</table>
          			<p><strong>자격 및 경력 정보</strong></p>
          			<table class="table table-hover">
          				<tbody id="certificateOutput"></tbody>
          			</table>
          			<p><strong>활동 위치&nbsp;&nbsp;</strong></p>
          			<input class="btn btn-lg btn-info" id="openButton" type="button" value="펼치기" onclick="relayout()">
          			<table class="table">
          				<tr class="row">
          					<td class="col-sm-12" id="map-container">
          						<div id="map"></div>
          					</td>
          				</tr>
          			</table>
          			
          			<p><strong>사진 정보</strong></p>
          			<div id="seekerPictureOutput"></div>
          			
        		</div>
        		<div class="modal-footer">
        			<button type="button" class="btn btn-lg btn-info" data-dismiss="modal">닫기</button>
        		</div>
      		</div>
		</div>
	</div>
	<!-- //end 상세정보 모달창-->
<!-- 구직자 평가 모달창-->
  	<div class="modal fade" id="seekerEvaluateModal" role="dialog">
    	<div class="modal-dialog">
      		<!-- Modal content-->
      		<div class="modal-content">
        		<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal">×</button>
          	 		<h5 class="modal-title">구직자 평가</h5>
        		</div>
        		<div class="modal-body">
        			<!-- 별점 주기 -->
        			<h5>별점</h5>
					<div class="starRev">
  						<span class="starR1 on">별1_왼쪽</span>
  						<span class="starR2">별1_오른쪽</span>
  						<span class="starR1">별2_왼쪽</span>
  						<span class="starR2">별2_오른쪽</span>
  						<span class="starR1">별3_왼쪽</span>
  						<span class="starR2">별3_오른쪽</span>
  						<span class="starR1">별4_왼쪽</span>
  						<span class="starR2">별4_오른쪽</span>
  						<span class="starR1">별5_왼쪽</span>
  						<span class="starR2">별5_오른쪽</span>
					</div>
					<br>
					<h5>평가내용</h5>
					<div class="center">
						<textarea rows="10" cols="50" id="evaluteStr">
							
						</textarea>
					</div>
					
					<input type="hidden" id="canidateNumber">
        		</div>
        		<div class="modal-footer">
        			<button type="button" class="btn btn-lg btn-info" id="evaluateButton" data-dismiss="modal">평가하기</button>
        			<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        		</div>
      		</div>
		</div>
	</div>
	<!-- //end 구직자 평가 모달창-->
<script type="text/javascript">
//근로계약서
function showContract(candidateNumber) {
	document.location.href="report.do?candidateNumber="+candidateNumber;
}
//별점주기
var rating = 0.0;
$('.starRev span').click(function(){
  $(this).parent().children('span').removeClass('on');
  $(this).addClass('on').prevAll('span').addClass('on');
  rating = ($(this).parent().children('.on').length)/2;
  console.log(rating);
  return false;
});
function evaluating(candidateNumber){
	$('#canidateNumber').attr("value",candidateNumber);
}
$('#evaluateButton').click(function(){
	var score = parseInt(rating);
	var evaluate = $('#evaluteStr').val();
	var candidateNumber = $('#canidateNumber').val();
	
	$.ajax({
		url:'requestEvaluate.do',
		method:'post',
		data:{candidateNumber:candidateNumber,evaluate:evaluate,score:score},
		success:function(data){
			if(data == 1) {
				window.location.reload();
			}else {
				console.log('평가 실패');
			}
		}
	});
});
var map;
var mapContainer;
var Lat;
var Lng;
//퇴근
function offWork (candidateNumber){
	$.ajax({
		url : "requestOffWorkByCandidateNumber.do",
		method : "post",
		data : {candidateNumber:candidateNumber},
		success : function(data) {
			if(data == 1) {
				window.location.reload();
			}else {
				console.log('퇴근 처리 실패');
			}
		}
	});
}
//출근확인
function working (candidateNumber){
	$.ajax({
		url : "requestWorkingByCandidateNumber.do",
		method : "post",
		data : {candidateNumber:candidateNumber},
		success : function(data) {
			if(data == 1) {
				window.location.reload();
			}else {
				console.log('근무중 처리 실패');
			}
		}
	});
}

//결근
function absent (candidateNumber){
	$.ajax({
		url : "requestAbsentByCandidateNumber.do",
		method : "post",
		data : {candidateNumber:candidateNumber},
		success : function(data) {
			if(data == 1) {
				window.location.reload();
			}else {
				console.log('결근 처리 실패');
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
		$('#map').html(`<p>위치정보를 등록하지 않았습니다.</p>`);
	} else if(seekerVO.openLocationInfo != '공개') {
		$('#openButton').hide();
		shrinkLayout();
		$('#map').html(`<p>위치정보를 공개하지 않았습니다.</p>`);
	} else {
		$('#openButton').show();
		showDaumMap(seekerVO.seekerLatitude,seekerVO.seekerLongitude);
	}
	//사진 정보 처리
	if (seekerVO.seekerPicture == null) {
		$('#seekerPictureOutput').html(`<p>사진정보를 등록하지 않았습니다.</p>`);
	} else if(seekerVO.openPictureInfo != '공개') {
		$('#seekerPictureOutput').html(`<p>사진정보를 공개하지 않았습니다.</p>`);
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
</body>
</html>