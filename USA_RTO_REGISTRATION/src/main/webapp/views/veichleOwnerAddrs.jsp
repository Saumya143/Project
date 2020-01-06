<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/css/owner_Details.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
 

</head>
<body>
<h1 style="text-align: center;color: blue">VEICHLE OWNER ADDRESS DETAILS REGISTRATION</h1>

<div class="text-center bg-primary text-white " style="height:50px;">
		<label style="margin-top:1%;">Veichle Owner address Details</label>
	</div>
	<div class="d-flex justify-content-center mt-4 table-responsive">
   <form:form action="/registrationAddrs/${ownerId}" method="POST"
	modelAttribute="ownerAdrsDtls">

	<table>   
		
		<tr>
			<td>HOUSE NO</td>
			<td><form:input path="houseNo" class="form-control" /></td>
		</tr>
		<tr>
			<td>STREET NAME</td>
			<td><form:input path="streetName" class="form-control"/></td>
		</tr>

		<tr>
			<td>CITY</td>
			<td><form:input path="city" class="form-control"/></td>
		</tr>
		<tr>
			<td>ZIP-CODE</td>
			<td><form:input path="zipCode" type="text"  id="datepicker" class="form-control"/></td>
		</tr>
		<tr>
			<td><a href="edituser?">PREVIOUS</a></td>
			<td><input type="submit" value="NEXT" class="form-control"></td>
		</tr>


	</table>

</form:form>
</div>
<!-- Validation Form Script -->
	<script type="text/javascript">
		$(function() {
			$("form")
					.validate(
							{
								errorPlacement : function(error, element) {
									if (element.prop('type') === 'text') {
										error.insertAfter(element.parent());
									} else {
										error.insertAfter(element.parent());
									}
								},
								rules : {
									houseNo : {
										required : true,
										length : 6,
										digits : true
									},
									streetName : {
										required : true,
										minlength : 6,
										maxlength : 40
									},
									city : {
										required : true,
										minlength : 6,
										maxlength : 40
									},
	
									zipCode : {
										required : true,
										minlength : 6,
										maxlength : 6,
										digits : true
									}
									
								},
								messages : {
									houseNo : {
										required : "Huse no is required!",
										minlength : "House no must be at least 3 number",
									    digits : "You can only enter digits"
									},
									streetName : {
										required : "StreetName is Required",
										minlength : "StreetName must be at least 6 characters long"
									},
									city : {
										required : "city is Required",
										minlength : "city must be at least 6 characters long"
									},
									
									zipCode : {
										required : "Zipcode Must be Required",
										length : "Your Zipcode  must be 6 digits",
										digits : "You can only enter digits"
									}
									
								}
							});
		});
	</script>
	<!-- End Of Validation Form Script -->
</body>
</html>