package app.gateway.web;

import app.gateway.feign.OrdersFeign;
import app.gateway.feign.props.Order;
import app.gateway.services.OrdersService;
import app.gateway.web.dtos.CreateNewOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrdersRestController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersRestController(OrdersFeign ordersFeign, OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable UUID id){
        return ResponseEntity.ok(ordersService.getOrdersByUserId(id));
    }

    @PostMapping
    public ResponseEntity<Order> createNewOrder(@RequestBody CreateNewOrderRequest dto){
        return ResponseEntity.ok(ordersService.createNewOrder(dto));
    }

}
