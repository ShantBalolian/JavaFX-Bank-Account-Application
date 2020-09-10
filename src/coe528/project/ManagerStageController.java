/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;

/**
 * FXML Controller class
 *
 * @author reals
 */
public class ManagerStageController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddACustomer(ActionEvent event) {
        try{
        TextInputDialog input= new TextInputDialog(); 
        input.setTitle("Adding a customer");
        input.setContentText("add a customer by entering the cutomer's username,\n"
                + "and password seperated by only a comma (,)");
        Optional<String> value = input.showAndWait();
        String info = value.get();
        String [] customer = info.split(",");
        String username = customer[0];
        String password = customer[1];
        double balance = 100.0;
  
        
        //creating a file object with the name of the username entered
        // to check if a file with the same username already exists.
        File file = new File(username +".txt");
        
        boolean exists;
        exists = file.exists();
        if (exists == true){
            System.out.println("a file with the name " + username + ".txt already exists");}
        else{AccountOfManager.addACustomer(username, password, balance);}
        }       
        catch (Exception e){
            System.out.println("unable to add a customer");
        }
               
    }

    @FXML
    private void DeleteAcustomer(ActionEvent event) {
         try{
        TextInputDialog input= new TextInputDialog(); 
        input.setTitle("Deleting a customer");
        input.setContentText("delete  a customer by entering the customer's username");
        Optional<String> value = input.showAndWait();
        String username = value.get();
        AccountOfManager.deleteACustomer(username);
        }       
        catch (Exception e){
            System.out.println("unable to delete a custoemr");
        }
        
    }

    @FXML
    private void LogOut(ActionEvent event) throws IOException {
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
        System.out.println("could not go logout");
    }
    }
}
