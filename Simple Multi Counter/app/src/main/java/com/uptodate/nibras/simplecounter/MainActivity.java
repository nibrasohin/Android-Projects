package com.uptodate.nibras.simplecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView totalText;
    private TextView text1;
    private TextView text2;
    private TextView text3;

    private int totIncrementer = 0;
    private int firstIncrementer = 0;
    private int secondIncrementer = 0;
    private int thirdIncrementer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        totalText = (TextView) findViewById(R.id.total);
        text1 = (TextView) findViewById(R.id.counter1);
        text2 = (TextView) findViewById(R.id.counter2);
        text3 = (TextView) findViewById(R.id.counter3);
    }

    public void incrementer(View v) {
        if (v.getId() == R.id.green) {
            firstIncrementer++;
        } else if (v.getId() == R.id.red) {
            firstIncrementer--;
        } else if (v.getId() == R.id.yellow) {
            secondIncrementer++;
        } else if (v.getId() == R.id.navyBlue) {
            secondIncrementer--;
        } else if (v.getId() == R.id.blue) {
            thirdIncrementer++;
        } else if (v.getId() == R.id.orrange) {
            thirdIncrementer--;
        } else {
            Log.i("Default", "Error");
        }
        totIncrementer = firstIncrementer + secondIncrementer + thirdIncrementer;
        show();
    }

    public void reset(View v) {
        if (v.getId() == R.id.resetTotal) {
            totIncrementer = 0;
            firstIncrementer = 0;
            secondIncrementer = 0;
            thirdIncrementer = 0;
        } else if (v.getId() == R.id.resetFirst) {
            firstIncrementer = 0;
        } else if (v.getId() == R.id.resetSecond) {
            secondIncrementer = 0;
        } else if (v.getId() == R.id.resetThird) {
            thirdIncrementer = 0;
        }
        totIncrementer = firstIncrementer + secondIncrementer + thirdIncrementer;
        show();
    }


    public void show() {
        text1.setText(String.valueOf(firstIncrementer));
        text2.setText(String.valueOf(secondIncrementer));
        text3.setText(String.valueOf(thirdIncrementer));
        totalText.setText(String.valueOf(totIncrementer));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==R.id.item_options1)
        {
            //means about us is selected
            //setContentView(R.layout.about_us);
            Intent i=new Intent(MainActivity.this,AboutUs.class);
            startActivity(i);
        }
        else if(item.getItemId()==R.id.item_options2)
        {
            //means contact us is selected`
            Intent i=new Intent(MainActivity.this,ContactUs.class);
            startActivity(i);

        }
        return super.onOptionsItemSelected(item);
    }
}
