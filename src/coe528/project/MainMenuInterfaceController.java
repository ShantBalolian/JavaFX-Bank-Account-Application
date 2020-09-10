/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author reals
 */
public class MainMenuInterfaceController implements Initializable{
 /**  OVERVIEW: This class is the controller class for the MainMenu interface 
 *   stage, it runs first when the application is started, it contains two 
 *   TextFields, username and password, and directs the user to the  
 *   manager or customer stage based on the given information.
 *   This class is an immutable class.
 *   
 *   
 *  For a java MainMenuInterfaceController object c,
 *   AF(c)= A TextField input i, such that
 *          i.username = c.username;
 *          i.password = c.password;
 *   RI: if ( (c.username != null) &&  (c.password != null))
 *       return true, otherwise false.
 *      
 */
    
    //variables to read the information of the customer's account.
    private String usrname, pssword;
    
    @FXML
    private TextField username;

    @FXML
    private TextField password;
     
  //  @FXML
  //private Label label;
    
  
   
   /** REQUIRES: username and password of type string
     * EFFECTS: Directs the user to manager or customer window
     * @param event
     * @throws java.io.IOException
    */ 
        @FXML
    public void handleLogin(ActionEvent event) throws IOException {
           try { 
      //object of type mManager
    Manager manager = new Manager("admin","admin");
    //rep
     String inputtedUsername = username.getText();
     String inputtedPassword = password.getText();
     double balance;
  
   
        // login
        if(inputtedUsername.equals(manager.getUsername()) && inputtedPassword.equals(manager.getPassword())){
            //opens the manager window
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ManagerStage.fxml"));
            Parent root = (Parent) loader.load();
      Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
      stage.hide();
      stage.setScene(new Scene(root));
      stage.show();
     
        }
          
        else{
           
     File file = new File(inputtedUsername + ".txt");
     FileReader reader = new FileReader(file);
     BufferedReader br = new BufferedReader(reader);
     String line;
     while((line = br.readLine())!= null){
         String[] accInfo = line.split(",");
         usrname = accInfo[0];
         pssword = accInfo[1];
         balance = Double.parseDouble(accInfo[2]);    
     }
      br.close();
         
            
          
            
     if(usrname.equals(inputtedUsername) && pssword.equals(inputtedPassword)){

             FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerStage.fxml"));
            Parent root = (Parent) loader.load();
            // seding the username info to the customer window.
      CustomerStageController controller = loader.getController();
      controller.receieve(inputtedUsername);
       
        //opens the customer window
      Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
      stage.hide();
      stage.setScene(new Scene(root));
      stage.show();
        }
     else System.out.println("either username or password is wrong, please try again");
     
        }
        }     
         catch (Exception e){
                System.out.println("account doesn't exist");
              }
         

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    //method of RI

    /**
     *
     * @return
     */
 public boolean repOK(){
        if(username.getText() != null && password.getText() != null){
            return true;
        }
        return false;
 }
    //method of AF

    /**
     *
     * @return
     */
 @Override
 public String toString(){
     return "username: "+ username.getText() + "\n password: " + password.getText();
 }   
 

 
}