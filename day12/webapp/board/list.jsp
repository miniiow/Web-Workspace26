<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', function() {
		let addBtn = document.querySelector('#addBtn')
		addBtn.addEventListener('click', function(){
			location.href = '/Mission-WEB-MVC/board/writeForm.do'
		})
	})
</script>
</head>
<body>
	<hr>
	<h2>전체 게시글 조회</h2>
	<hr>
	<table border="1" style="width: 80%;">
		<tr>
			<th width="7%">번호</th>
			<th>제목</th>
			<th width="17%">글쓴이</th>
			<th width="20%">등록일</th>
		</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td><c:out value="${ board.no }" /> </td>
				<td>
					<a href="${ pageContext.request.contextPath }/board/detail.do?no=${ board.no }">
						<c:out value="${ board.title }" />
					</a>
				</td>
				<td><c:out value="${ board.writer }" /></td>
				<td><c:out value="${ board.regDate }" /></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<button id="addBtn">새글등록</button>
</body>
</html>