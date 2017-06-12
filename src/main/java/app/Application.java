package app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.List;
import java.util.TimerTask;

import static app.ImageLoader.get;
import static app.Time.getTime;
import static javafx.application.Platform.exit;
import static javafx.application.Platform.runLater;
import static javafx.geometry.Pos.CENTER;
import static javafx.scene.layout.GridPane.setHalignment;

public class Application extends javafx.application.Application {
    private final BinaryClock binaryClock = new BinaryClock();
    private final Label normalClock = new Label();
    private final Button normalClockToggle = new Button();

    private boolean displayNormalClock = true;

    private Canvas canvas;


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Binary Time");

        /*GridPane grid = createGrid();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(displayBinaryClock(grid), 0, 1000);

        setNormalClockLabel(grid);

        setNormalClockToggleButton(grid);*/
//        grid.add(canvas, 6, 0);
        // dodac do grida  OBRAZEK ktory wczesnieij aktualizuje
        /*primaryStage.setScene(new Scene(grid, 400, 400));
        primaryStage.setOnCloseRequest(getCloseOperation());
        primaryStage.show();*/
        Group root = new Group();
        root.getChildren().add(normalClock);
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
//        drawAnalogClock(gc);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        return grid;
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

    private TimerTask displayBinaryClock(GridPane grid) {
        return new TimerTask() {
            @Override
            public void run() {
                runLater(() -> {
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

                    canvas = new Canvas(400, 400);
                    GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
//                    drawAnalogClock(graphicsContext);


                    // rysowanie w canvasie javafx

                    if (displayNormalClock) normalClock.setText(getTime());
                });
            }
        };
    }

    private void drawAnalogClock(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.GREEN);
        graphicsContext.setStroke(Color.BLUE);
        graphicsContext.setLineWidth(5);
        graphicsContext.strokeLine(40, 10, 10, 40);
        graphicsContext.fillOval(10, 60, 30, 30);
        graphicsContext.strokeOval(60, 60, 30, 30);
        graphicsContext.fillRoundRect(110, 60, 30, 30, 10, 10);
        graphicsContext.strokeRoundRect(160, 60, 30, 30, 10, 10);
        graphicsContext.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        graphicsContext.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        graphicsContext.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        graphicsContext.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        graphicsContext.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        graphicsContext.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        graphicsContext.fillPolygon(new double[]{10, 40, 10, 40}, new double[]{210, 210, 240, 240}, 4);
        graphicsContext.strokePolygon(new double[]{60, 90, 60, 90}, new double[]{210, 210, 240, 240}, 4);
        graphicsContext.strokePolyline(new double[]{110, 140, 110, 140}, new double[]{210, 210, 240, 240}, 4);
    }

    private boolean isBinaryOne(List<Boolean> binaryDigit, int j) {
        return binaryDigit.get(j).equals(true);
    }

    private EventHandler<WindowEvent> getCloseOperation() {
        return event -> {
            exit();
            System.exit(0);
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}
