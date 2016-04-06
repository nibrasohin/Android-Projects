package com.uptodate.nibras.chapter4;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> arrayList;
    static SharedPreferences sharedPreferences;
    static int idAdder=0;
    static  Set<String> set;

    public void getRandomTask(View view)
    {
        Random rn=new Random();
        String task="Your Task";
        TextView textView=(TextView)findViewById(R.id.randomTextView);
        if(arrayList.size()>0) {
            int random=rn.nextInt((arrayList.size()-1-0)+1)+0;
            task = arrayList.get(random);
        }
        textView.setText(task);


    }

    public void addTask(View view)
    {
        EditText editText=(EditText)findViewById(R.id.editText);
        if(view.getId()==R.id.task )
        {
//            System.out.println("Testing");
            arrayList.add(editText.getText().toString());

            set.addAll(arrayList);
            sharedPreferences.edit().putStringSet("notes",set).apply();
            editText.setText("");
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList=new ArrayList<String>();
        sharedPreferences=this.getSharedPreferences("com.uptodate.nibras.chapter4", Context.MODE_PRIVATE);
        set=sharedPreferences.getStringSet("notes",null);
        arrayList.clear();
        if(set!=null)
        {
            arrayList.addAll(set);
        }
        else
        {
            arrayList.add("Example Note");
            set=new HashSet<>();
            set.addAll(arrayList);
            sharedPreferences.edit().putStringSet("notes",set).apply();
        }

    }

    public void buttonClicked(View view)
    {

     if(view.getId()==R.id.showList)
     {
         Intent i=new Intent(MainActivity.this,List.class);
         startActivity(i);
     }
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

}