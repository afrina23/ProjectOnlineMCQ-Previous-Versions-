package sample;

import com.sun.org.apache.regexp.internal.REDebugCompiler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main extends Application {
    private static Stage stage;
    static Pane LogInPage,SignUpPage ,SignUpSuccessPage,LogInSuccessPage,HomePage;
    static Pane AfterPracticePage;
    private static ControllerLogIn login;
    private static String Name;
    private static int numOfQuestion=0;
    public static void setName(String name) {
        Name = name;
    }
    public static void setNumOfQuestion(int n) {numOfQuestion=n;}
    @Override

    public  void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        StartPage();
        //PracticeQuestion();
        //HomePage();
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
        SignUpSuccessPage=loader.load();
        Scene scene= new Scene(SignUpSuccessPage);
        stage.setScene(scene);
        stage.show();

    }

    public static void LogInSuccess() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("LogInSuccessful.fxml"));
        LogInSuccessPage=loader.load();
        Scene scene= new Scene(LogInSuccessPage);
        stage.setScene(scene);
        stage.show();

    }
    //switches to the home page
    public static void HomePage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("HomePage.fxml"));
        HomePage=loader.load();
        Scene scene= new Scene(HomePage);

        stage.setScene(scene);

        stage.show();
    }
    // practice page
    public static void PracticeQuestion() throws IOException {
        BufferedReader frQ= new BufferedReader(new FileReader("Question.txt"));
        BufferedReader frA= new BufferedReader(new FileReader("Answer.txt"));
        String Question,op1,op2,op3,op4;
        String Answer[] = new String[10];
        final ScrollPane sp = new ScrollPane();

        VBox Box = new VBox(10);
        VBox ques = new VBox(10);
        ques.setPadding(new Insets(3));
        Scene scene= new Scene(Box,640,480);
        stage.setScene(scene);
        HBox up=new HBox(400);
        Label practice=new Label("Practice ");
        Label name=new Label(Name);
        practice.setFont(Font.font("System",27));
        name.setFont(Font.font("System",27));
        up.getChildren().addAll(practice,name);


        ques.getChildren().add(up);
        Box.getChildren().addAll(sp);
        VBox.setVgrow(sp, Priority.ALWAYS);

        Label [] question= new Label[10];
        RadioButton [] button=new RadioButton[40];

        for(int i=0,j=0;i<10;i++,j+=4){

            Question=frQ.readLine();
            question[i]=new Label(Question);
            op1=frA.readLine();
            op2=frA.readLine();
            op3=frA.readLine();
            op4=frA.readLine();
            Answer[i]=frA.readLine();

            question[i].setFont(Font.font("System",17));
            button[j]=new RadioButton(op1);
            button[j+1]=new RadioButton(op2);
            button[j+2]=new RadioButton(op3);
            button[j+3]=new RadioButton(op4);

            ques.getChildren().addAll(question[i]);
            ques.getChildren().addAll(button[j],button[j+1],button[j+2],button[j+3]);
        }
        ques.setAlignment(Pos.BASELINE_LEFT);


        HBox forButtons = new HBox(490);
        Button Back= new Button("BACK");
        Button Show= new Button("Show Answer");
        Button  Finish = new Button("Finish");
        forButtons.getChildren().addAll(Back,Show);
        ques.getChildren().addAll(forButtons);
        ques.setMargin(Show,new Insets(10,10,10,10));
        sp.setVmax(440);
        sp.setPrefSize(440, 150);
        sp.setContent(ques);
        Back.setOnAction(e->{
            try {
                Main.HomePage();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        Show.setOnAction(e->{
            for(int i=0;i<10;i++){

                int ans=Answer[(i)].charAt(0)-'0'-1;
                System.out.println(ans);
                if(!button[i*4+ans].isSelected()){
                    System.out.println("yes");
                    System.out.println(button[i*4+ans].getText());
                    String ansue=button[i*4+ans].getText();
                    button[i*4+ans].setSelected(true);
                    button[i*4+ans].setTextFill(Color.RED);

                }
            }
            forButtons.getChildren().remove(Show);
            forButtons.setSpacing(500);
            forButtons.getChildren().addAll(Finish);
        });
        Finish.setOnAction(e->{
            try {
                afterPractice();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        stage.show();
    }

    // closes the program
    public static void afterPractice() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("AfterPractice.fxml"));
        Label UserName=new Label(Name);
        UserName.setLayoutX(294);
        UserName.setLayoutY(36);
        UserName.setFont(Font.font("System",22));
        AfterPracticePage=loader.load();
        AfterPracticePage.getChildren().addAll(UserName);
        Scene scene= new Scene(AfterPracticePage);
        stage.setScene(scene);
        stage.show();
    }
    public static void CloseProgram(){
        stage.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
