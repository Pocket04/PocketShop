package app.orders.web.dtos.requests;

import java.util.List;
import java.util.UUID;

public class CreateOrderRequest {

    private List<UUID> productIds;

    private UUID userId;

    public List<UUID> getProductIds() {
        return productIds;
    }
//e374fe34-5076-492e-87fc-caffa0f5a7d3
    public void setProductIds(List<UUID> productIds) {
        this.productIds = productIds;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
