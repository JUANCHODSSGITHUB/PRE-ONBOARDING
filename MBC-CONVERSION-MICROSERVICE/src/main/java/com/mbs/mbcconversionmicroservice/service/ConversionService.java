package com.mbs.mbcconversionmicroservice.service;

public interface ConversionService {
    String convert(String fromCurrency, String toCurrency, Double amount);
}
