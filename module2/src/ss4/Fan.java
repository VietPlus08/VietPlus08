package ss4;


public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5.0f;
    private String color = "blue";

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.on ?
                "Fan is on {" +
                        "speed=" + speed +
                        ", radius=" + radius +
                        ", color='" + color + '\'' +
                        '}' :
                "Fan is off {" +
                        "radius=" + radius +
                        ", color='" + color + '\'' +
                        '}';
    }
}
class test{
    public static void main(String[] args) {
        System.out.println(new Fan(3,true,10.0f,"yellow"));
        System.out.println(new Fan(2,false,5.0f,"blue"));
    }
}
