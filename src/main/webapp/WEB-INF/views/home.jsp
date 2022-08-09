<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />   
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%> 
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
<style>
	*{	
		box-sizing: border-box;
		padding: 0;
		margin: 0;
	}
	h1{
		margin: 0 auto;
	}
	form{
		display: flex;
		flex-direction: column;
		margin: 10px 30px;
	}
</style>
</head>
<body>
<h1>안녕하세요</h1>
<sec:authorize access="isAuthenticated()">
	<h4>아이디 : <sec:authentication property="principal.username"/></h4>
	<h4>이메일 : <sec:authentication property="principal.email"/></h4>
	<h4>이름 : <sec:authentication property="principal.realname"/></h4>
	<h4>권한 : <sec:authentication property="principal.authorities"/></h4>
</sec:authorize>
<sec:authorize access="isAnonymous()">
	<h3><a href="${rootPath }/user/login">로그인</a></h3>
	<h3><a href="${rootPath }/user/join">회원가입</a></h3>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<h3><a href="${rootPath }/todo">TODO 보기</a></h3>
<form:form class="logout" action="${rootPath}/logout">
	<button>로그아웃</button>
</form:form>
</sec:authorize>

</body>
</html>