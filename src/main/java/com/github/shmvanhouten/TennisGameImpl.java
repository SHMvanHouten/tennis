package com.github.shmvanhouten;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

public class TennisGameImpl implements TennisGame {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    private Map<Integer, String> tennisScores = new HashMap<>();


    TennisGameImpl(String player1Name, String player2Name){
        this.playerOneName = player1Name;
        this.playerTwoName = player2Name;

        populateScoreMap();
    }

    private void populateScoreMap() {
        tennisScores.put(0, "Love");
        tennisScores.put(1, "Fifteen");
        tennisScores.put(2, "Thirty");
        tennisScores.put(3, "Forty");
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

        boolean scoresAreFortyOrBelowAndNotDeuce = playerOneScore < 4 && playerTwoScore < 3 || playerOneScore < 3 && playerTwoScore < 4;

        if (scoresAreFortyOrBelowAndNotDeuce) {
            return getScoreIfGameHasNotPassedDeuceStage();
        } else {
            return getScoreIfGameHasEnteredDeuceStage();
        }
    }



    private String getScoreIfGameHasEnteredDeuceStage() {

        if (isEqualAmountOfPointsScored()) {
            return "Deuce";
        } else{
            String situation = ascertainIfItIsAdvantageOrWin();
            return situation + " " + getNameOfPlayerWithTheMostPoints();
        }
    }

    private boolean isEqualAmountOfPointsScored() {
        return playerOneScore == playerTwoScore;
    }

    private String getNameOfPlayerWithTheMostPoints() {
        if (playerOneScore > playerTwoScore) {
            return playerOneName;
        } else {
            return playerTwoName;
        }
    }

    private String ascertainIfItIsAdvantageOrWin() {
        if(abs(playerOneScore - playerTwoScore) > 1) {
            return "Win for";
        } else {
            return "Advantage";
        }
    }

    private String getScoreIfGameHasNotPassedDeuceStage() {
        if (isEqualAmountOfPointsScored()) {
            return tennisScores.get(playerOneScore) + "-All";
        } else {
            return tennisScores.get(playerOneScore) + "-" + tennisScores.get(playerTwoScore);
        }
    }


    public static void main (String[] args) {
        String player1Name = "Marjan";
        String player2Name = "Sjoerd";
        int player1Score = 1;
        int player2Score = 2;
        TennisGame game = new TennisGameImpl(player1Name, player2Name);
        int highestScore = Math.max(player1Score, player2Score);
        for (int i = 0; i< highestScore; i++){
            if (i < player1Score){
                game.wonPoint(player1Name);
            }
            if (i < player2Score){
                game.wonPoint(player2Name);
            }
        }
        System.out.println(game.getScore());
    }
}
