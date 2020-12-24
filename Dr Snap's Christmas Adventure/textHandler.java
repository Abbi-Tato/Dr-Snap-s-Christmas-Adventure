import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.util.ArrayList;

public class textHandler
{
    // instance variables - replace the example below with your own
    ArrayList<String> dialogue = dialoguefileReader();
    ArrayList<String> choiceA = choiceAfileReader();
    ArrayList<String> choiceB = choiceBfileReader();
    ArrayList<String> choiceC = choiceCfileReader();
    String currentString = dialogue.get(0);
    String choiceMade = "";
    String buttonA = "";
    String buttonB = "";
    String buttonC = "";
    int choiceProgress = 0;
    int choice1Posit = 16;
    int choice2Posit = 28;
    int choice3Posit = 40;
    //favor stat for keeping track of progress
    int favor = 0;
    public void progressCycle(int progress)
    {
        if (progress == dialogue.size())
        {
            System.exit(0);
        }
        if (progress == choice1Posit || progress == choice2Posit|| progress == choice3Posit)
        {
            buttonA = choiceA.get(choiceProgress);
            buttonB = choiceB.get(choiceProgress);
            buttonC = choiceC.get(choiceProgress);
        }
        else
        {
            currentString = dialogue.get(progress);
        }
    }
    
    public void choiceMaker(int progress)
    {
        switch (choiceMade)
        {
            case "A":
                currentString = choiceA.get(choiceProgress); 
                choiceProgress += 1;
                switch(progress)
                {
                    case 17:
                        favor -= 1;
                        break;
                    case 29:
                        favor += 1;   
                        break;
                    case 41:
                        favor -= 6;
                        break;
                    default:
                        break;
                        
                }
                break;
            case "B":
                currentString = choiceB.get(choiceProgress);
                choiceProgress += 1;
                switch(progress)
                {
                    case 17:
                        favor += 1;
                        break;
                    case 29:
                        favor +=2;
                        break;
                    case 41:
                        favor += 2;
                        break;
                    default:
                        break;                    
                }
                break;
            case "C":
                currentString = choiceC.get(choiceProgress);
                choiceProgress += 1;
                switch(progress)
                {
                    case 17:
                        favor += 2;
                        break;
                    case 29:
                        favor -=3;
                        break;
                    case 41:
                        favor += 5;
                        break;
                    default:
                        break;                    
                }
                break;
            default:
                break;
                
        }
    }
    
    public void endingChooser()
    {
        if (favor <= 0)
        {
            currentString = choiceA.get(choiceProgress);
        }
        else if (favor <= 8)
        {
            currentString = choiceB.get(choiceProgress);
        }
        else if (favor == 9)
        {
            currentString = choiceC.get(choiceProgress);
        }
    }
    //This method reads the game's dialogue from files I have made myself
    public ArrayList<String> dialoguefileReader()
    {
        //gets the dialogue string arraylist
        ArrayList<String> dialogueString = new ArrayList<String>();
        try
        {
            File dialogueFile = new File("dialogue.txt");
            Scanner readFile = new Scanner(dialogueFile);
            while (readFile.hasNextLine()) 
            {
                String data = readFile.nextLine();
                dialogueString.add(data);
            }
            readFile.close();
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return dialogueString;
    }
    
    public ArrayList<String> choiceAfileReader()
    {
        //gets the dialogue string arraylist
        ArrayList<String> choiceAString = new ArrayList<String>();
        try
        {
            File choiceAFile = new File("choiceA.txt");
            Scanner readFile = new Scanner(choiceAFile);
            while (readFile.hasNextLine()) 
            {
                String data = readFile.nextLine();
                choiceAString.add(data);
            }
            readFile.close();
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return choiceAString;
    }
    
    public ArrayList<String> choiceBfileReader()
    {
        //gets the dialogue string arraylist
        ArrayList<String> choiceBString = new ArrayList<String>();
        try
        {
            File choiceBFile = new File("choiceB.txt");
            Scanner readFile = new Scanner(choiceBFile);
            while (readFile.hasNextLine()) 
            {
                String data = readFile.nextLine();
                choiceBString.add(data);
            }
            readFile.close();
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return choiceBString;
    }
    
    public ArrayList<String> choiceCfileReader()
    {
        //gets the dialogue string arraylist
        ArrayList<String> choiceCString = new ArrayList<String>();
        try
        {
            File choiceCFile = new File("choiceC.txt");
            Scanner readFile = new Scanner(choiceCFile);
            while (readFile.hasNextLine()) 
            {
                String data = readFile.nextLine();
                choiceCString.add(data);
            }
            readFile.close();
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return choiceCString;
    }

}
