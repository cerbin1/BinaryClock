package app;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.rules.ExpectedException.none;

public class BinaryConverterTest {
    @Rule
    public ExpectedException expectedException = none();

    @Test
    public void shouldChangeToBinary() {
        // given
        List<Boolean> list;

        // when
        list = BinaryConverter.toBinary(7, 4);

        // then
        Boolean[] expected = {true, true, true, false};
        assertTrue(Arrays.equals(list.toArray(), expected));
    }

    @Test
    public void shouldChangeToBinaryUsingWholeSize() {
        // given
        List<Boolean> list;

        // when
        list = BinaryConverter.toBinary(7, 3);

        // then
        Boolean[] expected = {true, true, true};
        assertTrue(Arrays.equals(list.toArray(), expected));
    }

    @Test
    public void shouldChangeZeroNumberToBinary() {
        // given
        List<Boolean> list;

        // when
        list = BinaryConverter.toBinary(0, 4);

        // then
        Boolean[] expected = {false, false, false, false};
        assertTrue(Arrays.equals(list.toArray(), expected));
    }

    @Test
    public void shouldThrowWhenSizeIsSmallerThanNeeded() {
        // given

        expectedException.expect(IllegalArgumentException.class);

        // when

        BinaryConverter.toBinary(9, 2);

    }

    @Test
    public void shouldThrowOnTakingZeroSize() {
        // given

        expectedException.expect(IllegalArgumentException.class);

        // when

        BinaryConverter.toBinary(1, 0);
    }
}