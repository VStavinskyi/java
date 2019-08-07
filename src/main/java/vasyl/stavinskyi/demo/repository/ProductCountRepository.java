package vasyl.stavinskyi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vasyl.stavinskyi.demo.entity.ProductCount;

@Repository
public interface ProductCountRepository extends JpaRepository<ProductCount, Long> { }
