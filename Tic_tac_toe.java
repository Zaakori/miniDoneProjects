package com.company.other;

import java.util.Scanner;


public class Tic_tac_toe {             //23.11.2020

    String[] grid = {" ", " ", " ", " ", " ", " ", " ", " ", " "};   // the grid for tic-tac-toe, in the beginning it´s filled with " "

    int gridPlace = 0;                                               // place where the player puts the thing

    int counter = 0;                                                 // counts the amount of moves that´s been done

    int gameOver = 0;                                                // flips to 1 when one of the game over conditions are met and stops the game



    public String xOr0(){                                            // decides to return X or 0

        String result;


        if(counter % 2 == 0){
           result = "X";
        } else {
           result = "0";
        }

        return result;

    }

    void answerTaker(){                                 // tells the number of a move, prints the grid on the screen


       grid[gridPlace - 1] = xOr0();                                 // puts X or 0 on the grid


       System.out.println();
       System.out.println("That is move nr. " + (counter + 1));      // shows the number of a move
       System.out.println();

       System.out.println(grid[0] + "|" + grid[1] + "|" + grid[2]);  // prints the grid with X and 0´s on it
       System.out.println("-+-+-");
       System.out.println(grid[3] + "|" + grid[4] + "|" + grid[5]);
       System.out.println("-+-+-");
       System.out.println(grid[6] + "|" + grid[7] + "|" + grid[8]);

       System.out.println();
       System.out.println();

   }

    void isItWin(){                                                 // checks if the happened new move resulted in a win (checks for all possible win combinations)


        int i = 1, j = 4;

        if(counter >= 5) {                                          // it starts working after move 5, because it´s first time when there can be a win

            if(whatWinCheck()[5] != 11){

                j = 6;

            }

            if(whatWinCheck()[8] != 11){

                j = 8;

            }

            while(i < j){

                if (grid[whatWinCheck()[0]].equals(grid[whatWinCheck()[i]]) && grid[whatWinCheck()[0]].equals(grid[whatWinCheck()[i + 1]]) && !grid[whatWinCheck()[0]].equals(" ")) {
                    printOutWin();
                }
                i = i + 2;
            }
        }

   }

    int[] whatWinCheck(){                                          // determines what grid tiles to check for win depending where was the token placed this turn

        int[] checkArray = {11, 11, 11, 11, 11, 11, 11, 11, 11};


            if (gridPlace == 1) {

                checkArray[0] = 0;
                checkArray[1] = 1;
                checkArray[2] = 2;
                checkArray[3] = 3;
                checkArray[4] = 6;
                checkArray[5] = 4;
                checkArray[6] = 8;

            } else if (gridPlace == 2) {

                checkArray[0] = 1;
                checkArray[1] = 0;
                checkArray[2] = 2;
                checkArray[3] = 4;
                checkArray[4] = 7;

            } else if (gridPlace == 3) {

                checkArray[0] = 2;
                checkArray[1] = 0;
                checkArray[2] = 1;
                checkArray[3] = 5;
                checkArray[4] = 8;
                checkArray[5] = 4;
                checkArray[6] = 6;

            } else if (gridPlace == 4) {

                checkArray[0] = 3;
                checkArray[1] = 0;
                checkArray[2] = 6;
                checkArray[3] = 4;
                checkArray[4] = 5;

            } else if (gridPlace == 5) {

                checkArray[0] = 4;
                checkArray[1] = 3;
                checkArray[2] = 5;
                checkArray[3] = 1;
                checkArray[4] = 7;
                checkArray[5] = 2;
                checkArray[6] = 6;
                checkArray[7] = 0;
                checkArray[8] = 8;

            } else if (gridPlace == 6) {

                checkArray[0] = 5;
                checkArray[1] = 3;
                checkArray[2] = 4;
                checkArray[3] = 2;
                checkArray[4] = 8;

            } else if (gridPlace == 7) {

                checkArray[0] = 6;
                checkArray[1] = 7;
                checkArray[2] = 8;
                checkArray[3] = 0;
                checkArray[4] = 3;
                checkArray[5] = 2;
                checkArray[6] = 4;

            } else if (gridPlace == 8) {

                checkArray[0] = 7;
                checkArray[1] = 6;
                checkArray[2] = 8;
                checkArray[3] = 1;
                checkArray[4] = 4;

            } else if (gridPlace == 9) {

                checkArray[0] = 8;
                checkArray[1] = 6;
                checkArray[2] = 7;
                checkArray[3] = 2;
                checkArray[4] = 5;
                checkArray[5] = 0;
                checkArray[6] = 4;

            }

        return checkArray;

    }

    void printOutWin(){  // prints out winning sentence and stops the game

        counter++;

        System.out.println("Yahhoo! " + xOr0() + " won!");

       gameOver++;
   }



    void mainGame(){                                                  // main controller of the game



       Scanner scan = new Scanner(System.in);                        // the scanner

       System.out.println();

       System.out.println(grid[0] + "|" + grid[1] + "|" + grid[2]);
       System.out.println("-+-+-");
       System.out.println(grid[3] + "|" + grid[4] + "|" + grid[5]);
       System.out.println("-+-+-");
       System.out.println(grid[6] + "|" + grid[7] + "|" + grid[8]);

       System.out.println();

       while (gameOver == 0) {                                        // the while loop that contains the sequence of methods for the game to run

           System.out.println("Insert your move (" + xOr0() + "´s move):");

           gridPlace = scan.nextInt();

           if(gridPlace < 1 || gridPlace > 9){                        // checks for impossible move on the grid
               System.out.println();
               System.out.println();
               System.out.println("There aint such a number on the board, you dumbo. Try again.");
               System.out.println();
               continue;
           }

           if (!grid[gridPlace - 1].equals(" ")) {                    // checks that nobody puts a X or 0 to the place that is already filled
               System.out.println();
               System.out.println();
               System.out.println("This slot is already taken, you cheating bastard. Try again.");
               System.out.println();
               continue;
           }


           answerTaker();

           counter++;

           isItWin();

           if (counter == 9 && gameOver == 0) {                       // activated when there is a draw and stops the game
               System.out.println("That´s a draw, folks!");
               gameOver++;
           }

       }


   }



    public static void main(String[] args) {

       Tic_tac_toe game1 = new Tic_tac_toe();

       game1.mainGame();



    }
}
