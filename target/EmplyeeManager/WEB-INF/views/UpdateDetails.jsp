<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="com.nagarro.employeemanager.model.Employee"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Add Employee</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>

<body>
	<div class="container my-5">
		<h3>Add Employee</h3>
		<div class="card">
			<div class="card-body">
				<div class="col-md-10">
					<%
					OutputStream oImage;
					String url = "jdbc:mysql://localhost:3306/employeemanager";
					String username = "root";
					String password = "root";

					String sql = "select * from employee";

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, username, password);
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					%>

					<form action="#" th:action="@{saveEmployee}"
						th:object="${employee}" method="post">
						<div class="row">
							<div class="form-group col-md-8">
								<label for="name" class="col-form-label">Employee Code</label> <input
									type="text" th:field="*{Employee Code}" name="empCode"
									class="form-control" id="firstName" />
							</div>
							<div class="form-group col-md-8">
								<label for="name" class="col-form-label">Employee Name</label> <input
									type="text" th:field="*{Name}" name="empName"
									class="form-control" id="lastName" />
							</div>
							<div class="form-group col-md-8">
								<label for="email" class="col-form-label">Location</label> <input
									type="text" th:field="*{location}" name="empLoc"
									class="form-control" id="email" placeholder="Email Id" />
							</div>
							<div class="form-group col-md-8">
								<label for="email" class="col-form-label">Email</label> <input
									type="text" th:field="*{email}" name="empMail"
									class="form-control" id="email" placeholder="Email Id" />
							</div>
							<div class="form-group col-md-8">
								<label for="email" class="col-form-label">Date Of Birth</label>
								<input type="text" th:field="*{dob}" name="empDOB"
									class="form-control" id="email" placeholder="Email Id" />
							</div>

							<div class="col-md-6">
								<input type="submit" class="btn btn-primary" value=" save ">
							</div>


							<input type="hidden" id="id" th:field="*{id}">

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>