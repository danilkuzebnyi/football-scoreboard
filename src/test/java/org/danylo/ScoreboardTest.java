package org.danylo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {
    private static Scoreboard scoreboard;

    @BeforeAll
    static void init() {
        scoreboard = Scoreboard.getInstance();
    }

    @Test
    void startNewGame() {
        scoreboard.getMatches().clear();
        scoreboard.startNewGame(new Team("Mexico"), new Team("Canada"));

        assertEquals(1, scoreboard.getMatches().size());
        assertTrue(scoreboard.getMatches().get(0).getHomeTeamScore() == 0
                && scoreboard.getMatches().get(0).getAwayTeamScore() == 0);
    }

    @Test
    void finishGame() {
        scoreboard.getMatches().clear();
        Match match1 = scoreboard.startNewGame(new Team("Ukraine"), new Team("Canada"));
        Match match2 = scoreboard.startNewGame(new Team("Mexico"), new Team("France"));

        assertEquals(2, scoreboard.getMatches().size());
        scoreboard.finishGame(match1);
        assertEquals(1, scoreboard.getMatches().size());
        scoreboard.finishGame(match2);
        assertEquals(0, scoreboard.getMatches().size());
    }

    @Test
    void report() throws InterruptedException {
        Match match1 = scoreboard.startNewGame(new Team("Spain"), new Team("Canada"));
        Thread.sleep(1);
        Match match2 = scoreboard.startNewGame(new Team("Ukraine"), new Team("China"));
        Thread.sleep(1);
        Match match3 = scoreboard.startNewGame(new Team("Italy"), new Team("Belgium"));
        Thread.sleep(1);
        Match match4 = scoreboard.startNewGame(new Team("Morocco"), new Team("Brazil"));
        Thread.sleep(1);
        Match match5 = scoreboard.startNewGame(new Team("Croatia"), new Team("Australia"));
        Thread.sleep(1);
        Match match6 = scoreboard.startNewGame(new Team("Germany"), new Team("England"));
        Thread.sleep(1);

        match2.updateScore(2, 2);
        match1.updateScore(4, 1);
        match4.updateScore(2, 3);
        match3.updateScore(5, 0);
        match5.updateScore(2, 1);
        match6.updateScore(1, 2);

        scoreboard.report();

        List<Match> matches = List.of(match4, match3, match1, match2, match6, match5);
        assertEquals(matches, scoreboard.getMatches());
    }
}