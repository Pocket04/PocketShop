package app.orders.web.dtos.responses;

import app.orders.models.Order;

import java.util.List;

public class GetUserOrdersResponse {
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
