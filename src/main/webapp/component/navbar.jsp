<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<%@ page import="Entities.User" %>



<%
    boolean isLargeScreen = true; //  condition for large screen
    boolean isLogin = (session.getAttribute("userObj") != null);

    Map<String, String> pageUrls = new HashMap<>();
    pageUrls.put("home", "/my-quiz-app/");
    pageUrls.put("results", "/my-quiz-app/resultList");
    pageUrls.put("quizze1", "/my-quiz-app/QuizRequest?quizName=worldgeo.csv"); 
    pageUrls.put("quizze2", "/my-quiz-app/QuizRequest?quizName=science.csv");
    pageUrls.put("quizze3", "/my-quiz-app/QuizRequest?quizName=art.csv");
    pageUrls.put("quizze4", "/my-quiz-app/QuizRequest?quizName=computer.csv");

    pageUrls.put("profile", "/my-quiz-app/profile.jsp");
    pageUrls.put("leaderboard","/my-quiz-app/leaderBoard");
    pageUrls.put("about", "/my-quiz-app/about.jsp");
    pageUrls.put("login", "/my-quiz-app/login.jsp");
    pageUrls.put("logout", "/my-quiz-app/logout");
    
    User user = (User) session.getAttribute("userObj");
    String userName = (user != null) ? user.getName() : "Profile";

%>

<nav class="navbar navbar-expand-lg navbar-light bg-body-tertiary" fixed="top" >
    <div class="container" style="font-family: 'Montserrat', sans-serif; font-weight: bold;" >
        <a class="navbar-brand" href="<%= pageUrls.get("home") %>">
            <a href="<%= pageUrls.get("home") %>" style="color: black; text-decoration: none;">
                <% if (isLargeScreen) 
                { %>                       
                            
                    <h2 style=" font-size: 2rem;"><img src="img/quiz-app-logo.png" alt="My Quiz App Logo" class="logo"
                   style="width: 2rem; margin-right: 5px;"> My Quiz App</h2>
                <% } else { %>
                    <h2 style=" font-size: 2rem;">Quiz App</h2>
                <% }
                %>
            </a>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto"></ul>
            <ul class="navbar-nav justify-content-end">
             <li class="nav-item">
   				 <% if (isLogin) { %>
        			<a class="nav-link" href="<%= pageUrls.get("profile") %>"><%= userName %></a>
    			<% } %>
				</li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Quizzes
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        
                        <li><a class="dropdown-item" href="<%= pageUrls.get("quizze1") %>" >Wolrd geo</a></li>
                        <li><a class="dropdown-item" href="<%= pageUrls.get("quizze2") %>" >Science</a></li>
                        <li><a class="dropdown-item" href="<%= pageUrls.get("quizze3") %>" >Art</a></li>
                        <li><a class="dropdown-item" href="<%= pageUrls.get("quizze4") %>" >Computer</a></li>
                       
                    </ul>
                </li>
                <% if(isLogin){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="<%= pageUrls.get("results") %>" >Results</a>
                </li>
                <%}
                %>
                
                <li class="nav-item">
                    <a class="nav-link" href="<%= pageUrls.get("leaderboard") %>" >Leaderboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%= pageUrls.get("about") %>" >About</a>
                </li>
                
                <li class="nav-item">
                    <% if (!isLogin) 
                { %>
                    <a class="nav-link" href="<%= pageUrls.get("login") %>" >Login</a>
                <% } else { %>
                    <a class="nav-link" href="<%= pageUrls.get("logout") %>" >Logout</a>
                <% }
                %> 
                </li>
                
                
            </ul>
        </div>
    </div>
</nav>
