package com.mbs.mbcconversionmicroservice.controller;

import com.mbs.mbcconversionmicroservice.service.ConversionService;
import org.bson.types.Decimal128;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversion")
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    @GetMapping()
    public ResponseEntity<Decimal128> convert(@RequestParam String fromCurrency, @RequestParam String toCurrency, @RequestParam double amount) {
        return new ResponseEntity<>(conversionService.convert(fromCurrency,toCurrency,amount), HttpStatus.OK);
    }
}
