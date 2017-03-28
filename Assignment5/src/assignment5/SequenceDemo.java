/*==========================================================================  
 |   Source code:  SequenceDemo.java
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
 |   Compile/Run:  javac Sequence.java PrimeSequence.java SequenceDemo.java
 |                 java SequenceDemo int x int y
 |                 Where x is the number to start the prime sequence from
 |                 and y is the number of prime numbers to output.
 |                 
 | 
 |  +-----------------------------------------------------------------------  
 |  
 |  Description:  This class tests the functionality of the PrimeSequence
 |                class by generating a sequence of prime numbers based off
 |                user input and outputing the sequence as table. Additionally,
 |                a histogram representing the number of occurrences of the last
 |                digit in each prime number will be displayed.
 |
 |        Input:  Two command line arguments provided by the user. The first
 |                argument indicates where the prime sequence should start, 
 |                and the second argument indicates how many prime numbers
 |                should be generated.
 |  
 |       Output:  Will output a table representation of the generated prime
 |                sequence and a histogram representing the number of 
                  occurrences the last digit in each prime number.
 |  
 |      Process:  The program will execute four high-level methods in main
 |                which will validate user input, generate/print the 
 |                sequence, and generate/print the histogram.
 |
 |                
 |  
 |   Required Features Not Included: The histogram does not provide the
 |                exact number of occurrences of the final digit in each
 |                prime number. An approximation is generated represented by
 |                '*' and the approximation is always rounded down,
 |                i.e 29 occurrences will be represented as ' * * ' for a
 |                scale of 10.
 |                 
 |  
 |   Known Bugs: None; the program operates as intended. 
 |  *======================================================================*/


package assignment5;

import java.util.Scanner; //for command line input validation


public class SequenceDemo {
   
   //1 + the max possible value for rightmost digit in a given number
   private static final int MAX_DIGIT = 10; 
   private static final int DEFAULT_SCALE = 10;  //used to scale histogram
   
   public static void main(String[] args){
      
      if(isValid(args)){  
         int primeSequence[] = generateSequence(args);
		   generateTable(primeSequence);    
         generateHistogram(primeSequence);
      }  
   }
   
   /**
    * Validate command line arguments to ensure correct user input.
    * Scanner objects are created to check if values in args can be
    * parsed to int without incurring numberformatexception.
    * @param args command line arguments passed by the user
    * @return true if the arguments are valid, false if not
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
    * Determines if a table will look square or irregular and calls the
    * appropriate method.
    * @param primeArray the prime number sequence
    */
   public static void generateTable(int primeArray[]){
      int size = primeArray.length;
      int root = (int)Math.sqrt(size);
	   int square = root * root;
  
      //if the table can be representd as a perfect square
	   if(square == size){
         perfectSquareTable(root, primeArray);
      }
      else{
         int remainder = size - square;
         irregularTable(root, remainder, primeArray);
      }
   }
   
   /**
    * Generates a table at that looks as square as possible
    * @param root the size used for the rows/columns of the table
    * @param primeArray the prime number sequence
    */
   public static void perfectSquareTable(int root, int primeArray[]){
      
      int i, j;
      int k = 0; //used to keep track of the index of the sequence array
 
      System.out.println("Prime Sequence Table\n");
      for(i = 0; i < root; i++){
            System.out.println();
            for(j = 0; j < root; j++){
               System.out.format("%6d%1s", primeArray[k], " ");           
               k++;
            }
         }     
   }
   
   /**
    * Generates a table that attempts to look as "square as possible"
    * @param root the size used for the rows/columns of the table
    * @param remainder 
    * @param primeArray 
    */
   public static void irregularTable(int root, int remainder, int primeArray[]){
      int i, j;
      int k = 0; //used to keep track of the index of the sequnce arrya
      int excess = 0;  //number of elements in excess row to be printed
	  
	  if(root > 10){
         excess = root - 10;
         root = 10;
      }
      System.out.println("Prime Sequence Table\n");
      if(remainder > 10){
            for(i = 0; i < (remainder % 10); i++){
               System.out.format("%6d%1s", primeArray[i], " ");
            }
            for(i = 0; i < (remainder/10); i++){
               System.out.println();
               for(j = 0; j < 10; j++){
                  System.out.format("%6d%1s", primeArray[k + remainder % 10],
                     " ");
                  k++;
               }
            }
         }
		   else{
            for(i = 0; i < remainder; i++){
               System.out.format("%6d%1s", primeArray[i], " ");
            }
		   }
		 
         if(remainder == 1)
            k++;
         else
            k+= remainder;
         
         for(i = 0; i < (root + excess); i++){
            System.out.println();
            for(j = 0; j < root; j++){
               System.out.format("%6d%1s", primeArray[k], " ");
               k++;
            }
         }
   }
   
   /**
    * Generates a histogram detailing the number of occurrences of the
    * last digit of each number in the prime sequence
    * @param primeArray the prime number sequence
    */
   public static void generateHistogram(int primeArray[]){
      int i, j;
      int occurrences = 0;
      
      int scale = determineScale(primeArray);
      
      System.out.println("\n\nPrime Sequence Histogram\n");
      for(i = 0; i < MAX_DIGIT; i++){
         System.out.format("%d%1s", i, " | ");
         for(j = 0; j < primeArray.length; j++){
            if((primeArray[j] % MAX_DIGIT) == i)
               occurrences++;          
         }
         for(j = 0; j < (occurrences / scale); j++)
            System.out.format("%-5s", "* ");
         occurrences = 0;
         System.out.println();
      }
      System.out.print("   ___________________________________________\n    ");
      for(i = 1; i < MAX_DIGIT; i++)
         System.out.format("%-5d", (i * scale) );
       
   }
   
   /**
    * Determines the scale of the histogram
    * @param primeArray the prime number sequence
    * @return the size of the scale to be used for the histogram
    */
   public static int determineScale(int primeArray[]){
      int i, j;
      int scale = 1;
      int occurrences = 0;
      for(i = 0; i < MAX_DIGIT; i++){
         for(j = 0; j < primeArray.length; j++){
            if((primeArray[j] % MAX_DIGIT) == i)
               occurrences++;
         }
         if(occurrences > (scale *DEFAULT_SCALE))
            scale *= DEFAULT_SCALE;
         else
            occurrences = 0;
      } 
      return scale;
   }
}
