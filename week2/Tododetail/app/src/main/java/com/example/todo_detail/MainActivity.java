package com.example.todo_detail;


        import android.content.Intent;
        import android.content.res.Resources;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

        import static com.example.todo_detail.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    //private String[] tasks = {"Eat", "Sleep", "Code", "Repeat"};
    private String[] tasks;
    private TextView textView;
    int currentIndex = 0;
    private Button detailButton;
    public static String TodoIndex = "com.example.todo_detail";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("tasks", 0);
        }

        Log.d("MainActivity", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        textView = findViewById(R.id.result2);


        Resources res = getResources();
        tasks = res.getStringArray(R.array.tasks);
        textView.setText(tasks[currentIndex]);

        detailButton = (Button) findViewById(R.id.detail_button);

        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, todo_detail.class);
                intent.putExtra(TodoIndex, currentIndex);
                startActivity(intent);
            }
        });
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
        if (currentIndex > 0){
            currentIndex = currentIndex % tasks.length;
        } else {
            currentIndex = tasks.length-1;
        }
        currentIndex = --currentIndex % tasks.length;
        textView.setText(tasks[currentIndex]);
    }

}

