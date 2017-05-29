package app;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;

public class ImageLoaderTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowOnGettingUnexistingFile() throws FileNotFoundException {
        // given
        expectedException.expect(RuntimeException.class);

        // when

        ImageLoader.get("test");
    }
}
