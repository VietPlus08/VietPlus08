package service;

import entity.Customer;
import repo.CustomerRepoImpl;
import repo.IRepo;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements IService<Customer> {

    private IRepo<Customer> service = new CustomerRepoImpl();

    @Override
    public List<Customer> findAll(String index) {
        return service.findAll(index);
    }

    @Override
    public boolean save(Customer customer) {
        Customer findCustomer = findById(customer.getId());

        if (findCustomer!= null){
            update(customer);
            return true;
        }
        service.save(customer);
        return false;
    }

    @Override
    public Customer findById(int id) {
        return service.findById(id);
    }

    @Override
    public boolean delete(int id) {
        return service.delete(id);
    }

    @Override
    public List<Customer> findByIdOrName(String id, String name, String index) {
        List<Customer> list = service.findByIdOrName(id, name, index);
        if (list.isEmpty()){
            return new ArrayList<Customer>();
        }
        return list;
    }

    @Override
    public boolean update(Customer customer) {
        return service.update(customer);
    }

    @Override
    public int pages() {
        double countItems = service.countItem();
        return (int) Math.ceil (countItems/5);
    }
}
