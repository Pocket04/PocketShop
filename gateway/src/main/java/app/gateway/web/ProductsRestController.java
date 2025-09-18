package app.gateway.web;

import app.gateway.feign.ProductsFeign;
import app.gateway.feign.props.Product;
import app.gateway.feign.requests.CreateNewProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsRestController {

    private final ProductsFeign productsFeign;


    @Autowired
    public ProductsRestController(ProductsFeign productsFeign) {
        this.productsFeign = productsFeign;
    }

    @GetMapping("/order")
    public ResponseEntity<List<Product>> getProductsFromAnOrder(@RequestParam List<UUID> ids){
        return ResponseEntity.ok(productsFeign.getProductsBasedOnId(ids));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductBasedOnId(@PathVariable UUID id){
        return ResponseEntity.ok(productsFeign.getProductById(id));
    }

    @PostMapping()
    public ResponseEntity<Product> createNewProduct(@RequestBody CreateNewProductRequest dto){
        return ResponseEntity.ok(productsFeign.createNewProduct(dto));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productsFeign.getAllProducts());
    }

}
