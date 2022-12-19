package ss5;

public class Circle {
    private double radius = 1.0f;
    private String color = "red";

    public String getColor() {
        return color;
    }

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }
}
class TestCircle{
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.printf("Area: %.1f", circle.getArea());
    }
}
