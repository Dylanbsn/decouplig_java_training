package fr.lernejo.guessgame;

import java.util.Scanner;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class HumanPlayer implements Player {

    private final Logger logger = LoggerFactory.getLogger("Player");

    public long askNextGuess() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextLong();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void respond(boolean lowerOrGreater) {

    }
}
