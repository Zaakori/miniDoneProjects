package com.company.UndertaleLikeMonsterGame;

public class Monster {                      // parent class for monsters, mostly used to create monsterLoop in Main

    public int HP = 0;


    public void deathZero(){                           // ensures that HP amount doesn´t get lower than 0

        if(HP < 0){

            HP = 0;

        }

    }

    public void attackLine(int random){    // empty method, so that it can be used in monsterLoop method, but it´s overridden in child classes
    }

    public int attack(int attack){          // empty method, so that it can be used in monsterLoop method, but it´s overridden in child classes
        return 0;
    }

}
