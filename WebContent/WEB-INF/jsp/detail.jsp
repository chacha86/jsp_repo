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
<h1>게시물 상세보기</h1>

번호 : ${myData2.id}
<hr>
제목 : ${myData2.title}
<hr> 
내용 : ${myData2.body}
<hr>
<a href="/web-exam1/article?action=showUpdate&id=${myData2.id}">수정</a>
<a href="/web-exam1/article?action=delete&id=${myData2.id}">삭제</a>
<hr>
<h3>댓글</h3>
<hr>

<c:forEach items ="${replies}" var = "reply">
	<c:choose>
		<c:when test="${ flag == 'u' && rid == reply.id }">
			${ loginedMember.nickname }<br>
			<form action="/web-exam1/article">
				<input type="text" name="rbody" value="${reply.body}"/>
				<input type="hidden" name="rid" value="${reply.id}"/>
				<input type="hidden" name="aid" value="${myData2.id}" />
				<input type="hidden" name="action" value="doUpdateReply" />
				<input type="submit" value="등록" />
			</form>
		</c:when>
		<c:otherwise>
			${ reply.nickname }<br>
			${ reply.body }<br>
			${ reply.regDate } 
			<c:if test="${ reply.mid == loginedMember.id }">
			<a href="/web-exam1/article?action=showReplyUpdate&id=${ reply.id }&aid=${myData2.id}" >수정</a> <a href="/web-exam1/article?action=doDeleteReply&id=${ reply.id }&aid=${myData2.id}" >삭제</a>
			</c:if>
		</c:otherwise>
	</c:choose>
	<hr>
</c:forEach>
${ loginedMember.nickname }<br>
<form action="/web-exam1/article">
	<input type="text" name="rbody" placeholder="댓글을 남겨보세요"/>
	<input type="hidden" name="aid" value="${myData2.id}" />
	<input type="hidden" name="mid" value="${loginedMember.id}" />
	<input type="hidden" name="action" value="doInsertReply" />
	<input type="submit" value="등록" />
</form>
<hr>
</body>
</html>