package com.example.liquid_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gospelware.liquidbutton.LiquidButton;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    LiquidButton liquidButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liquidButton = (LiquidButton) findViewById(R.id.button);
        textView = findViewById(R.id.textview);

        liquidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LiquidButton btn =(LiquidButton) v;
                btn.startPour();
            }
        });

        liquidButton.setFillAfter(true);
        liquidButton.setAutoPlay(true);

        liquidButton.setPourFinishListener(new LiquidButton.PourFinishListener() {
            @Override
            public void onPourFinish() {
                Toast.makeText(MainActivity.this,"Finish",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProgressUpdate(float progress) {
                textView.setText(String.format("%.2f", progress* 100)+"%");

            }
        });
    }
}