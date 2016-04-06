//CSE 373 A
//Homework 1
//Fangzheng Sun
//04/07/2015

//The Executor is the main. Given the arrays of the answers and questions, it firstly rellocate
//the questions randomly to oracles each corresponding to one answer. Then it prints out the 
//questions and answers in the standard format in a round robin fashion until no questions in 
//the oracles anymore.
import java.util.*;

public class Executor {

	public static void main(String[] args) {
		Utility.init(); // initializes file readers
		String[] questions = Utility.readQuestions(); //reads question.txt file into questions array
		String[] answers = Utility.readAnswers(); // reads answers.txt file into answers array
		
		int numOracles = answers.length; //finds the number of oracles
      
      //Part 1: For the ArrayQueue 
      //(Please temporarily comment the part 2)
      
      Map<Integer, ArrayQueue> oracle =  new TreeMap<Integer, ArrayQueue>();//Creating a map to store the questions.
      //Initialize one ArrayQueue per oracle.
      for(int i = 0; i < numOracles; i++){
          oracle.put(i, new ArrayQueue(questions.length));
      }
      //Put the questions into the queues, assigning each one to the queue of the oracle 
      //whose number is returned by the random number generator.
      for(int j = 0; j < questions.length; j++){
          String question = questions[j];
          int answer = Utility.random(numOracles);
          oracle.get(answer).enqueue(question);
      }
      //Loop through the oracles, having each one remove a question from its queue (if 
      //empty do nothing) and answer it with its unique answer (oracle[k] uses answers[k]). 
      //Do this repeatedly till all queues become empty.
      while(!oracle.isEmpty()){
          for(int k = 0; k < numOracles; k++){
              if(oracle.containsKey(k)){
                  ArrayQueue set = oracle.get(k);
                  if(set.getSize() < 1){
                      oracle.remove(k);
                  }else{
                      String ques = set.dequeue();
                      String ans = answers[k];
                      System.out.println(ques + ":" + ans);
                  }
              }
          }
      }
      //Part1 ends.
      
      
      //Part 2: For the ListQueue 
      //(Please uncomment this part and comment the part 1)
      
      Map<Integer, ListQueue> oracle =  new TreeMap<Integer, ListQueue>();//Creating a map to store the questions.
		//Initialize one ArrayQueue per oracle.
      for(int i = 0; i < numOracles; i++){
          oracle.put(i, new ListQueue());
      }
		//Put the questions into the queues, assigning each one to the queue of the oracle 
      //whose number is returned by the random number generator.
      for(int j = 0; j < questions.length; j++){
          String question = questions[j];
          int answer = Utility.random(numOracles);
          oracle.get(answer).enqueue(question);
      }
		//Loop through the oracles, having each one remove a question from its queue (if 
      //empty do nothing) and answer it with its unique answer (oracle[k] uses answers[k]). 
      //Do this repeatedly till all queues become empty.
      while(!oracle.isEmpty()){
          for(int k = 0; k < numOracles; k++){
              if(oracle.containsKey(k)){
                  ListQueue set = oracle.get(k);
                  if(set.getSize() < 1){
                      oracle.remove(k);
                  }else{
                      String ques = set.dequeue();
                      String ans = answers[k];
                      System.out.println(ques + ":" + ans);
                  }
              }
          }
      }
      //Part2 ends.
	}
}

