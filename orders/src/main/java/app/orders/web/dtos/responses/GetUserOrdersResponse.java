package app.orders.web.dtos.responses;

import app.orders.models.Order;

import java.util.List;

public class GetUserOrdersResponse {
    private List<CreateOrderResponse> orders;

    public List<CreateOrderResponse> getOrders() {
        return orders;
    }

    public void setOrders(List<CreateOrderResponse> orders) {
        this.orders = orders;
    }
}
