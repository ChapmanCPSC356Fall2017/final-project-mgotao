package com.example.mgota.aad_final;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class MainActivity extends AppCompatActivity {
    protected abstract Fragment getFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment(getFragment());
    }

    private void showFragment(Fragment frag){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag).commit();
    }
}
