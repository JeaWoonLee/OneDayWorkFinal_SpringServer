<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<form method="post" action="offerjoin.do">
	<input type="button" id="offerjoin" value="회원가입" />
	</form>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
