package app.orders.web.dtos.responses;


import java.util.List;
import java.util.UUID;

public class CreateOrderResponse {

    private List<UUID> productsIds;

    private UUID userId;

    public List<UUID> getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(List<UUID> productsIds) {
        this.productsIds = productsIds;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
