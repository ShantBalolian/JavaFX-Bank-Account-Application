/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author reals
 */
public class CustomerStageController implements Initializable {
    private String username;
    private String username2; 
    private String password2;
    private double balance;
    private Customer customer;
    @FXML
  
    
     
        
 
  

      //receieves the username from the mainmenu window
     public void receieve(String username3) {
          username = username3;
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   

        // TODO
    }    

    @FXML
    private void handleCheckBalance(ActionEvent event) throws IOException {
           
            File file = new File(username+".txt");
        FileReader reader = new FileReader(file);
     BufferedReader br = new BufferedReader(reader);
     String line;
     while((line = br.readLine())!= null){
         String[] accInfo = line.split(",");
         username2 = accInfo[0];
         password2 = accInfo[1];
         balance = Double.parseDouble(accInfo[2]);
     }
     //creating a new text to put in the middle of the scene, while also 
     //customizing the font,color, and layout
 
    bankAccount account = new bankAccount(customer,balance);  
    bankAccount level = new bankAccount(account.getBalance());
     Text mainText = new Text();
     mainText.setText("Your account is "+ level);
     mainText.setFont(Font.font ("regular",25));
     mainText.setFill(Color.web("#007c16"));
     mainText.setLayoutX(50);
     mainText.setLayoutY(90); 
    
    
    
    
     Text t = new Text();
     t.setText("you currently have $" + balance + " in your bank account");
     t.setFont(Font.font ("regular",25));
     t.setFill(Color.web("#007c16"));
     t.setLayoutX(50);
     t.setLayoutY(50);
     //adding the components of the text t to a group
     
     Group group = new Group();
     group.getChildren().add(t);
     group.getChildren().add(mainText);
     //creating a scene and adding the group instance into it.
     Scene scene = new Scene(group,600,100);
     //creating a new stage and adding in the text and the scene.
     Stage stage = new Stage();
     stage.setTitle("Checking Balance");
     stage.setScene(scene);
     stage.show();
    }

    @FXML
    private void handleDepositMoney(ActionEvent event) throws IOException {
   try{
        File file = new File(username+".txt");
        FileReader reader = new FileReader(file);
     BufferedReader br = new BufferedReader(reader);
     String line;
     while((line = br.readLine())!= null){
         String[] accInfo = line.split(",");
         username2 = accInfo[0];
         password2 = accInfo[1];
         balance = Double.parseDouble(accInfo[2]);
     }
         br.close();
         //creating an account object and reading the user input value
     bankAccount account = new bankAccount(customer,balance);
        TextInputDialog input= new TextInputDialog(); 
        input.setTitle("Deposit");
        input.setWidth(1000);
        input.setContentText("deposite money into your account");
        Optional<String> value = input.showAndWait();
        String money = value.get();
        double amount = Double.parseDouble(money);
        if (amount <= 0)
            System.out.println("please deposit a positive amount larger than zero ");
        else  {  
        account.DepositMoney(amount);     
        balance = account.getBalance();
        System.out.println("you now have "+"$ "+ balance+" in your account");
        }
        FileWriter writer = new FileWriter(username+".txt"/*+"Updated.txt"*/);
        writer.write(username2 +","+ password2 +","+ balance);
        writer.close();
   }
   catch (Exception e){
       System.out.println("could not deposit, there was a mistake, please enter a positive amount bigger than zero.");
   }
    }
    @FXML
    private void handleWithdrawMoney(ActionEvent event) throws FileNotFoundException, IOException {
        try{
         File file = new File(username+".txt");
        FileReader reader = new FileReader(file);
     BufferedReader br = new BufferedReader(reader);
     String line;
     while((line = br.readLine())!= null){
         String[] accInfo = line.split(",");
         username2 = accInfo[0];
         password2 = accInfo[1];
         balance = Double.parseDouble(accInfo[2]);
     }
         br.close();
         
         
           bankAccount account = new bankAccount(customer,balance);
           
           
        TextInputDialog input= new TextInputDialog(); 
        input.setTitle("Withdraw");
        input.setWidth(1000);
        input.setContentText("Withdraw money from your account");
        Optional<String> value = input.showAndWait();
        String money = value.get();
        double amount = Double.parseDouble(money);
        if (amount < 0)
            System.out.println("please enter a positive amount bigger than zero");
        else if (amount > balance)
            System.out.println("you don't have enough money in your account");
        else{
            account.WithdrawMoney(amount);
            balance = account.getBalance();
            System.out.println("you now have "+"$ "+ balance+" in your account");
        }
        
        FileWriter writer = new FileWriter(username+".txt");
        writer.write(username2 +","+ password2 +","+ balance);
        writer.close();
        }
        catch (Exception e){
            System.out.println("could not withdraw, there was a mistake, please enter a positive amount bigger than zero.");
        }
    }
    

    @FXML
    private void handleOnlineShop(ActionEvent event) {
        
    try{
         
         File file = new File(username+".txt");
        FileReader reader = new FileReader(file);
     BufferedReader br = new BufferedReader(reader);
     String line;
     while((line = br.readLine())!= null){
         String[] accInfo = line.split(",");
         username2 = accInfo[0];
         password2 = accInfo[1];
         balance = Double.parseDouble(accInfo[2]);
     }
         br.close();
         
         
           bankAccount account = new bankAccount(customer,balance);
           bankAccount level = new bankAccount(account.getBalance());
           double price = 50.0;
           if (price + level.purchaseFee()> balance ){
               System.out.println("you don't have enough money to buy this item");
           }
           else{
            account.WithdrawMoney(level.purchaseFee() + price);
           
           balance = account.getBalance();
      
        
        FileWriter writer = new FileWriter(username+".txt");
        writer.write(username2 +","+ password2 +","+ balance);
        writer.close();
        
           Text t = new Text();
         
     t.setText("You just purchased an item for $50,\nsince "
             + "you are a "+ level +" member,\nyou had to pay a fee of $" +level.purchaseFee()
             + "\nyou now have $" + balance+" in your bank account.");
     t.setFont(Font.font ("regular",18));
     t.setFill(Color.web("#007c16"));
     t.setLayoutX(50);
     t.setLayoutY(50);
     //adding the components of the text t to a group    
     Group group = new Group();
     group.getChildren().add(t);
     //creating a scene and adding the group instance into it.
     Scene scene = new Scene(group,600,200);
     //creating a new stage and adding in the text and the scene.
     Stage stage = new Stage();
     stage.setTitle("Online Shop");
     stage.setScene(scene);
     stage.show();
           }
       }
       catch (Exception e){
            System.out.println("could not purchase, there was a mistake.");
        }
    }

    @FXML
    private void handleLogout(ActionEvent event) {
                          //opens the login window
    try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenuInterface.fxml"));
            Parent root = (Parent) loader.load();
    //   ManagerStageController controller = loader.getController();
       
        
      Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
      stage.hide();
      stage.setScene(new Scene(root));
      stage.show();
    }
    catch (Exception e){
       System.out.println("could not logout");
    }
    }
    
    }

  
    

