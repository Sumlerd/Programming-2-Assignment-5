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

public class PrimeSequence implements Sequence {
   
   private final int BASE_VALUE = 2;   //lowest possible used to determine prime
   private int current;
   
   
   PrimeSequence(int SequenceValue){
      current = SequenceValue;
   }
   
   /**
    * 
    * @return 
    */
   public int next(){
      boolean undetermined = true;
      int divisor = BASE_VALUE;
      
      do{
         if((divisor * BASE_VALUE) > current){
            undetermined = false;
         }
         else if((current % divisor) == 0){
            current++;
            divisor = BASE_VALUE;
         }
         else
            divisor++;
      }while(undetermined);
      
      return current;
   }
   
   /**
    * Retrieves the current value of the sequence.
    * @return the current value of the sequence
    */
   public int getCurrent(){
      return current;
   }
   
   /**
    * Set the current value of the sequence.
    */
   public void setCurrent(int newCurrent){
      current = newCurrent;
   }
   
   
}
