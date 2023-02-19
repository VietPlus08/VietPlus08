package ss16.ex2;

import java.util.List;

public class Nation {
    String no, id, name;

    public Nation(String no, String id, String name) {
        this.no = no;
        this.id = id;
        this.name = name;
    }

    public Nation(String[] data){
        no = data[0];
        id = data[1];
        name = data[2];
    }

    @Override
    public String toString() {
        return "Nation{" +
                "no='" + no + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
