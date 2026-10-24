package com.example.projectweek4;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    double weight = 35.0;
    double height = 90.0;
    TextView txtBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        setTitle("BMI");

        SeekBar seekWeight = findViewById(R.id.seekWeight);
        SeekBar seekHeight = findViewById(R.id.seekHeight);
        TextView txtWeight = findViewById(R.id.txtWeight);
        TextView txtHeight = findViewById(R.id.txtHeight);
        txtBmi = findViewById(R.id.txtBmi);

        // 몸무게: 35.0 ~ 150.0, 0.5씩 → (150 - 35) / 0.5 = 230칸
        seekWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                weight = 35 + progress * 0.5;
                txtWeight.setText(String.format("%.1f", weight) + " Kg");
                if (fromUser) showBmi();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        // 키: 90.0 ~ 230.0, 0.5씩 → (230 - 90) / 0.5 = 280칸
        seekHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                height = 90 + progress * 0.5;
                txtHeight.setText(String.format("%.1f", height) + " Cm");
                if (fromUser) showBmi();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }

    // BMI = 몸무게(kg) / (키(m) x 키(m))
    void showBmi() {
        double m = height / 100;
        double bmi = weight / (m * m);

        String result;
        if (bmi < 18.5) {
            result = "저체중";
        } else if (bmi < 23) {
            result = "정상 체중";
        } else if (bmi < 25) {
            result = "과체중";
        } else {
            result = "비만";
        }

        txtBmi.setText("BMI : " + String.format("%.2f", bmi) + "\n당신은 " + result + " 입니다!");
    }
}