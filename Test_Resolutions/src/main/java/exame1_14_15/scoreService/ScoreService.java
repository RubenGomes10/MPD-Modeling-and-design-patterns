package exame1_14_15.scoreService;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static java.util.stream.Collectors.*;

/**
 * Created by Ruben Gomes on 19/07/2015.
 */
public class ScoreService {
    void addListenerForGame(Match match,ScoreListener lst){}

    //a
    public List<Future<Score>> getScores(Match ... matches){
        return Arrays.asList(matches).stream().map(
                (match)->{
                    CompletableFuture<Score> cf = new CompletableFuture<Score>();
                    this.addListenerForGame(
                            match,
                            (homeS,awayS)-> cf.complete(new Score(match.date,match.homeTeam,match.awayTeam,homeS,awayS))
                    );
                    return cf;
                }
        ).collect(toList());
    }

    //b
    public Iterator<Future<Score>> getScoresLazy(Match ... matches){
        final Iterator<Match> matchIt = Arrays.asList(matches).iterator();
        return new Iterator<Future<Score>>() {
            @Override
            public boolean hasNext() {
                return matchIt.hasNext();
            }

            @Override
            public Future<Score> next() {
                Match currMatch = matchIt.next();
                CompletableFuture<Score> cf = new CompletableFuture<>();
                ScoreService.this.addListenerForGame(
                        currMatch,
                        (homeS,awayS) -> cf.complete(new Score(currMatch.date,currMatch.homeTeam,currMatch.awayTeam,homeS,awayS))
                );
                return cf;
            }
        };
    }


}
