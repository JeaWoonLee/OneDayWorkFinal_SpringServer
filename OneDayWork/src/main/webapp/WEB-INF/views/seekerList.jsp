<%@page import="com.lx.odw.vo.ProjectVO"%>
<%@page import="java.util.List"%>
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
		<!-- 가운데로 오게함 -->
<style>
	.container{
	    width: fit-content; height:fit-content; margin: 0 auto; margin-top:150px;
	}
</style>

<title>하루일감: 신청자목록</title>
</head>
<body>
<%List<ProjectVO> list = (List<ProjectVO>) request.getAttribute("projectList"); %>
	
	<div class="container">
				<tr>
					<th><h1>신청자 목록</h1></th>
				</tr>
		<form action="projectList.do" method="post"><!-- 검색 버튼을 누를 경우 searchEmpListByDeptId.do로 보내준다. -->
			<input class="form-control" type="text" value="" placeholder="번호를 입력하세요" id="offerId" name="offerId">
			<button class="btn btn-primary" id="searchButton" type="submit">검색</button>
		</form>
		<table class="table table-hover">
			<thead>
				
				<tr class="row">
					<th class="col-sm-1">일감 번호</th>
					<th class="col-sm-2">일감 이름</th>
					<th class="col-sm-2">일감 분류</th>
					<th class="col-sm-3">일감 시작일</th>
					<th class="col-sm-3">일감 종료일</th>	
									
				</tr>
			</thead>
			<tbody>
			<%
			if(list != null) {
				int i=1;
				for(ProjectVO item : list) {
					
			%>
				<tr class="row">
					<th class="col-sm-1"><%=i++%></th>
					<th class="col-sm-1"><%=item.getProjectNumber() %></th>
					<th class="col-sm-2"><%=item.getProjectName() %></th>
					<th class="col-sm-2"><%=item.getProjectSubject() %></th>
					<th class="col-sm-3"><%=item.getProjectStartDate() %></th>
					<th class="col-sm-3"><%=item.getProjectEndDate()%></th>
				</tr>
			<% 
				}
			}
			%>
				
			</tbody>
		</table>	
	</div>
</body>
</html>