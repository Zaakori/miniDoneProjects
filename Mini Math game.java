package com.company;

import java.util.Scanner;

public class MathGame {     // 17.11.2020


    int currentAnswer;  // the true calculated answer to a given math problem
    int pAnswer;        // the answer to a given math problem that the Player has given
    int currentPoints;  // current amount of points a Player has
    int lives = 3;      // current amount of lives a Player has, duh

    void questionMaker1(){   // level 1 of the game. makes random math problems with operators + or -, has two variables, max value for variable is 10

        int min = 1, max = 10;
        int x, y;
        double a, b, oper;

        a = min + (Math.random()) * max;
        x = (int)a;

        b = min + (Math.random()) * max;
        y = (int)b;


        oper = Math.random();
        if(oper < 0.5){
            System.out.println(x + " + " + y + " =");

            currentAnswer = x + y;
        } else {
            System.out.println(x + " - " + y + " =");

            currentAnswer = x - y;
        }


    }

    void questionMaker2(){ // level 2. makes random math problems with operator *, has two variables, max value for variable is 10

        int min = 1, max = 10;
        int x, y;
        double a, b;

        a = min + (Math.random()) * max;
        x = (int)a;

        b = min + (Math.random()) * max;
        y = (int)b;



        System.out.println(x + " * " + y + " =");

        currentAnswer = x * y;

    }

    void questionMaker3(){ // level 3. makes random math problems with operators + or -, has two variables, max value for variable is 50

        int min = 10, max = 50;
        int x, y;
        double a, b, oper;

        a = min + (Math.random()) * max;
        x = (int)a;

        b = min + (Math.random()) * max;
        y = (int)b;



        oper = Math.random();
        if(oper < 0.5){
            System.out.println(x + " + " + y + " =");

            currentAnswer = x + y;
        } else {
            System.out.println(x + " - " + y + " =");

            currentAnswer = x - y;
        }

    }

    void questionMaker4(){ // level 4. makes random math problems with operator *, has two variables, max value for variable is 20

        int min = 10, max = 20;
        int x, y;
        double a, b, oper;

        a = min + (Math.random()) * max;
        x = (int)a;

        b = min + (Math.random()) * max;
        y = (int)b;

        System.out.println(x + " * " + y + " =");

        currentAnswer = x * y;

    }

    void questionMaker5(){ // level 5, the last one. makes random math problems with operators +, - or *, has three variables, max value for variable is 20

        int min = 1, max = 20;
        int x, y, z;
        double a, b, c, oper;

        a = min + (Math.random()) * max;
        x = (int)a;

        b = min + (Math.random()) * max;
        y = (int)b;

        c = min + (Math.random()) * max;
        z = (int)c;


        oper = Math.random();
        if(oper < 0.333){
            System.out.println(x + " + " + y + " + " + z + " =");

            currentAnswer = x + y + z;

        } else if (oper >= 0.333 && oper < 0.666){
            System.out.println(x + " - " + y + " - " + z + " =");

            currentAnswer = x - y - z;

        } else {
            System.out.println(x + " * " + y + " * " + z + " =");

            currentAnswer = x * y * z;
        }

    }

    void answerTaker(int takerAnswer){ // checks if the answer given by a player is correct or not. if correct then gives 6 points, if wrong then takes away a life

        if(takerAnswer == currentAnswer){
            currentPoints += 6;
            System.out.println("Yay! You´re correct!");
        } else{
            lives -= 1;
            if(lives == 0){
                System.out.println("That´s it, game over. You got " + currentPoints + " points.");
            } else {
                System.out.println("Nope, that was wrong. You have " + lives + " lives left.");
            }
        }




    }

    void theGame(){
        // central controller of the game. has to be activated for the game to start.
        // controls which levels to run based on amount of Players´ points and terminates the game if amount of lives is 0

        Scanner scan = new Scanner(System.in);

        while(lives > 0) {


            if(currentPoints == 0) {
                System.out.println();
                System.out.println("Welcome to the best game in the World! You have 3 lives. For every right answer you get 6 points. \n \n You´re in the stage 1.");

                questionMaker1();

                pAnswer = scan.nextInt();

                answerTaker(pAnswer);

            } else if (currentPoints < 30){
            questionMaker1();

            pAnswer = scan.nextInt();

            answerTaker(pAnswer);

            } else if (currentPoints == 30){
                System.out.println("Nice! You got to the stage 2.");

                questionMaker2();

                pAnswer = scan.nextInt();

                answerTaker(pAnswer);

            }
            else if (currentPoints > 30 && currentPoints < 60){
                questionMaker2();

                pAnswer = scan.nextInt();

                answerTaker(pAnswer);

            } else if (currentPoints == 60){
                System.out.println("Nice! You got to the stage 3.");

                questionMaker3();

                pAnswer = scan.nextInt();

                answerTaker(pAnswer);

            } else if (currentPoints > 60 && currentPoints < 90){
                questionMaker3();

                pAnswer = scan.nextInt();

                answerTaker(pAnswer);

            } else if (currentPoints == 90){
                System.out.println("Nice! You got to the stage 4.");

                questionMaker4();

                pAnswer = scan.nextInt();

                answerTaker(pAnswer);

            } else if (currentPoints > 90 && currentPoints < 120){
                questionMaker4();

                pAnswer = scan.nextInt();

                answerTaker(pAnswer);

            } else if (currentPoints == 120){
                System.out.println("Nice! You got to the stage 5.");

                questionMaker5();

                pAnswer = scan.nextInt();

                answerTaker(pAnswer);
            } else if (currentPoints > 120 && currentPoints < 150){
                questionMaker5();

                pAnswer = scan.nextInt();

                answerTaker(pAnswer);
            } else {
                System.out.println("Wow, you have conquered The Game! You win! You´ve got maxPoints(150).");
                lives = 0;
            }
        }

    }


    public static void main(String[] args) {

        MathGame game1 = new MathGame();

        game1.theGame();

    }
}
