/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationjavafx;

import javafx.scene.shape.Circle;

/**
 *
 * @author hossein
 */
public class MyCircle {

    private int x, y;
    private double radious;
    private int step;

    public MyCircle(int x, int y, double radious, int step) {
        this.x = x;
        this.y = y;
        this.radious = radious;
        this.step = step;
    }

    public Circle getNextCircle() {
        if (radious+step > 60 || radious+step < 10) {
            step *= -1;
        }
        radious+=step;
        return new Circle(x, y, radious);
    }

}
