<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Customer's List</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

updateCustomer = function(customerId) {
	alert(customerId);
}

deleteCustomer = function(customerId) {
	alert(customerId);
}

load = function() {
	$.ajax({
		url:'list',
		type: 'POST',
		success: function(response) {
			data = response.data;
			for (i=0; i <data.length; i++) {
				$("#customer_list").append("<tr class='tr'> <td> " + data[i].customerId + "</td>"
						+ "<td> " + data[i].firstName + "</td>"
						+ "<td> " + data[i].lastName + "</td>"
						+ "<td> " + data[i].contactNo + "</td>"
						+ "<td> " + data[i].postalCode + "</td>"
						+ "<td> " + data[i].addressDetailed + "</td>"
						+ "<td> " + data[i].city + "</td>"
						+ "<td> " + data[i].province + "</td>"
						+ "<td> " + data[i].country + "</td>"
						+ "<td> <a href='#' onclick='updateCustomer(\"" + data[i].customerId + "\");'>Update</a></td>"
						+ "<td> <a href='#' onclick='deleteCustomer(\"" + data[i].customerId + "\");'>Delete</a></td>"
                        + "</tr>");
				
			}
		}
	});
}
</script>
</head>
<body onload="load();">
	<table id="customer_list" width="100%" border="1">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Contact No</th>
			<th>Postal Code</th>
			<th>Address</th>
			<th>City</th>
			<th>Province</th>
			<th>Country</th>
			<th colspan="2">Action</th>
			
		</tr>
	</table>
</body>
</html>