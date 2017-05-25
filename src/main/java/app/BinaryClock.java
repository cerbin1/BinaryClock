package app;

import java.util.ArrayList;
import java.util.List;

import static app.BinaryConverter.*;
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

    public List[] getTime() {
        int secondsPassed = getPassedSecondsFromMidnight();
        List[] binaryTime = new ArrayList[6];
        binaryTime[0] = getFirstDigitHour(secondsPassed);
        binaryTime[1] = getSecondDigitHour(secondsPassed);
        binaryTime[2] = getFirstDigitMinute(secondsPassed);
        binaryTime[3] = getSecondDigitMinute(secondsPassed);
        binaryTime[4] = getFirstDigitSecond(secondsPassed);
        binaryTime[5] = getSecondDigitSecond(secondsPassed);
        return binaryTime;
    }
}
