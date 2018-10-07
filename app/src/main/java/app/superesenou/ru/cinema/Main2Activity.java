package app.superesenou.ru.cinema;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

import app.superesenou.ru.cinema.adapter.AdapterKino;
import app.superesenou.ru.cinema.api.ApiService;
import app.superesenou.ru.cinema.api.RetroClient;
import app.superesenou.ru.cinema.models.AnswerKinoafisha;


import retrofit2.Callback;
import retrofit2.Response;


public class Main2Activity extends AppCompatActivity {




    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private KinoFragment leftFragment;
    private AnanasFragment rightFragment;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mMainFrame=(FrameLayout)findViewById(R.id.main_frame);
        mMainNav=(BottomNavigationView)findViewById(R.id.main_nav);


       // android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
      //  getSupportActionBar().setTitle("Computer Glossary");

      //  toolbar.setTitleTextColor(Color.parseColor("#FDFEFE"));



        leftFragment=new KinoFragment();
        rightFragment=new AnanasFragment();



        setFragment(leftFragment);
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.left_id:
                     //   mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(leftFragment);
                        return true;
                    case R.id.right_id:
                      //  mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);

                        setFragment(rightFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });


        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){


                onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();

    }




}