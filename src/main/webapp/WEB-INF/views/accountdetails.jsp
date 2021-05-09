<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Account Summary</title>
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
	<P align="center">Account Summary Details</P>
	<form:form action="fundtranfer">
	<input type="hidden" name="accountnumber" value=${accountnumber}>
	<table style="width: 80%; border: 20px" class="table">
		<tr>
			<th>User ID</th>
			<td><input type="hidden" name="userid" value=${userid}>${userid}</td>
		</tr>
		<tr>
			<th>User Name</th>
			<td><input type="hidden" name="username" value=${username}>${username}</td>
		</tr>
		<tr>
			<th>Account Number</th>
			<td><input type="hidden" name="accountnumber" value=${accountnumber}>${accountnumber}</td>		
		</tr>
		<tr>
			<th>Balance</th>
			<td><input type="hidden" name="balance" value=${balance}>${balance}</td>		
		</tr>
	</table>
             <div align="center">
			<input type="submit" name="action" value="FUND TRANSFER" />
			</div>
			
	</form:form>
</body>
</html>
