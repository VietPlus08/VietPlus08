package service;

import entity.Customer;
import repo.CustomerRepoImpl;
import repo.IRepo;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements IService<Customer> {

    private IRepo<Customer> service = new CustomerRepoImpl();

    @Override
    public List<Customer> findAll() {
        return service.findAll();
    }

    @Override
    public void save(Customer customer) {
        int customerId = customer.getId();
        if (service.findById(customerId) == null){
            service.save(customer);
            return;
        }
        service.delete(customerId);
        service.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return service.findById(id);
    }

    @Override
    public void delete(int id) {
        service.delete(id);
    }

    @Override
    public List<Customer> findByIdOrName(String searchName) {
        List<Customer> list = service.findByIdOrName(searchName);
        if (list.isEmpty()){
            return new ArrayList<Customer>();
        }
        return list;
    }
}
