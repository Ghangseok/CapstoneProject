<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Form</title>
</head>
<body>
	<spring:url value="/customer/save" var="saveURL" />

	<form:form action="${saveURL}" method="POST"
		modelAttribute="customerForm">
		<table>
			<tr>
				<td>Customer ID</td>
				<td><form:input path="customerId" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="passowrd" /></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><form:input path="confirm_password" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Contact No</td>
				<td><form:input path="contactNo" /></td>
			</tr>
			<tr>
				<td>Postal Code</td>
				<td><form:input path="postalCode" /></td>
			</tr>
			<tr>
				<td>Address Detail</td>
				<td><form:input path="addressDetailed" /></td>
			</tr>
			<tr>
				<td>City</td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td>Province</td>
				<td><form:input path="province" /></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><form:input path="country" /></td>
			</tr>
			<tr>
				<td>System</td>
				<td><form:select path="systems" multiple="false">
						<form:option value="NONE"> --SELECT--</form:option>
						<form:options items="${systemList}" itemLabel="systemName" itemValue="systemId"></form:options>
					</form:select></td>
			</tr>

			<tr>
				<td colspan="2"><button type="submit">Save</button></td>
			</tr>
		</table>

	</form:form>

</body>
</html>