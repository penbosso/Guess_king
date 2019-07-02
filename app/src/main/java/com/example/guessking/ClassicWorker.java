package com.example.guessking;

import java.util.ArrayList;
import java.util.Collections;

public class ClassicWorker {
    private static int firstNumber;
    private static int secondNumber;
    private static int thirdNumber;
    private static int fourthNumber;
    private static int guessKingNumber;
    private static int randomInt;
    private static int guessBotNumber;

    public static int getFirstNumber() {
        return firstNumber;
    }

    public static int getSecondNumber() {
        return secondNumber;
    }

    public static int getThirdNumber() {
        return thirdNumber;
    }

    public static int getFourthNumber() {
        return fourthNumber;
    }

    public static int getGuessKingNumber() {
        return guessKingNumber;
    }

    public static int getGuessBotNumber() {
        return guessBotNumber;
    }

    public static void generateNumbers(){
        ArrayList<Integer> digits = new ArrayList<>(10);
        for (int i = 0; i < 10; i++){
            digits.add(i);
        }
        Collections.shuffle(digits);

        firstNumber = digits.get(1);
        secondNumber = digits.get(2);
        thirdNumber = digits.get(3);
        fourthNumber = digits.get(4);

        randomInt = 1 + (int)(Math.random()*4);
        guessKingNumber = digits.get(randomInt);

        randomInt = 1 + (int)(Math.random()*4);
        guessBotNumber = digits.get(randomInt);
    }
}
