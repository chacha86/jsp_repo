<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%-- JSP 주석문입니다  이코드는 서블릿으로 변환할 때 자바 코드로 변하지 않아요. --%>

<%-- 문제 2. 구구단 출력하기 --%>
<h1>구구단</h1>
<div>
	<for>
	<%for(int j = 2; j < 10; j++) { %>
		*** <%=j%>단***<br>
		<%for(int i = 1; i < 10; i++) { %>
			<%= j %> * <%= i %> = <%= j * i %><br>
	<% }
	<>
	
	%>
</div>