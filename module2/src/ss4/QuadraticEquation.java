package ss4;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class QuadraticEquation {
    private float a;
    private float b;
    private float c;

    public QuadraticEquation(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(float a) {
        this.a = a;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void setC(float c) {
        this.c = c;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    float getDiscriminant() {
        return b * b - 4 * a * c;
    }

    double getRoot1() {
        return ((-b) + Math.pow(getDiscriminant(), 0.5)) / (2 * a);
    }

    double getRoot2() {
        return ((-b) - Math.pow(getDiscriminant(), 0.5)) / (2 * a);
    }

    String result() {
        return getDiscriminant() >= 0 ? "Root1 = " + getRoot1() + "; Root2 = " + getRoot2() : "No root";
    }

    public static void main(String[] args) {
        float a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.print("input a: ");
        a = Float.parseFloat(sc.nextLine());
        System.out.print("input b: ");
        b = Float.parseFloat(sc.nextLine());
        System.out.print("input c: ");
        c = Float.parseFloat(sc.nextLine());
        QuadraticEquation quad = new QuadraticEquation(a, b, c);
        System.out.println(quad.result());
    }
}