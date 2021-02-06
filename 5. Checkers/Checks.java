package com.company.Checkers2;

public class Checks {

    static int moveCounter;                             // holds which move it is
    static int error;                                   // if it´s 0 then everything is fine, if flipped to -1 then somewhere has been an error
    static int gameOver;                                // if 0, then game is still on, if flipped to 1 then game is over
    static int[] enemyNear = {0, 0, 0, 0};              // is used for telling whether a piece can eat or not, shows if an enemy is near the piece, if yes then flips to 1
    static int[] squareBehindEnemy = {1, 1, 1, 1};      // is used for telling whether a piece can eat or not, shows if square behind enemy is free, if yes then flips to 0



    public static int whoseMove() {

        return moveCounter % 2;

    }

    public static void printOutWhoseMove() {

        if (whoseMove() == 0) {

            System.out.println("White´s move.");

        } else {
            System.out.println("Black´s move.");
        }

        System.out.println();
    }

    public static void youCantMakeAMoveLikeThat() {

        System.out.println("Hey, you can´t make a move like that!");
        System.out.println();

        error = -1;

    }

    public static void checkUseOnlyBlackSquares() {

        if (((Board.kompEndRow % 2 == 0) && (Board.kompEndColumn % 2 == 0)) || ((Board.kompEndRow % 2 != 0) && (Board.kompEndColumn % 2 != 0))) {

            youCantMakeAMoveLikeThat();

        }

    }

    public static void checkIfSomeoneAlreadyOnThatSquare() {

        int row1 = (Board.kompEndRow * 3);


        if (!Board.board[row1][Board.kompEndColumn].equals("░░░░░░░░ ")) {

            youCantMakeAMoveLikeThat();

        }


    }

    public static void checkPieceMovesOnlyOneSquare() {


        if (whoseMove() == 0) {

            if (Board.kompEndRow != Board.kompStartRow - 1) {

                youCantMakeAMoveLikeThat();

            }

        } else {

            if (Board.kompEndRow != Board.kompStartRow + 1) {

                youCantMakeAMoveLikeThat();

            }

        }


    }

    public static void checkIfTheSquareIsFilled() {

        int row1 = (Board.kompStartRow * 3);


        if (Board.board[row1][Board.kompStartColumn].equals("░░░░░░░░ ") || Board.board[row1][Board.kompStartColumn].equals("▓▓▓▓▓▓▓▓ ")) {

            youCantMakeAMoveLikeThat();

        }

    }

    public static void defaultsEnemyNearAndSquareBehindEnemy() {

        enemyNear[0] = 0;
        enemyNear[1] = 0;
        enemyNear[2] = 0;
        enemyNear[3] = 0;

        squareBehindEnemy[0] = 1;
        squareBehindEnemy[1] = 1;
        squareBehindEnemy[2] = 1;
        squareBehindEnemy[3] = 1;

    }

    public static int[] checkCanPieceEatAnotherPiece(int row, int column) {

        int row1 = row * 3;


         defaultsEnemyNearAndSquareBehindEnemy();

        if (row != 0 && row != 1 && row != 7 && row != 6 && column != 0 && column != 1 && column != 7 && column != 6) {

            method1ForPieceEatAnotherPiece(row1, column, -1, -1, 0);
            method1ForPieceEatAnotherPiece(row1, column, -1, 1, 1);
            method1ForPieceEatAnotherPiece(row1, column, 3, 1, 2);
            method1ForPieceEatAnotherPiece(row1, column, 3, -1, 3);

        } else if ((row == 0 || row == 1) && column != 7 && column != 6 && column != 0 && column != 1) {

            method1ForPieceEatAnotherPiece(row1, column, 3, 1, 2);
            method1ForPieceEatAnotherPiece(row1, column, 3, -1, 3);

        } else if (row != 0 && row != 1 && row!= 6 && row != 7 && (column == 7 || column == 6)) {

            method1ForPieceEatAnotherPiece(row1, column, -1, -1, 0);
            method1ForPieceEatAnotherPiece(row1, column, 3, -1, 3);

        } else if ((row == 7 || row == 6) && column != 0 && column != 1 && column != 6 && column != 7) {

            method1ForPieceEatAnotherPiece(row1, column, -1, -1, 0);
            method1ForPieceEatAnotherPiece(row1, column, -1, 1, 1);

        } else if (row != 0 && row != 1 && row != 6 && row != 7 && (column == 0 || column == 1)) {

            method1ForPieceEatAnotherPiece(row1, column, -1, 1, 1);
            method1ForPieceEatAnotherPiece(row1, column, 3, 1, 2);

        } else if ((row == 0 || row == 1) && (column == 0 || column == 1)) {

            method1ForPieceEatAnotherPiece(row1, column, 3, 1, 2);

        } else if ((row == 0 || row == 1) && (column == 6 || column == 7)){

            method1ForPieceEatAnotherPiece(row1, column, 3, -1, 3);

        } else if ((row == 6 || row == 7) && (column == 6 || column == 7)) {

            method1ForPieceEatAnotherPiece(row1, column, -1, -1, 0);

        } else if ((row == 6 || row == 7) && (column == 0 || column == 1)) {

            method1ForPieceEatAnotherPiece(row1, column, -1, 1, 1);

        }


        method2ForPieceEatAnotherPiece(row, column);

        return squareBehindEnemy;

    }

    public static void method1ForPieceEatAnotherPiece(int row1, int column, int rowInt, int columnInt, int enemyNearIndex) {

        String enemyToCompareWith;

        if (whoseMove() == 0) {
            enemyToCompareWith = "░░    ░░ ";
        } else {
            enemyToCompareWith = "░░XXXX░░ ";
        }

        if (Board.board[row1 + (rowInt)][column + (columnInt)].equals(enemyToCompareWith)) {
            enemyNear[enemyNearIndex] = 1;
        }

    }

    public static void method2ForPieceEatAnotherPiece(int row, int column) {

        int enemyNearCheck = 0;



        for (int i = 0; i < 4; i++) {

            enemyNearCheck += enemyNear[i];

        }


        if (enemyNearCheck != 0) {

            methodInsideMethod2ForPieceEatAnotherPiece(row, column, 0, 1, 1, -4, -2);
            methodInsideMethod2ForPieceEatAnotherPiece(row, column, 1, 1, 6, -4, 2);
            methodInsideMethod2ForPieceEatAnotherPiece(row, column, 2, 6, 6, 6, 2);
            methodInsideMethod2ForPieceEatAnotherPiece(row, column, 3, 6, 1, 6, -2);

        }

    }

    public static void methodInsideMethod2ForPieceEatAnotherPiece(int row, int column, int eNAndSBEArrayIndexes, int rowInt, int column1Int, int row1Int, int column2Int) {

        int row1 = row * 3;


        if (enemyNear[eNAndSBEArrayIndexes] == 1 && row != rowInt && column != column1Int) {

            if (Board.board[row1 + row1Int][column + column2Int].equals("░░░░░░░░ ")) {

                squareBehindEnemy[eNAndSBEArrayIndexes] = 0;

            }
        }

    }

    public static void eatsOnePiece(int[] squareBehindEnemy) {


        if (checkSquareBehindEnemy(squareBehindEnemy) != 4) {

            if (squareBehindEnemy[0] == 0 && (Board.kompEndRow == Board.kompStartRow - 2) && (Board.kompEndColumn == Board.kompStartColumn - 2)) {

                int deletingEnemyPieceRow = Board.kompStartRow - 1;
                int deletingEnemyPieceColumn = Board.kompStartColumn - 1;

                Board.fillWhiteOrBlackEmptySquare(deletingEnemyPieceRow, deletingEnemyPieceColumn, 1);

            } else if (squareBehindEnemy[1] == 0 && (Board.kompEndRow == Board.kompStartRow - 2) && (Board.kompEndColumn == Board.kompStartColumn + 2)) {

                int deletingEnemyPieceRow = Board.kompStartRow - 1;
                int deletingEnemyPieceColumn = Board.kompStartColumn + 1;

                Board.fillWhiteOrBlackEmptySquare(deletingEnemyPieceRow, deletingEnemyPieceColumn, 1);

            } else if (squareBehindEnemy[2] == 0 && (Board.kompEndRow == Board.kompStartRow + 2) && (Board.kompEndColumn == Board.kompStartColumn + 2)) {

                int deletingEnemyPieceRow = Board.kompStartRow + 1;
                int deletingEnemyPieceColumn = Board.kompStartColumn + 1;

                Board.fillWhiteOrBlackEmptySquare(deletingEnemyPieceRow, deletingEnemyPieceColumn, 1);

            } else if (squareBehindEnemy[3] == 0 && (Board.kompEndRow == Board.kompStartRow + 2) && (Board.kompEndColumn == Board.kompStartColumn - 2)) {

                int deletingEnemyPieceRow = Board.kompStartRow + 1;
                int deletingEnemyPieceColumn = Board.kompStartColumn - 1;

                Board.fillWhiteOrBlackEmptySquare(deletingEnemyPieceRow, deletingEnemyPieceColumn, 1);
            }

        }
    }

    public static int checkSquareBehindEnemy (int[] squareBehindEnemy) {

            int squareBehindEnemycheck = 0;


            for (int i = 0; i < 4; i++) {

                squareBehindEnemycheck += squareBehindEnemy[i];

            }

            return squareBehindEnemycheck;

        }

    public static boolean checkIfSuperPieceIsMade() {


        if(Board.kompEndRow == 7 || Board.kompEndRow == 0){

            Board.fillWithWhiteOrBlackSuperPiece(Board.kompEndRow, Board.kompEndColumn, whoseMove());

            return true;
        }

        return false;

    }

    public static boolean checkIfItsSuperPiece() {

        if(Board.board[(Board.kompStartRow * 3) + 1][Board.kompStartColumn].equals("░XX  XX░ ") || Board.board[(Board.kompStartRow * 3) + 1][Board.kompStartColumn].equals("░  XX  ░ ")){

            return true;
        }

        return false;
    }

    public static void checkIfSuperPieceMovesOrEats(){

        int[] enemyLocationAndCount = {-1, -1, 0};


        if((Board.kompEndRow - Board.kompStartRow) == (Board.kompEndColumn - Board.kompStartColumn)){

            if(Board.kompStartRow > Board.kompEndRow){

                for(int i = 1; i < Board.kompStartRow - Board.kompEndRow; i++){

                    enemyLocationAndCount[0] = methodForSuperPieceMovesOrEats(i, -1, -1)[0];
                    enemyLocationAndCount[1] = methodForSuperPieceMovesOrEats(i, -1, -1)[1];
                    enemyLocationAndCount[2] = methodForSuperPieceMovesOrEats(i, -1, -1)[2];

                    if(enemyLocationAndCount[2] == 1){
                        break;
                    }

                }

            } else {


                for(int i = 1; i < Board.kompEndRow - Board.kompStartRow; i++){

                    enemyLocationAndCount[0] = methodForSuperPieceMovesOrEats(i, 1, 1)[0];
                    enemyLocationAndCount[1] = methodForSuperPieceMovesOrEats(i, 1, 1)[1];
                    enemyLocationAndCount[2] = methodForSuperPieceMovesOrEats(i, 1, 1)[2];

                    if(enemyLocationAndCount[2] == 1){
                        break;
                    }

                }

            }

        } else if (Board.kompEndColumn == Board.kompStartColumn + (Board.kompStartRow - Board.kompEndRow)){

            if(Board.kompStartRow > Board.kompEndRow){


                for(int i = 1; i < Board.kompStartRow - Board.kompEndRow; i++){

                    enemyLocationAndCount[0] = methodForSuperPieceMovesOrEats(i, -1, 1)[0];
                    enemyLocationAndCount[1] = methodForSuperPieceMovesOrEats(i, -1, 1)[1];
                    enemyLocationAndCount[2] = methodForSuperPieceMovesOrEats(i, -1, 1)[2];

                    if(enemyLocationAndCount[2] == 1){
                        break;
                    }


                }

            } else {

                for(int i = 1; i < Board.kompEndRow - Board.kompStartRow; i++){

                    enemyLocationAndCount[0] = methodForSuperPieceMovesOrEats(i, 1, -1)[0];
                    enemyLocationAndCount[1] = methodForSuperPieceMovesOrEats(i, 1, -1)[1];
                    enemyLocationAndCount[2] = methodForSuperPieceMovesOrEats(i, 1, -1)[2];

                    if(enemyLocationAndCount[2] == 1){
                        break;
                    }

                }

            }

        } else {

            youCantMakeAMoveLikeThat();

        }




        if(enemyLocationAndCount[2] == 0){

            Board.boardSuperPieceControl();

        } else if(enemyLocationAndCount[2] == 1){

            Board.fillWhiteOrBlackEmptySquare(enemyLocationAndCount[0], enemyLocationAndCount[1], 1);
            Board.boardSuperPieceControl();

        } else {

            youCantMakeAMoveLikeThat();
        }

    }

    public static int[] methodForSuperPieceMovesOrEats(int i, int rowOperator, int columnOperator) {

        int[] enemyLocCount = {-1, -1, 0};


        if(Board.board[(Board.kompStartRow * 3) + (rowOperator * (i * 3))][Board.kompStartColumn + (columnOperator * i)].equals("░░XXXX░░ ")) {

            if(whoseMove() == 0){

                youCantMakeAMoveLikeThat();

            } else {

                enemyLocCount[0] = Board.kompStartRow + (rowOperator * i);
                enemyLocCount[1] = Board.kompStartColumn + (columnOperator * i);
                enemyLocCount[2] = 1;

            }

        } else if(Board.board[(Board.kompStartRow * 3) + (rowOperator * (i * 3))][Board.kompStartColumn + (columnOperator * i)].equals("░░    ░░ ")){

            if(whoseMove() == 0){

                enemyLocCount[0] = Board.kompStartRow + (rowOperator * i);
                enemyLocCount[1] = Board.kompStartColumn + (columnOperator * i);
                enemyLocCount[2] = 1;

            } else {

                youCantMakeAMoveLikeThat();

            }

        }


        return enemyLocCount;

    }

    public static boolean checkIfAnyoneCanEat() {


        for (int j = 0; j < 24; j++) {

            for (int i = 0; i < 8; i++) {

                if (whoseMove() == 0) {

                    if (Board.board[j][i].contains("░XXXXXX░ ")) {


                        if (checkSquareBehindEnemy(checkCanPieceEatAnotherPiece(j / 3, i)) < 4) {

                            return true;

                        }

                    }

                } else {

                        if (Board.board[j][i].contains("░      ░ ")) {

                            if (checkSquareBehindEnemy(checkCanPieceEatAnotherPiece(j / 3, i)) < 4) {

                                return true;
                            }

                        }

                    }
                }


            }
        return false;

        }

    public static void deleteIfCouldButDidntEat(int piecesBeforeMove, int piecesAfterMove, boolean canEat){

        if(canEat){

            if(piecesBeforeMove - piecesAfterMove == 0){

                System.out.println("Whoops, you should have eaten!");
                System.out.println();

                Board.fillWhiteOrBlackEmptySquare(Board.kompEndRow, Board.kompEndColumn, 1);

            }

        }

    }

    public static int checkHowManyPieces(){

            int blackCount = 0;
            int whiteCount = 0;



            for (int j = 0; j < 24; j++) {

                for (int i = 0; i < 8; i++) {

                    if (Board.board[j][i].contains("░░    ░░ ")) {

                        blackCount++;

                    } else if (Board.board[j][i].contains("░░XXXX░░ ")) {

                        whiteCount++;

                    }

                }
            }

            if (blackCount == 0) {

                Board.boardPrint();
                System.out.println("WHITE WINS!");
                System.out.println();
                gameOver = 1;

            } else if (whiteCount == 0) {

                Board.boardPrint();
                System.out.println("BLACK WINS!");
                System.out.println();
                gameOver = 1;

            }

            return ((blackCount / 2) + (whiteCount / 2));
        }

}

