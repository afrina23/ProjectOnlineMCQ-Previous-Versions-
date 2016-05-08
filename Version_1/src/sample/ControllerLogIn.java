package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ControllerLogIn {

      private Main main;

      @FXML
      private TextField LogInName;

      @FXML
      private TextField LogInEmail;

      @FXML
      private PasswordField LogInPassword;

      @FXML
      private Label WelcomeUser;



      //go to sign up page
      public void SignAction(ActionEvent event) throws IOException {
          main.SignUpPage();
          System.out.println("Noting");
      }

      public void LogInAction(ActionEvent event) throws IOException {
            String name=LogInName.getText();
            String email=LogInEmail.getText();
            String password= LogInPassword.getText();
            try {
                  // reading from file
                  BufferedReader fr= new BufferedReader(new FileReader(name+".txt"));
                  String UserName=fr.readLine();
                  String UserEmail=fr.readLine();
                  String UserPassword=fr.readLine();
                  fr.close();
                  if(name.equals(UserName) &&  email.equals(UserEmail) &&password.equals(UserPassword)){
                        System.out.println("Log in Successful");

                        Main.LogInSuccess();
                  }
                  else{
                        reset();
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Wrong information");
                        alert.setHeaderText("Log In failed");
                        alert.setContentText("The information you provided is wrong.");
                        alert.showAndWait();
                        System.out.println("No account in this name ");
                  }
            } catch (FileNotFoundException e) {
                  reset();
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setTitle("Username does not exist");
                  alert.setHeaderText("Log In failed");
                  alert.setContentText("The username you provided does not  exist.");
                  alert.showAndWait();
                  System.out.println("No account in this name ");
            }
      }
      public void reset() {
            LogInName.setText(null);
            LogInEmail.setText(null);
            LogInPassword.setText(null);
      }
      public void exitAction(ActionEvent event){
            Main.CloseProgram();
      }

}
