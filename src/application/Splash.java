/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import static java.lang.StrictMath.random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Kent
 */
public class Splash extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        primaryStage.setScene(scene);

        Group circles = new Group();
        for (int i = 0; i < 30; i++) {
            Circle circle = new Circle(150, Color.web("white", 0.05));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 0.16));
            circle.setStrokeWidth(4);
            circles.getChildren().add(circle);
        }
        Image i = new Image(getClass().getResource("/view/leatherlarge.jpg").toExternalForm(), false);
        ImagePattern ip = new ImagePattern(i);
        Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight());
        colors.setFill(ip);
        // Stuff for gradient Bubbles
//                new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
//                        Stop[]{
//                    new Stop(0, Color.web("f8bd55")),
//                    new Stop(0.14, Color.web("#c0fe56")),
//                    new Stop(0.28, Color.web("#5dfbc1")),
//                    new Stop(0.43, Color.web("#64c2f8")),
//                    new Stop(0.57, Color.web("#be4af7")),
//                    new Stop(0.71, Color.web("#ed5fc2")),
//                    new Stop(0.85, Color.web("#ef504c")),
//                    new Stop(1, Color.web("#f2660f")),}));
        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());
        Group blendModeGroup =
                new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(),
                    Color.BLACK), circles), colors);
        colors.setBlendMode(BlendMode.OVERLAY);
        root.getChildren().add(blendModeGroup);
        circles.setEffect(new BoxBlur(10, 10, 3));
        Timeline timeline = new Timeline();
        for(Node circle: circles.getChildren()) {
            timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, //set start pos at 0
                    new KeyValue(circle.translateXProperty(), random() * 800),
                    new KeyValue(circle.translateYProperty(), random() * 600)),
                new KeyFrame(new Duration(10000), //set end pos at 10s
                    new KeyValue(circle.translateXProperty(), random() * 800),
                    new KeyValue(circle.translateYProperty(), random() * 600)));
        }
        //play 10s of animation
        timeline.play();
        timeline.setOnFinished(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0){
                try {
                    primaryStage.close();
                    Stage stage = new Stage();
                    Login login = new Login();
                    
                    login.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        primaryStage.show();
    }

    private void showLoginWindow() {
        Stage stage = new Stage();
        Login login = new Login();
        try {
            login.start(stage);
        } catch (Exception ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
