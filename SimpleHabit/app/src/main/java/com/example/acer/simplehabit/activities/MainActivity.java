package com.example.acer.simplehabit.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;
import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.fragments.MeFragment;
import com.example.acer.simplehabit.fragments.MeditateFragment;
import com.example.acer.simplehabit.fragments.MoreFragment;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
//    @BindView(R.id.toolbar)
//    Toolbar toolbar;

    @BindView(R.id.bn_simple_habit)
    BottomNavigationView bnSimpleHabit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);
//        setSupportActionBar(toolbar);


        MenuItem item =   bnSimpleHabit.getMenu().findItem(R.id.item_meditate);
        if (item.isCheckable() || item.isChecked()){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, new MeditateFragment()).commit();
        }


        bnSimpleHabit.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int mItem = item.getItemId();
                if (mItem == R.id.item_meditate) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, new MeditateFragment()).commit();
                    return true;
                } else if (mItem == R.id.item_me) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, new MeFragment()).commit();
                    return true;
                } else if (mItem == R.id.item_more) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, new MoreFragment()).commit();
                    return true;
                }

                return false;
            }

        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }



}
