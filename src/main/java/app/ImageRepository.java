package app;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageRepository {
    public static Image get(String name) throws FileNotFoundException {
        String filePath = new File("").getAbsolutePath();
        return new Image(new FileInputStream(filePath + "\\resources\\" + name));
    }
}
