<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<title>Agency List</title>
<script type="text/javascript">
	function activateConfirm() {
		return confirm("Do you want to Activate this Agency....!!");
	}

	function deActivateConfirm() {
		return confirm("Do you want to De-Activate this Agency....!!");
	}
</script>
</head>
<body bgcolor="lightyellow">
	<a href="#" class="btn btn-outline-secondary btn-lg">+ ADD More
		Agency </a>
	<div class="conatianer">
		<h2 class="h4 text-center text-primary">View All Admins Data</h2>
		<br>
		<c:if test="${msg ne null}">
			<div class="text-center text-danger h2">${msg}</div>
		</c:if>
		<c:if test="${adminList ne null}">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>S.NO.</th>
						<th>Agency Id</th>
						<th>Ag.Owner Name</th>
						<th>DOB</th>
						<th>Gender</th>
						<th>Email Id</th>
						<th>Phone Number</th>
						<th>SSN ID</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${agencyList}" var="agency" varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${agency.userId}</td>
							<td>${agency.fname}&nbsp;${agency.lname}</td>
							<td>${agency.dob}</td>
							<td>${agency.gender}</td>
							<td>${agency.email}</td>
							<td>${agency.phno}</td>
							<td>${agency.zzn}</td>
							<c:choose>
								<c:when test="${agency.activeSwitch eq 'N'}">
									<a href="#" class="btn btn-outline-success"
										onclick="return activateConfirm()">Active</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-outline-danger"
										onclick="return deActivateConfirm()">De-Active</a>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>