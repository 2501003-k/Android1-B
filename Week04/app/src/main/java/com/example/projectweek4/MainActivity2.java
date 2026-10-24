package com.example.projectweek4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    int progress = 0;
    int max = 100;
    int min = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView1 = findViewById(R.id.textView1);
        ProgressBar progressBar3 = findViewById(R.id.progressBar3);
        TextView textView2 = findViewById(R.id.textView2);
        ProgressBar progressBar4 = findViewById(R.id.progressBar4);
        TextView textView3 = findViewById(R.id.textView3);
        ProgressBar progressBar5 = findViewById(R.id.progressBar5);
        TextView textView4 = findViewById(R.id.textView4);

//        seekBar seekBar = findViewById(R.id.seekBar1);

        textView1.setText(String.format("%d %%", progress));
        progressBar3.setProgress(progress);
        textView2.setText(String.format("%d %%", progress));
        progressBar4.setProgress(progress);
        textView3.setText(String.format("%d %%", progress));
        progressBar5.setProgress(progress);
        textView4.setText(String.format("%d %%", progress));

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        // 10 증가
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress += 10;
                if (progress > max)
                    progress = max;
                textView1.setText(String.format("%d %%", progress));
                progressBar3.setProgress(progress);
                textView2.setText(String.format("%d %%", progress));
                progressBar4.setProgress(progress);
                textView3.setText(String.format("%d %%", progress));
                progressBar5.setProgress(progress);
                textView4.setText(String.format("%d %%", progress));
            }
        });

        // 10 감소
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress -= 10;
                if (progress < min)
                    progress = min;
                textView1.setText(String.format("%d %%", progress));
                progressBar3.setProgress(progress);
                textView2.setText(String.format("%d %%", progress));
                progressBar4.setProgress(progress);
                textView3.setText(String.format("%d %%", progress));
                progressBar5.setProgress(progress);
                textView4.setText(String.format("%d %%", progress));
            }
        });
    }
}
