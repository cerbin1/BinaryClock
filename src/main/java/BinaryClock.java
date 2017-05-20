import java.util.ArrayList;
import java.util.List;

public class BinaryClock {

    public List<Boolean> getFirstDigitHour(int secondPassed) {
        return Binary.toBinary(secondPassed / 36000, 2);
    }

    public List<Boolean> getSecondDigitHour(int secondPassed) {
        return Binary.toBinary(secondPassed / 3600 % 10, 4);
    }

    public List<Boolean> getFirstDigitMinute(int secondPassed) {
        return Binary.toBinary(secondPassed % 3600 / 60 / 10, 3);
    }

    public List<Boolean> getSecondDigitMinute(int secondPassed) {
        return Binary.toBinary(secondPassed % 3600 / 60 % 10, 4);
    }

    public List[] getBinaryClock() {
        int secondsPassed = Clock.getPassedSecondsFromMidnight();
        List[] clock = new ArrayList[4];
        clock[0] = getFirstDigitHour(secondsPassed);
        clock[1] = getSecondDigitHour(secondsPassed);
        clock[2] = getFirstDigitMinute(secondsPassed);
        clock[3] = getSecondDigitMinute(secondsPassed);
        return clock;
    }
}
