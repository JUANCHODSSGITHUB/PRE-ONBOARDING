package com.mbs.mbsaccountmicroservice.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AcctNumberGeneratorUtil {
    public String generateNumber(){
        Random rand = new Random();
        String number = "MBS";
        for (int i = 0; i < 14; i++)
        {
            int n = rand.nextInt(10) + 0;
            number += Integer.toString(n);
        }
        return number;
    }
}
