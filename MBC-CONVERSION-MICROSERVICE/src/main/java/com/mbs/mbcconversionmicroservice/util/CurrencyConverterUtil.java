package com.mbs.mbcconversionmicroservice.util;

import com.mbs.mbcconversionmicroservice.exception.TestException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class CurrencyConverterUtil {

    public String convert(String fromCurrency, String toCurrency, Double amount) throws IOException {
        String getUrl = "https://api.exchangerate.host/convert?from="+fromCurrency+"&to="+toCurrency+"&amount="+amount+"&places=2";
        URL url = new URL(getUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();


            while ((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }in.close();

            JSONObject obj = new JSONObject(response.toString());
            return obj.getBigDecimal("result").toString();
        } else {
            throw new TestException("Failed");
        }
    }
}
