<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
	<div align="center">
		<h1> New/Edit Employee</h1>
		<form:form action="saveEmployee" method="POST" modelAttribute="employee">
			<table>
				<tr>
				   <td>Name:</td>
				   <td><form:input type ="text" path="name"></form:input></td>
				</tr>
					<tr>
				   <td>Project Details:</td>
				   <td><form:input type ="text" path="projectDetails"></form:input></td>
				</tr>
					<tr>
				   <td>Email address:</td>
				   <td><form:input type ="email" path="email"></form:input></td>
				</tr>
					<tr>
				   <td>Phone number:</td>
				   <td><form:input type ="text" path="phone"></form:input></td>
				</tr>
				<tr><td colspan="2" align="center"><input type="submit" value="save"></td></tr>
			</table>
		</form:form>		
	</div>>
	</body>
</html>
