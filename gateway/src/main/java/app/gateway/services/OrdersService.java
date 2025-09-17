package app.gateway.services;

import app.gateway.feign.OrdersFeign;
import app.gateway.feign.props.Order;
import app.gateway.web.dtos.CreateNewOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrdersService {

    private final OrdersFeign ordersFeign;


    @Autowired
    public OrdersService(OrdersFeign ordersFeign) {
        this.ordersFeign = ordersFeign;
    }

    public List<Order> getOrdersByUserId(UUID id){
        return ordersFeign.getOrdersByUserId(id);
    }

    public Order createNewOrder(CreateNewOrderRequest dto){
        Order order = new Order();
        order.setProductsIds(dto.getProductIds());
        order.setId(dto.getUserId());
        return order;
    }


}
