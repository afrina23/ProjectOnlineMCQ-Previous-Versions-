package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * Created by Admin_8_1 on 12-May-16.
 */
public class AfterPracticeController {
    @FXML
    private Label UserName;
    @FXML
    public void initialize(){
        UserName= new Label(ControllerLogIn.getName());
    }
    public void exitAction(ActionEvent event){
        Main.CloseProgram();
    }


    public void LogOutAction() throws IOException {
        Main.StartPage();
    }
    public void GoToHome() throws IOException {
        Main.HomePage();
    }
}
