<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
int n1 = Integer.parseInt(request.getParameter("n1"));
int n2 = Integer.parseInt(request.getParameter("n2"));
String op = request.getParameter("op");


int result = 0;

switch(op) {
case "+" : result = n1 + n2;
break;
case "-" : result = n1 - n2;
break;
case "*" : result = n1 * n2;
break;
case "/" : result = n1 / n2;
break;

}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>계산기 JSP</title>
</head>
<body>
<h2>계산 결과-JSP</h2>
<hr>
결과 : <%=result %>

</body>
</html>