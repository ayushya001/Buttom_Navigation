package com.example.buttom_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.buttom_navigation.Fragments.Home_Fragment;
import com.example.buttom_navigation.Fragments.List_Fragment;
import com.example.buttom_navigation.Fragments.ProfileFragment;
import com.example.buttom_navigation.Fragments.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fm, new Home_Fragment()).commit();

        getSupportActionBar().hide();
        btv = findViewById(R.id.btnNav);
        btv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp = null;
                switch (item.getItemId()){
                    case R.id.menu_home: temp=new Home_Fragment();
                    break;
                    case R.id.menu_list: temp=new List_Fragment();
                    break;
                    case R.id.menu_profile: temp=new ProfileFragment();
                        break;
                    case R.id.menu_setting: temp=new SettingFragment();
                    break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fm,temp).commit();
                return true;
            }
        });

    }
}