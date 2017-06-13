package app;

import java.util.Calendar;
import java.util.List;

import static app.BinaryConverter.toBinary;
import static java.util.Calendar.*;

class Time {
    static String getTime() {
        int secondsPassed = getPassedSecondsFromMidnight();
        int hours = secondsPassed / 3600;
        int minutes = secondsPassed % 3600 / 60;
        int seconds = secondsPassed % 60;
        return getTimeInClassicFormat(hours, minutes, seconds);
    }

    private static String getTimeInClassicFormat(int hours, int minutes, int seconds) {
        return hours + ":" + (minutes < 10 ? "0" : "") + minutes + ":" + (seconds < 10 ? "0" : "") + seconds;
    }

    static List<Boolean> getFirstDigitHour(int secondPassed) {
        return toBinary(getTitheDigit(secondPassed / 3600), 2);
    }

    static List<Boolean> getSecondDigitHour(int secondPassed) {
        return toBinary(getDigitOfUnity(secondPassed / 3600), 4);
    }

    static List<Boolean> getFirstDigitMinute(int secondPassed) {
        return toBinary(getTitheDigit(secondPassed % 3600 / 60), 3);
    }

    static List<Boolean> getSecondDigitMinute(int secondPassed) {
        return toBinary(getDigitOfUnity(secondPassed % 3600 / 60), 4);
    }

    static List<Boolean> getFirstDigitSecond(int secondPassed) {
        return toBinary(getTitheDigit(secondPassed % 60), 3);
    }

    static List<Boolean> getSecondDigitSecond(int secondPassed) {
        return toBinary(getDigitOfUnity(secondPassed % 60), 4);
    }

    private static int getDigitOfUnity(int number) {
        return number % 10;
    }

    private static int getTitheDigit(int number) {
        return number / 10;
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
