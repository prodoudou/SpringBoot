package com.hkjava.demo.demofinnhub.service.callAPI.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.entity.StockPrice;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.Code;
import com.hkjava.demo.demofinnhub.infra.Protocol;
import com.hkjava.demo.demofinnhub.model.Quote;
import com.hkjava.demo.demofinnhub.repository.StockPriceRepository;
import com.hkjava.demo.demofinnhub.repository.StockRepository;
import com.hkjava.demo.demofinnhub.service.callAPI.StockService;

@Service
public class StockServiceImpl implements StockService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private StockRepository stockRepository;

  @Autowired
  @Qualifier(value = "finnhubToken")
  private String token;

  @Value(value = "${api.finnhub.domain}")
  private String domain;

  @Value(value = "${api.finnhub.base-url}")
  private String baseUrl;

  @Value(value = "${api.finnhub.endpoints.stock.quote}")
  private String quoteEndpoint;

  @Override
  public Quote getQuote(String symbol) throws FinnhubException {
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Protocol.HTTPS.name()) //
        .host(domain) //
        .pathSegment(baseUrl) //
        .path(quoteEndpoint) //
        .queryParam("symbol", symbol) //
        .queryParam("token", token) //
        .build() //
        .toUriString();
    System.out.println("url = " + url);
    try {
      return restTemplate.getForObject(url, Quote.class);
    } catch (RestClientException e) {
      throw new FinnhubException(Code.FINNHUB_QUOTE_NOTFOUND);
    }
  }

  public Stock getStockById(Long id) {
    return stockRepository.findById(id).orElse(null);
  }

  public List<Stock> getStock() {
    return stockRepository.findAll();
  }
}
