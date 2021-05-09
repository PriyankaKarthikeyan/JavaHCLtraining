<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 35%;
	border: 1px solid #ddd;
}
</style>
<body>
	<div align="center">
		<h2>User Login</h2>
		<form:form action="validate" method="POST" modelAttribute="user">
			<table style="with: 80%">
				<tr>
					<td>User Name</td>
					<td><input type="text" name="username" /></td>
					<td><c:if test="${not empty check}">
							<div class="alert alert-danger">
								<p>${check}</p>
							</div>
						</c:if></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>


				</tr>
			</table>
			<input type="Submit" value="Login" />
		</form:form>
	</div>

</body>
</html>