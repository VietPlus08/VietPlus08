package ss7.ex1;

public class Test {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];

        int count = 0;
        for (Circle circle : circles) {
            circle = new Circle((double) Math.round(Math.random() * 100) / 100);
            System.out.println("Circle[" + count + "]: " + circle.toString());
            circle.resize((double) Math.round(Math.random() * 100) / 100);
            count++;
        }
        System.out.println("-------------------------------");
        Rectangle[] rectangles = new Rectangle[3];
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new Rectangle((double) Math.round(Math.random() * 100) / 100,
                    (double) Math.round(Math.random() * 100) / 100);
            System.out.println("Rectangle[" + i + "]: " + rectangles[i].toString());
            rectangles[i].resize((double) Math.round(Math.random() * 100) / 100);
        }
    }
}
