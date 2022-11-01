package com.example.marketplace.service.scrapper;

import com.example.marketplace.dao.ExchangeRateRepository;
import com.example.marketplace.dto.exchange.ExchangeRateDTO;
import com.example.marketplace.entity.ExchangeRate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScrapperService {
    private final ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public ScrapperService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public List<ExchangeRate> getRates() {
        return exchangeRateRepository.findAll();
    }

    public List<ExchangeRateDTO> getRatesByDate(LocalDate date) {
        List<ExchangeRate> rates = exchangeRateRepository.findAllByRateDateEquals(date);
        List<ExchangeRateDTO> dto = new ArrayList<>(rates.size());
        for (ExchangeRate r : rates) {
            dto.add(new ExchangeRateDTO(r.getForeignCurAmount(),
                    r.getForeignCurName(),
                    r.getForeignCurCode(),
                    r.getTengeAmount(),
                    r.getRateDate()));
        }
        return dto;
    }

    public boolean checkDate(LocalDate date) {
        return exchangeRateRepository.existsExchangeRateByRateDate(date);
    }

    public void saveRates(List<ExchangeRateDTO> rates) {
        for (ExchangeRateDTO r : rates) {
            if (!checkDate(r.getDate())) {
                exchangeRateRepository.save(new ExchangeRate(0, r.getForeignCurAmount(), r.getForeignCurCode(), r.getForeignCurFullName(), r.getTengeAmount(), r.getDate()));
            }
        }

    }

    public List<ExchangeRateDTO> getExchangeRates() {
        List<ExchangeRateDTO> list = new ArrayList<ExchangeRateDTO>();
        try {
            Document document = Jsoup.connect("https://nationalbank.kz/ru/page/statistika").get();
            Elements elements = document.getElementsByClass("stats-rate__inner");
            List<String> heads = new ArrayList<>();
            List<Double> values = new ArrayList<>();
            List<LocalDate> dates = new ArrayList<>();

            for (Element e : elements) {

                heads.add(e.child(0).child(1).text());
                values.add(Double.parseDouble(e.child(1).text().replace(" ", "")));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

                dates.add(LocalDate.parse(e.child(2).text(), formatter));

            }

            for (int i = 0; i < heads.size(); i++) {
                String currency = "Доллар США";
                int amount = 1;

                switch (heads.get(i)) {
                    case ("EUR"):
                        currency = "ЕВРО";
                        break;
                    case ("RUB"):
                        currency = "Российских рублей";
                        break;
                    case ("Золото"):
                        currency = "гр. Золота";
                        break;
                }

                list.add(new ExchangeRateDTO(amount,
                        currency,
                        heads.get(i),
                        values.get(i),
                        dates.get(i)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        saveRates(list);
        return list;
    }
}
