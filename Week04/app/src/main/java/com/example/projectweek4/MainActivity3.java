package com.example.projectweek4;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    int redProgress = 0;
    int greenProgress = 0;
    int blueProgress = 0;
    int defaultColor = 0;

    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView textView1 = findViewById(R.id.textView1); // red
        TextView textView2 = findViewById(R.id.textView2); // green
        TextView textView3 = findViewById(R.id.textView3); // blue
        textView4 = findViewById(R.id.textView4);

        textView1.setText(String.format("%d(%X)", 0, 0));
        textView2.setText(String.format("%d(%X)", 0, 0));
        textView3.setText(String.format("%d(%X)", 0, 0));



        SeekBar seekBar1 = findViewById(R.id.seekBar1); // red
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redProgress = progress;
                textView1.setText(String.format("%d(%X)", redProgress, 0));
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar seekBar2 = findViewById(R.id.seekBar2); // green
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenProgress = progress;
                textView2.setText(String.format("%d(%X)", greenProgress, 0));
                changeColor();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar seekBar3 = findViewById(R.id.seekBar3); // blue
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueProgress = progress;
                textView3.setText(String.format("%d(%X)", blueProgress, 0));
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void changeColor() {
        defaultColor = Color.rgb(redProgress, greenProgress, blueProgress);
        textView4.setText(String.format("%s%X%s%X%s%X",
                redProgress < 16 ? "0" : "", redProgress,
                greenProgress < 16 ? "0" : "", greenProgress,
                blueProgress < 16 ? "0" : "", blueProgress));
        textView4.setBackgroundColor(defaultColor);

    }
}