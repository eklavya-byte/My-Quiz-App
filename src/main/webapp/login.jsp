<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="icon" type="image/png" href="img/quiz-app-logo.png">
<title>User Login</title>

<%@include file="component/allcss.jsp"%>
<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px ;
}

.form-card-color{
		background:#6699ff;
	}
</style>


</head>
<body class="app-background">
	

	<%@include file="component/navbar.jsp" %>


	<div class="container p-5"  style="height:80vh">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card my-card">
					<div class="card-header text-center text-white form-card-color">
						
						<p class="fs-4 text-center text-white mt-2">
							<i class="fa-solid fa-award"></i> User Login
						</p>
					</div>
					
					<div class="card-body">
					
						<c:if test="${not empty successMsg }">
							<p class="text-center text-success fs-5">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						<!-- error message -->
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<!-- end of message -->



						
						<form action="userLogin" method="post">
							<div class="mb-3">
								<label class="form-label">Email address</label> <input
									name="email" type="email" placeholder="Enter Email"
									class="form-control">
								<div id="emailHelp" class="form-text">We'll never share
									your email with anyone else.</div>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" placeholder="Enter password"
									class="form-control">
							</div>

							<button type="submit"
								class="btn col-md-12 text-white form-card-color">Submit</button>
						</form>
						<br>Don't have an account? <a href="signup.jsp"
							class="text-decoration-none">create one</a>
						
					</div>
				</div>
			</div>
		</div>
	</div>


		<footer><%@include file="component/footer.jsp" %></footer>

</body>
		

</html>