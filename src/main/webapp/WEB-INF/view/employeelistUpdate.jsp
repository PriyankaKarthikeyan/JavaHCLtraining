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
		<h1> Edit your values accordingly:</h1>
		<form:form action="showUpdateEmployees" method="POST" modelAttribute="employeelist">
			<table>
				   <c:forEach items="${employeedetailsupdated}" var="emp">
							<tr>
				   <td>Name:</td>
<%-- 				   <td><input type ="text" name="name" value="${emp.name}"></td>    --%>	
                       <td><input type ="text" value="${emp.name}"></td>			
 </tr>
					<tr>
				   <td>Project Details:</td>
				   <%-- td><input type ="text" name="projectDetails" value="${emp.projectDetails}"></td> --%>
				   <td><input type ="text" value="${emp.projectDetails}"></td>
				</tr>
					<tr>
				   <td>Email address:</td>
				   <%-- <td><input type ="email" name="email" value="${emp.email}"></td> --%>
				   <td><input type ="email" value="${emp.email}"></td>
				</tr>
					<tr>
				   <td>Phone number:</td>
				   <%-- <td><input type ="text"  name="phone" value="${emp.phone}"></td> --%>
				   <td><input type ="text" value="${emp.phone}"></td>
				</tr>
				<tr><td colspan="2" align="center"><input type="submit" value="save"></td></tr>
			</c:forEach>
				
			</table>
			
		</form:form>		
	</div>
	</body>
</html>
