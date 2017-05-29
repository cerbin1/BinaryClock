package app;

import java.util.Calendar;

import static java.util.Calendar.*;

public class Time {
    public static String getTime() {
        int secondsPassed = getPassedSecondsFromMidnight();
        int hours = secondsPassed / 3600;
        int minutes = secondsPassed % 3600 / 60;
        int seconds = secondsPassed % 60;
        return hours + ":" + (minutes < 10 ? "0" : "") + minutes + ":" + (seconds < 10 ? "0" : "") + seconds;
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
