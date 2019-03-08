package com.example.sean.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mPasswordSubmitButton;
    private static final String TAG = "MainActivity";
    private static final String PWD = "putty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPasswordSubmitButton = findViewById(R.id.pwd_submit_button);
        mPasswordSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Password submit button clicked");
                EditText pwdText = findViewById(R.id.pwd);
                String tmpText = pwdText.getText().toString();
                if(tmpText.equals(PWD))
                    Toast.makeText(getApplicationContext(), "SUCCESSFUL AUTHENTICATION", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "PLEASE ENTER CORRECT PASSWORD", Toast.LENGTH_LONG).show();

            }
        });


    }
}
