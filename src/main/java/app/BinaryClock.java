package app;

import java.util.ArrayList;
import java.util.List;

import static app.Binary.*;
import static app.Time.*;

public class BinaryClock {

    public List<Boolean> getFirstDigitHour(int secondPassed) {
        return toBinary(secondPassed / 36000, 2);
    }

    public List<Boolean> getSecondDigitHour(int secondPassed) {
        return toBinary(secondPassed / 3600 % 10, 4);
    }

    public List<Boolean> getFirstDigitMinute(int secondPassed) {
        return toBinary(secondPassed % 3600 / 60 / 10, 3);
    }

    public List<Boolean> getSecondDigitMinute(int secondPassed) {
        return toBinary(secondPassed % 3600 / 60 % 10, 4);
    }

    public List<Boolean> getFirstDigitSecond(int secondPassed) {
        return toBinary(secondPassed % 60 / 10, 3);
    }

    public List<Boolean> getSecondDigitSecond(int secondPassed) {
        return toBinary(secondPassed % 60 % 10, 4);
    }

    public List[] getBinaryClock() {
        int secondsPassed = getPassedSecondsFromMidnight();
        List[] clock = new ArrayList[6];
        clock[0] = getFirstDigitHour(secondsPassed);
        clock[1] = getSecondDigitHour(secondsPassed);
        clock[2] = getFirstDigitMinute(secondsPassed);
        clock[3] = getSecondDigitMinute(secondsPassed);
        clock[4] = getFirstDigitSecond(secondsPassed);
        clock[5] = getSecondDigitSecond(secondsPassed);
        return clock;
    }
}
