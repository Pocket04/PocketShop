package app.gateway.feign.props;

import java.util.List;
import java.util.UUID;

public class Order {

    private UUID id;

    private List<UUID> productsIds;

    public void setId(UUID id){
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public List<UUID> getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(List<UUID> productsIds) {
        this.productsIds = productsIds;
    }

}
