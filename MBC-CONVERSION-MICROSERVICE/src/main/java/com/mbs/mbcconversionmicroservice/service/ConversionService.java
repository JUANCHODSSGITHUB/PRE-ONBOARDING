package com.mbs.mbcconversionmicroservice.service;

import org.bson.types.Decimal128;

public interface ConversionService {
    Decimal128 convert(String fromCurrency, String toCurrency, Double amount);
}
