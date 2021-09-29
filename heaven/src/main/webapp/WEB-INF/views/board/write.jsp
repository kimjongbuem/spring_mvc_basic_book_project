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
	<form action="<c:url value="/board/write" />" method="POST">
		
		<table border="1">
			<tr>
				<th>제목</th>
				<th><input name="title"></th>
			</tr>
			<tr>
				<th>내용</th>
				<th><input name="content"></th>
			</tr>	
			<tr>
				<th>작성자</th>
				<th><input name="writer"></th>
			</tr>	
			<tr>
				<th>비밀번호</th>
				<th><input type="password" name="password"></th>
			</tr>	
		</table>
		
		<div>
			<input type="submit" value="등록">
			<a href="<c:url value="/board/list"/>">목록으로 이동</a>
		</div>
	</form>
</body>
</html>