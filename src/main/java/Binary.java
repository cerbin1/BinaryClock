import java.util.ArrayList;
import java.util.List;

public class Binary {
    public static List<Boolean> changeToBinaryAndRevert(int digit, int size) {
        List<Boolean> binary = new ArrayList<>(size);
        while (digit != 0) {
            binary.add(digit % 2 == 1);
            digit /= 2;
        }
        return binary;
    }
}
