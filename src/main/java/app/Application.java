package app;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import static javafx.application.Platform.exit;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Binary Time");
        ClocksUICreator clocksUICreator = new ClocksUICreator();
        primaryStage.setScene(new Scene(clocksUICreator.getGrid(), 400, 400));
        primaryStage.setOnCloseRequest(getCloseOperation());
        primaryStage.show();
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
