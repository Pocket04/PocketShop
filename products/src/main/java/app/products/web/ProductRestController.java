package app.products.web;

import app.products.services.ProductService;
import app.products.web.dtos.requests.CreateProductRequest;
import app.products.web.dtos.responses.GetProductResponse;
import app.products.web.mappers.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<GetProductResponse> createProduct(@RequestBody CreateProductRequest dto){
        return ResponseEntity.ok(DtoMapper.mapProductToCreateProductResponse(productService.createProduct(dto)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponse> getProductById(@PathVariable UUID id){
        return ResponseEntity.ok(DtoMapper.mapProductToCreateProductResponse(productService.getProductById(id)));
    }
    @GetMapping()
    public ResponseEntity<List<GetProductResponse>> getAllProducts(){
        return ResponseEntity.ok(DtoMapper.mapProductsListToGetProductResponseList(productService.getAllProducts()));
    }
    @GetMapping("/order")
    public ResponseEntity<List<GetProductResponse>> getSpecificProducts(@RequestParam List<UUID> ids){
        return ResponseEntity.ok(DtoMapper.mapProductsListToGetProductResponseList(productService.getSelectedProductsByIds(ids)));
    }
}
