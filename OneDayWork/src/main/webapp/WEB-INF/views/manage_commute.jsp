<%@page import="com.lx.odw.vo.OfferWorkVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header2.jsp"></jsp:include>
<%List<OfferWorkVO> todayProjectList = (List<OfferWorkVO>) request.getAttribute("todayProjectList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출퇴근 관리</title>
</head>
<body>
<div class="container">
	<h1>출퇴근 관리</h1>
	<table class="table table-boder">
		<%for(OfferWorkVO item : todayProjectList){ %>
		<tr class="row">
			<td class="col-sm-2">
				
			</td>
			
		</tr>
		<%} %>
	</table>
</div>
</body>
</html>