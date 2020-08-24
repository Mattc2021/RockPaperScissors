package rockpaperscissors;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {
        
        //Create new Scanner object to allow for user input
        Scanner scan = new Scanner(System.in);
        
        //Create new random object
        Random rand = new Random();
        
        //Variables to hold scores
        int comp_score = 0;
        int user_score = 0;
        int ties = 0;
        
        //Boolean value that continues the game while the user wishes to continue
        boolean cont = true;
        
        //Introduces user to game
        System.out.println("################################################");
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("When prompted, make a selection from the following,");
        System.out.println("[1] = Rock");
        System.out.println("[2] = Paper");
        System.out.println("[3] = Scissors");
        System.out.println("The result of each match will be made once a choice has been made.");
        System.out.println("The game will continue for as long as you like. Once you end the game, the total score will be displayed.");
        System.out.println("################################################");
        
        //Continue playing the game while the user wishes too
        while(cont){
            
            //Assign computer's choice to the a value between 1 and 3
            int comp_choice = 1 + rand.nextInt(3);
            
            //Prompt user for their choice
            System.out.println("");
            System.out.println("################################################");
            System.out.print("ROCK, PAPER, SCISSORS: ");
            
            //Store user choice
            int user_choice = scan.nextInt();
            
            if ((user_choice != 1) || (user_choice != 2) || (user_choice != 3)) {
                
                System.out.print("Incorrect choice! ROCK, PAPER, SCISSORS: ");
                user_choice = scan.nextInt();
                
            }
            
            System.out.println("");
            
            //If user and computer tie
            if(user_choice == comp_choice) {
                
                String tie_selection = "";
                
                switch (user_choice) {
                    case 1:
                        tie_selection = "Rock";
                        break;
                    case 2:
                        tie_selection = "Paper";
                        break;
                    case 3:
                        tie_selection = "Scissors";
                        break;
                    default:
                        break;
                }
                
                System.out.println("WOW! Both the user and the computer selected " + tie_selection + "! That results in a tie!");
                ties += 1;
                
            }
            
            //Check each user choice wih each computer choice Paper > Rock, Scissors > Paper, Rock > Scissors
            else if (user_choice == 1) {
                
                System.out.print("Rock vs ");
                
                if (comp_choice == 2) {
                    
                    System.out.println("Paper");
                    System.out.println("Computer scores!");
                    
                    comp_score += 1;
                    
                }
                
                else if (comp_choice == 3) {
                    
                    System.out.println("Scissors");
                    System.out.println("User scores!");
                    
                    user_score += 1;
                    
                }
                
            }
            else if (user_choice == 2) {
                
                System.out.print("Paper vs ");
                
                if (comp_choice == 1) {
                    
                    System.out.println("Rock");
                    System.out.println("User scores!");
                    
                    user_score += 1;
                    
                }
                
                else if (comp_choice == 3) {
                    
                    System.out.println("Scissors");
                    System.out.println("Computer scores!");
                    
                    comp_score += 1;
                }
                
            }
            else if (user_choice == 3) {
                
                System.out.print("Scissors vs ");
                
                if (comp_choice == 1) {
                    
                    System.out.println("Rock");
                    System.out.println("Computer scores!");
                    
                    comp_score += 1;
                    
                }
                
                else if (comp_choice == 2) {
                    
                    System.out.println("Computer's choice: Paper");
                    System.out.println("User scores!");
                    
                    user_score += 1;
                    
                }
            } 
            
            //Check to see if the user would like to continue playing
            System.out.println("");
            System.out.print("Play again? y/n ");
            String user_cont = scan.next();
            System.out.println("################################################");
            
            //If yes, continue game
            if ("y".equals(user_cont.toLowerCase())) {
                
                cont = true;
            
            } 
            //If no, then end the game and display the total number points 
            //and ties
            else if ("n".equals(user_cont.toLowerCase())) {
                
                cont = false;
                System.out.println("");
                System.out.println("User's total score: " + user_score);
                System.out.println("Computer's total score: " + comp_score);
                System.out.println("Total number of ties: " + ties);
                System.out.println("");
                
                //Determine winner
                if (user_score > comp_score) {
                    
                    System.out.println("USER WINS!");
                    
                } else if (user_score < comp_score) {
                    
                    System.out.println("COMPUTER WINS!");
                    
                } else {
                    
                    System.out.println("IT'S A TIE!");
                    
                }
               
            } 
            //If an incorrect choice is selected, then ask again
            else {
                
                System.out.print("Incorrect input. Play again? y/n ");
                user_cont = scan.next();
                
            }
            
        }
        
    }
    
}
