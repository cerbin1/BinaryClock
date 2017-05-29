package app;

import java.util.ArrayList;
import java.util.List;

import static app.BinaryConverter.toBinary;
import static app.Time.getPassedSecondsFromMidnight;

class BinaryClock {

    private List<Boolean> getFirstDigitHour(int secondPassed) {
        return toBinary(getTitheDigit(secondPassed / 3600), 2);
    }

    private List<Boolean> getSecondDigitHour(int secondPassed) {
        return toBinary(getDigitOfUnity(secondPassed / 3600), 4);
    }

    private List<Boolean> getFirstDigitMinute(int secondPassed) {
        return toBinary(getTitheDigit(secondPassed % 3600 / 60), 3);
    }

    private List<Boolean> getSecondDigitMinute(int secondPassed) {
        return toBinary(getDigitOfUnity(secondPassed % 3600 / 60), 4);
    }

    private List<Boolean> getFirstDigitSecond(int secondPassed) {
        return toBinary(getTitheDigit(secondPassed % 60), 3);
    }

    private List<Boolean> getSecondDigitSecond(int secondPassed) {
        return toBinary(getDigitOfUnity(secondPassed % 60), 4);
    }

    private int getDigitOfUnity(int number) {
        return number % 10;
    }

    private int getTitheDigit(int number) {
        return number / 10;
    }

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
