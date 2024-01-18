<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>

<html>
<head>
   <meta charset="UTF-8">
   <link rel="icon" type="image/png" href="img/quiz-app-logo.png">
   <title>Quiz Page</title>
   <%@include file="component/allcss.jsp"%>
   <style type="text/css">
      <!-- Custom CSS for the quiz content -->
      .quiz-content {
         margin-start: 33%;
         padding: 20px;
         border: 1px solid #ccc;
         border-radius: 5px;
         text-align: left;
      }
      
      label {
         display: inline-block;
         margin-right: 60%;
      }

      .quiz-content h4 {
         width: 100%;
      }

      .quiz-content form {
         display: flex;
         flex-direction: column;
         margin: 0 5px;
         padding: 5px;
      }

      .quiz-content form input[type="radio"] {
         display: none;
      }

      .quiz-content form label {
         position: relative;
         padding-right: 15px;
         cursor: pointer;
      }

      .quiz-content form label:before {
         content: '';
         position: absolute;
         right: 0;
         top: 50%;
         transform: translateY(-50%);
         width: 20px;
         height: 20px;
         border-radius: 50%;
         background-color: #86A7FC;
         display: none;
      }

      .quiz-content form input[type="radio"]:checked + label:before {
         display: block;
      }

      .quiz-content form input[type="radio"]:checked + label {
         color: #86A7FC;
      }

      .submit-button {
         width: 50%;
         margin: 10px 0;
         margin-left: 50% !important;
         padding: 10px 20px;
         background-color: #3498DB;
         color: white;
         border: none;
         border-radius: 5px;
         cursor: pointer;
      }

      .submit-button:hover {
         background-color: #2980B9;
      }
      <!-- End of custom CSS -->
   </style>
</head>
<body>
   <div class="container-fluid" style="width: 100%;">
      <%@include file="component/navbar.jsp" %>
      <h2 class="text-center mt-5 mb-5">Quiz Page</h2>

      <div class="container text-center">
         <div class="row">
            <div class="col-md-8 col-lg-8 mb-3 mx-5 px-5">
               <div class="quiz-content text-start mx-5 px-5">
                  <form action="submitQuiz" method="post">
                  	<input type="hidden" name="quizName" value="${quizName}">
                     <c:forEach var="quiz" items="${quizList}">
                        <!-- Iterate through the quizList -->
                        <h4>${quiz[0]}. ${quiz[1]}</h4>
                        
                        <!-- Iterating through options  -->
                        <c:forEach var="optionIndex" begin="2" end="5">
                           <c:set var="option" value="${quiz[optionIndex]}"/>
                           <input type="radio" name="${quiz[0]}" id="${quiz[0]}_${optionIndex - 1}" value="option ${optionIndex - 1}">
                           <label for="${quiz[0]}_${optionIndex - 1}">(${optionIndex - 1}) ${option}</label><br>
                        </c:forEach>
                        <hr>
                     </c:forEach>
                     <br>
                     <button type="submit" class="submit-button">Submit</button>
                  </form>
               </div>
            </div>
         </div>
      </div>
   </div>
   <%@include file="component/footer.jsp" %>
</body>
</html>
