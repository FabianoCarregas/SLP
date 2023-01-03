package com.group.slp.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public Page<Sale> datedSales(String min, String max, Pageable pageable) {
        LocalDate now = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate minDate = min.equals("") ? now.minusDays(30) : LocalDate.parse(min);
        LocalDate maxDate = min.equals("") ? now : LocalDate.parse(max);

        return saleRepository.findAllBetweenDate(minDate, maxDate, pageable);
    }

}
