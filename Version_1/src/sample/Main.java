package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stage;
     static Pane LogInPage,SignUpPage ,SignUpSuccess,LogInSuccessPage;
    @Override

    public  void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        StartPage();
    }
    //page 1, contains login,sign up button
    public static void StartPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("FrontPage.fxml"));
        LogInPage=loader.load();
        Scene scene= new Scene(LogInPage);
        stage.setScene(scene);
        stage.show();

    }
    // page 2, contains sign up information
    public static void SignUpPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("SignUpPage.fxml"));
        SignUpPage=loader.load();
        Scene scene= new Scene(SignUpPage);
        stage.setScene(scene);
        stage.show();

    }

    // page 3, if sign in is successful
    public static void SignUpSuccess() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("SignUpSuccessful.fxml"));
        LogInSuccessPage=loader.load();
        Scene scene= new Scene(LogInSuccessPage);
        stage.setScene(scene);
        stage.show();

    }

    public static void LogInSuccess() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("LogInSuccessful.fxml"));
        SignUpSuccess=loader.load();
        Scene scene= new Scene(SignUpSuccess);
        stage.setScene(scene);
        stage.show();

    }

    // closes the program
    public static void CloseProgram(){
        stage.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
