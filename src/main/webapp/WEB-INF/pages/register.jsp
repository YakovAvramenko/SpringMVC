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
			action="/auth/register">

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
					<td>Address country</td>
					<td><form:input path="address.country" /></td>
					<td><form:errors path="address.country" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Address zipCode</td>
					<td><form:input path="address.zipCode" /></td>
					<td><form:errors path="address.zipCode" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Address city</td>
					<td><form:input path="address.city" /></td>
					<td><form:errors path="address.city" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Address street</td>
					<td><form:input path="address.street" /></td>
					<td><form:errors path="address.street" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" /></td>
				</tr>
			</table>

		</form:form>

	</div>

</body>