package com.example.sugarcrash10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivityGlicemie extends AppCompatActivity {

    private Button glicemie;

    EditText xValue, yValue;
    Button adauga;

    FirebaseDatabase database;
    DatabaseReference reference;

    GraphView graphView;
    LineGraphSeries series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_glicemie);

        glicemie = (Button) findViewById(R.id.glicemie);
        glicemie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivityValoriGlicemie();
            }
        });

        xValue = (EditText) findViewById(R.id.x_value);
        yValue = (EditText) findViewById(R.id.y_value);

        adauga = (Button) findViewById(R.id.adauga);
        graphView = (GraphView) findViewById(R.id.graphView);
        series = new LineGraphSeries();
        graphView.addSeries(series);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("chartTable");

        setListeneres();
    }

    public void  openMainActivityValoriGlicemie(){
        Intent intent = new Intent(this, MainActivityValoriGlicemie.class);
        startActivity(intent);
    }

    private void setListeneres() {
        adauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=reference.push().getKey();

                int x = Integer.parseInt(xValue.getText().toString());
                int y = Integer.parseInt(yValue.getText().toString());

                PointValue pointValue = new PointValue(x,y);

                reference.child(id).setValue(pointValue);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                DataPoint[] dp= new DataPoint[(int) snapshot.getChildrenCount()];
                int index = 0;

                for (DataSnapshot myDataSnapshot : snapshot.getChildren())
                {
                    PointValue pointValue =myDataSnapshot.getValue(PointValue.class);
                    dp[index] = new DataPoint(pointValue.getxValue(),pointValue.getyValue());
                    index++;
                }

                series.resetData(dp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}