package fr.lernejo;

import fr.lernejo.guessgame.ComputerPlayer;
import fr.lernejo.guessgame.HumanPlayer;

import java.security.SecureRandom;


public class Launcher {

    public static long MAX_RANGE = Long.MAX_VALUE;
    public static long MIN_RANGE = Long.MIN_VALUE;

    public static void main(String[] args){

        SecureRandom random = new SecureRandom();
        long number = random.nextLong();

        if (args.length == 2 && args[0].equalsIgnoreCase("-auto")) {
            Simulation simulation = new Simulation(new ComputerPlayer());
            try {
                simulation.initialize(Long.parseLong(args[1]));
            }
            catch(NumberFormatException e){
                System.out.println("Mauvais format d'input veuillez renseigner un nombre");
                return;
            }
            simulation.loopUntilPlayerSucceed(1000);
        } else if (args.length==1 && args[0].equalsIgnoreCase("-interactive")) {
            Simulation simulation = new Simulation(new HumanPlayer());
            simulation.initialize(number);
            simulation.loopUntilPlayerSucceed(1000);
        }
        else{
            System.out.println("Please type: -auto to play with a robot\n");
            System.out.println("Or type: -interactive to play independently\n");
        }
    }
}
