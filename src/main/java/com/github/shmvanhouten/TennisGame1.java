package com.github.shmvanhouten;

public class TennisGame1 implements TennisGame {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    private String[] tennisScores = {"Love","Fifteen","Thirty","Forty"};

    TennisGame1 (String player1Name, String player2Name){
        this.playerOneName = player1Name;
        this.playerTwoName = player2Name;
    }

    public void wonPoint(String playerName){
        if(playerName.equals(playerOneName)){
            playerOneScore ++;
        }
        if(playerName.equals(playerTwoName)){
            playerTwoScore ++;
        }
    }
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
            score = ascertainIfItIsAdvantageOrWin();
            score = getMostWinningPlayer(score);
        }
        return score;
    }

    private String getMostWinningPlayer(String score) {
        if (playerOneScore > playerTwoScore){score += playerOneName;}
        else {score += playerTwoName;}
        return score;
    }

    private String ascertainIfItIsAdvantageOrWin() {
        String score;
        int scoreDifference = Math.abs(playerOneScore - playerTwoScore);
        if(scoreDifference >1){score = "Win for ";}
        else{score = "Advantage ";}
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
