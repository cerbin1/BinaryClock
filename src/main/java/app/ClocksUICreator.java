package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static app.ImageLoader.get;
import static app.Time.getTime;
import static javafx.application.Platform.runLater;
import static javafx.geometry.Pos.CENTER;
import static javafx.scene.layout.GridPane.setHalignment;

public class ClocksUICreator {
    private final BinaryClock binaryClock = new BinaryClock();
    private final Label normalClock = new Label();
    private final Button normalClockToggle = new Button();

    private boolean displayNormalClock = true;
    private GridPane grid;

    public ClocksUICreator() {
        grid = createGrid();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(displayBinaryClock(), 0, 1000);

        setNormalClockLabel();

        setNormalClockToggleButton();
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        return grid;
    }

    private void setNormalClockLabel() {
        grid.add(normalClock, 0, 4, 6, 1);
        setHalignment(normalClock, HPos.CENTER);
        normalClock.setFont(new Font(60));
    }

    private void setNormalClockToggleButton() {
        normalClockToggle.setText("Hide");
        grid.add(normalClockToggle, 0, 5, 6, 1);
        normalClockToggle.setFont(new Font(13));
        setHalignment(normalClockToggle, HPos.CENTER);
        normalClockToggle.setOnAction(getEventHandlerForDisplayClockButton());
    }

    private EventHandler<ActionEvent> getEventHandlerForDisplayClockButton() {
        return event -> {
            normalClockToggle.setText((displayNormalClock ? "Display" : "Hide"));
            displayNormalClock = !displayNormalClock;
            normalClock.setText((displayNormalClock ? getTime() : ""));
        };
    }

    private TimerTask displayBinaryClock() {
        return new TimerTask() {
            @Override
            public void run() {
                runLater(() -> {
                    createBinaryClock();

                    if (displayNormalClock) {
                        normalClock.setText(getTime());
                    }
                });
            }

            private void createBinaryClock() {
                List<List<Boolean>> timeDigits = binaryClock.getTime();
                for (int col = 0; col < timeDigits.size(); col++) {
                    List<Boolean> binaryDigit = timeDigits.get(col);
                    for (int row = 0; row < binaryDigit.size(); row++) {
                        ImageView imageView = new ImageView();
                        imageView.setImage(isBinaryOne(binaryDigit, row) ? get("1.png") : get("0.png"));
                        grid.add(imageView, col, 3 - row);
                    }
                }
            }

            private boolean isBinaryOne(List<Boolean> binaryDigit, int index) {
                return binaryDigit.get(index).equals(true);
            }
        };
    }

    public GridPane getGrid() {
        return grid;
    }
}
