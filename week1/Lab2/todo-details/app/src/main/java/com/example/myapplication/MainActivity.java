
package com.example.myapplication;


import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.myapplication.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    //private String[] tasks = {"Eat", "Sleep", "Code", "Repeat"};
    private String[] tasks;
    private TextView textView;
    int currentIndex = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (savedInstanceState != null){
            currentIndex = savedInstanceState.getInt("tasks",0);
        }

        Log.d( "MainActivity", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        textView = findViewById(R.id.result);


        Resources res = getResources();
        tasks = res.getStringArray(R.array.tasks);
        textView.setText(tasks[currentIndex]);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("tasks", currentIndex);
    }

    @Override
    protected void onStart() {
        Log.d( "MainActivity", "onStart()");
        super.onStart();

    }

    @Override
    protected void onPause() {
        Log.d( "MainActivity", "onPause()");

        super.onPause();
    }

    @Override
    protected void onPostResume() {
        Log.d( "MainActivity", "onPostResume()");
        super.onPostResume();
    }

    @Override
    protected void onStop() {
        Log.d( "MainActivity", "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d( "MainActivity", "onDestroy()");
        super.onDestroy();
    }

    public void next_click(View view) {
        currentIndex = ++currentIndex % tasks.length;
        //Log.d( tag: "MainActivity", msg: "value of current index: "+currentIndex);

        textView.setText(tasks[currentIndex]);
    }

    public void previous_click(View view) {
        textView.setText(tasks[currentIndex]);
    }

}
