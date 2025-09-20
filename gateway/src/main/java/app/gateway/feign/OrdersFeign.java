package app.gateway.feign;

import app.gateway.feign.props.Order;
import app.gateway.web.dtos.CreateNewOrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "orders", url = "http://localhost:8081/orders")
public interface OrdersFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    List<Order> getOrdersByUserId(@PathVariable UUID id);

    @RequestMapping(method = RequestMethod.POST)
    Order createNewOrder(@RequestBody CreateNewOrderRequest dto);

}
