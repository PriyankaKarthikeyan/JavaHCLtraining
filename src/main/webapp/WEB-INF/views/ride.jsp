<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<P>Booked successfully!</P>
	<table style="width: 80%; border: 2px">
		<tr>
			<td>Ride Id</td>
 			<td>UserId</td>
			<td>Date</td>
		</tr><tr>
			<td>${ride.rideId}</td>
			<td>${ride.userId}</td>
			<td>${ride.dateTime}</td>
		</tr>


	</table>
</body>
</html>