<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Start</title>
</head>
<body>
<h1>
    Hello World!
    ${path}
</h1>
<p> The Time on the server is ${serverTime}</p>
<p> <a href="board/list">게시판으로 이동</a> </p>
</body>
</html>
