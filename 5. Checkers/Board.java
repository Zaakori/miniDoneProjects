package com.company.Checkers2;

public class Board {

    public static String[][] board = new String[24][8];          // the array that holds the board and the pieces in it, has 24 rows because one square is 3 rows high.
                                                                 // if you wanna see what´s in the board use .boardPrint()

    public static int kompStartRow;                              // the four standard values for players move that have been converted from players´ input,
    public static int kompStartColumn;                           // they show what piece has been chosen (kompStart---) and where it wants to go (kompEnd---)
    public static int kompEndRow;                                // these standard values are used in every method except for where concrete array "board" Object is needed
    public static int kompEndColumn;


    public static void startOfGameFillWithEmptySquares(){


        for(int j = 0; j < 8; j++) {

            for (int i = 0; i < 8; i++) {

                if(j % 2 == 0) {

                    if (i % 2 == 0) {
                        fillWhiteOrBlackEmptySquare(j, i, 0);
                    } else {
                        fillWhiteOrBlackEmptySquare(j, i, 1);
                    }


                } else {
                    if (i % 2 != 0) {
                        fillWhiteOrBlackEmptySquare(j, i, 0);
                    } else {
                        fillWhiteOrBlackEmptySquare(j, i, 1);
                    }
                }
            }
        }



    }

    public static void startOfGameFillWithPieces(){

        for(int j = 0; j < 8; j++) {

            for (int i = 0; i < 8; i += 2) {

                if(j < 3) {
                    if (j % 2 == 0) {
                        fillWithWhiteOrBlackPiece(j, i + 1, 1);
                    } else {
                        fillWithWhiteOrBlackPiece(j, i, 1);

                    }
                } else if(j > 4){

                    if (j % 2 == 0) {
                        fillWithWhiteOrBlackPiece(j, i + 1, 0);
                    } else {
                        fillWithWhiteOrBlackPiece(j, i, 0);

                    }
                }
            }
        }


    }

    public static void fillWhiteOrBlackEmptySquare(int kompRow, int kompColumn, int whiteOrBlack){

        int row1 = kompRow * 3;
        int row2 = row1 + 1;
        int row3 = row1 + 2;


        if(whiteOrBlack == 0) {
            board[row1][kompColumn] = "▓▓▓▓▓▓▓▓ ";
            board[row2][kompColumn] = "▓▓▓▓▓▓▓▓ ";
            board[row3][kompColumn] = "▓▓▓▓▓▓▓▓ ";

        } else {
            board[row1][kompColumn] = "░░░░░░░░ ";
            board[row2][kompColumn] = "░░░░░░░░ ";
            board[row3][kompColumn] = "░░░░░░░░ ";
        }

    }

    public static void fillWithWhiteOrBlackPiece(int kompRow, int kompColumn, int whiteOrBlack){

        int row1 = kompRow * 3;
        int row2 = row1 + 1;
        int row3 = row1 + 2;

        if(whiteOrBlack == 0) {
            board[row1][kompColumn] = "░░XXXX░░ ";
            board[row2][kompColumn] = "░XXXXXX░ ";
            board[row3][kompColumn] = "░░XXXX░░ ";
        } else {
            board[row1][kompColumn] = "░░    ░░ ";
            board[row2][kompColumn] = "░      ░ ";
            board[row3][kompColumn] = "░░    ░░ ";
        }



    }

    public static void fillWithWhiteOrBlackSuperPiece(int kompRow, int kompColumn, int whiteOrBlack){

        int row1 = kompRow * 3;
        int row2 = row1 + 1;
        int row3 = row1 + 2;

        if(whiteOrBlack == 0) {
            board[row1][kompColumn] = "░░XXXX░░ ";
            board[row2][kompColumn] = "░XX  XX░ ";
            board[row3][kompColumn] = "░░XXXX░░ ";
        } else {
            board[row1][kompColumn] = "░░    ░░ ";
            board[row2][kompColumn] = "░  XX  ░ ";
            board[row3][kompColumn] = "░░    ░░ ";
        }



    }

    public static void playerInputConverterToKomp(String playerInput, int StartOrEnd){

        int[] rowConversion = {8, 7, 6, 5, 4, 3, 2, 1, 0};


        if(StartOrEnd == 0){

         kompStartColumn = playerInput.codePointAt(0) - 65;

         kompStartRow = rowConversion[playerInput.codePointAt(1) - 48];

        } else {

         kompEndColumn = playerInput.codePointAt(0) - 65;

         kompEndRow = rowConversion[playerInput.codePointAt(1) - 48];

        }

    }

    public static void boardPrint(){


        int row = 0;
        int realWorldRow = 8;

        for(int k = 0; k < 8; k++) {

            for(int j = 0; j < 3; j++) {

                    for (int i = 0; i < 8; i++) {

                        if (j == 1 && i == 0) {

                                System.out.print(realWorldRow + "  " + Board.board[row][i]);
                                realWorldRow--;

                        } else if(i == 0) {

                            System.out.print("   " + Board.board[row][i]);

                        } else {

                            System.out.print(Board.board[row][i]);

                        }
                    }
                System.out.println();
                    row++;
                }
                }

        System.out.print("      A        B        C        D        E        F        G        H");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void boardSimplePieceControl(){

        int[] squareBehindEnemy = Checks.checkCanPieceEatAnotherPiece(kompStartRow, kompStartColumn);
        int checkIfCanEatEnemy = 0;



        for(int i = 0; i < 4; i++){

            checkIfCanEatEnemy += squareBehindEnemy[i];

        }


        Checks.checkUseOnlyBlackSquares();
        Checks.checkIfSomeoneAlreadyOnThatSquare();
        Checks.checkIfTheSquareIsFilled();


        if(checkIfCanEatEnemy == 4){

            Checks.checkPieceMovesOnlyOneSquare();

        } else {
            Checks.eatsOnePiece(squareBehindEnemy);
        }


        if(Checks.error == 0) {

            fillWhiteOrBlackEmptySquare(kompStartRow, kompStartColumn, 1);

            fillWithWhiteOrBlackPiece(kompEndRow, kompEndColumn, Checks.whoseMove());

            if(Checks.checkIfSuperPieceIsMade()){
                Checks.checkIfSuperPieceIsMade();
            }

        }

    }

    public static void boardSuperPieceControl(){


        Checks.checkIfSomeoneAlreadyOnThatSquare();
        Checks.checkIfTheSquareIsFilled();



        if(Checks.error == 0) {

            fillWhiteOrBlackEmptySquare(kompStartRow, kompStartColumn, 1);

            fillWithWhiteOrBlackSuperPiece(kompEndRow, kompEndColumn, Checks.whoseMove());

        }

    }



}
