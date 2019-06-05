package com.example.natter;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
 {
    private Toolbar mToolbar;
    private ViewPager myViewPager;
    private TabLayout myTablayout;
    private TabsAccessorAdapter myTabsAccessorAdapter;

    private FirebaseUser currentUser;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Natter");


        myViewPager = (ViewPager) findViewById(R.id.main_tabs_pager);
        myTabsAccessorAdapter = new TabsAccessorAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(myTabsAccessorAdapter);

        myTablayout = (TabLayout) findViewById(R.id.main_tabs);
        myTablayout.setupWithViewPager(myViewPager);

    }


     @Override
     protected void onStart()
     {
         super.onStart();

         if(currentUser == null)
         {
             SendUserToLoginActivity();
         }
     }



     private void SendUserToLoginActivity()
     {
         Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
         startActivity(loginIntent);
     }
 }
