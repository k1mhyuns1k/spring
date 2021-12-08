<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
el방식 : ${msg }, ${msg2 }<br>
jsp방식 : <%=request.getAttribute("msg")%>, <%=request.getAttribute("msg2") %>
</body>
</html>