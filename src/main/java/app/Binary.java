package app;

import java.util.ArrayList;
import java.util.List;

public class Binary {
    public static List<Boolean> toBinary(int digit, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        if (Math.pow(2, size) < digit) {
            throw new IllegalArgumentException();
        }
        List<Boolean> binary = initialize(size);
        int i = 0;
        while (digit != 0) {
            binary.set(i, digit % 2 == 1);
            digit /= 2;
            i++;
        }
        return binary;
    }

    private static List<Boolean> initialize(int size) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i, false);
        }
        return list;
    }
}
