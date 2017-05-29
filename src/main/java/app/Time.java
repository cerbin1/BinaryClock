package app;

import java.util.Calendar;

import static java.util.Calendar.*;

class Time {
    static String getTime() {
        int secondsPassed = getPassedSecondsFromMidnight();
        int hours = secondsPassed / 3600;
        int minutes = secondsPassed % 3600 / 60;
        int seconds = secondsPassed % 60;
        return getTimeInProperFormat(hours, minutes, seconds);
    }

    private static String getTimeInProperFormat(int hours, int minutes, int seconds) {
        return hours + ":" + (minutes < 10 ? "0" : "") + minutes + ":" + (seconds < 10 ? "0" : "") + seconds;
    }

    static int getPassedSecondsFromMidnight() {
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
