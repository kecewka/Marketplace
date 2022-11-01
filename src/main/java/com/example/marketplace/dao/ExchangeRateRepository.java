package com.example.marketplace.dao;

import com.example.marketplace.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {
    public boolean existsExchangeRateByRateDate(LocalDate date);

    public List<ExchangeRate> findAllByRateDateEquals(LocalDate date);
}
