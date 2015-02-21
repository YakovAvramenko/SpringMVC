<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"  type="text/css" href="/SpringMVC/css/style.css" />
<title>Spring MVC</title>
</head>

<body>

	<div class="center">
		<h2>Login</h2>

		<form:form method="POST" commandName="userAccount"
			action="/auth/login">

			<table>
				<tr>
					<td>User Name</td>
					<td><form:input path="userName" /></td>
					<td><form:errors path="userName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>

				<tr>
					<td colspan="3"><input type="submit" value="Login" /></td>
				</tr>
			</table>

		</form:form>

		<div class="border">
			<h3>
				<a href="register">Register</a>
			</h3>
		</div>
	</div>


</body>