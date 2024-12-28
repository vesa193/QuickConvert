package com.example.quickconvert;

public class CurrencyConverter {

    private final double EUR_TO_USD = 1.1;
    private final double EUR_TO_RSD = 116.60;
    private final double USD_TO_RSD = 110.52;

    // Metoda za konverziju
    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return amount;
        }

        switch (fromCurrency + "_" + toCurrency) {
            case "EUR_USD":
                return amount * EUR_TO_USD;
            case "EUR_RSD":
                return amount * EUR_TO_RSD;
            case "USD_RSD":
                return amount * USD_TO_RSD;
            case "USD_EUR":
                return amount / EUR_TO_USD;
            case "RSD_EUR":
                return amount / EUR_TO_RSD;
            case "RSD_USD":
                return amount / USD_TO_RSD;
            default:
                return 0;
        }
    }
}
