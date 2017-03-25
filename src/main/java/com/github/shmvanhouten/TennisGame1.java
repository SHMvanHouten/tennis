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
        String score;
        boolean playerScoresAreEqual = playerOneScore == playerTwoScore;
        boolean scoresAreFortyOrBelowAndNotDeuce = playerOneScore < 4 && playerTwoScore < 3 || playerOneScore < 3 && playerTwoScore < 4;
        if (scoresAreFortyOrBelowAndNotDeuce) {
            score = getScoreIfGameHasNotPassedDeuceStage(playerScoresAreEqual);
        }
        else {
            score = getScoreIfGameHasEnteredDeuceStage(playerScoresAreEqual);
        }
        return score;
    }

    private String getScoreIfGameHasEnteredDeuceStage(boolean playerScoresAreEqual) {
        String score;
        if (playerScoresAreEqual) {
            score = "Deuce";
        } else{
            int scoreDifference = Math.abs(playerOneScore - playerTwoScore);
            if(scoreDifference >1){score = "Win for ";}
            else{score = "Advantage ";}
            if (playerOneScore > playerTwoScore){score += "player1";}
            else {score += "player2";}
        }
        return score;
    }

    private String getScoreIfGameHasNotPassedDeuceStage(boolean playerScoresAreEqual) {
        String score;
        if (playerScoresAreEqual) {
            score = tennisScores[playerOneScore] + "-All";
        } else {
            score = tennisScores[playerOneScore] + "-" + tennisScores[playerTwoScore];
        }
        return score;
    }
}
