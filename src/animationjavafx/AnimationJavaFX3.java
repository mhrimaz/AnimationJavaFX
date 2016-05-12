/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationjavafx;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author hossein
 */
public class AnimationJavaFX3 extends Application{
    
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        
        for (int i = 0; i < 180; i += 10) {
            Rectangle a = new Rectangle(450, 450);
            a.setRotate(i);
            a.setFill(Color.rgb(i + 70, i + 20, i + 60));
            RotateTransition transition = new RotateTransition(Duration.seconds(10), a);
            transition.setFromAngle(i);
            transition.setToAngle(360);
            transition.setCycleCount(100);
            transition.setAutoReverse(true);
            transition.play();
            root.getChildren().add(a);
        }
        Image image=new Image("Java_logo.png");
        ImageView imageView=new ImageView(image);
        root.getChildren().add(imageView);
        Scene scene = new Scene(root, 680, 680);

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
