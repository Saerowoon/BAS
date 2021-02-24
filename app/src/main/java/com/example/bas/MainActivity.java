package com.example.bas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private MainChat mainChat;
    private MainMypage mainMypage;
    private MainLeave mainLeave;
    private MainNeed mainNeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_notes :
                        setFrag(0);
                        break;
                    case R.id.action_quiz :
                        setFrag(1);
                        break;
                    case R.id.action_share :
                        setFrag(2);
                        break;
                    case R.id.action_setting :
                        setFrag(3);
                        break;

                }
                return true;
            }
        });
        mainChat = new MainChat();
        mainLeave = new MainLeave();
        mainMypage = new MainMypage();
        mainNeed = new MainNeed();
    }
    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch (n){
            case 0:
                ft.replace(R.id.main_frame, mainNeed);
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.main_frame, mainLeave);
                ft.commit();
                break;

            case 2:
                ft.replace(R.id.main_frame, mainChat);
                ft.commit();
                break;

            case 3:
                ft.replace(R.id.main_frame, mainMypage);
                ft.commit();
                break;

        }

    }
}