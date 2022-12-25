package ss6.ex1;

import javax.swing.*;
import java.awt.*;

public class Cylinder extends Circle {
    float height;

    public Cylinder(float radius, String color, float height) {
        super(radius, color);
        this.height = height;
    }

    public Cylinder(float radius, String color) {
        super(radius, color);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", height=" + height +
                '}';
    }

    public float getVolume(){
        return super.getPerimeter() * height;
    }
}
