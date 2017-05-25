package app;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageRepository {
    public static Image get(String name) throws FileNotFoundException {
        return new Image(new FileInputStream("C:\\Users\\bartek\\Desktop\\Projekty\\Java\\BinaryClock\\res\\" + name));
    }
}
