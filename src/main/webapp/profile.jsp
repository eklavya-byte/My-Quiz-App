<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/png" href="img/quiz-app-logo.png">
    <title>Profile - Quiz App</title>
    <%@include file="component/allcss.jsp"%>
    <style type="text/css">
        .profile-container {
            margin: 50px;
            display: flex;
        }

        .profile-pic {
            width: 200px; 
            height: auto;
            margin-right: 20px;
            border-radius: 30%;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .profile-details {
            flex: 1;
        }

        .profile-name {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .profile-fields {
            margin-bottom: 20px;
        }

        .profile-paragraph {
            line-height: 1.5;
        }
         .about-heading {
            font-size: 2rem;
            font-weight: bold;
            margin-bottom: 30px;
            text-align:center;
        }

        .about-content {
            font-size: 1.2rem;
            line-height: 1.6;
        }
    </style>
</head>

<body>
    <div class="container-fluid" >
        <%@include file="component/navbar.jsp" %>
        <div style="height:100vh;">
        <div class="profile-container  px-5">
			<img src="https://premprakash.site/static/media/profile-pic.c202780a832c70582730.png" 
     			alt="Profile Picture" 
    			 class="profile-pic mx-5" 
    			 style="margin-left: 5rem; max-width: 250px; min-width: 150px;">
            <div class="profile-details mt-5 px-5" >
                <div class="profile-name">Name : <%= user.getName()%></div>
                <div class="profile-fields ">
                    <span>Email: <%= user.getEmail()%></span><br>
   					 <span>Level: <%= user.getName()%></span><br>

                </div>
                <div class="profile-description">
                    <p class="profile-paragraph">${userProfile.description}</p> 
                    
                </div>
            </div>
        </div>
        <div class="container">
                <h2 class="about-heading">User Description</h2>
                <p class="about-content">
                                Hello, I'm <%= user.getName()%>, a passionate Java developer. With a strong foundation 
                                in Java and JavaScript frameworks, I thrive on tackling challenging problems and delivering
                                 high-quality solutions. My expertise includes ${userProfile.skills} and I 
                                 have ${userProfile.experience} years of professional experience in the field. 
                                 I am dedicated to continuous learning and staying updated with the latest technologies.
                                  Let's connect and create innovative solutions together!
                    
                </p>
       
    </div>
    
    </div>
     <%@include file="component/footer.jsp" %>
</body>
</html>