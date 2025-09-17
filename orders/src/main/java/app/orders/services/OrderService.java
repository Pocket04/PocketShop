package app.orders.services;

import app.orders.models.Order;
import app.orders.repositories.OrderRepository;
import app.orders.web.dtos.requests.CreateOrderRequest;
import app.orders.web.dtos.responses.CreateOrderResponse;
import app.orders.web.mappers.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public Order createOrder(CreateOrderRequest dto){
        Order order = new Order();
        order.setUserId(dto.getUserId());
        order.setProductsIds(dto.getProductIds());

        return orderRepository.save(order);
    }

    public List<CreateOrderResponse> getOrdersByUserId(UUID id){
        List<Order> orders = orderRepository.getOrdersByUserId(id);
        List<CreateOrderResponse> dtos = new ArrayList<>();
        for (Order order : orders) {
            dtos.add(DtoMapper.mapOrderToCreateOrderResponse(order));
        }
        return dtos;
    }

}
