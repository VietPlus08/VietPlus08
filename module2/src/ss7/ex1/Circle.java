package ss7.ex1;

public class Circle implements Resizeable {
    private double radius = 1.0f;
    private double size = 1.0f;
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

    public void setRadius() {
        this.radius = this.radius * this.getSize();
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", size=" + size +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void resize(double percent) {
        setSize(percent);
        setRadius();
        System.out.println("After resize: " + toString());
    }
}
