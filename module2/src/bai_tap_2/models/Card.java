package bai_tap_2.models;

public abstract class Card {
    private String id, code, name, idPerson;

    public Card(String id, String code, String name, String idPerson) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.idPerson = idPerson;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getIdPerson() {
        return idPerson;
    }

    @Override
    public abstract String toString();

    public abstract String toStringFile();
}
