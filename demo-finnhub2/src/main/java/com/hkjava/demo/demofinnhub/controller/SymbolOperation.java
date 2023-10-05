package com.hkjava.demo.demofinnhub.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.ApiResponse;
import com.hkjava.demo.demofinnhub.model.Symbol;

public interface SymbolOperation {
  @GetMapping(value = "/stockSymbol")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<Symbol>> getStockSymbol() throws FinnhubException;

}
