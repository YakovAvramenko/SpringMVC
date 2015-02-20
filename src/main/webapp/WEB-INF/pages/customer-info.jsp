<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>Spring's form tags example</h2>

	<table>
		<tr>
			<td>User Name</td>
			<td>${customer.userName}</td>
		</tr>

		<tr>
			<td>Address</td>
			<td>${customer.address}</td>
		</tr>

		<tr>
			<td>Password</td>
			<td>${customer.password}</td>
		</tr>
		<tr>
			<td>Subscribe</td>
			<td>${customer.receiveNewsletter}</td>
		</tr>

		<tr>
			<td>Fav web frameworks</td>
			<td>${customer.favFramework}</td>
		</tr>

		<tr>
			<td>Sex</td>
			<td>${customer.sex}</td>
		</tr>
		<tr>
			<td>Java Skills :</td>
			<td>${customer.javaSkills}</td>
		</tr>

		<tr>
			<td>secretValue :</td>
			<td>${customer.secretValue}</td>
		</tr>
	</table>




</body>