<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr>
		<h2>게시판 등록폼</h2>
		<hr>
		<br>
		<!-- <form action="/Mission-WEB-MVC/board/write.do" method="post"> -->
		<form action="${ pageContext.request.contextPath }/board/write.do" method="post">							
			<table border="1" style="width:80%;">
				<tr>
					<th width="25%">제목</th>
					<td><input type="text" name="title" size="100"></td>
				</tr>
				<tr>
					<th width="25%">작성자</th>
					<td><input type="text" name="writer" size="100"></td>
				</tr>
				<tr>
					<th width="25%">내용</th>
					<td>
						<textarea rows="10" cols="100" name="content"></textarea>
					</td>
				</tr>
			</table>
			<br>
			<!-- <input type="submit" value="등록"> -->
			<button type="submit">등  록</button>
		</form>
	</div>
</body>
</html>








