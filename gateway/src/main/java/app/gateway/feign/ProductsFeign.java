package app.gateway.feign;

import app.gateway.feign.props.Product;
import app.gateway.web.dtos.CreateNewProductRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "products", url = "http://localhost:8082/products")
public interface ProductsFeign {

    @GetMapping
    List<Product> getAllProducts();

    @PostMapping
    Product createNewProduct(@RequestBody CreateNewProductRequest createNewProductRequest);

    @GetMapping("/{id}")
    Product getProductById(@PathVariable UUID id);

    @GetMapping("/order")
    List<Product> getProductsBasedOnId(@RequestParam List<UUID> ids);

}
