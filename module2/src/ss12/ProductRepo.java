package ss12;

import ss12.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductRepo {
    private static final List<Product> list = new ArrayList<>();

    static {
        list.add(new Product(1, "Iphone X", 50, 1000));
        list.add(new Product(2, "Iphone 6", 50, 500));
        list.add(new Product(3, "Iphone 12", 50, 1200));
        list.add(new Product(4, "Iphone 5", 50, 300));
    }

    public void add(Product product){
        list.add(product);
    }

    public void findAll() {
        list.forEach(System.out::println);
    }

    public void findByName(String name){
        list.stream().filter(i -> i.getName().contains(name)).forEach(System.out::println);
    }

    public Product getById(int id){
        return list.stream().filter(i -> id == i.getId()).findFirst().orElse(null);
    }

    public boolean removeById(int id){
        Product product = getById(id);
        if (product!= null){
            list.remove(product);
            return true;
        }
        return false;
    }

    public void findAllSortByPriceIncrease() {
        list.sort(((o1, o2) -> {
            return o1.getPrice() - o2.getPrice();
        }));
        list.forEach(System.out::println);
    }

    public void findAllSortByPriceDecrease() {
        list.sort(((o1, o2) -> {
            return o2.getPrice() - o1.getPrice();
        }));
        list.forEach(System.out::println);
    }
}
