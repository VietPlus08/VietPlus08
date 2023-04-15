package repo;

import entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerRepoImpl implements IRepo<Customer>{

    private static List<Customer> list;
    static {
        list = new ArrayList<>();
        list.add(new Customer(1,"Nguyen Huy Hoang","24","99","img\\cho.jpg"));
        list.add(new Customer(2,"Nguyen Quang Sang","24","19","img\\meo.jpg"));
        list.add(new Customer(3,"Nguyen Huy Ho","24","29",""));
        list.add(new Customer(4,"Nguyen Huy ngoc","24","59",""));
        list.add(new Customer(5,"Nguyen Huy Minh","24","79",""));
    }

    @Override
    public List<Customer> findAll() {
        return list;
    }

    @Override
    public void save(Customer customer) {
        list.add(customer);
    }

    @Override
    public List<Customer> findByIdOrName(String searchName) {
        return list.stream().filter(i-> String.valueOf(i.getId()).contains(searchName)  ||
                i.getName().toLowerCase().contains(searchName.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public Customer findById(int id) {
        return list.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void delete(int id) {
        Customer customer = findById(id);
        if (customer != null){
            list.remove(findById(id));
        }
    }

}
