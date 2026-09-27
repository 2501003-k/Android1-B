package com.example.projectweek04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        setTitle("온도 변환기");

        EditText editCelsius = findViewById(R.id.editCelsius);
        EditText editFahrenheit = findViewById(R.id.editFahrenheit);
        Button btnToFahrenheit = findViewById(R.id.btnToFahrenheit);
        Button btnToCelsius = findViewById(R.id.btnToCelsius);
        TextView txtResult = findViewById(R.id.txtResult);

        // 섭씨 → 화씨
        btnToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editCelsius.getText().toString().trim();

                if (str.isEmpty()) {
                    Toast.makeText(getBaseContext(), "섭씨 온도를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                float c = Float.parseFloat(str);

                // F = (9/5 × C) + 32
                float f = (9f / 5f * c) + 32;

                Toast.makeText(getBaseContext(), String.valueOf(f), Toast.LENGTH_SHORT).show();

                txtResult.setText("섭씨 온도 " + String.format("%.2f", c) + "도는\n"
                        + "화씨 온도로 " + String.format("%.2f", f) + "도 입니다.");
            }
        });

        // 화씨 → 섭씨
        btnToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editFahrenheit.getText().toString().trim();

                if (str.isEmpty()) {
                    Toast.makeText(getBaseContext(), "화씨 온도를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                float f = Float.parseFloat(str);

                // C = 5/9 × (F - 32)
                float c = 5f / 9f * (f - 32);

                Toast.makeText(getBaseContext(), String.valueOf(c), Toast.LENGTH_SHORT).show();

                txtResult.setText("화씨 온도 " + String.format("%.2f", f) + "도는\n"
                        + "섭씨 온도로 " + String.format("%.2f", c) + "도 입니다.");
            }
        });
    }
}