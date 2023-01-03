package com.group.slp.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/all")
    public Page<Sale> findAll(
            @RequestParam(value = "minDate", defaultValue = "") String minDatePageable,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDatePageable,
            Pageable pageable) {
        return saleService.datedSales(minDatePageable, maxDatePageable, pageable);
    }

}
