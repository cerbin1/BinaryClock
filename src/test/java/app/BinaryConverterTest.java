package app;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static app.BinaryConverter.toBinary;
import static org.junit.Assert.assertTrue;
import static org.junit.rules.ExpectedException.none;

public class BinaryConverterTest {
    @Rule
    public ExpectedException expectedException = none();

    @Test
    public void shouldChangeToBinary() {
        // given
        int digit = 7;
        int size = 4;

        // when
        List<Boolean> list = toBinary(digit, size);

        // then
        Boolean[] expected = {true, true, true, false};
        assertTrue(Arrays.equals(list.toArray(), expected));
    }

    @Test
    public void shouldChangeToBinaryUsingWholeSize() {
        // given
        int digit = 7;
        int size = 3;

        // when
        List<Boolean> list = toBinary(digit, size);

        // then
        Boolean[] expected = {true, true, true};
        assertTrue(Arrays.equals(list.toArray(), expected));
    }

    @Test
    public void shouldChangeZeroNumberToBinary() {
        // given
        int digit = 0;
        int size = 4;

        // when
        List<Boolean> list = toBinary(digit, size);

        // then
        Boolean[] expected = {false, false, false, false};
        assertTrue(Arrays.equals(list.toArray(), expected));
    }

    @Test
    public void shouldThrowWhenSizeIsSmallerThanNeeded() {
        // given

        expectedException.expect(IllegalArgumentException.class);

        // when

        toBinary(9, 2);
    }

    @Test
    public void shouldThrowOnTakingZeroSize() {
        // given

        expectedException.expect(IllegalArgumentException.class);

        // when

        toBinary(1, 0);
    }
}