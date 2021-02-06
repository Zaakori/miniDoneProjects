package com.company.UndertaleLikeMonsterGame;

public class UnimpressedUnicorn extends Monster {

    int attack = 50;
    static String[] lines = new String[5];          // array that contains the quirky lines before attacks



    static {
                                                    // those quirky lines

    lines[0] = "- Let´s see if you are actually as unimpressive as you look! -";
    lines[1] = "- My left nostril is way more impressive than you! -";
    lines[2] = "- Pff, you are so weak that I can fight you even without looking at you! -";
    lines[3] = "- Not bad, not bad... - That´s what I would say if you weren´t so bad. -";
    lines[4] = "- Just stop wasting my time and give up already, you skinny looking ape. -";

    }

    public UnimpressedUnicorn(){                    // constructor that sets Unicorns HP to 50 when you create an object

        HP = 50;

    }

    @Override
    public void attackLine(int random){             // randomly prints one of 5 quirky lines

        System.out.println("\n You are being attacked by the Unimpressed Unicorn. \n");

        System.out.println(lines[random]);

        System.out.println();

    }

    @Override
    public int attack(int playerDodge){             // attacks player if he doesn´t manage to dodge


        int attackTotal = 0;


        if(playerDodge == 3){

            System.out.println("The Unicorn stops in his tracks to admire such an amazingly big bicep.");

        } else{

            attackTotal = attack + (int) ((Math.random() * 20) - 10);

            System.out.println("That was a horrible dodge that didn´t work. Unicorn smashes you and you lose " + attackTotal + " HP.");


        }

        return attackTotal;

    }


}
