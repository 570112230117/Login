<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String result = "";
%>
<%
	result = (String) request.getAttribute("amnuay");
%>
<html>
<head>
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<form name="hello" action="hello" method="post">
			<div class="panel panel-primary" style="margin-top: 15%">
				<div class="panel-heading">Login</div>
				<div class="panel-body">
					<%
						if (result.equals("F")) {
					%>
					<div class="alert alert-danger">
						<strong>Faill ! </strong> You Login Faill !!
					</div>
					<%
						} else if (result.equals("L")) {
					%>
					<div class="alert alert-success">
						<strong>Success </strong> Logout Success
					</div>
					<%
						}
					%>
					<div class="form-group">
						<label for="exampleInputEmail1">ID Card</label> <input type="text"
							class="form-control" placeholder="ID card" name="email">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" placeholder="Password"
							name="password">
					</div>
<!-- 					<div class="form-group">
						<select name="roleId" class="form-control">
						<option value="1"> ADMIN</option>
						<option value="2"> STUDENT</option>
						</select>
					</div> -->
				</div>
				<div class="panel-footer">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>


		</form>
	</div>
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>