package com.example.calvinwang.tictactoe;

import android.speech.tts.TextToSpeech;

public class Moves {
    private int i;
    private int j;
    private int playerNumber;
    private String playerName;


    Moves(int setI, int setJ, int setPlayerNumber, String setPlayerName) {
        i = setI;
        j = setJ;
        playerName = setPlayerName;
        playerNumber = setPlayerNumber;
    }

    Moves(int setI, int setJ, int setPlayerNumber) {
        i = setI;
        j = setJ;
        playerNumber = setPlayerNumber;
    }


    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getPlayerName() {
        return playerName;
    }
}
