package vasyl.stavinskyi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vasyl.stavinskyi.demo.dto.request.ProductRequest;
import vasyl.stavinskyi.demo.dto.response.ProductResponse;
import vasyl.stavinskyi.demo.service.ProductService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void create(@RequestBody ProductRequest request) {
        productService.create(request);
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @GetMapping("/findOne")
    public ProductResponse findOne(Long id) {
        return new ProductResponse(productService.findOne(id));
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody ProductRequest request) throws IOException {productService.update(id, request); }

    @DeleteMapping
    public void delete(Long id) {
        productService.delete(id);
    }

}
