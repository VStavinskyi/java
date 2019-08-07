package vasyl.stavinskyi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vasyl.stavinskyi.demo.dto.request.WorkerRequest;
import vasyl.stavinskyi.demo.dto.response.WorkerResponse;
import vasyl.stavinskyi.demo.service.WorkerService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @PostMapping
    public void create(@RequestBody WorkerRequest request) {
        workerService.create(request);
    }

    @GetMapping
    public List<WorkerResponse> findAll() {
        return workerService.findAll();
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody WorkerRequest request) throws IOException {workerService.update(id, request); }

    @DeleteMapping
    public void delete(Long id) {
        workerService.delete(id);
    }

}