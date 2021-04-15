<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="ride" method="post">
		<table style="with: 80%">
			<tr>
				<td>User ID</td>
				<td>RouteId</td>
				<td>Source</td>
				<td>Destination</td>
				<td>Duration</td>
			</tr>
		
			    <tr>
		     <tr><td>User id--<input type="hidden" name="userId" value=${userId} >${userId}</td></tr>
			<c:forEach items="${rList}" var="route">
				<tr>
					<td><input type="hidden" name="routeId" value=${route.routeId}>${route.routeId}</td>
					<td><input type="hidden" name="source">${route.source}</td>
					<td><input type="hidden" name="destination">${route.destination}</td>
					<td><input type="hidden" name="duration">${route.duration}</td>
					
					<td>	<input name="action" value="book"/></td>
		            <td><input type="submit" value="book" /></td>
				</tr>

			</c:forEach>

		</table>
	</form>

</body>
</html>