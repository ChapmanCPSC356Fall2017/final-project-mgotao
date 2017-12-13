package com.example.mgota.aad_final;

import java.util.ArrayList;
import java.util.Collections;

public class CurrencyCollection {
    private static CurrencyCollection singleton;
    public static CurrencyCollection getCollection(){

        if(singleton == null) singleton = new CurrencyCollection();
        return singleton;
    }

    private ArrayList<String> currencyList = new ArrayList<>();
    private ArrayList<CurrencyModel> myCollection = new ArrayList<>();

    private CurrencyCollection(){
        currencyList.add("USD");    currencyList.add("EUR");
        currencyList.add("JPY");    currencyList.add("BGN");
        currencyList.add("CZK");    currencyList.add("DKK");
        currencyList.add("GBP");    currencyList.add("HUF");
        currencyList.add("PLN");    currencyList.add("RON");
        currencyList.add("SEK");    currencyList.add("CHF");
        currencyList.add("NOK");    currencyList.add("HRK");
        currencyList.add("RUB");    currencyList.add("TRY");
        currencyList.add("AUD");    currencyList.add("BRL");
        currencyList.add("CAD");    currencyList.add("CNY");
        currencyList.add("HKD");    currencyList.add("IDR");
        currencyList.add("ILS");    currencyList.add("INR");
        currencyList.add("KRW");    currencyList.add("MXN");
        currencyList.add("MYR");    currencyList.add("NZD");
        currencyList.add("PHP");    currencyList.add("SGD");
        currencyList.add("THB");    currencyList.add("ZAR");

        for (int i = 0; i < 31; i++) {
            CurrencyModel curr = new CurrencyModel();
            curr.setCode(currencyList.get(i));
            curr.findName(curr.getCode());
            this.myCollection.add(curr);
        }
    }

    public ArrayList<CurrencyModel> getElements(){
        return this.myCollection;
    }

    public CurrencyModel getElement(String id){
        for (CurrencyModel element:this.myCollection) {
            if(element.getId().equals(id)) return element;
        }
        return null;
    }

    void remove(int pos){
        this.myCollection.remove(pos);
    }

    void swap(int posOne, int posTwo){
        Collections.swap(this.myCollection, posOne, posTwo);
    }
}
