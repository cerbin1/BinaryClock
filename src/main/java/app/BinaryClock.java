package app;

import java.util.ArrayList;
import java.util.List;

import static app.BinaryConverter.toBinary;
import static app.Time.getPassedSecondsFromMidnight;

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

    public List<List<Boolean>> getTime() {
        int secondsPassed = getPassedSecondsFromMidnight();
        List<List<Boolean>> binaryTime = new ArrayList<>(6);
        binaryTime.add(getFirstDigitHour(secondsPassed));
        binaryTime.add(getSecondDigitHour(secondsPassed));
        binaryTime.add(getFirstDigitMinute(secondsPassed));
        binaryTime.add(getSecondDigitMinute(secondsPassed));
        binaryTime.add(getFirstDigitSecond(secondsPassed));
        binaryTime.add(getSecondDigitSecond(secondsPassed));
        return binaryTime;
    }
}
