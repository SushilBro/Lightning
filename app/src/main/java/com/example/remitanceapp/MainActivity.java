package com.example.remitanceapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationBarView;

import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements  NavigationBarView.OnItemSelectedListener {
    NavigationBarView navigationBarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationBarView = findViewById(R.id.bottonnav);
        navigationBarView.setOnItemSelectedListener(this);
        loadFragment(new Home());
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.page_1:
                fragment = new Home();
                break;
            case R.id.page_2:
                fragment = new Invoice();
                break;
            case R.id.page_3:
                fragment = new Settings();
                break;
        }
        if (fragment != null) {
            loadFragment(fragment);
        }
        return true;
    }
    void loadFragment(Fragment fragment) {
        //to attach fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.relativelayout, fragment).commit();
    }
}