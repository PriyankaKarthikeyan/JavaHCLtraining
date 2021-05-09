<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js "></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js "></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js "></script>
<meta charset="ISO-8859-1">
<title>Fund transfer page</title>
</head>
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 35%;
	border: 1px solid #ddd;
}

th, tr, td {
	width: 150px;
	text-align: center;
	border: 1px solid black;
	padding: 5px
}
</style>
<body>
	<form:form action="sumbittransfer">
		<h2 align="center">Hai ${username}</h2>
		<input type="hidden" name="accountnumber" value=${accountnumber}>
		<input type="hidden" name="userid" value=${userid}>
		<input type="hidden" name="username" value=${username}>
		<input type="hidden" name="balance" value=${balance}>

		<table align="center" width="260%" class="table">
			<tr>
				<td>From Account Number:</td>
				<td>${accountnumber}</td>

			</tr>
			<tr>
				<td>To Account Number:</td>
				<td><input type="text" name="toaccountno"></td>

			</tr>
			<tr>
				<td>Enter the amount you want to transfer:</td>
				<td><input type="text" name="transferamount"></td>

			</tr>
			<tr>
				<td>Transaction type:</td>
				<td><input type="text" name="transactiontype"></td>

			</tr>
<%-- 			<tr>
				<td><c:if test="${not empty check}">
						<div class="alert alert-danger">
							<p>${check}</p>
						</div>
					</c:if></td>
			</tr> --%>
		</table>
		<input align="center" type="submit" name="action" value="TRANSFER" />
	</form:form>
</body>
</html>