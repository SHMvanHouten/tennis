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
        boolean playerScoresAreEqual = playerOneScore == playerTwoScore;
        boolean scoresAreFortyOrBelowAndNotDeuce = playerOneScore < 4 && playerTwoScore < 3 || playerOneScore < 3 && playerTwoScore < 4;
        if (scoresAreFortyOrBelowAndNotDeuce) {
            if (playerScoresAreEqual) {
                return tennisScores[playerOneScore] + "-All";
            } else {
                return tennisScores[playerOneScore] + "-" + tennisScores[playerTwoScore];
            }
        }
        else {
            if (playerScoresAreEqual) {
                return "Deuce";
            } else{
                if (playerOneScore > playerTwoScore){return "Advantage player1";}
                else {return "Advantage player2";}
            }
        }
    }
}
