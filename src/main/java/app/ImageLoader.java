package app;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class ImageLoader {
    static Image get(String name) {
        String absolutePath = new File("").getAbsolutePath();
        try {
            return new Image(new FileInputStream(absolutePath + "\\resources\\" + name));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
