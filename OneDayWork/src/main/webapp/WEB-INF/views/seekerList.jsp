<%@page import="com.lx.odw.vo.SeekerVO"%>
<%@page import="java.util.List"%>
<%@page import="com.lx.odw.vo.ProjectVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>하루일감: 신청자목록</title>

</head>
<body>

	<%List<SeekerVO> list = (List<SeekerVO>) request.getAttribute("seekerList"); %><!-- 요청해서 받은 empList를 list에 담는다. -->
	<div class="container">
		<h1>신청자목록</h1>
			<table class="table table-hover">
				<thead>

					<tr class="row">
						<th class="col-sm-1">순서</th>
						<th class="col-sm-2">신청자 ID</th>
						<th class="col-sm-2">신청자 이름</th>
						<th class="col-sm-2">신청자 생년월일</th>
						<th class="col-sm-2">신청자 성별</th>
						<!-- 
						<th class="col-sm-2">신청자 신뢰도</th>
						 -->

					</tr>
				</thead>
				<tbody>
					<%
						if (list != null) {
							int i = 1;
							for (SeekerVO item : list) {
					%>
					<tr class="row">
						<th class="col-sm-1"><%=i++%></th>
						<th class="col-sm-2"><%=item.getSeekerId()%></th>
						<th class="col-sm-2"><%=item.getSeekerName()%></th>
						<th class="col-sm-2"><%=item.getSeekerBirth()%></th>
						<th class="col-sm-2"><%=item.getSeekerSex()%></th>
						
					</tr>
					<%
						}
						}
					%>

				</tbody>
			</table>
		</form>
	</div>

	<!-- 일감 상세정보 모달창
	<div class="modal fade" id="projectDetailInfoModal" role="dialog">
		<div class="modal-dialog">
	-->
			<!-- Modal content 
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"></button>
					<h4 class="modal-title">일감 상세정보</h4>
				</div>
				<div class="modal-body">
					<table class="table table-bordered">
						<tr class="row">
							<td class="col-sm-4">일감</td>
							<td class="col-sm-8"></td>
						</tr>
						<tr class="row">
							<td class="col-sm-4">업종 분류</td>
							<td class="col-sm-8"></td>
						</tr>
						<tr class="row">
							<td class="col-sm-4">시작 일 ~ 마감 일</td>
							<td class="col-sm-8"></td>
						</tr>
						<tr class="row">
							<td class="col-sm-4">시작 시간 ~ 종료 시간</td>
							<td class="col-sm-8"></td>
						</tr>
						<tr class="row">
							<td class="col-sm-4">신청제약 사항</td>
							<td class="col-sm-8"></td>
						</tr>
						<tr class="row">
							<td class="col-sm-4">제공사항</td>
							<td class="col-sm-8"></td>
						</tr>
						<tr class="row">
							<td class="col-sm-4">상세내용</td>
							<td class="col-sm-8"></td>
						</tr>
						<tr class="row">
							<td class="col-sm-4">근무 장소</td>
							<td class="col-sm-8"></td>
						</tr>
						
				</div>

			</div>

		</div>

	</div>
-->

</body>
</html>