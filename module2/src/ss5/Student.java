package ss5;

public class Student {
    private String name = "John";
    private String className = "A0922I1";

    public Student() {
    }

    public Student(String name, String className) {
        this.name = name;
        this.className = className;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
class TestStudent{
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Quang");
        student.setClassName("B1");
        System.out.println(student);
    }
}
