import java.util.Calendar;
import java.util.List;

import static java.util.Calendar.*;

public class Clock {
    void displayTime() {
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
        System.out.println("It is: " + hours + ":" + minutes + ":" + seconds);
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

    public List<Boolean> getFirstDigitHour() {
        return Binary.toBinary(getPassedSecondsFromMidnight() / 36000, 3);
    }

    public List<Boolean> getSecondDigitHour() {
        System.out.println(getPassedSecondsFromMidnight() / 3600 % 10);
        return Binary.toBinary(getPassedSecondsFromMidnight() / 3600 % 10, 4);
    }

    public List<Boolean> getFirstDigitMinute() {
        return Binary.toBinary(getPassedSecondsFromMidnight() % 3600 / 60 / 10, 3);
    }

    public List<Boolean> getSecondDigitMinute() {
        return Binary.toBinary(getPassedSecondsFromMidnight() % 3600 / 60 % 10, 4);
    }
}
