package com.uptodate.nibras.randomtodolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView showSubj;
    private int counter=0;
    private double gpa=0.00;
    EditText gpaW;
    private double lastStoredGpa=0.00;
    public double calculateGpa(double gpaWeight,int numOfSub)
    {
        if(numOfSub==1) {
            gpa += (gpaWeight);
        }
        else if(numOfSub==-1)
        {
            gpa=gpa-lastStoredGpa;
        }
        return gpa;
    }
    public int subjectCounter(View view)
    {
        gpaW=(EditText)findViewById(R.id.editGpaWeight);
        showSubj=(TextView)findViewById(R.id.showNumOfSubj);
        if(view.getId()==R.id.add)
        {
            calculateGpa(Double.parseDouble(gpaW.getText().toString()),1);
            lastStoredGpa=Double.parseDouble(gpaW.getText().toString());
            counter++;
        }
        else if(view.getId()==R.id.substract)
        {
            calculateGpa(0.00,-1);
            counter--;
        }
        else
        {
            System.out.println("Checkig OHin");
        }

        showSubj.setText(Integer.toString(counter));
        gpaW.setText("0");
        return  counter;
    }
    public void response(View view)
    {
        TextView output = (TextView) findViewById(R.id.output);
        showSubj=(TextView)findViewById(R.id.showNumOfSubj);
        if(view.getId()==R.id.calculate) {
            double finalGpa = gpa / counter;
            output.setText(Double.toString(finalGpa));
        }
        else {
            output.setText("0.00");
            showSubj.setText("0");
            counter=0;
            gpa = 0.0;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
