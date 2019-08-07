package vasyl.stavinskyi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vasyl.stavinskyi.demo.dto.request.PaginationRequest;
import vasyl.stavinskyi.demo.dto.request.PlaceCriteria;
import vasyl.stavinskyi.demo.dto.request.PlaceRequest;
import vasyl.stavinskyi.demo.dto.response.PageResponse;
import vasyl.stavinskyi.demo.dto.response.PlaceResponse;
import vasyl.stavinskyi.demo.service.PlaceService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping
    public void create(@RequestBody PlaceRequest request) {
        placeService.create(request);
    }

    @PostMapping("/findByFilter")
    public PageResponse<PlaceResponse> findByFilter(@RequestBody PlaceCriteria productCriteria) {
        return placeService.findAllByCriteria(productCriteria);
    }

    @GetMapping
    public PageResponse<PlaceResponse> findPage(@Valid PaginationRequest paginationRequest) {
        return placeService.findPage(paginationRequest);
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody PlaceRequest request) throws IOException {placeService.update(id, request); }

    @DeleteMapping
    public void delete(Long id) {
        placeService.delete(id);
    }

}
