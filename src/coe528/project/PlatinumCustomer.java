
package coe528.project;



public class PlatinumCustomer extends CustomerLevel {
    private double fee = 0;
   
     //purchasing an item as a platinum member will not cost any extra fees. 
   @Override
     public double purchaseFee(){
   return fee;
   }
    
    
    
                @Override
           public String toString(){
           return "Platinum level";
       }

    }

