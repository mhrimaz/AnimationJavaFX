/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationjavafx;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author hossein
 */
public class AnimationJavaFX1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Circle circle = new Circle(200, 200, 10);
        AnimationTimer animationTimer = new AnimationTimer() {
            private long lastTime;
            private int step = 1;

            @Override
            public void handle(long now) {
                if (now - lastTime > 10_000_000) {
                    lastTime = now;
                } else {
                    return;
                }
                if (circle.getRadius() > 200 || circle.getRadius() < 0) {
                    step *= -1;
                }
                circle.setRadius(circle.getRadius() + step);
            }
        };
        AnimationTimer colorChenger = new AnimationTimer() {
            private long lastTime;
            int red=10, green=10, blue=60;
            int direction=1;
            @Override
            public void handle(long now) {
                if (now - lastTime > 1_000_000) {
                    lastTime = now;
                } else {
                    return;
                }
                
                circle.setFill(Color.rgb(red,green,blue));
                if(red>254||red<1){
                    direction*=-1;
                    blue+=2;
                    green+=10;
                }
                red+=direction;
            }
        };
        
        root.getChildren().add(circle);
        colorChenger.start();
        Scene scene = new Scene(root, 400, 400);
        animationTimer.start();
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
