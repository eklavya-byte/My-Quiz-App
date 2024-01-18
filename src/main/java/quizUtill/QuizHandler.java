package quizUtill;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuizHandler {


	 public static String getAllQuestions(String quizName) {
	        String quiz = "";
	        Path p1 = Paths.get("E:/JavaEE/my-quiz-app/src/main/java/quizUtill/"+quizName);//working fine ! 
	        //Path p1 = Paths.get(relative path + quizName); this one is not working !! 
	        try {
	            StringBuilder tempQuiz = new StringBuilder();
	            BufferedReader reader = Files.newBufferedReader(p1);

	            String line;
	            reader.readLine();//wasting fist line
	            while ((line = reader.readLine()) != null) {
	                tempQuiz.append(line).append("\n");
	            }

	            quiz = tempQuiz.toString();
	        } catch (IOException e) {
	        	System.out.println("Path not found ! ! ");

	            throw new RuntimeException(e);
	        }

	        return quiz;
	    }

	// sent like that  list contain question which is inside list ! and that list contain option as list

	   // [   [ [question],[a],[b],[c],[d] ], [ [question],[a],[b],[c],[d] ],  [ [question],[a],[b],[c],[d] ],  [ [question],[a],[b],[c],[d] ]   ]

	    public static List<List<String>> listofQuestions (String quizName){
	        List<List<String>> question = new ArrayList<>();

	        for (String s : getAllQuestions(quizName).split("\n")) {
	            question.add(List.of(s.split(",")));
	        }
	        return question;
	    }
	    
	    public static List<String> answers(String quizName){
	        List<String> answers = new ArrayList<>();
	        List<List<String>> listofQuestions = listofQuestions(quizName);
	        for(List<String> s : listofQuestions){
	            answers.add(s.get(6));
	        }
	        return answers;
	    }

}

