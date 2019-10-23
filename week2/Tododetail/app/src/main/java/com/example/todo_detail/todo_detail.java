package com.example.todo_detail;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class todo_detail extends AppCompatActivity {
    private String[] todo_description;
    private TextView textView;
    private Button backButton;
    private static final String IS_TODO_COMPLETE = "com.example.isTodoComplete";
    private static final String TODO_INDEX = "com.example.todoIndex";
    int currentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);

        final Intent intent = getIntent();
        intent.getIntExtra (MainActivity.TodoIndex,0);
        Resources res = getResources();
        todo_description = res.getStringArray(R.array.todo_description);

        int CurrentIndex = getIntent().getIntExtra(MainActivity.TodoIndex,0);
        textView = findViewById(R.id.result2);
        textView.setText(todo_description[CurrentIndex]);

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(todo_detail.this, MainActivity.class);
                intent.putExtra(TODO_INDEX, currentIndex);
                startActivity(intent);
            }
        });

        CheckBox checkBoxIsComplete = findViewById(R.id.checkBoxIsComplete);
        //register the onclick listener
        checkBoxIsComplete.setOnClickListener(mTodoListener);
    }

    //create an anonymous implementation of onClickListener for all clickable view objects
    private View.OnClickListener mTodoListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.checkBoxIsComplete:
                    CheckBox checkBoxIsComplete = (CheckBox)findViewById(R.id.checkBoxIsComplete);
                    setIsComplete(checkBoxIsComplete.isChecked());
                    finish();
                    break;
                    default:
                        break;
            }
        }
    };

    private void setIsComplete(boolean isChecked){

        //celebrate with a static toast
        if (isChecked){
            Toast.makeText(todo_detail.this,
                    "Hurray, it's done!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(todo_detail.this,
                    "There is always tomorrow.", Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent();
        intent.putExtra(IS_TODO_COMPLETE,isChecked);
        setResult(RESULT_OK,intent);
    }
}
