package com.example.sugarcrash10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityMeniu extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_meniu);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivityInformatii();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivityApa();
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivityRetete();
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivitySport();
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivityGlicemie();
            }
        });
    }

    public void  openMainActivityInformatii(){
        Intent intent = new Intent(this, MainActivityInformatii.class);
        startActivity(intent);
    }

    public void  openMainActivityApa(){
        Intent intent = new Intent(this, MainActivityApa.class);
        startActivity(intent);
    }

    public void  openMainActivityRetete(){
        Intent intent = new Intent(this, MainActivityRetete.class);
        startActivity(intent);
    }

    public void  openMainActivitySport(){
        Intent intent = new Intent(this, MainActivitySport.class);
        startActivity(intent);
    }

    public void  openMainActivityGlicemie(){
        Intent intent = new Intent(this, MainActivityGlicemie.class);
        startActivity(intent);
    }
}