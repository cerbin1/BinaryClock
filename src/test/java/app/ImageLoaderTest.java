package app;

import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;

public class ImageLoaderTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldGetImage() throws FileNotFoundException {
        // when

        Image test = ImageLoader.get("test.png");

        // then
        Assert.assertFalse(test.isError());
    }

    @Test
    public void shouldThrowOnGettingUnexistingFile() throws FileNotFoundException {
        // given
        expectedException.expect(RuntimeException.class);

        // when

        ImageLoader.get("test");
    }
}
