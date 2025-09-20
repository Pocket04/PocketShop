package app.gateway.services;

import app.gateway.feign.ProductsFeign;
import app.gateway.feign.props.Product;
import app.gateway.web.dtos.CreateNewProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductsService {

    private final ProductsFeign productsFeign;


    @Autowired
    public ProductsService(ProductsFeign productsFeign) {
        this.productsFeign = productsFeign;
    }


    public Product createNewProduct(CreateNewProductRequest dto){
        return productsFeign.createNewProduct(dto);
    }

    public List<Product> getProductsBasedOnId(List<UUID> ids){
        return productsFeign.getProductsBasedOnId(ids);
    }

    public List<Product> getAllProducts(){
        return productsFeign.getAllProducts();
    }

    public Product getSpecificProduct(UUID id){
        return productsFeign.getProductById(id);
    }


}
