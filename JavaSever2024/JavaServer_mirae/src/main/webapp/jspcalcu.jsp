<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
    
<%
	long result = 0;
	int n1 = Integer.parseInt(request.getParameter("n1"));
	int n2 = Integer.parseInt(request.getParameter("n2"));
	
	switch(request.getParameter("op")) {
		case "+" : result = n1 + n2; break;
		case "-" : result = n1 - n2; break;
		case "*" : result = n1 * n2; break;
		case "/" : result = n1 / n2; break;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP 계산결과</title>
</head>
<body>
<br><br><br><br><br><Br>
<h2> 계산결과 - JSP : 김미래 </h2>
<hr>
결과: <%=result %>
</body>
</html>