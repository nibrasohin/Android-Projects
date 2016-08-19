package com.uptodate.nibras.marksweightageconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView manualInput;

    TextView txt10;
    TextView txt20;
    TextView txt25;
    TextView txt30;
    TextView txt50;
    TextView txt60;
    TextView txt70;
    TextView txt80;
    TextView txt90;
    TextView txt100;
    EditText input;
    EditText outOf;
    EditText manualOutOf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        manualInput=(TextView)findViewById(R.id.textView18);
        txt10=(TextView)findViewById(R.id.textView2);
        txt20=(TextView)findViewById(R.id.textView20);
        txt25=(TextView)findViewById(R.id.textView5);
        txt30=(TextView)findViewById(R.id.textView23);
        txt50=(TextView)findViewById(R.id.textView8);
        txt60=(TextView)findViewById(R.id.textView26);
        txt70=(TextView)findViewById(R.id.textView11);
        txt80=(TextView)findViewById(R.id.textView29);
        txt90=(TextView)findViewById(R.id.textView14);
        txt100=(TextView)findViewById(R.id.textView32);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        input=(EditText)findViewById(R.id.editText);
        outOf=(EditText)findViewById(R.id.editText2);
        manualOutOf=(EditText)findViewById(R.id.editText4);
    }


    public void setText(int txt,TextView textView,double divided)
    {
        String settingText=String.format("%.1f", divided * txt);//Double.toString(Math.round(divided * txt*100)/100);
        textView.setText(settingText);
    }
    public void doneClick(View v)
    {
        boolean test=true;
        double inputVal=0.0;
        double outOfVal=0.0;
        try
        {
            inputVal=Double.parseDouble(input.getText().toString());
            outOfVal=Double.parseDouble(outOf.getText().toString());
        }
        catch (NumberFormatException e)
        {
            test=false;
            Log.i("Default Message","Error Not a double: "+e.getMessage());
        }

        if(test && outOfVal>=inputVal)
        {
            double divided = (double) inputVal / outOfVal;
            setText(10, txt10, divided);
            setText(20, txt20, divided);
            setText(25, txt25, divided);
            setText(30, txt30, divided);
            setText(50, txt50, divided);
            setText(60, txt60, divided);
            setText(70, txt70, divided);
            setText(80, txt80, divided);
            setText(90, txt90, divided);
            setText(100, txt100, divided);
        }
        else
        {
            Log.i("Error Message", "Error with your input.");
        }


    }

    public void okClick(View v)
    {
        boolean test=true;
        double inputVal=0.0;
        double outOfVal=0.0;
        double manualInputVal=0.0;
        try
        {
            inputVal=Double.parseDouble(input.getText().toString());
            outOfVal=Double.parseDouble(outOf.getText().toString());
            manualInputVal=Double.parseDouble(manualOutOf.getText().toString());
        }
        catch (NumberFormatException e)
        {
            test=false;
            Log.i("Default Message","Error Not a double: "+e.getMessage());
        }

        if(test && outOfVal>=inputVal && manualInputVal<=100)
        {
            double divided=(double)inputVal/outOfVal;
            manualInput.setText(String.format("%.1f", divided * manualInputVal));
        }
        else
        {
            Log.i("Error Message", "Error with your input.");
        }

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
