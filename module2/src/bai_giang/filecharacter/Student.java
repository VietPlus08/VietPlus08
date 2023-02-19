package bai_giang.filecharacter;

public class Student implements Comparable<Student> {
    public int id;
    public String name;
    public float mark;

    public Student() {
    }

    public Student(int id, String name, float mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public Student(String[] data) {
        this.id = Integer.parseInt(data[0]);
        this.name = data[1];
        this.mark = Float.parseFloat(data[2]);
    }

    @Override
    public int compareTo(Student o) {
        return o.id - this.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }

    public String toStringFile() {
        return id + "," + name + "," + mark;
    }
}
