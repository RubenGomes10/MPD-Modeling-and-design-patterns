package exame1_14_15.scoreService;

import sun.util.calendar.BaseCalendar.Date;

/**
 * Created by Ruben Gomes on 19/07/2015.
 */
public class Score {

    final Date date ;
    final Team homeTeam, awayTeam;
    final int homeScore,awayScore;

    public Score(Date date, Team homeTeam, Team awayTeam, int homeScore, int awayScore){
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
}
