package org.danylo;

public class ScoreboardApp {
    public static void main(String[] args) throws InterruptedException {
        Scoreboard scoreboard = Scoreboard.getInstance();

        Match match1 = scoreboard.startNewGame(new Team("Mexico"), new Team("Canada"));
        Thread.sleep(1);
        Match match2 = scoreboard.startNewGame(new Team("Spain"), new Team("Brazil"));
        Thread.sleep(1);
        Match match3 = scoreboard.startNewGame(new Team("Germany"), new Team("France"));
        Thread.sleep(1);
        Match match4 = scoreboard.startNewGame(new Team("Uruguay"), new Team("Italy"));
        Thread.sleep(1);
        Match match5 = scoreboard.startNewGame(new Team("Argentina"), new Team("Australia"));
        Thread.sleep(1);

        match2.updateScore(10, 2);
        match3.updateScore(2, 2);
        match5.updateScore(3, 1);
        match1.updateScore(0, 5);
        match4.updateScore(6, 6);

        scoreboard.report();
    }
}
