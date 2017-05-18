import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    private Time time;

    public Application() {
        time = new Time();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hi");
        Button button = new Button();
        button.setText("Witaj towarzyszu");
        button.setOnAction(event -> time.displayTime());

        StackPane root = new StackPane();
        root.getChildren().add(button);
        primaryStage.setScene(new Scene(root, 200, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
