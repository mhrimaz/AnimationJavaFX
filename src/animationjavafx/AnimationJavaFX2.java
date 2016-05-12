/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationjavafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author hossein
 */
public class AnimationJavaFX2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        MyCircle[] circle = new MyCircle[10];
        for(int i=0;i<circle.length;i++){
            circle[i]=new MyCircle((int) (Math.random()*500+50), (int) (Math.random()*500+50), (int) (Math.random()*40+10), 1);
        }
        
        AnimationTimer animationTimer = new AnimationTimer() {
            private long lastTime;
            @Override
            public void handle(long now) {
                if (now - lastTime > 30_000_000) {
                    lastTime = now;
                } else {
                    return;
                }
                root.getChildren().clear();
                for(int i=0;i<circle.length;i++){
                    root.getChildren().add(circle[i].getNextCircle());
                }
            }
        };
        
        
        Scene scene = new Scene(root, 600, 600);
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
