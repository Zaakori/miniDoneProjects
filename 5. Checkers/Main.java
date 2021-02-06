package com.company.Checkers2;

import java.util.Scanner;



public class Main {

    static String nextMove = "nullo";                           // used for confirmation that player ends his move, if its "next" then move goes to next player
    static int counterInOneMove = 0;                            // counts how many times has a player moved during one move (like, if it´s eating in a row)



    public static void main(String[] args) {                    // the abomination of a main code for the game, that I call "Frank Carlsen"

        Scanner scan = new Scanner(System.in);

        Board.startOfGameFillWithEmptySquares();
        Board.startOfGameFillWithPieces();


        while (Checks.gameOver == 0) {


            while (!nextMove.equals("next")) {

                int piecesBeforeMove;
                int piecesAfterMove;
                boolean canEat;

                piecesBeforeMove = Checks.checkHowManyPieces();


                Checks.printOutWhoseMove();
                Board.boardPrint();


                String playerInput0 = scan.next();
                String playerInput1 = scan.next();
                String playerInput2 = scan.next();

                nextMove = playerInput2;

                canEat = Checks.checkIfAnyoneCanEat();


                Board.playerInputConverterToKomp(playerInput0, 0);
                Board.playerInputConverterToKomp(playerInput1, 1);





                        if (counterInOneMove > 0) {

                            if((Board.kompEndRow == Board.kompStartRow + 1) || (Board.kompEndRow == Board.kompStartRow - 1)) {

                            Checks.youCantMakeAMoveLikeThat();

                            }

                        }


                    if (!Checks.checkIfItsSuperPiece()) {

                        Board.boardSimplePieceControl();

                    } else {

                        Checks.checkIfSuperPieceMovesOrEats();

                    }


                    if (Checks.error == 0) {
                        counterInOneMove++;
                    } else {
                        nextMove = "nullo";
                    }


                    Checks.error = 0;


                    if(Board.kompStartRow == Board.kompEndRow){
                        System.out.println("Oh, or I suppose you can.\n");
                        nextMove = "next";
                    }


                    piecesAfterMove = Checks.checkHowManyPieces();

                    Checks.deleteIfCouldButDidntEat(piecesBeforeMove, piecesAfterMove, canEat);

                System.out.println("End of turn.");
                System.out.println();

            }
                Checks.moveCounter++;
                nextMove = "nullo";
                counterInOneMove = 0;

                if (Checks.moveCounter > 10) {

                    Checks.checkHowManyPieces();

                }
            }




        }

    }

