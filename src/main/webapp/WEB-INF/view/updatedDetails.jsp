<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Successfully updated.</title>
	</head> 
	<body>
	<div align="center">
		<h1> List of Employees</h1>
			<table>
			<tr>
				   <th>Name:</th>
				   <th>Project Details:</th>
				   <th>Email address:</th>
				   <th>Phone number:</th>
				   
				   <td>Name:</td>
		    </tr>
		    <c:forEach items="${updatedDetails}" var="emp">
					<tr>
				   <td>${emp.name}</td>
				   <td>${emp.projectDetails}</td>
				   <td>${emp.email}</td>
				   <td>${emp.phone}</td>
				   
				</tr>
				</c:forEach>
			</table>
	</div>>
	</body>
</html>
