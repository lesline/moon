<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="GBK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>

<FORM name=LogonForm action=login.jsp method=post>

    <INPUT name=UserID type="text" value="4444">
    <INPUT name=Password type="password" value="99999999">

    <%--<INPUT type="submit" value="" onclick="javascript:doSubmit();  ">--%>
    <INPUT type="submit" value="提交">


</FORM>

<a href="Logon.jsp">login</a>
<br>
<SCRIPT>
    function doSubmit() {

        document.forms("LogonForm").submit();
    }
</SCRIPT>

</body>
<%


    session.setAttribute("UserID", "张三");
    String b = (String) session.getAttribute("UserID");
    out.println(b);

%>


</html>