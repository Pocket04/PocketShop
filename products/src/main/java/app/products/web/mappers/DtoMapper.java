package app.products.web.mappers;

import app.products.modules.Product;
import app.products.web.dtos.responses.GetProductResponse;

import java.util.ArrayList;
import java.util.List;

public class DtoMapper {

    public static GetProductResponse mapProductToCreateProductResponse(Product product){
        GetProductResponse dto = new GetProductResponse();
        dto.setId(product.getId());
        dto.setDescription(product.getDescription());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        return dto;
    }

    public static List<GetProductResponse> mapProductsListToGetProductResponseList(List<Product> products){
        List<GetProductResponse> dtos = new ArrayList<>();
        for (Product product : products) {
            dtos.add(mapProductToCreateProductResponse(product));
        }
        return dtos;
    }


}
