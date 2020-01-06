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
 <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>

</head>
<body>
<h1 style="text-align: center;color: blue">VEICHLE OWNER DETAILS REGISTRATION</h1>

<div class="text-center bg-primary text-white " style="height:50px;">
		<label style="margin-top:1%;">Veichle Owner Details</label>
	</div>
	<div class="d-flex justify-content-center mt-4 table-responsive">
   <form:form action="veclOnrReg" method="POST"
	modelAttribute="OwnerDetails">

	<table>   
		
		<tr>
			<td>FIRST NAME</td>
			<td><form:input path="firstName" class="form-control" /></td>
		</tr>
		<tr>
			<td>LAST NAME</td>
			<td><form:input path="lastName" class="form-control"/></td>
		</tr>
		<tr>
			<td>GENDER</td>
			<td><form:radiobutton path="gender" value="Male"/>male</td>
			<td><form:radiobutton path="gender" value="Female" />female</td>
		</tr>
		<tr>
			<td>EMAIL ID</td>
			<td><form:input path="email" class="form-control"/></td>
		</tr>
		<tr>
			<td>DATE OF BIRTH</td>
			<td><form:input path="dob"  id="datepicker" class="form-control"/></td>
		</tr>
		<tr>
			<td>PHONE NO</td>
			<td><form:input path="phnNo" class="form-control" /></td>
		</tr>
		<tr>
			<td><input type="reset" value="RESET" class="form-control"></td>
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
									firstName : {
										required : true,
										minlength : 6,
										maxlength : 40
									},
									lastName : {
										required : true,
										minlength : 3,
										maxlength : 40
									},
									
									gender : {
										required : "Gender is Required"
									},
								
									email : {
										required : true,
										email : true
									},
									dob : {
										required : true,
										date : true
									},
									phnNo : {
										required : true,
										length : 10,
										digits : true
									}
									
								},
								messages : {
									firstName : {
										required : "FirstName is required!",
										minlength : "FirstName must be at least 6 characters long"
									},
									lastName : {
										required : "LastName is Required",
										minlength : "LastName must be at least 3 characters long"
									},
									gender : {
										required : "Gender is Required"
									},
									email : {
										required : "Mail is equired",
										email : "your mail should be XXX@gmail.com format"
									},
									dob : {
										required : "Your Date must be Required",
										date : "Date Format Should be MM/dd/YYYY format"
									},
									phnNo : {
										required : "Mobile Number Must be Required",
										length : "Your mob number must be 10 digits",
										digits : "You can only enter digits"
									}
									
								}
							});
		});
	</script>
	<!-- End Of Validation Form Script -->

</body>
</html>