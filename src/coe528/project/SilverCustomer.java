
package coe528.project;


public class SilverCustomer extends CustomerLevel{
    private double fee = 20;

    
   //purchasing an item as a silver member will cost $20 extra 
        @Override
   public double purchaseFee(){
   return fee;
   }

    
 
          @Override
       public String toString(){
           return "Silver level";
       } 
}
