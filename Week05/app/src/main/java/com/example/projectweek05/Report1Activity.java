package com.example.projectweek05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Report1Activity extends AppCompatActivity {

    EditText editGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);

        setTitle("Report02");

        editGrade = findViewById(R.id.editGrade);

        // EditText를 누르면 학년 입력 전용 Activity로 이동
        editGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Report1Activity.this, Report1GradeActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    // Report1GradeActivity에서 돌려준 학년 받기
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            editGrade.setText(data.getStringExtra("grade"));
        }
    }
}