<%@page import="com.lx.odw.vo.OfferWorkVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header2.jsp"></jsp:include>
<%List<OfferWorkVO> todayProjectList = (List<OfferWorkVO>) request.getAttribute("todayProjectList"); 
System.out.println(todayProjectList.toString());%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출퇴근 관리</title>
</head>
<body>
<div class="container">
	<h1>출퇴근 관리</h1>
	<br><br>
	<table class="table table-boder">
		<%for(OfferWorkVO item : todayProjectList){ %>
		<tr class="row">
			<td class="col-sm-4"><%=item.getProjectName()%></td>
			<td class="col-sm-3"><%=item.getWorkStartTime() + " ~ " + item.getWorkEndTime() %></td>
			<td class="col-sm-2"><%="모집률 : ( "+item.getRecruit() + " / " + item.getTotal() +" )"%></td>
			<td class="col-sm-2"><%="출석률 : ( "+ item.getCommute()+" / " + item.getRecruit() + " )"%></td>
			<td class="col-sm-1"><a href="manageCommuteDateil.do?projectNumber=<%=item.getProjectNumber()%>&projectName=<%=item.getProjectName()%>" class="btn btn-primary">출퇴근 관리</a></td>
		</tr>
		<%} %>
	</table>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>