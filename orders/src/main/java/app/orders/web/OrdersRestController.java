package app.orders.web;

import app.orders.services.OrderService;
import app.orders.web.dtos.requests.CreateOrderRequest;
import app.orders.web.dtos.responses.CreateOrderResponse;
import app.orders.web.dtos.responses.GetUserOrdersResponse;
import app.orders.web.mappers.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrdersRestController {

    private final OrderService orderService;

    @Autowired
    public OrdersRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CreateOrderResponse>> getOrdersByUserId(@PathVariable UUID id){
        return ResponseEntity.ok(orderService.getOrdersByUserId(id));
    }

    @PostMapping()
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest dto){
        return ResponseEntity.ok(DtoMapper.mapOrderToCreateOrderResponse(orderService.createOrder(dto)));
    }

}
