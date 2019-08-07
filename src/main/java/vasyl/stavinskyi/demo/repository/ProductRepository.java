package vasyl.stavinskyi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vasyl.stavinskyi.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { }