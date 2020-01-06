<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form modelAttribute="bo" action="registrationurl" method="GET">
	<h1>Registration page</h1>
	<table>
		<tr>
			<td>userName</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>Email Id</td>
			<td><form:input path="mailid"/></td>
		</tr>
		<tr>
			<td>mobileNo</td>
			<td><form:input path="mblno"/></td>
		</tr>
	</table>
	<form:input path="submit" value="register"/>
	
    
</form:form>
