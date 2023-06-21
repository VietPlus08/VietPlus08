package codegym.vn.repo;

import codegym.vn.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByNameContaining(String name);

    @Query(value = "select p from Product p where p.price between :min and :max")
    List<Product> findAllByPrice(@Param("min") double min,@Param("max") double max);
}
