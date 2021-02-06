package com.company;

public class Bottle {      // 11.11.2020

    private double waterAmount; // That´s how much water is currently in the bottle. 2l is max


    void checkWater(double initialW){ // Checks that bottle capacity is 2l (so it´s not more than 2l AND not less than 0)

        if (initialW > 0 & initialW <= 2) {
            waterAmount = initialW;
        } else if(initialW > 2){
            waterAmount = 2;
            System.out.println("Bottle capacity is 2l, that much aint fitting in there. So now you lost some water. Congratulations.");
        } else {
            waterAmount = 0;
            System.out.println("The bottle is empty.");
        }


    }

    void getWater() { // Shows the current amount of water... it´s a glorified print.out.ln really
        System.out.println(waterAmount);
    }


    void pour(double amount) { // Pour in or pour out water using positive or negative numbers

        double z = 0;

        z = waterAmount + amount;

        checkWater(z);

        }


    void waterTransfer(double amount, Bottle transferWater) { // Transfer water from one bottle to another bottle


        if (amount > waterAmount) {

            System.out.println("You can´t transfer more water than there is in the bottle. Come on, it´s common sense.");

        } else if(amount < 0) {

            System.out.println("You can´t transfer a negative amount of water, you dummy.");

        } else {

            double opposite = 0;

            opposite = -amount;

            pour(opposite);
            transferWater.pour(amount);
        }
    }

    public static void main(String[] args) {
        int size = 5;
        Bottle[] bottles = new Bottle[size];

        for (int i = 0; i < size; i++) {
            bottles[i] = new Bottle();
        }

    }

}
