<%@ page contentType="text/html; charset=utf-8"%>


<%
String  a= request.getParameter("UserID");
out.println(a);


String b = (String)session.getAttribute("UserID");  
out.println(b);

%>		