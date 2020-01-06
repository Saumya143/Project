<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	function deleteConfirm() {
		return confirm("Are you sure,you want to delete");
	}
</script>
<a href="registerUser">+Add User</a>
<table border="1">
	<tr>
		<th>userId</th>
		<th>username</th>
		<th>password</th>
		<th>email</th>
		<th>phno</th>
		<th>update</th>
	</tr>

	<c:forEach items="${userList}" var="user" varStatus="index">
		<tr>
			<td>${index.count}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td>${user.email}</td>
			<td>${user.phno}</td>
			<td><a href="edituser?userId=${user.userId}">Edit</a> <a
				href="deleteUser?userId=${user.userId}"
				onclick="return deleteConfirm()">Delete</a></td>
		</tr>

	</c:forEach>

</table>

<c:if test="${cp>1}">
<a href="viewUser?pn=${cp-1}">Previous</a>
</c:if>
<c:forEach begin="1" end="${tp}" var="i">
	<c:choose>
		<c:when test="${cp==i}">
			<c:out value="${i}" />
		</c:when>
		<c:otherwise>
			<a href="viewUser?pn=${i}"><c:out value="${i}"></c:out></a>

		</c:otherwise>
	</c:choose>
</c:forEach>
<c:if test="${cp<tp}">
<a href="viewUser?pn=${cp+1}">Next</a>
</c:if>