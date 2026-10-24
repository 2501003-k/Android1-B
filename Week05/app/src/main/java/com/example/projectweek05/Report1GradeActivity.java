package com.example.projectweek05;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Report1GradeActivity extends AppCompatActivity {

    String[] grades = {"1학년", "2학년", "3학년", "4학년"};
    int selected = -1;   // 아무것도 선택 안 함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1_grade);

        setTitle("학년 입력");

        showGradeDialog();
    }

    void showGradeDialog() {
        selected = -1;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("몇학년 입니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        // 하나만 고를 수 있는 목록
        builder.setSingleChoiceItems(grades, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selected = which;
            }
        });

        builder.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (selected == -1) {
                    Toast.makeText(getBaseContext(), "학년을 선택해주세요", Toast.LENGTH_SHORT).show();
                    showGradeDialog();   // 다시 띄우기
                } else {
                    // 선택한 학년을 원래 화면으로 돌려보내기
                    Intent result = new Intent();
                    result.putExtra("grade", grades[selected]);
                    setResult(RESULT_OK, result);
                    finish();
                }
            }
        });

        builder.setCancelable(false);   // 바깥/Back으로 닫히지 않게
        builder.create();
        builder.show();
    }
}