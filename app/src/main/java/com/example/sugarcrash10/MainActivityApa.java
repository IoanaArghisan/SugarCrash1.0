package com.example.sugarcrash10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivityApa extends AppCompatActivity {

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_apa);

        builder= new AlertDialog.Builder(this);
        builder.setTitle("Alertă hidratare");
        builder.setMessage("Ați consumat in cursul acestei zile minimul de 2 litrii de apă?");
        builder.setPositiveButton("Da", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivityApa.this,"Felicitări, hidratați-vă in continuare!", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Nu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivityApa.this,"Ar trebui să vă hidratați!",Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
    }

    public void show(View view) {
        builder.show();
    }
    }
