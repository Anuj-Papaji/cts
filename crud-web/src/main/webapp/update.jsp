<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>update</h1>
<form action="EmployeeController" method="get">

		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="save" value="Update" /></td>
				<td><input type="reset" name="reset" value="Clear" />
				<input type="hidden" name="action" value="update" />
				</td>
			</tr>
		</table>

	</form>

</body>
</html>