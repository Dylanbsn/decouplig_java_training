package fr.lernejo.timer;

public class Timer {

    private long time;

    public Timer() {
        time = System.currentTimeMillis();
    }

    public String stop() {
        return TimeFormater.display(System.currentTimeMillis() - time, false);
    }
}
