package entity;

public class Customer {
    int id;
    String name;
    String age;
    String point;
    String img;

    public Customer(int id, String name, String age, String point, String img) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.point = point;
        this.img = img;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
