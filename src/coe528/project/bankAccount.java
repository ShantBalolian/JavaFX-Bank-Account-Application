
package coe528.project;


/* this class has the information of the customer's account, details 
   the balance, and online purchases.
   This class is also the context for the state design pattern, as it is 
   responsible for the change of state of the customer levels.
*/
public class bankAccount {
   private Customer customer;
   private double balance;
   private CustomerLevel level;
   
   
   public bankAccount(Customer customer, double amount){
       this.customer = customer;
       this.balance = amount;    
   }
  //  constructor which is responsible for the change of states
  public bankAccount(double balance){
      this.balance = balance;
        if (balance < 10000)
     level = new SilverCustomer();
      else if (balance >= 10000 && balance < 20000)
     level = new GoldCustomer();
      else if (balance >= 20000)
     level = new PlatinumCustomer();
  }
   
      public double purchaseFee(){
      return level.purchaseFee();
   }
      
   public void DepositMoney(double m){
       this.balance = m + this.balance;
   }
   
   public void WithdrawMoney(double m){
       this.balance = this.balance - m;
   }
   
   public double getBalance(){
       return balance;
   }
   
  
   @Override
  public String toString(){
      return level.toString();
  }

   

    
    
}
