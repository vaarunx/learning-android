package com.example.alertbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.click);

        btn.setOnClickListener(this);
    }

    public void onClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage("Did you mean to click the button ?");
        builder.setTitle("Alert !");

        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

    }

}
//    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//    alertDialogBuilder.setMessage("Are you sure,You wanted to open another activity");
//    alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
//        @Override public void onClick(DialogInterface arg0, int arg1)
//        { Toast.makeText(AlertActivity.this,"You clicked YES button",Toast.LENGTH_LONG).show();
//        // write code here to open the second activity
//        } }); alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
//            @Override public void onClick(DialogInterface dialog, int which) { finish(); } });
//        AlertDialog alertDialog = alertDialogBuilder.create(); alertDialog.show()

