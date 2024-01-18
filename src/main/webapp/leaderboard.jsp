<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/png" href="img/quiz-app-logo.png">
    <title>Leaderboard - Quiz App</title>
   
    <%@include file="component/allcss.jsp"%>
    <style type="text/css">
        .leaderboard-container {
            margin: 50px;
        }

        .leaderboard-heading {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .leaderboard-list {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        .leaderboard-item {
            padding: 10px;
            border: 1px solid #ccc;
            margin-bottom: 10px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width:50%;
        }

        .leaderboard-item span {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <%@include file="component/navbar.jsp" %>
        <div class="leaderboard-container">
            <h2 class="leaderboard-heading">Leaderboard</h2>
            <ul class="leaderboard-list">
                <c:forEach var="player" items="${leaderboard}">
                    <li class="leaderboard-item">
                        <span>${player.quizName}</span> - Score: ${player.quizScore}
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <%@include file="component/footer.jsp" %>
</body>
</html>
