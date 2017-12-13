package com.example.mgota.aad_final;

import java.util.UUID;

public class CurrencyModel {
    private String id;
    private String code;
    private String name;

    public CurrencyModel() {
        this.id = UUID.randomUUID().toString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void findName(String code) {
        switch(code){
            case "USD": this.name = "US Dollar"; break;
            case "EUR": this.name = "Union Euro"; break;
            case "JPY": this.name = "Japanese Yen"; break;
            case "BGN": this.name = "Bulgarian Lev"; break;
            case "CZK": this.name = "Czech Koruna"; break;
            case "DKK": this.name = "Danish Krone"; break;
            case "GBP": this.name = "Pound Sterling"; break;
            case "HUF": this.name = "Hungarian Forint"; break;
            case "PLN": this.name = "Polish Zloty"; break;
            case "RON": this.name = "Romanian Leu"; break;
            case "SEK": this.name = "Swedish Krona"; break;
            case "CHF": this.name = "Swiss Franc"; break;
            case "NOK": this.name = "Norwegian Krone"; break;
            case "HRK": this.name = "Croatian Kuna"; break;
            case "RUB": this.name = "Russian Ruble"; break;
            case "TRY": this.name = "Turkish Lira"; break;
            case "AUD": this.name = "Australian Dollar"; break;
            case "BRL": this.name = "Brazilian Real"; break;
            case "CAD": this.name = "Canadian Dollar"; break;
            case "CNY": this.name = "Chinese Yuan Renminbi"; break;
            case "HKD": this.name = "Hong Kong Dollar"; break;
            case "IDR": this.name = "Indonesian Rupiah"; break;
            case "ILS": this.name = "Israeli Shekel"; break;
            case "INR": this.name = "Indian Rupee"; break;
            case "KRW": this.name = "South Korean Won"; break;
            case "MXN": this.name = "Mexican Peso"; break;
            case "MYR": this.name = "Malaysian Ringgit"; break;
            case "NZD": this.name = "New Zealand Dollar"; break;
            case "PHP": this.name = "Philippine Peso"; break;
            case "SGD": this.name = "Singapore Dollar"; break;
            case "THB": this.name = "Thai Baht"; break;
            case "ZAR": this.name = "South African Rand"; break;
        }
    }
}
