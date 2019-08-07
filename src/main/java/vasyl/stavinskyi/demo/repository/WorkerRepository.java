package vasyl.stavinskyi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vasyl.stavinskyi.demo.entity.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> { }