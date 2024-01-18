# My-Quiz-App

Welcome to My-Quiz-App, a Java EE web application where you can take quizzes on various topics like Computer, Art, and Science.

## Technologies Used

- Java
- MySQL
- Bootstrap
- JSP (JavaServer Pages)
- JSTL (JavaServer Pages Standard Tag Library)


![Registration Page](https://github.com/eklavya-byte/My-Quiz-App/blob/main/src/main/webapp/projectImg/My-Quiz-App.png?raw=true)

## Registration

To access quizzes, you need to register. Here's an image of the registration page:

![Registration Page](https://github.com/eklavya-byte/My-Quiz-App/blob/main/src/main/webapp/projectImg/User-Signup.png?raw=true)

## Login

After registration, you can log in to your account. Here's an image of the login page:

![Login Page](https://github.com/eklavya-byte/My-Quiz-App/blob/main/src/main/webapp/projectImg/User-Login.png?raw=true)

## After login home page will look like this 
![Login Page](https://github.com/eklavya-byte/My-Quiz-App/blob/main/src/main/webapp/projectImg/My-Quiz-App-after.png?raw=true)

## Quiz Assessment

Once logged in, click on the card corresponding to the quiz you want to take. For example, clicking on the Computer card takes you to the Computer quiz page:

![Computer Quiz Page](https://github.com/eklavya-byte/My-Quiz-App/blob/main/src/main/webapp/projectImg/Quiz-Page.png?raw=true)

After completing the quiz, click submit, and you will be redirected to the score page:

![Score Page](https://github.com/eklavya-byte/My-Quiz-App/blob/main/src/main/webapp/projectImg/My-Quiz-App-Score.png?raw=true)

Alternatively, you can view yourself on the leaderboard and check the result page.

## Profile

You can view your profile by clicking on your name in the navbar:

![Profile Page](https://github.com/eklavya-byte/My-Quiz-App/blob/main/src/main/webapp/projectImg/Profile-Quiz-App.png?raw=true)

## Running the App

Feel free to fork this repository, run it on your local machine, and enjoy the quizzes! 

## To create database & tables make use of these sql queries 😊

- create database quiz_app;

- CREATE TABLE `quiz_app`.`user_details` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NULL,
  `user_email` VARCHAR(45) NULL,
  `user_password` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`));
  
- CREATE TABLE `quiz_app`.`result` (
  `result_id` INT NOT NULL AUTO_INCREMENT,
  `quiz_name` VARCHAR(45) NULL,
  `quiz_score` VARCHAR(45) NULL,
  `result_email` VARCHAR(45) NULL,
  PRIMARY KEY (`result_id`));

  make relation between that table using following query ->
  
- ALTER TABLE `quiz_app`.`result`
ADD CONSTRAINT `result_user_details_fk`
  FOREIGN KEY (`result_email`)
  REFERENCES `quiz_app`.`user_details` (`user_email`);

  - and inside my-quiz-app/src/main/java/quizUtill/Filehandler pass absolute path of your file
  - if you find any idea how to use relative path there please share with me ! 


# Thank you for using My-Quiz-App!
