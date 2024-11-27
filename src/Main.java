import java.util.Scanner;
import java.util.Random;

class RockPaperScissors
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

    //Global Pre-def Vars
        char play;
        byte playInt;
        int cpu;
        boolean rps = false;
        byte rounds = 0;
        byte tallyP = 0;
        byte tallyC = 0;
        boolean showSystemProperties = false;

    //Intro
    System.out.println("\n\nRock Paper Scissors!");

    //Game mode Selector
    System.out.println("\nSelect Play Style");
    System.out.println("1. One and Done");
    System.out.println("2. Best of Three");
    System.out.println("3. First to Three");

    byte gameMode = sc.nextByte();

    System.out.println("\n\n\n");

//changes # rounds
    switch(gameMode)
    {

    case 1:
        System.out.println("One and Done Selected\n");
        rounds = 1;
        rps = true;
        break;
        
    case 2:
        System.out.println("Best of Three Selected\n");
        rounds = 3;
        rps = true;
        break;
        

    case 3:
        System.out.println("First to Three Selected\n");
        rounds = 6;
        rps = true;
        break;

    }

        //RPS Loop
        for (int i = 1; i <= rounds && rps; i++)
        {

            System.out.println("Enter r/p/s or 1/2/3");

            play = sc.next().charAt(0);
            cpu = rand.nextInt(3) + 1;

            //Converts input into number
            //Combines both characters into one cohesive input (r ->1 and '1' -> 1)
            switch(play)
                {

                case '1':
                case 'r': playInt = 1;
                    break;

                case '2':
                case 'p': playInt = 2;
                    break;

                case '3':
                case 's': playInt = 3;
                    break;

                default: playInt = 0;
                        System.out.println("Error! Invalid Input");

                }


        //Tie
            if (playInt == cpu)
                {
                System.out.println("\nBoth Played Same! Tie!");
                //doesn't tick up the times played as draw
                i --;
                }

        //Player Rock
        else if (playInt == 1)
                {

                if (cpu == 2)
                    {
                    System.out.println("CPU PLAYS PAPER!");
                    System.out.println("\nCpu Wins! Paper Beats Rock!");
                    tallyC++;
                    }
                if (cpu == 3)
                    {
                    System.out.println("CPU PLAYS SCISSORS!");
                    System.out.println("\nYou Win! Rock Beats Scissors!");
                    tallyP++;
                    }

                }

        //Player Paper
        else if (playInt == 2)
            {

            if (cpu == 3)
                {
                System.out.println("CPU PLAYS SCISSORS!");
                System.out.println("\nCpu Wins! Scissors Beats Paper!");
                tallyC++;
                }
            if (cpu == 1)
                {
                System.out.println("CPU PLAYS ROCK!");
                System.out.println("\nYou Win! Paper Beats Rock!");
                tallyP++;
                }

            }

        //Player Scissors
        else if (playInt == 3)
            {

            if (cpu == 1)
                {
                System.out.println("CPU PLAYS ROCK!");
                System.out.println("\nCpu Wins! Rock Beats Scissors!");
                tallyC++;
                }
            if (cpu == 2)
                {
                System.out.println("CPU PLAYS PAPER!");
                System.out.println("\nYou Win! Scissors Beats Paper!");
                tallyP++;
                }

            }

            System.out.println("\n\n\n");

            //Checks For First to Three
            if (rounds == 6)
                {
                if(tallyP == 3 || tallyC == 3)
                    {
                    i=7;
                    }
                }

        }
    
        //Checks Who Won
        if (tallyP > tallyC)
            {
            System.out.println("You Win!");
            }
        else
            {
            System.out.println("CPU Win!");
            }

        showSystemProperties = true;


        if (showSystemProperties)
            {
            System.out.println("\n\n\n");
            System.out.println("Java Version: " + System.getProperty("java.version") + " by " + System.getProperty("java.vendor"));
            System.out.println("User: " + System.getProperty("user.name"));  //<-- TURNED OFF FOR PRIVACY IN THE VIDEO
            System.out.print("Operating System: " + System.getProperty("os.name"));
            System.out.println(" " + System.getProperty("os.version"));
            System.out.println ("By: Blu");
            System.out.println ("Coded for Hack Club High Seas on November 27th 2024");
            }


    }
}