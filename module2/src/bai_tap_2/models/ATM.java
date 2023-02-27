package bai_tap_2.models;

import java.util.List;

public class ATM extends Card{
    private long balance;

    public ATM(String id, String code, String name, String idPerson, long balance) {
        super(id, code, name, idPerson);
        this.balance = balance;
    }

    public ATM(String id, List<String> data) {
        super(id, data.get(0), data.get(1), data.get(2));
        balance = Long.parseLong(data.get(3));
    }
    public ATM(List<String> data) {
        super(data.get(0), data.get(1), data.get(2),data.get(3));
        balance = Long.parseLong(data.get(4));
    }

    public long getBalance() {
        return balance;
    }

    public static String getInfo(){
        return "CODE,NAME,ID_PERSON,BALANCE";
    }

    @Override
    public String toString() {
        return "ATM{" +
                "id='" + super.getId() + '\'' +
                ", code='" + super.getCode() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", idPerson='" + super.getIdPerson() + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public String toStringFile() {
        return super.getId() + "," +
                super.getCode() + "," +
                super.getName() + "," +
                super.getIdPerson() + "," +
                balance;
    }
}
