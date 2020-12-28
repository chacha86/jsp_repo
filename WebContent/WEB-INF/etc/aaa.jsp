<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> EL/JSTL 연습</h1>

<!-- 변수 선언 -->
<% 
	int num = 21;
%>
<c:set var="num2" value="11" />
aaaa
aa
df

<!-- 변수 출력 -->
<%
	out.println("jsp : " + num);
%>
<br>
<c:out value="jstl : ${num2}" />
<br>
<!-- 조건문 -->
<%
	if(num % 2 == 0) {
		out.println("even");
	} 
	if(num % 2 == 1){
		out.println("odd");
	}
	
	if(num % 2 == 0) {
		out.println("even");
	} else {
		out.println("odd");
	}
%>


<c:choose>
	<c:when test="${num2 % 2 == 0}">
		even
	</c:when>
	<c:otherwise>
		odd
	</c:otherwise>
</c:choose>
<br>
<!-- 반복문 -->
<%
	for(int i = 1; i <= 10; i++) {
		out.println(i + " ");
	}
%>
<br>
<c:forEach var="i" begin="1" end="10" step="1">
	${i}
</c:forEach>

</body>
</html>