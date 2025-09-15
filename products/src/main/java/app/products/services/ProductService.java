package app.products.services;

import app.products.modules.Product;
import app.products.repositories.ProductRepository;
import app.products.web.dtos.requests.CreateProductRequest;
import app.products.web.dtos.requests.GetProductsBasedOnId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(CreateProductRequest dto){
        Product product = new Product();
        product.setDescription(dto.getDescription());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }

    public Product getProductById(UUID id){
        Optional<Product> optProduct = productRepository.findById(id);
        return optProduct.isPresent()? optProduct.get() : null;
    }

    public List<Product> getSelectedProductsByIds(GetProductsBasedOnId dto){
        return productRepository.findAllById(dto.getIds());
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


}


