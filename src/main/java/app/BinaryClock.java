package app;

import java.util.ArrayList;
import java.util.List;

import static app.Time.*;

class BinaryClock {
    List<List<Boolean>> getTime() {
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
