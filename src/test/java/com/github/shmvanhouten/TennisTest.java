package com.github.shmvanhouten;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TennisTest {
    @Test
    public void itShouldGiveScoreFifteenLove() throws Exception{
        TennisGame game = new TennisGame1();
        game.wonPoint("player1");

        assertThat(
                game.getScore(),
                is("Fifteen-Love")
        );
    }
}
