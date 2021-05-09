<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
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
<title>Transaction History</title>
</head>
<body>
		<h2>Transaction history for ${username} - ${accountno}</h2>
		<table style="with: 80%" class="table">
			<tr>
				<td>Transaction ID</td>
				<td>Transaction date</td>
				<td>Amount</td>
				<td>To account number</td>
			</tr>
		
			    <tr>
			<c:forEach items="${tlist}" var="trans">
				<tr>
					<td style="padding:0 15px 0 15px;"> <input type="hidden" name="transactionid" value=${trans.transactionid}>${trans.transactionid}</td>
					<td style="padding:0 15px 0 15px;"><input type="hidden" name="date">${trans.date}</td>
					<td style="padding:0 15px 0 15px;"><input type="hidden" name="amount">${trans.amount}</td>
					<td style="padding:0 15px 0 15px;"><input type="hidden" name="toaccountno">${trans.toaccountno}</td>
					<td style="padding:0 15px 0 15px;"><input type="hidden" name="transactiontype">${trans.transactiontype}</td>
				
				</tr>

			</c:forEach>

		</table>

</body>
</html>