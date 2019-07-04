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
    private static int score = 0, round = 1, timeToLive = 3;

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

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        ClassicWorker.score = score;
    }

    public static int getRound() {
        return round;
    }

    public static void setRound(int round) {
        ClassicWorker.round = round;
    }

    public static int getTimeToLive() {
        return timeToLive;
    }

    public static void setTimeToLive(int timeToLive) {
        ClassicWorker.timeToLive = timeToLive;
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

    public static void evaluateGuess(int firstChoice, int secondChoice, int thirdChoice){
        if(guessKingNumber == firstChoice) {
            setScore(getScore() + 5);
        }
        else if(guessKingNumber == secondChoice) {
            setScore(getScore() + 3);
        }
        else  if(guessKingNumber == thirdChoice) {
            setScore(getScore() + 1);
        }
        else {
            setTimeToLive(getTimeToLive() - 1);
        }

        setRound(getRound() + 1);

    }
}
