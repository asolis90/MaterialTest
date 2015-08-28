package com.materialtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.materialtest.adapter.MyRecyclerViewAdapter;
import com.materialtest.fragments.FragmentPage1;
import com.materialtest.fragments.FragmentPage2;
import com.materialtest.fragments.FragmentPage3;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {


    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    RecyclerView recyclerView;
    ViewPager viewpager;
    SlidingTabLayout slidingTabLayout;
    public static AppCompatActivity act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        act = this;

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, setDrawerData());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tablayout);
        slidingTabLayout.setDistributeEvenly(true);
        viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        slidingTabLayout.setCustomTabView(R.layout.row_tab,R.id.textView_tab);
        slidingTabLayout.setViewPager(viewpager);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("materialtest");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                             /* host Activity */
                mDrawerLayout,                    /* DrawerLayout object */
                toolbar,             /* nav drawer image to replace 'Up' caret */
                R.drawable.ic_drawer, R.drawable.ic_drawer  /* "close drawer" description for accessibility */
        ) {
            @Override
            public void onDrawerClosed(View drawerView) {

                invalidateOptionsMenu(); // calls onPrepareOptionsMenu()

            }

            @Override
            public void onDrawerOpened(View drawerView) {

                invalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }
        };

        // Defer code dependent on restoration of previous instance state.
        // NB: required for the drawer indicator to show up!
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
//        getSupportActionBar().setLogo(R.drawable.ic_launcher);
//        setDrawerData();


    }

    private List<DataPojo> setDrawerData() {
        String[] names = {"home", "profile", "settings", "preferences"};
        String[] description = {"asdasdad", "asdasd", "asdasd", "asdasd"};
        int[] icons = {R.drawable.ic_action_action_crear_voucher, R.drawable.ic_action_action_crear_voucher, R.drawable.ic_action_action_crear_voucher, R.drawable.ic_action_action_crear_voucher};

        List<DataPojo> drawerList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            Log.d("setting data in drawer", "passed");
            DataPojo p = new DataPojo();
            p.setName(names[i]);
            p.setDescription(description[i]);
            p.setIcon(icons[i]);
            drawerList.add(p);
        }

        return drawerList;

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
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void itemClicked(View view, int position) {
        Toast.makeText(this, "clicked" + position, Toast.LENGTH_SHORT).show();
    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {

        String[] tabs = {"PAGE 1","PAGE 2","PAGE3"};
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);

            Log.d("constructor adapter","passed");
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public Fragment getItem(int position) {
            Log.d("getitem","passed" + position);

            switch (position) {
                case 0:
                    FragmentPage1 fp1 = new FragmentPage1();
                    return fp1;

                case 1:
                    FragmentPage2 fp2 = new FragmentPage2();
                    return fp2;
                case 2:
                    FragmentPage3 fp3 = new FragmentPage3();
                    return fp3;

            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
