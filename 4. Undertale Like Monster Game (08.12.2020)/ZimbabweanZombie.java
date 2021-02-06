package com.company.UndertaleLikeMonsterGame;

public class ZimbabweanZombie extends Monster{

    public int HP = 75;
    static String[] lines = new String[5];               // array that contains the mini-monologue lines before attacks



    static {                                             // those mini-monologue lines

        lines[0] = "- Grrrrhhh! -";
        lines[1] = "- Oh, hhhuue! -";
        lines[2] = "- Memm-memmm... -";
        lines[3] = "- Zimba-zimba-zimbo-baaa. -";
        lines[4] = "- ... Meow? -";

    }


    public void attackLine(int random){                   // randomly prints one of 5 lines


        System.out.println("\n You are being attacked by the Zimbabwean Zombie. \n");

        System.out.println(lines[random]);

        System.out.println();


    }

    public int beingAttacked(int attackTotal){                         // poisons player if he hits the Zombie heavily

        int poisonTotal = 0;


        if(attackTotal == 0){

            System.out.println("It feels like Zombie is quietly laughing at your unsuccessful attempt... But you´re not sure. ");

        } else if(attackTotal <= 12){

            System.out.println("Attack was so weak, that Zimbabwean Zombie doesn´t even seem to notice it.");

        } else{

            poisonTotal = (attackTotal/3) + (int) ((Math.random() * 6) - 3);
            System.out.println("You attacked so ferociously that zombie slime flies everywhere and you get " + poisonTotal + " poison damage.");

        }



        return poisonTotal;


    }


}
