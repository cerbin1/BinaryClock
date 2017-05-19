import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.List;

import static javafx.geometry.Pos.CENTER;

public class Application extends javafx.application.Application {
    private Clock clock;

    public Application() {
        clock = new Clock();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hi");
        Button button = new Button();
        button.setText("Witaj towarzyszu");
        button.setOnAction(event -> clock.displayTime());

        GridPane grid = new GridPane();
        grid.setAlignment(CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        List<Boolean> list = clock.getFirstDigitHour();

        for (int i = 0; i < list.size(); i++) {
            ImageView imageView = new ImageView();
            if (list.get(i)) {
                imageView.setImage(new Image(new FileInputStream("C:\\Users\\bartek\\Desktop\\Projekty\\Java\\BinaryClock\\res\\1.png")));
            } else {
                imageView.setImage(new Image(new FileInputStream("C:\\Users\\bartek\\Desktop\\Projekty\\Java\\BinaryClock\\res\\0.png")));
            }
            grid.add(imageView, 0, 3 - i);
        }

        List<Boolean> list2 = clock.getSecondDigitHour();
        for (int i = 0; i < list2.size(); i++) {
            ImageView imageView = new ImageView();
            if (list2.get(i)) {
                imageView.setImage(new Image(new FileInputStream("C:\\Users\\bartek\\Desktop\\Projekty\\Java\\BinaryClock\\res\\1.png")));
            } else {
                imageView.setImage(new Image(new FileInputStream("C:\\Users\\bartek\\Desktop\\Projekty\\Java\\BinaryClock\\res\\0.png")));
            }
            grid.add(imageView, 1, 3 - i);
        }
        List<Boolean> list3 = clock.getFirstDigitMinute();

        for (int i = 0; i < list3.size(); i++) {
            ImageView imageView = new ImageView();
            if (list3.get(i)) {
                imageView.setImage(new Image(new FileInputStream("C:\\Users\\bartek\\Desktop\\Projekty\\Java\\BinaryClock\\res\\1.png")));
            } else {
                imageView.setImage(new Image(new FileInputStream("C:\\Users\\bartek\\Desktop\\Projekty\\Java\\BinaryClock\\res\\0.png")));
            }
            grid.add(imageView, 2, 3 - i);
        }
        List<Boolean> list4 = clock.getSecondDigitMinute();
        for (int i = 0; i < list4.size(); i++) {
            ImageView imageView = new ImageView();
            if (list4.get(i)) {
                imageView.setImage(new Image(new FileInputStream("C:\\Users\\bartek\\Desktop\\Projekty\\Java\\BinaryClock\\res\\1.png")));
            } else {
                imageView.setImage(new Image(new FileInputStream("C:\\Users\\bartek\\Desktop\\Projekty\\Java\\BinaryClock\\res\\0.png")));
            }
            grid.add(imageView, 3, 3 - i);
        }
        primaryStage.setScene(new Scene(grid, 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
