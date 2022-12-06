<html xmlns:th="http://www.thymeleaf.org">

<head>
<title>게시 글 상세</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body th:align="center">
	<h1>게시글 상세</h1>
	<form th:action="@{updateBoard}" method="post">
		<input name="seq" type="hidden" th:value="${board.seq}">
		<table th:align="center" border="1" th:cellpadding="0"
			th:cellspacing="0">
			<tr>
				<td bgcolor="orange" th:text="제목" width="80"></td>
				<td><input name="title" type="text" th:value="${board.title}"></td>
			</tr>
			<tr>
				<td bgcolor="orange" th:text="작성자"></td>
				<td th:text="${board.writer}"></td>
			</tr>
			<tr>
				<td bgcolor="orange" th:text="내용">
				<td><textarea name="content" th:text="${board.content}"
						cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange" th:text="등록일"></td>
				<td th:text="${board.createDate}"></td>
			</tr>
			<tr>
				<td bgcolor="orange" th:text="조회수"></td>
				<td th:text="${board.cnt}"></td>
			</tr>

		</table>
	</form>
	<a th:href="@{/getBoardList}">글목록</a>
</body>
</html>