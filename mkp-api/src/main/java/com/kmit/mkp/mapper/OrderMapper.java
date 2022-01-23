package com.kmit.mkp.mapper;

import com.kmit.mkp.dto.OrderDetailDto;
import com.kmit.mkp.dto.OrdersDto;
import com.kmit.mkp.entity.OrderDetail;
import com.kmit.mkp.entity.Orders;
import com.kmit.mkp.util.UUIDGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = { UUIDGenerator.class })
public interface OrderMapper {

    @Mapping(
            target = "id",
            expression = "java(ordersDto.getId().isEmpty()? UUIDGenerator.getUUID():ordersDto.getId())")
    Orders toOrder(OrdersDto ordersDto);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(
            source = "id",
            target = "id",
            defaultExpression = "java(UUIDGenerator.getUUID())" )
    OrderDetail toOrderDetail(OrderDetailDto orderDetailDto);

    OrdersDto toOrderDto(Orders orders);

    @Mapping(source = "product.id", target = "productId")
    OrderDetailDto toOrderDetailDto(OrderDetail orderDetail);

    List<OrdersDto> toOrderDtoList(List<Orders> ordersList);
}
