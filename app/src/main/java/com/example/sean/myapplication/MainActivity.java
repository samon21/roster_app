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
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    private Button mPasswordSubmitButton;
    private static final String TAG = "MainActivity";
    private static final String PWD = "putty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText pwdText = findViewById(R.id.pwd);
        pwdText.setText("");
        mPasswordSubmitButton = findViewById(R.id.pwd_submit_button);
        mPasswordSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Password submit button clicked");

                String tmpText = pwdText.getText().toString();
                if(tmpText.equals(PWD)) {
                    Intent i = new Intent(getApplicationContext(), SelectPersonnelActivity.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "SUCCESSFUL AUTHENTICATION", Toast.LENGTH_LONG).show();
                }
                else {
                    pwdText.setText("");
                    Toast.makeText(getApplicationContext(), "PLEASE ENTER CORRECT PASSWORD", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "In onResume()");
        final EditText pwdText = findViewById(R.id.pwd);
        pwdText.setText("");
    }
}
