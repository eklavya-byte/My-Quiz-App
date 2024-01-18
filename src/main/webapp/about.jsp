<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/png" href="img/quiz-app-logo.png">
    <title>About Us</title>
    <%@include file="component/allcss.jsp"%>
    <style type="text/css">
        .container-fluid {
            width: 100%;
            padding: 0;
            margin: 0;
        }

        .about-section {
           
            color: white;
            padding: 50px 0;
            text-align: center;
        }

        .about-heading {
            font-size: 2rem;
            font-weight: bold;
            margin-bottom: 30px;
        }

        .about-content {
            font-size: 1.2rem;
            line-height: 1.6;
        }
    </style>
</head>
<body>
    <div class="container-fluid"  style="height:100vh">
        <%@include file="component/navbar.jsp" %>
        
        <div class="about-section">
            <div class="container">
                <h2 class="about-heading">About Us</h2>
                <p class="about-content">
                    Welcome to the Quiz App! We are dedicated to providing an engaging and educational experience through our quizzes.
                    Our mission is to make learning fun and interactive. Whether you are a student, professional, or just someone looking
                    to expand your knowledge, our quizzes cover a wide range of topics to suit your interests.
                </p>
                <p class="about-content">
                    Explore our quizzes, challenge yourself, and enjoy the journey of continuous learning. Thank you for being a part of
                    the Quiz App community!
                </p>
                <p class="about-content">
                    At Quiz App, we believe in the power of knowledge to transform lives. Our team of experts curates quizzes that are
                    not only informative but also enjoyable. We strive to create a platform where curiosity is nurtured, and every
                    question sparks a desire to learn more.
                </p>
                <p class="about-content">
                    Join us on this intellectual adventure. Dive into the diverse world of topics, from science and technology to arts
                    and literature. Let's embark on a quest for knowledge together!
                </p>
                <p class="about-content">
    				Greetings! I'm Prem Prakash, a passionate Java developer contributing to the Quiz App journey. 
    				With a robust foundation in Java programming, I bring a wealth of technical expertise to our dynamic team.
    				 My skills extend to crafting efficient and scalable solutions, ensuring a seamless user experience. 
    				 In addition to my proficiency in Java, I actively explore innovative technologies to stay at the forefront of 
    				 software development. Join me on this exciting adventure as we explore the world of quizzes and knowledge together!
				</p>
                
            </div>
        </div>

        
    </div>
    <%@include file="component/footer.jsp" %>
</body>
</html>
