package org.danylo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Scoreboard {
    private static final Scoreboard INSTANCE = new Scoreboard();
    private final List<Match> matches;

    private Scoreboard() {
        matches = new LinkedList<>();
    }

    public List<Match> getMatches() {
        return matches;
    }

    public Match startNewGame(Team homeTeam, Team awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
        return match;
    }

    public void finishGame(Match match) {
        matches.remove(match);
    }

    public void report() {
        matches.sort(Comparator.comparing((Match match) -> match.getHomeTeamScore() + match.getAwayTeamScore()).reversed()
                .thenComparing(Comparator.comparing(Match::getStartTime).reversed()));
        for (int i = 0; i < matches.size(); i++) {
            Match match = matches.get(i);
            System.out.printf("%d. %s %d - %s %d %n", i + 1, match.getHomeTeam().getName(), match.getHomeTeamScore(),
                    match.getAwayTeam().getName(), match.getAwayTeamScore());
        }
    }

    public static Scoreboard getInstance() {
        return INSTANCE;
    }
}
