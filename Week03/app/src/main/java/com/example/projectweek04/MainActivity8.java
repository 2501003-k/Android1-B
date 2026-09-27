package com.example.projectweek04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        setTitle("만 나이 계산기");

        EditText editMonth = findViewById(R.id.editMonth);
        EditText editDay = findViewById(R.id.editDay);
        EditText editYear = findViewById(R.id.editYear);
        EditText editAge = findViewById(R.id.editAge);
        Button btnAge = findViewById(R.id.btnAge);
        Button btnYear = findViewById(R.id.btnYear);

        // 오늘 날짜 구하기 (월은 0부터 시작해서 +1)
        Calendar today = Calendar.getInstance();
        int thisYear = today.get(Calendar.YEAR);
        int thisMonth = today.get(Calendar.MONTH) + 1;
        int thisDay = today.get(Calendar.DAY_OF_MONTH);

        // 오늘 월일을 숫자로 (예: 9월 27일 → 927)
        int todayMD = thisMonth * 100 + thisDay;

        // 출생 년도 → 만 나이
        btnAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strMonth = editMonth.getText().toString().trim();
                String strDay = editDay.getText().toString().trim();
                String strYear = editYear.getText().toString().trim();

                if (strMonth.isEmpty() || strDay.isEmpty() || strYear.isEmpty()) {
                    Toast.makeText(getBaseContext(), "생일(월, 일)과 출생 년도를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int month = Integer.parseInt(strMonth);
                int day = Integer.parseInt(strDay);
                int year = Integer.parseInt(strYear);

                if (month < 1 || month > 12 || day < 1 || day > 31) {
                    Toast.makeText(getBaseContext(), "월은 1~12, 일은 1~31로 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 조건: 0 ~ 올해까지만
                if (year < 0 || year > thisYear) {
                    Toast.makeText(getBaseContext(), "출생 년도는 0에서 " + thisYear + "까지만 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int birthMD = month * 100 + day;

                // (1) 년도끼리 빼기
                int age = thisYear - year;

                // (2) 월일 비교: 생일이 아직 안 지났으면 -1
                if (todayMD < birthMD) {
                    age = age - 1;
                }

                // 올해 태어났는데 생일이 아직 안 온 경우 (미래 날짜)
                if (age < 0) {
                    Toast.makeText(getBaseContext(), "아직 오지 않은 날짜입니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(getBaseContext(), "당신의 만 나이는 " + age + "세입니다.", Toast.LENGTH_SHORT).show();
            }
        });

        // 만 나이 → 출생 년도
        btnYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strMonth = editMonth.getText().toString().trim();
                String strDay = editDay.getText().toString().trim();
                String strAge = editAge.getText().toString().trim();

                if (strMonth.isEmpty() || strDay.isEmpty() || strAge.isEmpty()) {
                    Toast.makeText(getBaseContext(), "생일(월, 일)과 나이를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int month = Integer.parseInt(strMonth);
                int day = Integer.parseInt(strDay);
                int age = Integer.parseInt(strAge);

                if (month < 1 || month > 12 || day < 1 || day > 31) {
                    Toast.makeText(getBaseContext(), "월은 1~12, 일은 1~31로 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 조건: 1 ~ 130살까지만
                if (age < 1 || age > 130) {
                    Toast.makeText(getBaseContext(), "나이는 1에서 130까지만 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int birthMD = month * 100 + day;

                int year = thisYear - age;

                // 생일이 아직 안 지났으면 1년 더 전에 태어난 것
                if (todayMD < birthMD) {
                    year = year - 1;
                }

                Toast.makeText(getBaseContext(), "당신의 태어난 해는 " + year + "입니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}