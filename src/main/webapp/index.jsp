<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.ResultBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dumble</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<div class="logoField">
		<a href="index.jsp">
			<img class="large" alt="404: logo not found" src="./media/Dumble.png">
		</a>
	</div>
	<div class="searchField">
		<form class="mainForm" action="<%=request.getContextPath()%>/SearchServlent">
			<div>
				<input class="mainSearchbar" type="text" name="SearchString" placeholder="Search.." required>			
			</div>
			<div>
				<input class="mainSubmit" type="submit" value="Dumble Search">			
			</div>
		</form>
	</div>
</body>
</html>