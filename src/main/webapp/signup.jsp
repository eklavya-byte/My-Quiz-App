<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- for jstl tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- end of jstl tag -->

<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Signup</title>


    <%@include file="component/allcss.jsp"%>
    <style type="text/css">
        .my-card {
            box-shadow: 0px 0px 10px 1px ;
        }

        .form-card-color {
            background: #ff6669;
        }
    </style>


</head>
<body class="app-background">
    <!-- navbar -->
    <%@include file="component/navbar.jsp" %>

    <!-- User Signup -->
    <div class="container p-5"  style="height:100vh">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card my-card">
                    <div class="card-header text-center text-white form-card-color">
                        <p class="fs-4 text-center text-white mt-2">
                            <i class="fa-solid fa-award"></i> User Signup
                        </p>
                    </div>

                    <div class="card-body">
                        <!-- Boostrap form -->
                        <form action="UserSignUp" method="post">
                            <div class="mb-3">
                                <label class="form-label">Full Name</label>
                                <input name="user_name" type="text" placeholder="Enter Full Name" class="form-control">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Email address</label>
                                <input name="user_email" type="email" placeholder="Enter Email" class="form-control">
                                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Password</label>
                                <input name="user_password" type="password" placeholder="Enter password" class="form-control">
                            </div>

                            <button type="submit" class="btn col-md-12 text-white form-card-color">Signup</button>
                        </form>
                        <!-- End of Boostrap form -->

                        <br>Already have an account? <a href="login.jsp" class="text-decoration-none">Login here</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End of User Signup -->

    <!-- Footer -->
    <footer><%@include file="component/footer.jsp" %></footer>

</body>
</html>
