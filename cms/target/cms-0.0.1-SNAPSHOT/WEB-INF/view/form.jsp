<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Form</title>
</head>
<body>
<spring:url value="/customer/save" var="saveURL"/>

<form:form action="${saveURL}" method="POST" modelAttribute="customerForm">
	<table>
		<tr>
			<td>Customer ID</td>
			<td><form:input path="customerId"/>
		</tr>
		<tr>
			<td>First Name</td>
			<td><form:input path="firstName"/>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><form:input path="lastName"/>
		</tr>
		<tr>
			<td>Contact No</td>
			<td><form:input path="contactNo"/>
		</tr>
		<tr>
			<td>Postal Code</td>
			<td><form:input path="postalCode"/>
		</tr>
		<tr>
			<td>Address Detail</td>
			<td><form:input path="addressDetailed"/>
		</tr>
		<tr>
			<td>City</td>
			<td><form:input path="city"/>
		</tr>
		<tr>
			<td>Province</td>
			<td><form:input path="province"/>
		</tr>
		<tr>
			<td>Country</td>
			<td><form:input path="country"/>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">Save</button></td>
		</tr>		
	</table>
</form:form>

</body>
</html>