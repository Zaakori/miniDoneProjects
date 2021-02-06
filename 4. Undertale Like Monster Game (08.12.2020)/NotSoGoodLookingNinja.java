package com.company.UndertaleLikeMonsterGame;

public class NotSoGoodLookingNinja extends Monster {

    int attack = 25;
    static String[] lines = new String[5];                       // array that contains the mini-monologue lines before attacks



    static {                                                     // those mini-monologue lines

        lines[0] = "- Hey, I saw how you stared at me! That´s... that´s not nice of you! -";
        lines[1] = "- Actually I look pretty good... from behind... from far away... in the dark. -";
        lines[2] = "- This Unicorn dude from before was so pretty and fabulous... oehh.... -";
        lines[3] = "- Uhh... look better at yourself! You´re not that good looking either! -";
        lines[4] = "- I don´t look too bad, I even put an eyeliner on!. -";

    }

    public NotSoGoodLookingNinja(){                              // constructor that sets Ninjas HP to 60 when you create an object

        HP = 60;
    }

    @Override
    public void attackLine(int random){                          // randomly prints one of 5 lines


        System.out.println("\n You are being attacked by Not-so-good-looking Ninja. \n");

        System.out.println(lines[random]);

        System.out.println();

    }

    @Override
    public int attack(int playerDodge){                        // attacks player if he doesn´t manage to dodge



        int attackTotal = 0;


        if(playerDodge == 1){

            int chanceBackStab = (int) (Math.random() * 100);

            if(chanceBackStab >= 30) {

                System.out.println("Ninja stops to think whether you´re lying or not.");

            } else {                                           // there is 30% chance that dodge doesn´t work and he still attacks

                attackTotal = (attack + (int) ((Math.random() * 20) - 10))/2;

                System.out.println("This time Ninja sees through your clever lies and delivers a backstab! You lose " + attackTotal + " HP.");

            }


        } else{

            attackTotal = attack + (int) ((Math.random() * 20) - 10);

            System.out.println("That was a horrible dodge that didn´t work. Ninja attacks you with his shinobigatana and you lose " + attackTotal + " HP.");

        }

        return attackTotal;

    }



    }

