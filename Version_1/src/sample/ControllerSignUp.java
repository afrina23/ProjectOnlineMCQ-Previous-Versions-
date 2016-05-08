package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;

/**
 * Created by Admin_8_1 on 08-May-16.
 */
public class ControllerSignUp {
    private Main main;
    @FXML
    private TextField UserName;
    @FXML
    private TextField Email;

    @FXML
    private PasswordField PassWord;

    @FXML
    private PasswordField Confirm;


    //action of sign up button

    public void SignAction(ActionEvent event ) throws IOException {
        String name=UserName.getText();
        String email= Email.getText();
        String password=PassWord.getText();
        String confirm=Confirm.getText();
        System.out.println("n "+name+" e "+email+" p "+password);
        if(!password.equals(confirm)){
            System.out.println("ERROR");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("password doesn't match");
            alert.setHeaderText("Sign In failed");
            alert.setContentText("Confirm your Password");
            alert.showAndWait();
            UserName.setText(null);
            Email.setText(null);
            PassWord.setText(null);
            Confirm.setText(null);
        }
        else{
            // creating new file for information

            // checks if same named account exists
            try{
                BufferedReader fr= new BufferedReader(new FileReader(name+".txt"));
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Username already exists");
                alert.setHeaderText("Sign In failed");
                alert.setContentText("The username you provided already exists.");
                alert.showAndWait();
                UserName.setText(null);
                Email.setText(null);
                PassWord.setText(null);
                Confirm.setText(null);

            }

           catch(FileNotFoundException e){
                File fw= new File(name+".txt");
                PrintWriter bw=new PrintWriter(fw);
                bw.println(name);
                bw.println(email);
                bw.println(password);
                bw.close();
                Main.SignUpSuccess();
            }

        }


    }

    //action of exit button
    public void exitAction(ActionEvent event){
        Main.CloseProgram();
    }



}
