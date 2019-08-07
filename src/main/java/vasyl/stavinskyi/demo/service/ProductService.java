package vasyl.stavinskyi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vasyl.stavinskyi.demo.dto.request.ProductRequest;
import vasyl.stavinskyi.demo.dto.response.ProductResponse;
import vasyl.stavinskyi.demo.entity.Product;
import vasyl.stavinskyi.demo.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void create(ProductRequest request) {
        productRepository.save(productRequestToProduct(null, request));

    }

    public List<ProductResponse> findAll() {

        return productRepository.findAll().stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());

    }

    public void update(Long id, ProductRequest request) {
        productRepository.save(productRequestToProduct(findOne(id), request));
    }

    public void delete(Long id) {
        productRepository.delete(findOne(id));
    }

    public Product findOne(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " not exists"));
    }

    private Product productRequestToProduct(Product product, ProductRequest request) {
        if (product == null) {
            product = new Product();
        }
        product.setCalorie(request.getCalorie());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setRecipe(request.getRecipe());
        return product;
    }
}
