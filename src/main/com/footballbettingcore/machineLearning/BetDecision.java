package com.footballbettingcore.machineLearning;

import com.footballbettingcore.database.Result;
import com.footballbettingcore.scrape.classes.OddsCheckerBookies;

import java.util.TreeSet;

import static com.footballbettingcore.machineLearning.DecideBet.MAX_STAKE;
import static com.footballbettingcore.machineLearning.DecideBet.MIN_STAKE;

public class BetDecision {
    private Result winner;
    private TreeSet<BookieBetInfo> bookiePriority;

    public BetDecision(Result res) {
        this.winner = res;
        this.bookiePriority = new TreeSet<>();
    }

    public void addBookie(OddsCheckerBookies bookie, double stake, double minOdds) {
        if (stake >= MIN_STAKE && stake <= MAX_STAKE && minOdds > 1.3) {
            bookiePriority.add(new BookieBetInfo(bookie, stake, minOdds));
        }
    }

    public TreeSet<BookieBetInfo> getBookiePriority() {
        return bookiePriority;
    }

    public Result getWinner() {
        return winner;
    }

}
