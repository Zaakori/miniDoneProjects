package com.company.UndertaleLikeMonsterGame;

import java.util.Scanner;


public class Player {

    public int HP = 100;
    Scanner scan = new Scanner(System.in);



    public int playerAtk(){                          // player attacks, the stronger he wants to attack the smaller is the chance of hitting


        System.out.println("\n Now it´s your time to attack.\n How hard do you want to attack? (1 - 100)");

        int attack = scan.nextInt();

        int pAttackPercent = 101 - attack;

        int hitOrMiss = (int) (Math.random() * 100);

        int attackTotal = 0;




        if(attack > 100){

            System.out.println("Pfff, I doubt that with such attack you´ll achieve anything.");

        }

        if(hitOrMiss <= pAttackPercent){

            attackTotal = (attack/2) + (int) ((Math.random() * 10) - 5);

            if(attack <= 5){

                attackTotal = 1 + (int) ((Math.random() * 3));

            }

            System.out.println("That´s a hit! Your attack made " + attackTotal + " damage.");

        } else{

            System.out.println("You missed... well, that happens.");
        }

        return attackTotal;

    }

    public void deathZero(){                           // ensures that HP amount doesn´t get lower than 0

        if(HP < 0){

            HP = 0;

        }

    }

}
