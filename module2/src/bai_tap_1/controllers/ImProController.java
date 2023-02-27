package bai_tap_1.controllers;

import bai_tap_1.models.ExportProduct;
import bai_tap_1.models.ImportProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImProController implements IController<ImportProduct> {
    private static List<ImportProduct> repo = new ArrayList<>();
    private static int idCount = 2;

    @Override
    public void add(List<String> data) {
        repo.add(new ImportProduct(String.valueOf(++idCount), data));
    }

    @Override
    public boolean remove(String id) {
        ImportProduct importProduct = repo.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
        if (importProduct != null) {
            repo.remove(importProduct);
            return true;
        }
        return false;
    }

    public List<ImportProduct> findAll() {
        return repo;
    }

    @Override
    public List<ImportProduct> findById(String id) {
        List<ImportProduct> result = repo.stream().filter(i -> i.getId().contains(id)).collect(Collectors.toList());
        result.addAll(repo.stream().filter(i -> i.getName().contains(id)).collect(Collectors.toList()));
        return result;
    }
}
