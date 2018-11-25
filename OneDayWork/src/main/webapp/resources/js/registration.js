//Registration.jsp
$(function(){
	console.log("onLoad 실행됨");
	$("#insertProject").on("click",insertProject);
	$('#showJobModalButton').on("click",settingSubject);
	$('#addJobButton').on("click",addJob);
	jQueryDatePickeSetting();
});
function insertProject(){
	console.log('insertProject이 실행됨');
	//프로젝트 이름
	var projectName= $('#projectName').val();
	//업종 분류
	var projectSubject= $('#projectSubject').val();
	//프로젝트 기간
	var projectStartDate= $('#projectStartDate').val();
	var projectEndDate= $('#projectEndDate').val();
	//근무 시간
	var workStartTime= $('#workStartTime').val();
	var workEndTime= $('#workEndTime').val();
	//신청 제약사항
	var constCertificate= $('#constCertificate').val();
	var requestPicture= $('#requestPicture').val();
	//제공사항
	var morning= $('#morning').val();
	var launch= $('#launch').val();
	var evening= $('#evening').val();
	var commute= $('#commute').val();
	var offWork= $('#offWork').val();
	//프로젝트 설명
	var projectComment= $('#projectComment').val();
	//근무 장소
	var projectLat = $('#projectLat').val();
	var projectLng = $('#projectLng').val();
	
	console.log('projectName : '+projectName);
	console.log('projectSubject : '+projectSubject);
	console.log('projectStartDate : '+projectStartDate);
	console.log('projectEndDate : '+projectEndDate);
	console.log('workStartTime : '+workStartTime);
	console.log('workEndTime : '+workEndTime);
	console.log('constCertificate : '+constCertificate);
	console.log('requestPicture : '+requestPicture);
	console.log('morning : '+morning);
	console.log('launch : '+launch);
	console.log('evening : '+evening);
	console.log('commute : '+commute);
	console.log('offWork : '+offWork);
	console.log('projectComment : ' + projectComment);
	console.log('clickLatlng : '+projectLat + ", "+projectLng);
	console.log(jobs);
	var jobsStr = JSON.stringify(jobs);
	console.log('jobsStr : ' +jobsStr);
	$.ajax({
		url:'insertProject.do',
		method:'post',
		data:{projectName:projectName,
			projectSubject:projectSubject,
			projectStartDate:projectStartDate,
			projectEndDate:projectEndDate,
			workStartTime:workStartTime,
			workEndTime:workEndTime,
			constCertificate:constCertificate,
			requestPicture:requestPicture,
			morning:morning,
			launch:launch,
			evening:evening,
			commute:commute,
			offWork:offWork,
			projectLat:projectLat,
			projectLng:projectLng,
			projectComment:projectComment,
			jobs:jobsStr},
		success:function(data){
			console.log(data);
			if(data != null) {
				console.log("성공함");
				alert("일감이 성공적으로 등록되었습니다");
				document.location.href = "/projectList.do";
			}
		}
	});
}
//프로젝트 직군
var projectSubjects = new Array("","건설현장","토목","조선","공장","운송","식당","이벤트","청소","기타");
//직군 설정에 따라 jobName select 박스가 바뀐다
function settingSubject() {
	var projectSubject= $('#projectSubject').val();
	var projectStartDate = $('#projectStartDate').val();
	var projectEndDate = $('#projectEndDate').val();
	console.log(projectStartDate + " ~ " + projectEndDate);
	
	var setJobName = "";
	if(projectSubject == projectSubjects[0]){
		alert("먼저 업종 분류를 설정해야 합니다");
		return false;
	} else if(projectStartDate == ''){
		alert("일감 시작 날짜를 먼저 설정해야 합니다");
		return false;
	} else if(projectEndDate == ''){
		alert("일감 종료 날짜를 먼저 설정해야 합니다");
		return false;
	}else if(projectSubject == projectSubjects[1]){
		setJobName = `<select name="jobName" id="jobName" required>
			<option value="건설현장">건설현장</option>
			<option value="보통인부">보통인부</option>
			<option value="운반">운반</option>
			<option value="철거">철거</option>
			<option value="목수">목수</option>
			<option value="미장">미장</option>
			<option value="조적">조적</option>
			<option value="용접">용접</option>
			<option value="타일">타일</option>
			<option value="도장">도장</option>
			<option value="전기">전기</option>
			<option value="철근">철근</option>
			<option value="면갈이">면갈이</option> 
			</select>`;
	} else if(projectSubject == projectSubjects[2]){
		setJobName = `<select name="jobName" id="jobName" required>
			<option value="보통인부">보통인부</option>
			<option value="경계석">경계석</option>
			<option value="보도블록">보도블록</option>
			<option value="배관공">배관공</option>
			<option value="포장공">포장공</option>
			</select>`;
	}else if(projectSubject == projectSubjects[3]){
		setJobName = `<select name="jobName" id="jobName" required>
			<option value="조선">조선</option>
			<option value="배관">배관</option>
			<option value="배선">배선</option>
			<option value="취부">취부</option>
			<option value="용접">용접</option>
			<option value="닥트">닥트</option>
			<option value="기공">기공</option>
			<option value="조공">조공</option>
			<option value="칸막이">칸막이</option>
			<option value="족장">족장</option>
			<option value="도배">도배</option>
			<option value="단순노무">단순노무</option>
			<option value="기타">기타</option>
			</select>`;
	}else if(projectSubject == projectSubjects[4]){
		setJobName = `<select name="jobName" id="jobName" required>
			<option value="공장">공장</option>
			<option value="기타">기타</option>
			</select>`;
	}else if(projectSubject == projectSubjects[5]){
		setJobName = `<select name="jobName" id="jobName" required>
			<option value="운송">운송</option>
			<option value="지게차"></option>
			<option value="배반차"></option>
			<option value="1톤 화물차"></option>
			<option value="2.5톤 화물차"></option>
			<option value="3.5톤 화물차"></option>
			<option value="기타">기타</option>
			</select>`;
	}else if(projectSubject == projectSubjects[6]){
		setJobName = `<select name="jobName" id="jobName" required>
			<option value="식당">식당</option>
			<option value="배달원">배달원</option>
			<option value="홀서빙">홀서빙</option>
			<option value="주방">주방</option>
			<option value="기타">기타</option>
			</select>`;
	}else if(projectSubject == projectSubjects[7]){
		setJobName = `<select name="jobName" id="jobName" required>
			<option value="이벤트">이벤트</option>
			<option value="기타">기타</option>
			</select>`;
	}else if(projectSubject == projectSubjects[8]){
		setJobName = `<select name="jobName" id="jobName" required>
			<option value="청소">청소</option>
			<option value="운반">운반</option>
			<option value="기타">기타</option>
			</select>`;
	}else if(projectSubject == projectSubjects[9]){
		setJobName = `<select name="jobName" id="jobName" required>
			<option value="기타">기타</option>
			</select>`;
	}

	$('#jobSubject').html(setJobName);
	return true;
}
//j-Query의 DatePicker 세팅
function jQueryDatePickeSetting(){
	$( "#projectStartDate" ).datepicker({ minDate: 0,dateFormat: 'yy-mm-dd',
		onClose:function(selectedDate){
			$( "#projectEndDate" ).datepicker("option","minDate",selectedDate);
			$( "#jobStartDate" ).datepicker("option","minDate",selectedDate);
		}});
	$( "#projectEndDate" ).datepicker({ minDate: 0,dateFormat: 'yy-mm-dd',
		onClose:function(selectedDate){
			$( "#jobStartDate" ).datepicker("option","maxDate",selectedDate);
			$( "#jobEndDate" ).datepicker("option","maxDate",selectedDate);
		}});
	$( "#jobStartDate" ).datepicker({ minDate: 0,dateFormat: 'yy-mm-dd',
		onClose:function(selectedDate){
			$( "#jobEndDate" ).datepicker("option","minDate",selectedDate);
		}});
	
	$( "#jobEndDate" ).datepicker({ minDate: 0,dateFormat: 'yy-mm-dd'});
}
//요구 직군 목록 배열
var jobs = new Array();
//직업 추가하기
function addJob(){
	var jobName = $('#jobName').val();
	var jobPay = $('#jobPay').val();
	var jobLimitCount = $('#jobLimitCount').val();
	var jobStartDate = $('#jobStartDate').val();
	var jobEndDate = $('#jobEndDate').val();
	var jobRequirement = $('#jobRequirement').val();

	var b = new Object();

	//날짜 계산
	var startDate = new Date(jobStartDate);
	var endDate = new Date(jobEndDate);
	var date = endDate.getDate() - startDate.getDate();
	console.log('날짜 차이 : ' + date);
	//요금 계산기하기
	var pay = date * jobLimitCount * jobPay;
	console.log('요금 : ' + pay);

	//갖고 온 값으로 부터 job 객체 생성
	b = {
			jobName : jobName,
			jobPay : jobPay,
			jobLimitCount : jobLimitCount,
			jobStartDate : jobStartDate,
			jobEndDate : jobEndDate,
			jobRequirement : jobRequirement,
			pay : pay
	}

	//배열에 객체를 집어 넣음
	jobs.push(b);

	//로그 확인
	console.log(b);
	console.log(jobs);

	//객체를 출력하기
	printJobArray(jobs);
}

//객체를 출력하기
function printJobArray(jobs) {

	var buffer = '';
	for(var i = 0 ; i < jobs.length ; i ++) {
		buffer += `<tr class="row">
			<th class="col-sm-1">`+(i+1)+`</th>
			<th class="col-sm-2">`+jobs[i].jobName+`</th>
			<th class="col-sm-2">`+numberWithCommas(jobs[i].jobPay)+`원</th>
			<th class="col-sm-1">`+jobs[i].jobLimitCount+`</th>
			<th class="col-sm-2">`+jobs[i].jobStartDate+' ~ '+jobs[i].jobEndDate+`</th>
			<th class="col-sm-2">`+jobs[i].jobRequirement+`</th>
			<th class="col-sm-2">`+numberWithCommas(jobs[i].pay)+`원</th>
			</tr>`;
	}

	$('#jobListOutput').html(buffer);
}

//숫자 콤마 찍어주기
function numberWithCommas(num) {
	var len, point, str; 

	num = num + ""; 
	point = num.length % 3 ;
	len = num.length; 

	str = num.substring(0, point); 
	while (point < len) { 
		if (str != "") str += ","; 
		str += num.substring(point, point + 3); 
		point += 3; 
	} 

	return str;
}

//Daum Map
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = { 
	center: new daum.maps.LatLng(37.5161487, 127.0348843), // 지도의 중심좌표
	level: 4 // 지도의 확대 레벨
};

var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new daum.maps.MapTypeControl();

//지도에 컨트롤을 추가해야 지도위에 표시됩니다
//daum.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT);

//지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new daum.maps.ZoomControl();
map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);
//지도를 클릭한 위치에 표출할 마커입니다
var marker = new daum.maps.Marker({ 
	// 지도 중심좌표에 마커를 생성합니다 
	position: map.getCenter() 
}); 
//지도에 마커를 표시합니다
marker.setMap(map);

//지도에 클릭 이벤트를 등록합니다
//지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
daum.maps.event.addListener(map, 'click', function(mouseEvent) {        
	// 클릭한 위도, 경도 정보를 가져옵니다 
	var latlng = mouseEvent.latLng; 
	// 마커 위치를 클릭한 위치로 옮깁니다
	marker.setPosition(latlng);
	var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
	message += '경도는 ' + latlng.getLng() + ' 입니다';
	$('#projectLat').attr("value",latlng.getLat());
	$('#projectLng').attr("value",latlng.getLng());
	var resultDiv = document.getElementById('clickLatlng'); 
	resultDiv.innerHTML = message;

});	
//end Daum Map