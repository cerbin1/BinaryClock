package app;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static app.ImageRepository.get;
import static app.Time.getTime;
import static javafx.geometry.Pos.CENTER;

public class Application extends javafx.application.Application {
    private BinaryClock binaryClock;

    private Label normalClock = new Label();
    private Button normalClockToggle = new Button();

    private boolean displayNormalClock = true;

    public Application() {
        binaryClock = new BinaryClock();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Binary Time");

        GridPane grid = createGrid();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(displayBinaryClock(grid), 0, 1000);

        grid.add(normalClock, 1, 4, 4, 1);
        normalClock.setFont(new Font(60));

        normalClockToggle.setText("Hide");
        grid.add(normalClockToggle, 0, 5, 6, 1);
        GridPane.setHalignment(normalClockToggle, HPos.CENTER);
        normalClockToggle.setOnAction(getEventHandlerForDisplayClockButton());

        primaryStage.setScene(new Scene(grid, 400, 400));
        primaryStage.setOnCloseRequest(getCloseOperation());
        primaryStage.show();
    }

    private EventHandler<ActionEvent> getEventHandlerForDisplayClockButton() {
        return event -> {
            normalClockToggle.setText((displayNormalClock ? "Hide" : "Display"));
            displayNormalClock = !displayNormalClock;
            normalClock.setText((displayNormalClock ? getTime() : ""));
        };
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        return grid;
    }

    private TimerTask displayBinaryClock(GridPane grid) {
        return new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    try {
                        List[] timeDigits = binaryClock.getTime();
                        for (int i = 0; i < timeDigits.length; i++) {
                            List binaryDigit = timeDigits[i];
                            for (int j = 0; j < binaryDigit.size(); j++) {
                                ImageView imageView = new ImageView();
                                if (isBinaryOne(binaryDigit, j)) {
                                    imageView.setImage(get("1.png"));
                                } else {
                                    imageView.setImage(get("0.png"));
                                }
                                grid.add(imageView, i, 3 - j);
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    if (displayNormalClock) normalClock.setText(getTime());
                });
            }
        };
    }

    private boolean isBinaryOne(List binaryDigit, int j) {
        return binaryDigit.get(j).equals(true);
    }

    private EventHandler<WindowEvent> getCloseOperation() {
        return e -> {
            Platform.exit();
            System.exit(0);
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}
