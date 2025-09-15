package app.orders.web.mappers;

import app.orders.models.Order;
import app.orders.web.dtos.responses.CreateOrderResponse;
import app.orders.web.dtos.responses.GetUserOrdersResponse;

import java.util.List;

public class DtoMapper {

    public static GetUserOrdersResponse mapOrdersToGetUserOrdersResponse(List<Order> order){
        GetUserOrdersResponse dto = new GetUserOrdersResponse();
        dto.setOrders(order);
        return dto;
    }

    public static CreateOrderResponse mapOrderToCreateOrderResponse(Order order){
        CreateOrderResponse dto = new CreateOrderResponse();
        dto.setProductsIds(order.getProductsIds());
        dto.setUserId(order.getUserId());
        return dto;
    }


}
