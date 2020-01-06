<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"isELIgnored="false" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    <form:form action="/currencyFrom" method="POST" modelAttribute="CurrencyFrom">
   FROM: <form:input path="from"/><br><br>
   TO: <form:input path="to"/><br><br>
   QUANTITY: <form:input path="quantity"/><br><br>
    <input type="submit" value="convert"/>
    </form:form>
    
    ${convertCurency}