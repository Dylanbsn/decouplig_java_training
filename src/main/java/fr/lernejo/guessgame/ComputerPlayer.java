package fr.lernejo.guessgame;

import fr.lernejo.Launcher;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{
    private long guessing;
    private long min,max;
    private final Logger logger = new LoggerFactory().getLogger("player");
    public ComputerPlayer(){
        min= Launcher.MIN_RANGE;
        max= Launcher.MAX_RANGE;
        guessing=getMean(max,min);
    }
    public long askNextGuess() {
        logger.log(String.valueOf(guessing));
        return guessing;
    }

    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater){
            min=getMean(min,max);
        }
        else{
            max=getMean(min,max);
        }
        guessing=getMean(min,max);
    }
    private long getMean(long max, long min){
        return (max+min)/2;
    }
}
