<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>My Custom Login Page</h3>
	<!-- Make sure the mapping matches with the spring security configuration for our custom login form -->
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
		<!-- Check for login error, Spring Security returns a param if the user can't be authenticated -->
		<c:if test="${param.error != null}">
			<i>Sorry! You entered invalid username/password.</i>
		</c:if>
		<p>
			User name: <input type="text" name="username">
		</p>
		<p>
			Password: <input type="password" name="password">
		</p>
		
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>