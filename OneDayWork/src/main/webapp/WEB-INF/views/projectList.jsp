<%@page import="java.util.List"%>
<%@page import="com.lx.odw.vo.ProjectVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>하루일감: 일감목록</title>
<script type="text/javascript">
function showProjectDetail (projectNumber){
	console.log(projectNumber);
	document.location="showPrjDetail.do?projectNumber="+projectNumber; //projectNumber파라메터값
}
</script>
<style>
th{color:black;text-size:15px;}
</style>
</head>
<body>

<body>

<!-- 일감 목록 -->
<%List<ProjectVO> list = (List<ProjectVO>) request.getAttribute("projectList"); %>

	<div class="container">
		<h3 class="text-center">일감 목록</h3>
		<form class="form-horizontal" action="joinOffer.do" method="get">

			<table class="table table-striped">
				<thead>
					<tr class="row">
						<th class="col-sm-1">순서</th>
						<th class="col-sm-3">일감 이름</th>
						<th class="col-sm-2">일감 분류</th>
						<th class="col-sm-2">일감 시작일</th>
						<th class="col-sm-2">일감 종료일</th>
						<th class="col-sm-2"></th>
					</tr>
				</thead>
				<tbody>
					<%
						if (list != null) {
							int i = 1;
							for (ProjectVO item : list) {
					%>
					<tr class="row">
						<th class="col-sm-1"><%=i++%></th>
						<th class="col-sm-3"><%=item.getProjectName()%></th>
						<th class="col-sm-2"><%=item.getProjectSubject()%></th>
						<th class="col-sm-2"><%=item.getProjectStartDate()%></th>
						<th class="col-sm-2"><%=item.getProjectEndDate()%></th>
						<td><input class="btn btn-info btn-sm" type="button"
							id="showProjectModalButton" value="상세정보"
							onclick="showProjectDetail(<%=item.getProjectNumber()%>)"></td>

					</tr>
					<%
						}
						}
					%>
				</tbody>
			</table>
	</div>




	</div>

	</form> 

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
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>