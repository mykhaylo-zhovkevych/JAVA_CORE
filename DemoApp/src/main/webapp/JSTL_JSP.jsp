<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

hello World
<%
// this will return a object so it need to be converted to the String 
String name= request.getAttribute("lable").toString();
out.println(name);
%>

<!-- das ist expression language -->
${lable}



</body>
</html>