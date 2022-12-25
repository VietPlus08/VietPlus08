package ss6.ex3;

import ss6.ex2.Point2D;
import ss6.ex2.Point3D;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Point point1 = new Point();
        Point point2 = new Point(5, 10);

        MovablePoint point3 = new MovablePoint();
        MovablePoint point4 = new MovablePoint(1,1);
        MovablePoint point5 = new MovablePoint(8,8,2,2);

        System.out.println("Point 1: " + point1);
        System.out.println("Point 2: " + point2);
        System.out.println("Point 3: " + point3);
        System.out.println("Point 4: " + point4);
        System.out.println("Point 5: " + point5);

        System.out.println("After change value X, Y");
        point1.setXY(1,2);
        System.out.println("Point 1: " + point1);
        point4.setXY(1,2);
        point4.setSpeed(5,5);
        System.out.println("Point 4: " + point4);

    }
}
