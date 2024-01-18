<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/png" href="img/quiz-app-logo.png">
    <title>Results - Quiz App</title>

    <%@include file="component/allcss.jsp"%>
    <style type="text/css">
        .result-container {
            margin: 50px;
        }

        .result-heading {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .result-list {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        .result-item {
            width: 50%; 
            padding: 10px;
            border: 1px solid #ccc;
            margin-bottom: 10px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .result-item span {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <%@include file="component/navbar.jsp" %>
        <div class="result-container">
            <h2 class="result-heading mx-5">Results</h2>
            <ul class="result-list">
                <c:forEach var="result" items="${resultList}">
                    <li class="result-item text-start mx-5 px-5">
                        <span class="mx-3">${result.quizName}</span> --  Score: ${result.quizScore}
                    </li>
                </c:forEach>
            </ul>
        </div>
        
    </div>
    <%@include file="component/footer.jsp" %>
</body>
</html>
