package exame1_14_15.scoreService;

import sun.util.calendar.BaseCalendar.Date;

/**
 * Created by Ruben Gomes on 19/07/2015.
 */
public class Match {

    final Date date;
    final Team homeTeam, awayTeam;

    public Match(Date date, Team homeTeam, Team awayTeam){
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

}
