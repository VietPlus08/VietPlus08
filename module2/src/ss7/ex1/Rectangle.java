package ss7.ex1;

public class Rectangle implements Resizeable {
    private double height = 1.0f;
    private double width = 1.0f;
    private double size = 1.0f;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getSize() {
        return size;
    }

    public void setHeight() {
        this.height = this.height * this.getSize();
    }

    public void setWidth() {
        this.width = this.width * this.getSize();
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                ", size=" + size +
                '}';
    }

    @Override
    public void resize(double percent) {
        setSize(percent);
        setHeight();
        setWidth();
        System.out.println("After resize: " + toString());
    }

}
