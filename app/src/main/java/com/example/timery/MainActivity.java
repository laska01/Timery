package com.example.timery;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int ileSekund;
    Button start;
    Button stop;
    Button reset;
    Button zapisz;

    private boolean czyIdzie = false;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        start.findViewById(R.id.start);
        stop.findViewById(R.id.stop);
        reset.findViewById(R.id.reset);
        zapisz.findViewById(R.id.zapisz);
        Handler handler = new Handler();
        start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyIdzie = true;
                    }
                }
        );
        stop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyIdzie = false;
                    }
                }
        );
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        if (czyIdzie) {
                            ileSekund++;
                            textView.setText("" + ileSekund);
                        }
                        handler.postDelayed(this,1000);

                    }
                }
        );


    }
}