package app;

import java.util.Calendar;

import static java.util.Calendar.*;

public class Clock {
    public static String getTime() {
        Calendar c = getInstance();
        long now = c.getTimeInMillis();
        c.set(HOUR_OF_DAY, 0);
        c.set(MINUTE, 0);
        c.set(SECOND, 0);
        c.set(MILLISECOND, 0);
        long passed = now - c.getTimeInMillis();
        long secondsPassed = passed / 1000;
        long hours = secondsPassed / 3600;
        long minutes = secondsPassed % 3600 / 60;
        long seconds = secondsPassed % 60;
        return "It is: " + hours + ":" + minutes + ":" + seconds;
    }

    public static int getPassedSecondsFromMidnight() {
        Calendar c = getInstance();
        long now = c.getTimeInMillis();
        c.set(HOUR_OF_DAY, 0);
        c.set(MINUTE, 0);
        c.set(SECOND, 0);
        c.set(MILLISECOND, 0);
        long passed = now - c.getTimeInMillis();
        return (int) (passed / 1000);
    }
}
