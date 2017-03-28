/*==========================================================================  
 |   Source code:  PrimeSequence.java
 |        Author:  Dylan Sumler
 |    Student ID:  3538998  
 |    Assignment:  Assignment #5 - Prime Sequencer
 |  
 |        Course:  COP 3337 (Programming II) 
 |       Section:  U02  
 |    Instructor:  William Feild  
 |      Due Date:  28 March 2017, class time
 |
 |	I hereby certify that this collective work is my own
 |	and none of it is the work of any other person or entity.
 |	______________________________________ [Signature]
 |  
 |      Language:  Java 
 |   Compile/Run:  
 |                 
 | 
 |  +-----------------------------------------------------------------------  
 |  
 |  Description:  
 |
 |        Input:  
 |  
 |       Output:  
 |  
 |      Process:  
 |
 |                
 |  
 |   Required Features Not Included: All required features are included.
 |                 
 |  
 |   Known Bugs: None; the program operates as intended. 
 |  *======================================================================*/


package assignment5;

import java.util.Scanner; //for command line input validation

public class SequenceDemo {
   
   public static void main(String[] args){
      int i;
      if(isValid(args)){
         int size = Integer.parseInt(args[1]);
         //for(i = 0; i < size; i++)
           // System.out.println(generateSequence(args)[i]);
		   generateTable(generateSequence(args));
      }  
   }
   
   /**
    * Validate command line arguments to ensure correct user input.
    * Scanner objects are created to check if values in args can be
    * parsed to int without incurring numberformatexception.
    * @param args
    * @return 
    */
   public static boolean isValid(String args[]){
      
      if(args.length < 2){
         System.out.println("Not enough arguments detected. Please enter two"
            + " integer arguments.");
         return false;
      }
      
      Scanner scanin = new Scanner(args[0]);
      Scanner scanin2 = new Scanner(args[1]);
	  
      if(!scanin.hasNextInt() || !scanin2.hasNextInt()){
         System.out.println("Invalid argument type detected. Please enter two"
            + " integer arguments.");
         return false;
      }
	   else
         return true;
   }
   
   /**
    * Generates a sequence of prime numbers starting at the number
    * provided by arguments[1] and totaling at the number provided by
    * arguments[0].
    * @param arguments the command line arguments provided by the user
    * @return primeArray the prime number sequence.
    */
   public static int[] generateSequence(String arguments[]){
      int size = Integer.parseInt(arguments[1]);
      int i;
      int primeArray[] = new int[size];
      PrimeSequence prime = new PrimeSequence(Integer.parseInt(arguments[0]));
      
      for(i = 0; i < size; i++){
         primeArray[i] = prime.next();
      }
      
      return primeArray;
      
   }
   
   /**
    * Generates a table representation of the prime sequence array created
    * using the generateSequence method.
    * @param primeArray 
    */
   public static void generateTable(int primeArray[]){
      int size = primeArray.length;
      int root = (int)Math.sqrt(size);
	   int square = root * root;
      
      PrimeSequence prime = new PrimeSequence(size - 1);
      
	   int i, j;
      int k = 0;
	  
	   if(square == size){
         for(i = 0; i < root; i++){
            System.out.println();
            for(j = 0; j < root; j++){
               System.out.print(primeArray[k] + " ");
               k++;
            }
         }
      }
      else if(prime.next() == size){
         int remainder = size - square;
         for(i = 0; i < remainder; i++){
            System.out.print(primeArray[i] + " ");
         }
         
         if(remainder == 1)
            k++;
         else
            k+= remainder - 1;
         for(i = 0; i < root; i++){
            System.out.println();
            for(j = 0; j < root; j++){
               System.out.print(primeArray[k] + " ");
               k++;
            }
         }
      }              
   }
     
}
