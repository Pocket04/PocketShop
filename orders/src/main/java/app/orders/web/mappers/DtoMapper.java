package app.orders.web.mappers;

import app.orders.models.Order;
import app.orders.web.dtos.responses.CreateOrderResponse;
import app.orders.web.dtos.responses.GetUserOrdersResponse;

import java.util.List;

public class DtoMapper {

    public static GetUserOrdersResponse mapOrdersToGetUserOrdersResponse(List<CreateOrderResponse> orders){
        GetUserOrdersResponse dto = new GetUserOrdersResponse();
        dto.setOrders(orders);
        return dto;
    }

    public static CreateOrderResponse mapOrderToCreateOrderResponse(Order order){
        CreateOrderResponse dto = new CreateOrderResponse();
        dto.setProductsIds(order.getProductsIds());
        dto.setId(order.getId());
        return dto;
    }


}
