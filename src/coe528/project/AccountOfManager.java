
/* This class is the manager's account, it is going to handle the 
   addition and the deletion of the customers.
 */
package coe528.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AccountOfManager{
    
public static void addACustomer(String username,String password, double money) throws IOException{
    try{
    File file = new File(username + ".txt");
      System.out.println("customer account created with an initial balance of $100: " + file);
           
    //File file = new File(username + ".txt"); 
    FileWriter write = null;
    write = new FileWriter(file);
    
    file.createNewFile();
     write.write(username+","+ password+"," +money);
     write.close();
    }
    catch(Exception e){
        System.out.println("Customer account has not been created");
    }
}
public static void deleteACustomer(String username){
    File file = new File(username+".txt");
    if(file.exists()){
         file.delete();
        System.out.println(username +"'s "+ "account has been deleted successfully");
  
    }
    else{
               System.out.println("customer account does not exist");
      
}
}
    
}   

