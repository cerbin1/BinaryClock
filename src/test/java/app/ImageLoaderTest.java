package app;

import javafx.scene.image.Image;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertFalse;

public class ImageLoaderTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldGetImageFile() throws FileNotFoundException {
        // when
        Image test = ImageLoader.get("test.png");

        // then
        assertFalse(test.isError());
    }

    @Test
    public void shouldThrowOnGettingUnexistingFileImage() throws FileNotFoundException {
        // given
        expectedException.expect(RuntimeException.class);

        // when

        ImageLoader.get("test");
    }
}
