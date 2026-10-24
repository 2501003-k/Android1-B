package com.example.projectweek4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    int celsius = 0;
    int fahrenheit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        setTitle("Report 02");

        TextView txtCelsius = findViewById(R.id.txtCelsius);
        TextView txtFahrenheit = findViewById(R.id.txtFahrenheit);
        SeekBar seekCelsius = findViewById(R.id.seekCelsius);
        SeekBar seekFahrenheit = findViewById(R.id.seekFahrenheit);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button btnConvert = findViewById(R.id.btnConvert);
        Button btnReset = findViewById(R.id.btnReset);
        TextView txtResult = findViewById(R.id.txtResult);

        // 라디오 버튼을 고르기 전에는 SeekBar를 못 움직이게
        seekCelsius.setEnabled(false);
        seekFahrenheit.setEnabled(false);

        // SeekBar 0 ~ 200 → 온도 -100 ~ +100 (1씩)
        seekCelsius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                celsius = progress - 100;
                txtCelsius.setText("섭씨온도(" + String.format("%.1f", (double) celsius) + " ℃)");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        seekFahrenheit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                fahrenheit = progress - 100;
                txtFahrenheit.setText("화씨온도(" + String.format("%.1f", (double) fahrenheit) + " ℉)");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        // 라디오 버튼을 누르면 해당 SeekBar만 움직일 수 있게
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioCtoF) {
                    seekCelsius.setEnabled(true);
                    seekFahrenheit.setEnabled(false);
                } else if (checkedId == R.id.radioFtoC) {
                    seekCelsius.setEnabled(false);
                    seekFahrenheit.setEnabled(true);
                } else {
                    // 초기화로 선택이 풀린 경우
                    seekCelsius.setEnabled(false);
                    seekFahrenheit.setEnabled(false);
                }
            }
        });

        // 변환
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = radioGroup.getCheckedRadioButtonId();

                if (checkedId == -1) {
                    Toast.makeText(getBaseContext(), "선택해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (checkedId == R.id.radioCtoF) {
                    // ℉ = (℃ × 1.8) + 32
                    double f = celsius * 1.8 + 32;
                    txtResult.setText("섭씨온도 : " + String.format("%.2f", (double) celsius) + " ℃, "
                            + "화씨온도 : " + String.format("%.2f", f) + " ℉");
                } else {
                    // ℃ = (℉ - 32) / 1.8
                    double c = (fahrenheit - 32) / 1.8;
                    txtResult.setText("화씨온도 : " + String.format("%.2f", (double) fahrenheit) + " ℉, "
                            + "섭씨온도 : " + String.format("%.2f", c) + " ℃");
                }
            }
        });

        // 초기화
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.clearCheck();
                seekCelsius.setProgress(100);     // 0도로
                seekFahrenheit.setProgress(100);
                txtResult.setText("");
            }
        });
    }
}