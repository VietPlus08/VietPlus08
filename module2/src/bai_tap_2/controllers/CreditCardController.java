package bai_tap_2.controllers;

import bai_tap_2.models.CreditCard;
import bai_tap_2.utils.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CreditCardController implements IController<CreditCard>{
    private static final String CARD = "CREDIT_CARD";
    private static List<CreditCard> repo = ReadWriteFile.readFromFile(CARD);
    private static int id = 1;
//    static {
//        repo.add(new CreditCard("1","111","Quang","101212121212",1000000L,2000000L));
//        ReadWriteFile.writeCreditCardToFile(new CreditCard("1","111","Quang","101212121212",1000000L,2000000L));
//    }

    @Override
    public void add(List<String> data) {
//        repo.add(new CreditCard(String.valueOf(id++), data));
        ReadWriteFile.writeCreditCardToFile(new CreditCard(String.valueOf(id++), data));
    }

    @Override
    public boolean remove(String code) {
        CreditCard a = findByCode(code);
        if (a != null){
            repo.remove(a);
            return true;
        }
        return false;
    }

    @Override
    public List<CreditCard> findAll() {
        return repo;
    }

    @Override
    public List<CreditCard> findByNameOrCode(String data) {
        return null;
    }

    @Override
    public CreditCard findByCode(String code) {
        return repo.stream().filter(i -> i.getCode().contains(code)).findFirst().orElse(null);
    }
}
