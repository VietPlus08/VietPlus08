package bai_tap_1.controllers;

import bai_tap_1.models.ExportProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ExProController implements IController<ExportProduct> {
    private static List<ExportProduct> repo = new ArrayList<>();
    private static int idCount = 2;

    static {
        repo.add(new ExportProduct("1", "EX0001", "Laptop", 100, 10, "Vietteo", 110, "China"));
        repo.add(new ExportProduct("2", "EX0001", "Laptop2", 110, 10, "Vietteo", 110, "China"));
    }

    @Override
    public void add(List<String> data) {
        repo.add(new ExportProduct(String.valueOf(++idCount), data));
    }

    @Override
    public boolean remove(String id) {
        ExportProduct exportProduct = repo.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
        if (exportProduct != null) {
            repo.remove(exportProduct);
            return true;
        }
        return false;
    }

    @Override
    public List<ExportProduct> findAll() {
        return repo;
    }

    @Override
    public List<ExportProduct> findById(String id) {
        List<ExportProduct> result = repo.stream().filter(i -> i.getId().contains(id)).collect(Collectors.toList());
        result.addAll(repo.stream().filter(i -> i.getName().contains(id)).collect(Collectors.toList()));
        return result;
    }
}
