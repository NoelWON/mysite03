<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${Blist }" var="board" varStatus="status">
						<tr>
							<td>${board.no }</td>
							<td><a href="${pageContext.request.contextPath }/board/view/${board.no }">${board.title }</a></td>
							<td>${board.userName }</td>
							<td>${board.hitCount }</td>
							<td>${board.regDate }</td>
							<td><a href="" class="del" style="background-image:url(${pageContext.request.contextPath }/assets/images/recycle.png)">삭제</a></td>
						</tr>
					</c:forEach>
				</table>
				<div class="bottom">
					<c:if test="${not empty authUser }">
						<a href="${pageContext.request.contextPath }/board/write"
							id="new-book">글쓰기</a>
					</c:if>

				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navi.jsp"></c:import>
	</div>
</body>
</html>