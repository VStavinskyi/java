package vasyl.stavinskyi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import vasyl.stavinskyi.demo.dto.request.PaginationRequest;
import vasyl.stavinskyi.demo.dto.request.PlaceCriteria;
import vasyl.stavinskyi.demo.dto.request.PlaceRequest;
import vasyl.stavinskyi.demo.dto.response.PageResponse;
import vasyl.stavinskyi.demo.dto.response.PlaceResponse;
import vasyl.stavinskyi.demo.entity.Place;
import vasyl.stavinskyi.demo.repository.PlaceRepository;
import vasyl.stavinskyi.demo.specification.PlaceSpecification;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private RestaurantService restaurantService;

    public void create(PlaceRequest request) {
        placeRepository.save(placeRequestToPlace(null, request));
    }

    public List<PlaceResponse> findAll() {

        return placeRepository.findAll().stream()
                .map(PlaceResponse::new)
                .collect(Collectors.toList());

    }

    public PageResponse<PlaceResponse> findPage(PaginationRequest paginationRequest) {
        Page<Place> page = placeRepository.findAll(paginationRequest.toPageable());
        return new PageResponse<>(page.getTotalPages(),
                page.getTotalElements(),
                page.get().map(PlaceResponse::new).collect(Collectors.toList()));
    }

    public PageResponse<PlaceResponse> findAllByCriteria(PlaceCriteria criteria) {
        Page<Place> page = placeRepository.findAll(
                new PlaceSpecification(criteria), criteria.getPaginationRequest().toPageable());
        return new PageResponse<>(page.getTotalPages(),
                page.getTotalElements(),
                page.get().map(PlaceResponse::new).collect(Collectors.toList()));
        /*return placeRepository.findAll(
                new PlaceSpecification(criteria), criteria.getPaginationRequest().toPageable()
        ).stream().map(PlaceResponse::new).collect(Collectors.toList());*/


        /*Page<Place> page = placeRepository.findAll(paginationRequest.toPageable());
        return new PageResponse<>(page.getTotalPages(),
                page.getTotalElements(),
                page.get().map(PlaceResponse::new).collect(Collectors.toList()));*/
    }

    public Place findOne(Long id) {
        return placeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Place with id " + id + " not exists"));
    }

    public void update(Long id, PlaceRequest request) {
        placeRepository.save(placeRequestToPlace(findOne(id), request));
    }

    public void delete(Long id) {
        placeRepository.delete(findOne(id));
    }

    private Place placeRequestToPlace(Place place, PlaceRequest request) {
        if (place == null) {
            place = new Place();
        }
        place.setNumber(request.getNumber());
        place.setRestaurant(restaurantService.findOne(request.getRestaurantId()));
        return place;
    }

}
