package com.github.shmvanhouten;

public class TennisGame1 implements TennisGame {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String[] tennisScores = {"Love","Fifteen","Thirty","Forty"};

    public void wonPoint(String playerName){
        if(playerName.equals("player1")){
            playerOneScore ++;
        }
        if(playerName.equals("player2")){
            playerTwoScore ++;
        }
    };
    public String getScore(){
        if(playerOneScore == playerTwoScore){
            return tennisScores[playerOneScore] + "-All";
        }
        else{
            return tennisScores[playerOneScore] + "-" + tennisScores[playerTwoScore];
        }
    }
}
