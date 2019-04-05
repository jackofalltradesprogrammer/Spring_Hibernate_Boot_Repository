<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	First name: <form:input path="firstName"/>
	<br><br>
	Last name: <form:input path="lastName"/>
	<br><br>
	Country: 
		<form:select path="country">
		<!-- items refer to the collection of items key-value pair in this case -->
			<form:options items="${student.countryOptions}"/>
		</form:select>
	<br><br>
	Favorite Language:
		Java <form:radiobutton path="favoriteLanguage" value="java" />
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />
	<br><br>
	Operating Systems:
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
	<br><br>
	<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>