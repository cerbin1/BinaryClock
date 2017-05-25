package app;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static javafx.application.Platform.runLater;
import static javafx.geometry.Pos.CENTER;

public class Application extends javafx.application.Application {
    private BinaryClock binaryClock;

    public Application() {
        binaryClock = new BinaryClock();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Binary Clock");

        Label label = new Label();

        GridPane grid = new GridPane();
        grid.setAlignment(CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    try {
                        List[] clockDigits = binaryClock.getBinaryClock();
                        for (int i = 0; i < clockDigits.length; i++) {
                            List clockDigit = clockDigits[i];
                            for (int j = 0; j < clockDigit.size(); j++) {
                                ImageView imageView = new ImageView();
                                if ((Boolean) clockDigit.get(j)) {
                                    imageView.setImage(ImageRepository.get("1.png"));
                                } else {
                                    imageView.setImage(ImageRepository.get("0.png"));
                                }
                                grid.add(imageView, i, 3 - j);
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
        }, 0, 1000);
        grid.add(label, 1, 4, 4, 1);
        label.setFont(new Font(60));
        setDisplayingTimeOn(label);
        primaryStage.setScene(new Scene(grid, 400, 400));
        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
        primaryStage.show();
    }

    private void setDisplayingTimeOn(Label label) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runLater(() -> label.setText(Clock.getTime()));
            }
        }, 0, 1000);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
