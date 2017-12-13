package com.example.mgota.aad_final;

import android.support.v4.app.Fragment;

public class CurrencyListActivity extends MainActivity{
    protected Fragment getFragment(){
        return new CurrencyListFragment();
    }
}
