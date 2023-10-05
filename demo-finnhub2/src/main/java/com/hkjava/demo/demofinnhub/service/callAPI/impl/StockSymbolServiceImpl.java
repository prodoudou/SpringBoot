package com.hkjava.demo.demofinnhub.service.callAPI.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.hkjava.demo.demofinnhub.entity.StockSymbol;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.Protocol;
import com.hkjava.demo.demofinnhub.model.Symbol;
import com.hkjava.demo.demofinnhub.model.mapper.FinnhubMapper;
import com.hkjava.demo.demofinnhub.repository.SymbolRepository;
import com.hkjava.demo.demofinnhub.service.callAPI.StockSymbolService;

@Service
public class StockSymbolServiceImpl implements StockSymbolService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private FinnhubMapper finnhubMapper;

  @Autowired
  private SymbolRepository symbolRepository;

  @Autowired
  @Qualifier(value = "finnhubToken")
  private String token;

  @Value(value = "${api.finnhub.domain}")
  private String domain;

  @Value(value = "${api.finnhub.base-url}")
  private String baseUrl;


  @Value(value = "${api.finnhub.endpoints.stock.stocksymbol}")
  private String stocksymbolEndpoint;


  // @Autowired
  // SymbolRepository symbolRepository;

  @Override
  public List<Symbol> getStockSymbol() throws FinnhubException {

    String url = UriComponentsBuilder.newInstance() //
        .scheme(Protocol.HTTPS.name()) //
        .host(domain) //
        .pathSegment(baseUrl) //
        .path(stocksymbolEndpoint) //
        .queryParam("exchange", "US") //
        .queryParam("token", token) //
        .build() //
        .toUriString();
    System.out.println("StockSymbol url = " + url);
    // try {
    return Arrays.asList(restTemplate.getForObject(url, Symbol[].class));

    // } catch (RestClientException e) {
    // throw new FinnhubException(Code.FINNHUB_PROFILE2_NOTFOUND);
    // }
  }


  @Override
  public List<StockSymbol> save(List<Symbol> symbols) {
    List<StockSymbol> stockSymbols = symbols.stream()//
        .filter(s -> "Common Stock".equals(s.getType())) //
        .map(s -> finnhubMapper.map(s))// convert to Entity
        .collect(Collectors.toList());
    // save to DB
    return symbolRepository.saveAll(stockSymbols);
  }


  @Override
  public void deleteAll() {
    symbolRepository.deleteAll();
  }
}

