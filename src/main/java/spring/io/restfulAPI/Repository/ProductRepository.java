package spring.io.restfulAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.io.restfulAPI.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
