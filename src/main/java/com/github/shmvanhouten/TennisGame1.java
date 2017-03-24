package com.github.shmvanhouten;

public class TennisGame1 implements TennisGame {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public void wonPoint(String playerName){
        if(playerName.equals("player1")){
            playerOneScore ++;
        }
        if(playerName.equals("player2")){
            playerTwoScore ++;
        }
    };
    public String getScore(){
        if (playerOneScore == 1 && playerTwoScore == 0){
            return "Fifteen-Love";
        }
        else{return "oops!";}
    }
}
