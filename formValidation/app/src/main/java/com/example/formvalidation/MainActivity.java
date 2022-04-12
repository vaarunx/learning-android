package com.example.formvalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button validateBtn;
    EditText username , pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.uname);
        pin = (EditText) findViewById(R.id.pwd);
        validateBtn = (Button) findViewById(R.id.validateBtn);

        validateBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (username.getText().toString().matches("[a-zA-Z]+") && pin.getText().toString().matches("[0-9]+") && pin.getText().toString().length() == 4){
            Toast t= Toast.makeText(getApplicationContext(),"Successfully Validated" , Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            Toast t= Toast.makeText(getApplicationContext(),"Please Check your username and pin!" , Toast.LENGTH_SHORT);
            t.show();
        }
    }

    //etUname.getText().toString().matches("[a-zA-Z]+")
    //etPwd.getText().toString().matches("[0-9]+")
    //etPwd.getText().toString().length() == 4;
}