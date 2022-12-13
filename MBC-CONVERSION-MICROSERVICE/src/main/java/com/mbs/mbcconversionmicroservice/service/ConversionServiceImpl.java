package com.mbs.mbcconversionmicroservice.service;

import com.mbs.mbcconversionmicroservice.util.CurrencyConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConversionServiceImpl implements ConversionService{

    @Autowired
    private CurrencyConverterUtil currencyConverterUtil;

    @Override
    public String convert(String fromCurrency, String toCurrency, Double amount) {
        try {
             return currencyConverterUtil.convert(fromCurrency, toCurrency, amount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
