<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Summary</title>
</head>
<body>
	<P>Updated Balance</P>
	<form:form action="transactionhistory">
	<div>
			<input type="hidden" name="username" value=${username}>
			<input type="hidden" name="toaccountno" value=${toaccountno}>
		    <input type="hidden" name="transferamount" value=${transferamount}>
			<input type="hidden" name="accountnumber" value=${accountnumber}>
			<input type="hidden" name="transactiontype" value=${transactiontype}>
			
			
			<h3>Hi ${username}.</h3>
			<p>Your updated balance is : ${updatedbalance}.</p>
			
			</div>
			<input type="submit" name="action" value="CHECK TRANSACTION HISTORY"/>
	
	</form:form>
</body>
</html>