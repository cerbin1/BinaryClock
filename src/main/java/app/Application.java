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

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static app.ImageLoader.get;
import static app.Time.getTime;
import static javafx.geometry.Pos.CENTER;
import static javafx.scene.layout.GridPane.setHalignment;

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

        setNormalClockLabel(grid);

        setNormalClockToggleButton(grid);

        primaryStage.setScene(new Scene(grid, 400, 400));
        primaryStage.setOnCloseRequest(getCloseOperation());
        primaryStage.show();
    }

    private void setNormalClockLabel(GridPane grid) {
        grid.add(normalClock, 0, 4, 6, 1);
        setHalignment(normalClock, HPos.CENTER);
        normalClock.setFont(new Font(60));
    }

    private void setNormalClockToggleButton(GridPane grid) {
        normalClockToggle.setText("Hide");
        grid.add(normalClockToggle, 0, 5, 6, 1);
        normalClockToggle.setFont(new Font(13));
        setHalignment(normalClockToggle, HPos.CENTER);
        normalClockToggle.setOnAction(getEventHandlerForDisplayClockButton());
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
                    List<List<Boolean>> timeDigits = binaryClock.getTime();
                    for (int i = 0; i < timeDigits.size(); i++) {
                        List<Boolean> binaryDigit = timeDigits.get(i);
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

                    if (displayNormalClock) normalClock.setText(getTime());
                });
            }
        };
    }

    private boolean isBinaryOne(List<Boolean> binaryDigit, int j) {
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
