import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.List;

import static javafx.geometry.Pos.CENTER;

public class Application extends javafx.application.Application {
    private BinaryClock binaryClock;

    public Application() {
        binaryClock = new BinaryClock();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Binary Clock");

        GridPane grid = new GridPane();
        grid.setAlignment(CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        List[] clockDigits = binaryClock.getBinaryClock();
        for (int i = 0; i < clockDigits.length; i++) {
            List clockDigit = clockDigits[i];
            for (int j = 0; j < clockDigit.size(); j++) {
                ImageView imageView = new ImageView();
                if ((Boolean) clockDigit.get(j)) {
                    imageView.setImage(new Image(new FileInputStream("C:\\Users\\bartek\\Desktop\\Projekty\\Java\\BinaryClock\\res\\1.png")));
                } else {
                    imageView.setImage(new Image(new FileInputStream("C:\\Users\\bartek\\Desktop\\Projekty\\Java\\BinaryClock\\res\\0.png")));
                }
                grid.add(imageView, i, 3 - j);
            }
        }
        primaryStage.setScene(new Scene(grid, 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
