package app.gateway.web.dtos;


import java.util.List;
import java.util.UUID;

public class CreateNewOrderRequest {

    private List<UUID> productIds;

    private UUID id;

    public List<UUID> getProductIds() {
        return productIds;
    }
    public void setProductIds(List<UUID> productIds) {
        this.productIds = productIds;
    }

    public UUID getUserId() {
        return id;
    }

    public void setUserId(UUID id) {
        this.id = id;
    }

}
