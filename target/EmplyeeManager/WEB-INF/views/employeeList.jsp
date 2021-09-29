<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="com.nagarro.employeemanager.model.Employee"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title><c:out value="${title }">All Employees</c:out></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>

<body>
	<div class="container my-2">
		<div class="card">
			<div class="card-body">

				<div th:switch="${employees}" class="container my-5">
					<p class="my-5">
						<a href="addEmployee" class="btn btn-primary"> <i
							class="fas fa-user-plus ml-2"> Add Employee </i></a>
					</p>
					<div class="col-md-12">

						<div>
							<table class="table table-striped table-responsive-md">
								<thead>
									<tr>
										<th>Employee Code</th>
										<th>Employee Name</th>
										<th>Location</th>
										<th>Email</th>
										<th>Data Of Birth</th>
										<th scope="col" style="align-content: center">Action</th>
									</tr>
								</thead>
								<tbody>
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

									<c:forEach items="${employees}" var="employee">
										<tr>
											<td>${employee.empCode}</td>
											<td>${employee.empName}</td>
											<td>${employee.empLoc}</td>
											<td>${employee.empMail}</td>
											<td>${employee.empDOB}</td>
											<td><a href="edit/${employee.empCode }"> <i
													class="fa fa-edit"></i>
											</a><input type="hidden" name="empCode" value=${employee.empCode }/></td>

										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>
</body>

</html>