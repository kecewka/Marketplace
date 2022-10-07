package com.example.marketplace.mapper.payment;

import com.example.marketplace.dto.payment.PaymentDto;
import com.example.marketplace.entity.Payment;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    PaymentDto paymentToDto(Payment payment);
}
