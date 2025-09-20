package app.gateway.web;

import app.gateway.feign.props.Product;
import app.gateway.web.dtos.CreateNewProductRequest;
import app.gateway.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsRestController {

    private final ProductsService productsService;


    @Autowired
    public ProductsRestController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/order")
    public ResponseEntity<List<Product>> getProductsFromAnOrder(@RequestParam List<UUID> ids){
        return ResponseEntity.ok(productsService.getProductsBasedOnId(ids));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductBasedOnId(@PathVariable UUID id){
        return ResponseEntity.ok(productsService.getSpecificProduct(id));
    }

    @PostMapping
    public ResponseEntity<Product> createNewProduct(@RequestBody CreateNewProductRequest dto){
        return ResponseEntity.ok(productsService.createNewProduct(dto));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productsService.getAllProducts());
    }
}
