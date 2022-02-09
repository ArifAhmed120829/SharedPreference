package com.example.data_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        DisplayST();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String et = editText.getText().toString();
                SaveText(et);
            }
        });
    }

    private void DisplayST() {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s1 = sharedPreferences.getString("name"," ");
        textView.setText(s1);
    }

    private void SaveText(String et) {
        //Display the text
        textView.setText(et);
        //Saving the Text into sharedPref
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",et);
        editor.commit();
    }
}