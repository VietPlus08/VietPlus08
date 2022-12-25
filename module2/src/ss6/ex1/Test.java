package ss6.ex1;

public class Test {
    public static void main(String[] args) {
        Circle c1 = new Circle(10.0f, "black");
        Circle c2 = new Cylinder(10.0f, "black",5.0f);
        Circle c3 = new Cylinder(10.0f, "pink");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}
