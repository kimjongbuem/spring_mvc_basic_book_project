<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WRITE</title>
</head>
<body>
	<form action="<c:url value="/board/edit/${boardVO.seq}" />" method="POST">
		
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input name="title" value="${boardVO.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input name="content" value="${boardVO.content}"></td>
			</tr>	
			<tr>
				<td>작성자</td>
				<td><input name="writer" value="${boardVO.writer}"></td>
			</tr>	
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" id="pwd" name="pwd">
					${msg}
				</td>
			</tr>	
		</table>
		
		<div>
			<input type="submit" value="수정">
			<a href="<c:url value="/board/list"/>">목록</a>
		</div>
	</form>
</body>
</html>