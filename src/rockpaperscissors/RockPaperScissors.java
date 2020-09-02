package rockpaperscissors;
import java.util.Scanner;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

class TimerHelper extends TimerTask{
    /* Timer class that prints the classic Rock, Paper, Scissors, Shoot! */
    public static int secondsPassed = 0;
    
    public void run(){
        secondsPassed += 1;
        
        if (secondsPassed == 1){
            System.out.println("ROCK!");
        }
        if (secondsPassed == 2) {
            System.out.println("PAPER!");
        }
        if (secondsPassed == 3) {
            System.out.println("SCISSORS!");
        }
        if (secondsPassed == 4) {
            System.out.println("SHOOT!");
        }
    }
}                           

public class RockPaperScissors {

    public static void main(final String[] args) {
        
        
        ////////////////////////////////////////////////////////////////////////
        //Variables
        int comp_score = 0;
        int user_score = 0;
        int ties = 0;
        boolean cont = true;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        ////////////////////////////////////////////////////////////////////////
        
        ////////////////////////////////////////////////////////////////////////
        //Introduces user to game
        System.out.println("################################################");
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("After the shoot, make a selection from the following,");
        System.out.println("[1] = Rock");
        System.out.println("[2] = Paper");
        System.out.println("[3] = Scissors");
        System.out.println("The result of each match will be made once a choice has been made.");
        System.out.println("The game will continue for as long as you like. Once you end the game, the total score will be displayed.");
        System.out.println("################################################");
        ////////////////////////////////////////////////////////////////////////
        
        ////////////////////////////////////////////////////////////////////////
        //While the user wishes to continue playing, continue executing this code
        while(cont){
            
            //Prints a seperator between each game
            System.out.println("");
            System.out.println("################################################");
            
            //Assign computer's choice to the a value between 1 and 3
            int comp_choice = 1 + rand.nextInt(3);
            
            //Store user choice
            int user_choice = scan.nextInt();
            
            ////////////////////////////////////////////////////////////////////////
            //Initializes the timer for the Rock, Paper, Scissors, Shoot!
            TimerHelper.secondsPassed = 0;
            Timer timer = new Timer();
            TimerTask task = new TimerHelper();
            timer.schedule(task, 1000, 1000);
            ////////////////////////////////////////////////////////////////////////
            
            ////////////////////////////////////////////////////////////////////
            //Get outcome of match, and based on the outcome, increase the appropriate value
            try{
                Thread.sleep(5000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            String outcome = determineOutcome(user_choice, comp_choice);
            if (null != outcome) 
                switch (outcome) {
                    case "tie":
                        ties += 1;
                        break;
                    case "user":
                        user_score += 1;
                        break;
                    case "comp":
                        comp_score += 1;
                        break;
                    default:
                        break;
            }
            ////////////////////////////////////////////////////////////////////
            
            ////////////////////////////////////////////////////////////////////
            //Check to see if the user would like to continue playing
            System.out.println("");
            System.out.print("Play again? y/n ");
            String user_cont = scan.next();
            System.out.println("################################################");
            
            /*
            If yes, continue the game and reset the timer for the countdown.
            If no, print the total number of points and ties, and end the program
            If an incorrect option if given, ask again
            */
            if ("y".equals(user_cont.toLowerCase())) {
                
                cont = true;
                
            } else if ("n".equals(user_cont.toLowerCase())) {
                
                cont = false;
                System.out.println("");
                System.out.println("User's total score: " + user_score);
                System.out.println("Computer's total score: " + comp_score);
                System.out.println("Total number of ties: " + ties);
                System.out.println("");
                System.out.println(getWinner(user_score, comp_score));
                System.exit(0);
                
            } else {
                
                System.out.print("Incorrect input. Play again? y/n ");
                user_cont = scan.next();
                
            }
            ////////////////////////////////////////////////////////////////////
            
        }
        ////////////////////////////////////////////////////////////////////////
        
    }
    
    public static String determineOutcome(final int user_choice, final int comp_choice) {
        /* Takes the user's and computer's choice and compares them in
        order to determine the outcome of the match */

        String result = "";

        //Get the selections made by the computer and user as a printable string
        final String user_selection = getSelection(user_choice);
        final String comp_selection = getSelection(comp_choice);

        //Print the match-up
        System.out.println(user_selection + " vs. " + comp_selection);

        //Determine if there is a tie
        if (user_choice == comp_choice) {

            System.out.println("Tie!");

            result = "tie";
        }

        ////////////////////////////////////////////////////////////////////////
        //Check each user possibility with each computer possibility
        //Paper(2) > Rock(1), Scissors(3) > Paper(2), Rock(1) > Scissors(3)

        //User picks Rock
        if (user_choice == 1) {
            if (comp_choice == 2) {
                System.out.println("Computer Scores!");
                result = "comp";
            } else if (comp_choice == 3) { 
                System.out.println("User Scores!");
                result = "user";
            }
        }
        //User picks Paper 
        else if (user_choice == 2) {
            if (comp_choice == 1) {
                System.out.println("User Scores!");
                result = "user";
            } else if (comp_choice == 3) {
                System.out.println("Computer Scores!");
                result = "comp";
            }
        }
        //User picks Scissors 
        else if (user_choice == 3) {
            if (comp_choice == 1) {
                System.out.println("Computer Scores!");
                result = "comp";
            } else if (comp_choice == 2) {
                System.out.println("User Scores!");
                result = "user";
            }
        }
        ////////////////////////////////////////////////////////////////////////

        return result;

    }

    public static String getSelection(final int choice) {

        /* Takes the integer value chosen by the computer or the user
        and assigns it to a printable string representive of 
        the choice made */

        String selection = "";

        switch (choice) {
            case 1:
                selection = "Rock";
                break;
            case 2:
                selection = "Paper";
                break;
            case 3:
                selection = "Scissors";
                break;
            default:
                break;
        }

        return selection;

    }

    public static String getWinner(final int user_score, final int comp_score) {
        /* Determines the victor of the game based on the scores */
        
        String result = "";
        
        if (user_score > comp_score) {
            result = "User Wins!";
        } else if (comp_score > user_score) {
            result = "Computer Wins!";
        } else {
            result = "It's a Tie!";
        }
        
        return result;
    }
}
