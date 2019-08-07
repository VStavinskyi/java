package vasyl.stavinskyi.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import vasyl.stavinskyi.demo.entity.Worker;

@Getter
@Setter
public class WorkerResponse {
    private Long id;
    private String name;
    private String surname;

    public WorkerResponse(Worker worker) {
        id = worker.getId();
        name = worker.getName();
        surname = worker.getSurname();
    }
}
