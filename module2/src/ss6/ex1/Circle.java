package ss6.ex1;


public class Circle {
    float radius;
    String color;

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Circle(float radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public float getPerimeter(){
        return (float) (Math.PI * radius * radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
