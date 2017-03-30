package com.github.shmvanhouten;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TennisTest {
    @Test
    public void itShouldGiveScoreFifteenLove() throws Exception{
        TennisGame game = new TennisGameImpl("player1", "player2");
        game.wonPoint("player1");

        assertThat(
                game.getScore(),
                is("Fifteen-Love")
        );
    }
    @Test
    public void itShouldGiveScoreThirtyLove() throws Exception{
        TennisGame game = new TennisGameImpl("player1", "player2");
        game.wonPoint("player1");
        game.wonPoint("player1");
        assertThat(
                game.getScore(),
                is("Thirty-Love")
        );
    }
    @Test
    public void itShouldGiveScoreFifteenAll() throws Exception{
        TennisGame game = new TennisGameImpl("player1", "player2");
        game.wonPoint("player1");
        game.wonPoint("player2");
        assertThat(
                game.getScore(),
                is("Fifteen-All")
        );
    }
    @Test
    public void itShouldGiveScoreDeuce() throws Exception{
        TennisGame game = new TennisGameImpl("player1", "player2");
        int player1Score = 3;
        int player2Score = 3;

        simulateMatch(game, player1Score, player2Score);
        assertThat(
                game.getScore(),
                is("Deuce")
        );
    }
    @Test
    public void itShouldGiveScoreAdvantagePlayer1() throws Exception{
        TennisGame game = new TennisGameImpl("player1", "player2");
        int player1Score = 4;
        int player2Score = 3;

        simulateMatch(game, player1Score, player2Score);
        assertThat(
                game.getScore(),
                is("Advantage player1")
        );
    }
    @Test
    public void itShouldGiveScoreAdvantagePlayer2() throws Exception{
        TennisGame game = new TennisGameImpl("player1", "player2");
        int player1Score = 3;
        int player2Score = 4;

        simulateMatch(game, player1Score, player2Score);
        assertThat(
                game.getScore(),
                is("Advantage player2")
        );
    }
    @Test
    public void itShouldGiveTheWinToPlayer1() throws Exception{
        TennisGame game = new TennisGameImpl("player1", "player2");
        int player1Score = 5;
        int player2Score = 3;

        simulateMatch(game, player1Score, player2Score);
        assertThat(
                game.getScore(),
                is("Win for player1")
        );
    }




    private void simulateMatch(TennisGame game, int player1Score, int player2Score) {
        int highestScore = Math.max(player1Score, player2Score);
        for (int i = 0; i< highestScore; i++){
            if (i < player1Score){
                game.wonPoint("player1");
            }
            if (i < player2Score){
                game.wonPoint("player2");
            }
        }
    }


}
