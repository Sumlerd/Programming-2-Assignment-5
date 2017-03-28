/*==========================================================================  
 |   Source code:  Sequence.java
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
 |  Description:  Interface to be implemented by the PrimeSequence class. 
 |                Contains one method, next.
 |
 |        Input:  No input is used.
 |  
 |       Output:  No output will be generated.
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

public interface Sequence {
   
   /**
    * Will be used by any class that requires a unique sequence of integers
    * to be generated.
    * @return an integer representation of the current number in the sequence
    */
   int next();
}
