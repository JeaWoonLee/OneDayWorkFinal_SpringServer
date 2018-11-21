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
<!-- 제이쿼리 날짜 선택기 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<style>
html, body {width: 100%;height: 100%;margin: 0px;padding: 0px;}
.navbarDiv {margin-top: 50px;}
.mainTable {width: fit-content;height: fit-content;margin: 0 auto;margin-top: 30px;}
th{text-align: center;}
th,td{padding: 10px}
#projectComment{height: 250px}
</style>
<title>registration</title>
</head>
<body>
	<!-- Header -->
	<div class="container-fluid">
		<table class="mainTable">
			<tr>
				<td><img src="resources/img/haru.png" width="80px"
					height="80px"></td>
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
			</div>
		</nav>
	</div>
	<!-- //end Header -->

	<!-- 일감 등록 -->
	<div class="container" id="registration">
		<h3 style="text-align: center;">일감 등록</h3>
		<form action="registration.do" method="get">
			<table class="table table-bordered" id="registrationTable">
				<tr class="row">
					<th class="col-sm-4">
						<label>사업명</label> 
					</th>
					<td class="col-sm-8">
						<input class="form-control" type="text" placeholder=" 사업명" id="projectName" name="projectName" required>
					</td>
				</tr>
				<tr class="row">
					<th class="col-sm-4">
						<label>업종 분류</label>
					</th>
					<td class="col-sm-8">
						<select name="projectSubject" id="projectSubject" required>
							<option value="">사업분류</option>
							<option value="건설현장">건설현장</option>
							<option value="토목">토목</option>
							<option value="조선">조선</option>
							<option value="공장">공장</option>
							<option value="운송">운송</option>
							<option value="식당">식당</option>
							<option value="이벤트">이벤트</option>
							<option value="청소">청소</option>
							<option value="기타">기타</option>
						</select>
					</td>
				</tr>
				<tr class="row">
					<th class="col-sm-4">
						<label for="dateLabel">일감 시작~마감일</label><br>
					</th>
					<td class="col-sm-8">
						<input type="text" name="projectStartDate" id="projectStartDate" required>
						<input type="text" name="projectEndDate" id="projectEndDate" required>
					</td>	
				</tr>
				<tr class="row">
					<th class="col-sm-4">
						<label for="TimeLabel">업무 시작~마감시간</label><br>
					</th>
					<td class="col-sm-8">
						<input type="time" name="workStartTime" id="workStartTime" required>
						<input type="time" name="workEndTime" id="workEndTime" required>
					</td>
				</tr>
				<tr class="row">
					<th class="col-sm-4">
						<label for="demandLabel">신청 제약 사항</label> <br> 
					</th>
					<td class="col-sm-8">
						<input type="checkbox" name="constCertificate" value="필요">건설안전교육이수증&nbsp; 
						<input type="checkbox" id="requestPicture" name="requestPicture" value="필요">사진
					</td>
				</tr>
				<tr class="row">
					<th class="col-sm-4">
						<label for="demandLabel">제공 사항</label> <br> 
					</th>
					<td class="col-sm-8">
						<input type="checkbox" id="morning" name="morning" value="제공">아침 제공&nbsp;
						<input type="checkbox" id="launch" name="launch" value="제공">점심 제공&nbsp;
						<input type="checkbox" id="evening" name="evening" value="제공">저녁 제공&nbsp;
						<input type="checkbox" id="commute" name="commute" value="제공">출근 차량&nbsp;
						<input type="checkbox" id="offWork" name="offWork" value="제공">퇴근 차량&nbsp;
					</td>
				</tr>
				<!-- 일감 추가 영역 -->
				<tr class="row">
					<td colspan="11">
						<label for="showJobModalButton">업무&nbsp;</label>
						<input class="btn btn-primary" type="button" id="showJobModalButton" value="업무 추가" data-toggle="modal" data-target="#addJobModal" data-backdrop="static">
						<table class="table table-hover">
							<thead>
								<tr class="row">
									<th class="col-sm-1">#</th>
									<th class="col-sm-2">직군</th>
									<th class="col-sm-2">임금</th>
									<th class="col-sm-1">정원</th>
									<th class="col-sm-2">모집날짜</th>
									<th class="col-sm-2">요구 자격</th>
									<th class="col-sm-2">필요 임금</th>
								</tr>
							</thead>
							<!-- 모달창을 통해 추가된 직군이 보여지는 곳 -->
							<tbody id="jobListOutput">
								<tr>
									<td colspan="11" style="text-align: center;">
										<p>업무을 추가해 주세요</p>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<!-- //end 일감 추가 영역 -->
				<tr class="row">
					<th class="col-sm-4">
						<label for="locationLabel">업무 상세 내용</label> 
					</th>
					<td class="col-sm-8">
						<textarea class="form-control" id="projectComment" name="projectComment" placeholder=" 업무 상세 내용" required></textarea>
					</td>
				</tr>
				<tr class="row">
					<th class="col-sm-4">
						<label for="locationLabel">근무 장소</label>
					</th>
					<td class="col-sm-8">
						<div id="map" style="height: 350px;"></div>
						<p><em>근무 위치를 클릭해주세요!</em></p>
						<div id="clickLatlng"></div> 
						<input type="hidden" id="projectLat" name="projectLat"> 
						<input type="hidden" id="projectLng" name="projectLng">
					</td>
				</tr>
				<tr class="row">
					<td colspan="11">
						<input class="btn btn-primary" type="button" value="일감 등록" id="insertProject" name="insertProject">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- //end 일감 등록 -->
	<!-- 일감 추가 모달창 -->
  	<div class="modal fade" id="addJobModal" role="dialog">
    	<div class="modal-dialog">
    
      		<!-- Modal content-->
      		<div class="modal-content">
        		<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal">×</button>
          	 		<h4 class="modal-title">업무 추가하기</h4>
        		</div>
        		<div class="modal-body">
          			<table class="table table-bordered">
          				<tr class="row">
          					<th class="col-sm-4">
          						업무
          					</th>
          					<td class="col-sm-8" id="jobSubject">
          						<select name="jobName" id="jobName" required>
								</select>
          					</td>
          				</tr>
          				<tr class="row">
          					<th class="col-sm-4">
          						임금 (원)
          					</th>
          					<td class="col-sm-8">
          						<input class="form-control" type="number" id="jobPay" name="jobPay">
          					</td>
          				</tr>
          				<tr class="row">
          					<th class="col-sm-4">
          						정원 (명/일)
          					</th>
          					<td class="col-sm-8">
          						<input class="form-control" type="number" id="jobLimitCount" name="jobLimitCount"> 
          					</td>
          				</tr>
          				<tr class="row">
          					<th class="col-sm-4">
          						모집 날짜
          					</th>
          					<td class="col-sm-8">
          						<input type="text" name="jobStartDate" id="jobStartDate" required>
								<input type="text" name="jobEndDate" id="jobEndDate" required>
          					</td>
          				</tr>
          				<tr class="row">
          					<th class="col-sm-4">
          						요구 자격
          					</th>
          					<td class="col-sm-8">
          						<select name="jobRequirement" id="jobRequirement" required>
									<option value="">자격증 분류</option>
									<option value="건설안전교육이수증">건설안전교육이수증</option>
								</select>
          					</td>
          				</tr>
          			</table>
        		</div>
        		<div class="modal-footer">
        			<button type="button" class="btn btn-primary" id="addJobButton" data-dismiss="modal">추가</button>
          			<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
        		</div>
      		</div>
		</div>
	</div>
<!-- //end 일감 추가 모달창 -->
<!-- 해당 파일 스크립트 -->
<script type="text/javascript" src="resources/js/registration.js"></script>

</body>
</html>