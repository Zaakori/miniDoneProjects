package com.company;

import com.company.UndertaleLikeMonsterGame.*;
import java.util.Scanner;



public class Main {

    static Player play = new Player();
    static UnimpressedUnicorn uni = new UnimpressedUnicorn();
    static ZimbabweanZombie zom = new ZimbabweanZombie();
    static NotSoGoodLookingNinja nin = new NotSoGoodLookingNinja();
    static Scanner scan = new Scanner(System.in);       // scanner needed to dodge




    public static int randomTill5(){                    // makes random int from 0 to 5, used for randomizing monsters lines of monologue

        return (int) (Math.random() * 5);

    }

    public static int dodging(){                        // player has a chance to dodge monsters attack

        System.out.println("Try to dodge! \n\n Your choices: \n 1. Say: Oh, what a handsome man is running towards me \n 2. Play dead \n 3. Flex your bicep");

        return scan.nextInt();
    }

    public static void monsterLoop(Monster monster){    // loop for monster encounters (doesn´t work for Zombie because it´s structure is different)

        while (monster.HP > 0) {

            monster.attackLine(randomTill5());

            play.HP -= monster.attack(dodging());

            if(play.HP <= 0){

                System.out.println("\nYOU DIED");

                break;

            }

            monster.HP -= play.playerAtk();

            monster.deathZero();

            play.deathZero();

            System.out.println("\nEnemy health: " + monster.HP);
            System.out.println("Player health: " + play.HP);
        }



    }



    public static void main(String[] args) {            // the main game program


        while(play.HP > 0) {


            monsterLoop(uni);

            System.out.println("************************************************");

            while (zom.HP > 0) {                        // separate loop for Zombie again because of encounters different structure
                zom.attackLine(randomTill5());

                dodging();

                System.out.println("Zombie doesn´t really care what you do, it still marches forward.");

                int playerAtk = play.playerAtk();


                zom.HP -= playerAtk;

                play.HP -= zom.beingAttacked(playerAtk);

                if(zom.HP < 0){

                    zom.HP = 0;

                }
                play.deathZero();


                System.out.println("\nZombie health: " + zom.HP);
                System.out.println("Your health: " + play.HP);

                if(play.HP <= 0){

                    System.out.println("\nYOU DIED");

                    break;

                }
            }

            System.out.println("************************************************");

            monsterLoop(nin);

            System.out.println("************************************************");


            if(play.HP > 0) {
                System.out.println("Yahhooo! You defeated everyone and now get the treasure - power of friendship!");
                play.HP = 0;
            }

        }

        System.out.println("\nGAME OVER");

    }
}