package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Created by Admin_8_1 on 12-May-16.
 */
public class ControllerHome {
    private Main main;
    ObservableList<String> Subject= FXCollections.
            observableArrayList("English","Bangla","General Knowledge");


    @FXML
    private GridPane GridBox;

    @FXML
    private ChoiceBox SubjectChoice;

    @FXML
    private RadioButton Practice;
    @FXML
    private RadioButton OnlineTest;

    @FXML
    private  RadioButton Easy;

    @FXML
    private  RadioButton Medium;

    @FXML
    private  RadioButton Hard;
    @FXML
    public void initialize(){
        SubjectChoice.setItems(Subject);
        SubjectChoice.setValue("English");
    }


    public void exitAction(ActionEvent event){
        Main.CloseProgram();
    }


    public void LogOutAction() throws IOException {
        Main.StartPage();
    }
    public void StartButton() throws IOException {
        if(Practice.isSelected()){
            System.out.println("practice selected");
            Main.PracticeQuestion();
        }
        if(OnlineTest.isSelected()){

        }
        System.out.println("Started ");
    }
}
