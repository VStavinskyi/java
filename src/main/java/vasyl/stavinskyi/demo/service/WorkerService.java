package vasyl.stavinskyi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vasyl.stavinskyi.demo.dto.request.WorkerRequest;
import vasyl.stavinskyi.demo.dto.response.WorkerResponse;
import vasyl.stavinskyi.demo.entity.Worker;
import vasyl.stavinskyi.demo.repository.WorkerRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public void create(WorkerRequest request) {
        workerRepository.save(workerRequestToWorker(null, request));
    }

    public List<WorkerResponse> findAll() {

        return workerRepository.findAll().stream()
                .map(WorkerResponse::new)
                .collect(Collectors.toList());

    }

    public void update(Long id, WorkerRequest request) {
      workerRepository.save(workerRequestToWorker(findOne(id), request));
    }

    public void delete(Long id) {
        Worker worker = findOne(id);
        workerRepository.delete(worker);
    }

    public Worker findOne(Long id) {
        return workerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Worker with id " + id + " not exists"));
    }

    private Worker workerRequestToWorker(Worker worker, WorkerRequest request) {
        if (worker == null) {
            worker = new Worker();
        }
        worker.setName(request.getName());
        worker.setSurname(request.getSurname());
        return worker;
    }

}
