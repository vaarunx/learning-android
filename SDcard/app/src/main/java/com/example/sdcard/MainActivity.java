package com.example.sdcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button readData, writeData;
    EditText fileName, studentName, cgpa;

    String file, student , cgpaString;
    String[] text = new String[]{"",""};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readData = (Button) findViewById(R.id.readData);
        writeData = (Button) findViewById(R.id.writeData);
        fileName = (EditText) findViewById(R.id.fileName);
        studentName = (EditText) findViewById(R.id.studentName);
        cgpa = (EditText) findViewById(R.id.cgpa);


        readData.setOnClickListener(this);
        writeData.setOnClickListener(this);

    }

    public void onClick(View view) {
        if(view==readData) {
            file = fileName.getText().toString();
            student = studentName.getText().toString();
            cgpaString = cgpa.getText().toString();
            try {
                FileOutputStream writer = openFileOutput(file, Context.MODE_PRIVATE);
                writer.write(student.getBytes());
                writer.write("\n".getBytes());
                writer.write(cgpaString.getBytes());
                writer.flush();
                writer.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        if(view==writeData){
            file = studentName.getText().toString();
            try {
                FileInputStream reader = openFileInput(file);
                int x,i=0;
                while((x = reader.read())!=-1){
                    if((char)x=='\n') i++;
                    text[i]+=(char)x;
                }
                studentName.setText(text[0]);
                cgpa.setText(text[1]);
                reader.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }


}