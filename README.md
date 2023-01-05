# Live Football World Cup Score Board

## Description
This project is written in Java. It shows all the ongoing matches and their scores.

**The scoreboard supports the following operations:**
1. ***Start a new game***, assuming initial score 0 – 0 and adding it to the scoreboard.
   It takes 2 [teams](/src/main/java/org/danylo/Team.java) as parameters:
    - *Home team*
    - *Away team*


2. ***Finish game*** currently in progress. This removes a specific match from the scoreboard.


3. ***Get a summary of games in progress ordered by their total score***. The games with the same
   total score will be returned ordered by the most recently started match in the scoreboard.


4. ***Update score***. This takes a pair of absolute scores: home team score and away
   team score.


First 3 methods are implemented in [Scoreboard](/src/main/java/org/danylo/Scoreboard.java) class
and the last one - in [Match](/src/main/java/org/danylo/Match.java) class
as it updates score in the specific match.

All the main methods of the application are covered with tests
that confirm the correct operation of the functionality.