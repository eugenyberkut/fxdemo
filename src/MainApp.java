/**
 * Created by eugeny on 09.09.2015.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane rootPane = new GridPane();
        Canvas canvas = new Canvas(500,500);
        Button drawBorderButton = new Button("Draw");
        drawBorderButton.setOnAction(e -> drawBorder(canvas));
        Button drawLinesButton = new Button("Graphic");
        drawLinesButton.setOnAction(e -> drawGraphic(canvas));
        Button exitButton = new Button("Exit");
        ToolBar toolBar = new ToolBar(drawBorderButton, drawLinesButton, exitButton);
        toolBar.setMinHeight(50);
        GridPane.setConstraints(canvas, 0, 1);
        GridPane.setConstraints(toolBar, 0, 0);
        rootPane.getChildren().addAll(toolBar, canvas);
        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawBorder(Canvas canvas) {
        double width = canvas.getWidth();
        double height = canvas.getHeight();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.strokeRect(10,10,width-20,height-20);
    }

    private void drawGraphic(Canvas canvas) {
        double width = canvas.getWidth();
        double height = canvas.getHeight();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.strokeLine(10,10,width-10,height-10);
    }
}
