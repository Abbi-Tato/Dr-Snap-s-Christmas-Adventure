import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class drSnapAdventureMain extends Application 
{
    //main is mostly pointless but it launches the javaFX magic
    public static void main(String[] args) 
    {
        launch(args);
    }
    // a GridPane object to lay out our graphical interface
    public GridPane grid;
    //creating the text and buttons
    public Text text1;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button advanceButton;
    textHandler mainHandler = new textHandler();
    int progress = 0;
     
    public void start(Stage window) 
    {
        //set window title
        window.setTitle("javaFX practice");
        
        
        //creating the gridpane
        grid = new GridPane();
        
        //setting the properties for the main text field
        text1 = new Text(mainHandler.currentString);
        text1.setFont(new Font("Helvetica", 30));
        text1.setWrappingWidth(1100);
        grid.add(text1,0,0);
        
        //creating the various buttons
        button1 = new Button(mainHandler.buttonA);
        button2 = new Button(mainHandler.buttonB);
        button3 = new Button(mainHandler.buttonC);
        advanceButton = new Button("Advance");
        
        //setting button sizes
        button1.setPrefSize(500,100);
        button2.setPrefSize(500,100);
        button3.setPrefSize(500,100);
        advanceButton.setPrefSize(500,50);
        
        //setting button font
        button1.setFont(new Font("Helvetica", 15));
        button2.setFont(new Font("Helvetica", 15));
        button3.setFont(new Font("Helvetica", 15));
        button1.setWrapText(true);
        button2.setWrapText(true);
        button3.setWrapText(true);
        advanceButton.setFont(new Font("Helvetica", 30));
        
        //creating a vbox to place the buttons at the side
        VBox vbButtons = new VBox();
        vbButtons.setSpacing(10);
        vbButtons.setPadding(new Insets(50, 0, 0, 1200)); 
        vbButtons.getChildren().addAll(button1, button2, button3, advanceButton);
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        
        //adding all the buttons to the grid
        grid.add(vbButtons,0, 0);
        button1.setOnAction(this::button1Click);
        button2.setOnAction(this::button2Click);
        button3.setOnAction(this::button3Click);
        advanceButton.setOnAction(this::advanceButtonClick);
        window.setScene(new Scene(grid, 1800, 960));
        window.show();
    }
    
    public void button1Click(ActionEvent event) 
    {
        mainHandler.choiceMade = "A";
        mainHandler.choiceProgress += 1; 
        mainHandler.choiceMaker(progress);
        text1.setText(mainHandler.currentString);
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        advanceButton.setDisable(false);
    }
    
    public void button2Click(ActionEvent event)
    {
        mainHandler.choiceMade = "B";
        mainHandler.choiceProgress += 1; 
        mainHandler.choiceMaker(progress);
        text1.setText(mainHandler.currentString);
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        advanceButton.setDisable(false);
        progress += 1;
    }
    
    public void button3Click(ActionEvent event)
    {
        mainHandler.choiceMade = "C";
        mainHandler.choiceProgress += 1; 
        mainHandler.choiceMaker(progress);
        text1.setText(mainHandler.currentString);
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        advanceButton.setDisable(false);
        progress += 1;
    }
    
    public void advanceButtonClick(ActionEvent event)
    {
        if (progress == mainHandler.choice1Posit || progress == mainHandler.choice2Posit|| progress == mainHandler.choice3Posit)
        {
            mainHandler.progressCycle(progress);
            button1.setDisable(false);
            button2.setDisable(false);
            button3.setDisable(false);
            button1.setText(mainHandler.buttonA);
            button2.setText(mainHandler.buttonB);
            button3.setText(mainHandler.buttonC);
            advanceButton.setDisable(true);
            progress += 1;
        }
        else if (progress == 42)
        {
            mainHandler.endingChooser();
            text1.setText(mainHandler.currentString);
        }
        else
        {
            progress += 1;
            mainHandler.progressCycle(progress);
            text1.setText(mainHandler.currentString);
        }
    }
    
  }