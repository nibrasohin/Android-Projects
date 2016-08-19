package com.uptodate.nibras.chapter4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashSet;

/**
 * Created by nibras on 2016-03-25.
 */
public class List extends Activity
{
//    static ArrayList<String> arrayList;
//    static ListView listView;
//    ArrayAdapter<String> arrayAdapter;

    static ListView listView;
    static ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        listView=(ListView)findViewById(R.id.listView);


        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,MainActivity.arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), MainActivity.arrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                new AlertDialog.Builder(List.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Delete")
                        .setMessage("Do you want to delete this task?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MainActivity.arrayList.remove(position);
                                SharedPreferences sharedPreferences=List.this.getSharedPreferences("com.uptodate.nibras.chapter4", Context.MODE_PRIVATE);
                                MainActivity.set=sharedPreferences.getStringSet("notes",null);

                                if(MainActivity.set==null)
                                {
                                    MainActivity.set=new HashSet<>();
                                }
                                else
                                {
                                    MainActivity.set.clear();

                                }
                                MainActivity.set.addAll(MainActivity.arrayList);
                                sharedPreferences.edit().putStringSet("notes", MainActivity.set).apply();
                                listView.setAdapter(arrayAdapter);
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
                return  true;
            }
        });

    }

}
