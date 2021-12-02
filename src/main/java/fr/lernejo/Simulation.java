package fr.lernejo;

import fr.lernejo.guessgame.Player;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import fr.lernejo.timer.Timer;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private Long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long next = player.askNextGuess();
        if (next > numberToGuess) {
            logger.log("Lower");
            player.respond(false);
        } else if (next < numberToGuess) {
            logger.log("Higher");
            player.respond(true);
        } else {
            logger.log("gg");
            return true;
        }
        return false;
    }

    public void loopUntilPlayerSucceed(int iter) {
        int i = 0;
        Timer timer = new Timer();
        while (!nextRound()) {
            i++;
            if (i >= iter) {
                logger.log("You lose, no more try available");
                break;
            }
        }
        logger.log("Temps écoulé: " + timer.stop());
        logger.log(String.valueOf(i));
    }
}
