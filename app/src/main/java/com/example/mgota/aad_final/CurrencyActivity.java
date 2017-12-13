package com.example.mgota.aad_final;

import android.support.v4.app.Fragment;
import android.os.Bundle;

public class CurrencyActivity extends MainActivity{
    public static final String myId = "";

    protected Fragment getFragment(){
        Bundle currencyBundle = getIntent().getExtras();
        CurrencyFragment frag = new CurrencyFragment();
        frag.setArguments(currencyBundle);

        return frag;
    }
}
