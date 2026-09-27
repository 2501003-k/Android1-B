package com.example.projectweek04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        setTitle("나이 계산기");

        EditText editYear = findViewById(R.id.editYear);
        EditText editAge = findViewById(R.id.editAge);
        Button btnAge = findViewById(R.id.btnAge);
        Button btnYear = findViewById(R.id.btnYear);

        // 올해 년도 구하기
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);

        // 출생 년도 → 나이
        btnAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editYear.getText().toString().trim();

                if (str.isEmpty()) {
                    Toast.makeText(getBaseContext(), "출생 년도를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int year = Integer.parseInt(str);

                // 조건: 0 ~ 올해까지만
                if (year < 0 || year > thisYear) {
                    Toast.makeText(getBaseContext(), "출생 년도는 0에서 " + thisYear + "까지만 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int age = thisYear - year;

                Toast.makeText(getBaseContext(), "당신의 나이는 " + age + "세입니다.", Toast.LENGTH_SHORT).show();
            }
        });

        // 나이 → 출생 년도
        btnYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editAge.getText().toString().trim();

                if (str.isEmpty()) {
                    Toast.makeText(getBaseContext(), "나이를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int age = Integer.parseInt(str);

                // 조건: 1 ~ 130살까지만
                if (age < 1 || age > 130) {
                    Toast.makeText(getBaseContext(), "나이는 1에서 130까지만 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int year = thisYear - age;

                Toast.makeText(getBaseContext(), "당신의 태어난 해는 " + year + "입니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}