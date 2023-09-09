package org.danylo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {
    private static Scoreboard scoreboard;

    @BeforeAll
    static void init() {
        scoreboard = Scoreboard.getInstance();
    }

    @Test
    void updateScore() {
        Match match = scoreboard.startNewGame(new Team("Germany"), new Team("France"));
        match.updateScore(3, 2);
        assertTrue(match.getHomeTeamScore() == 3 && match.getAwayTeamScore() == 2);
    }
}