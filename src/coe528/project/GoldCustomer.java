
package coe528.project;


public class GoldCustomer extends CustomerLevel {
    private double fee = 10;

    
     //purchasing an item as a gold member will cost $10 extra 
      @Override
   public double purchaseFee(){
   return fee;
   }


    
        @Override
            public String toString(){
           return "Gold level";
       }

 
    }


