package utils;

import entity.Customer;

import java.util.HashMap;
import java.util.Map;

public class Valid {
    public static Map<String,String> getValidation(Customer customer){
        Map<String,String> error = new HashMap<>();
        if (customer.getId() <= 0){
            error.put("id","Must be number");
        }
        if (!customer.getName().matches("([A-Z][a-z]+[\\s]*)+")){
            error.put("name","Must be characters, the firt character in letters must be upper");
        }
        if (!customer.getAge().matches("[1-9][0-9]")){
            error.put("age","Must be number");
        }
        if (!customer.getPoint().matches("[1-9][0-9]")){
            error.put("point", "Must be number");
        }
        return error;
    }
}
