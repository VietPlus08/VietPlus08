package ss6.ex2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Point2D point1 = new Point2D();
        Point2D point2 = new Point2D(5.0f, 4.0f);
        Point2D point3 = new Point3D();
        Point2D point4 = new Point3D(5.0f, 4.0f, 3.0f);

        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
        System.out.println(point4);

        point1.setXY(1,2);
        System.out.println(Arrays.toString(point1.getXY()));
    }
}
