package com.example.quickconvert;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatCurrency {
    Locale locale;

    public String format(double amount, String toCurrency) {
        switch (toCurrency) {
            case "EUR": {
                locale = new Locale.Builder().setLanguage("de").setRegion("DE").build();
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                return currencyFormatter.format(amount);
            }
            case "USD": {
                locale = new Locale.Builder().setLanguage("us").setRegion("US").build();
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                return currencyFormatter.format(amount);
            }
            case "RSD": {
                locale = new Locale.Builder().setLanguage("rs").setRegion("RS").build();
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                return currencyFormatter.format(amount);
            }
            default:
                locale = new Locale.Builder().setLanguage("de").setRegion("DE").build();
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                return currencyFormatter.format(amount);
        }
    }
}
