package com.mbs.mbcconversionmicroservice.service;

import com.mbs.mbcconversionmicroservice.util.CurrencyConverterUtil;
import org.bson.types.Decimal128;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConversionServiceImpl implements ConversionService{

    @Autowired
    private CurrencyConverterUtil currencyConverterUtil;

    @Override
    public Decimal128 convert(String fromCurrency, String toCurrency, Double amount) {
        try {
            String convertedAmount = currencyConverterUtil.convert(fromCurrency, toCurrency, amount);
             return Decimal128.parse(convertedAmount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
