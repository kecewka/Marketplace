package com.example.marketplace.controller;

import com.example.marketplace.dto.exchange.ExchangeRateDTO;
import com.example.marketplace.service.scrapper.ScrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ScrapperController {
    private final ScrapperService scrapperService;

    @Autowired
    public ScrapperController(ScrapperService scrapperService) {
        this.scrapperService = scrapperService;
    }

    @RequestMapping("/rates")
    public String asd(Model model) {
        List<ExchangeRateDTO> rates = scrapperService.getExchangeRates();
        model.addAttribute("rateslist", rates);

        return "index";
    }
}
