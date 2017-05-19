import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.rules.ExpectedException.none;

public class BinaryTest {
    @Rule
    public ExpectedException expectedException = none();

    @Test
    public void shouldChangeToBinary() {
        // given
        List<Boolean> list;

        // when
        list = Binary.toBinary(7, 4);

        // then
        Boolean[] expected = {true, true, true, false};
        assertTrue(Arrays.equals(list.toArray(), expected));
    }

    @Test
    public void shouldChangeToBinaryWithUsingFullSize() {
        // given
        List<Boolean> list;

        // when
        list = Binary.toBinary(7, 3);

        // then
        Boolean[] expected = {true, true, true};
        assertTrue(Arrays.equals(list.toArray(), expected));
    }

    @Test
    public void shouldChangeZeroNumberToBinary() {
        // given
        List<Boolean> list;

        // when
        list = Binary.toBinary(0, 4);

        // then
        Boolean[] expected = {false, false, false, false};
        assertTrue(Arrays.equals(list.toArray(), expected));
    }

    @Test
    public void shouldThrowOnTakingNumberWithNotEnoughSizeOn() {
        // given

        expectedException.expect(IllegalArgumentException.class);

        // when

        Binary.toBinary(9, 2);

    }

    @Test
    public void shouldThrowOnTakingZeroSize() {
        // given

        expectedException.expect(IllegalArgumentException.class);

        // when

        Binary.toBinary(1, 0);
    }
}