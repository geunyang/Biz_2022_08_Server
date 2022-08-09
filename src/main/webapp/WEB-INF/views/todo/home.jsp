<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
	padding: 0;
	margin: 0;
}

h1 {
	margin: 0 auto;
}

form {
	display: flex;
	flex-direction: column;
	margin: 10px 30px;
}
</style>
</head>
<body>

	<table>
		<tr>

			<th>NO.</th>
			<th>작성일자</th>
			<th>작성시간</th>
			<th>TODO</th>
			<th>완료일자</th>
			<th>완료시간</th>
			<th></th>
		</tr>
		<c:forEach items="${LIST}" var="todo">
			<tr>
				<td>${todo.t_id}</td>
				<td>${todo.t_date}</td>
				<td>${todo.t_time}</td>
				<td>
				<c:if test="${todo.t_comp == true}">
					<span style="color:red;text-decoration:line-through">
					${todo.todo}
					</span>
				</c:if>
				<c:if test="${todo.t_comp == false}">
				<a href="${rootPath}/todo/update?id=${todo.t_id}">
					${todo.todo}
				</a>
				</c:if>
				</td>
				<td>${todo.t_compdate}</td>
				<td>${todo.t_comptime}</td>
				<td><a href="${rootPath}/todo/complete?id=${todo.t_id}">완료</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${rootPath}/todo/input">입력하기</a>

</body>
</html>