package com.example.marketplace.mapper.payment;

import com.example.marketplace.dto.payment.PaymentDto;
import com.example.marketplace.entity.Payment;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PaymentMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PaymentListMapper {
    List<PaymentDto> toDtoList(List<Payment> payments);
}
