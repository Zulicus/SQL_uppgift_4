<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.ResultBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dumble</title>
</head>
<body>


	<form action="<%=request.getContextPath()%>/SearchServlent">
		<p>
			Search: <input type="text" name="SearchString" required>
		</p>
		<input type="submit" value="Submit">
	</form>

	<%
	ArrayList<ResultBean> bean = (ArrayList<ResultBean>) request.getAttribute("SearchResult");
		if (bean != null) {
			if (bean.size() == 0) {
		out.print("<p>No Results Found</p>");
			} else {
		out.print("<ul>");
		for (int i = 0; i < bean.size(); i++) {
			out.println("<li><p>" + bean.get(i).getColumn1()+" " + bean.get(i).getColumn2()+" "+ bean.get(i).getColumn3()+" "+ bean.get(i).getColumn4()+" "+ bean.get(i).getColumn5()+" "+ bean.get(i).getColumn6()+" "+ bean.get(i).getColumn7()+" "+ bean.get(i).getColumn8()+" "+ bean.get(i).getColumn9()+" "+ bean.get(i).getColumn10()+" "+ bean.get(i).getColumn11()+" "+ bean.get(i).getColumn12()+" "+ bean.get(i).getColumn13()+" "+ bean.get(i).getColumn14()+" "+ bean.get(i).getColumn15()+" "+ bean.get(i).getColumn16()+" "+ bean.get(i).getColumn17()+ "</p></li>");
		}
		out.print("</ul>");
		bean = null;
			}
		}
	%>

</body>
</html>