package com.finalproject.mywallet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_due));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_owe));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_past));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = findViewById(R.id.view_pager);

        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });


    }

    /*
     * This method attach the menu
     * created in resource folder
     * to the main activity.
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu, menu);
        return true;
    }

    /*
     * This the controller for the item in the overflow Menu.
     * It allows us to detect which item was selected.
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        //TODO
        // We will use the "Switch" to know which options got selected and
        // open another view or something else.


        switch(item.getItemId())
        {
            
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    Creates all Listeners for the menu buttons
     */

    //Listener for Search (menu) button
    public void onClickSearch(MenuItem item) {
    }


    //Listener for Add (menu) button
    public void onClickAdd(MenuItem item) {
        Intent intent = new Intent(this, Add_Customer.class);
        startActivity(intent);
    }

    //Listener for Edit (menu) button
    public void onClickEdit(MenuItem item) {
    }

    //Listener for Preferences (menu) button
    public void onClickPreferences(MenuItem item) {
        Intent intent = new Intent(this, Preferences.class);
        startActivity(intent);
    }


    //Listener for About (menu) button
    public void onClickAbout(MenuItem item) {
        Intent intent = new Intent(this, AboutScreen.class);
        startActivity(intent);
    }

    /*
    Listener for the add card button on fragments
     */

    public void onClickAdd(View view) {
        Intent intent = new Intent(this, Add_Customer.class);
        startActivity(intent);
    }
}
