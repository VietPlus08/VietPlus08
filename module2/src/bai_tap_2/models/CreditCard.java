package bai_tap_2.models;

import java.util.List;

public class CreditCard extends Card{
    private long balance, max_money;

    public CreditCard(String id, String code, String name, String idPerson, long balance, long max_money) {
        super(id, code, name, idPerson);
        this.balance = balance;
        this.max_money = max_money;
    }

    public CreditCard(String id, List<String> data) {
        super(id, data.get(0), data.get(1), data.get(2));
        balance = Long.parseLong(data.get(3));
        max_money = Long.parseLong(data.get(4));
    }

    public CreditCard(List<String> data) {
        super(data.get(0), data.get(1), data.get(2),data.get(3));
        balance = Long.parseLong(data.get(4));
        max_money = Long.parseLong(data.get(5));
    }

    public long getBalance() {
        return balance;
    }

    public long getMax_money() {
        return max_money;
    }

    public static String getInfo(){
        return "CODE,NAME,ID_PERSON,BALANCE,MAX_MONEY";
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id='" + super.getId() + '\'' +
                ", code='" + super.getCode() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", idPerson='" + super.getIdPerson() + '\'' +
                ", balance=" + balance +
                ", max_money=" + max_money +
                '}';
    }

    @Override
    public String toStringFile() {
        return super.getId() + "," +
                super.getCode() + "," +
                super.getName() + "," +
                super.getIdPerson() + "," +
                balance + "," +
                max_money;
    }
}
