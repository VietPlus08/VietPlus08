package bai_tap_2.controllers;

import bai_tap_2.models.ATM;
import bai_tap_2.models.Card;
import bai_tap_2.utils.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class ATMController implements IController<ATM>{
    private static final String CARD = "ATM";
    private static List<ATM> repo = ReadWriteFile.readFromFile(CARD);
    private static int id = 1;
//    static {
//        repo.add(new ATM("1","111","Quang","101212121212",0));
//        ReadWriteFile.writeATMToFile(new ATM("1","111","Quang","101212121212",0));
//    }

    @Override
    public void add(List<String> data) {
//        repo.add(new ATM(String.valueOf(id++), data));
        ReadWriteFile.writeATMToFile(new ATM(String.valueOf(id++), data));
    }

    @Override
    public boolean remove(String code) {
        ATM a = findByCode(code);
        if (a != null){
            repo.remove(a);
            return true;
        }
        return false;
    }

    @Override
    public List<ATM> findAll() {
        return repo;
    }

    @Override
    public List<ATM> findByNameOrCode(String data) {
        return null;
    }

    @Override
    public ATM findByCode(String code) {
        return repo.stream().filter(i -> i.getCode().contains(code)).findFirst().orElse(null);
    }
}
