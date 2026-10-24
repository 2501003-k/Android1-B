package com.example.projectweek05;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Report2Activity extends AppCompatActivity {

    String[] hobbies = {"독서", "등산", "수영", "수집", "영화"};
    boolean[] checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);

        setTitle("Report2");

        Button btnAlert = findViewById(R.id.btnAlert);
        Button btnInput = findViewById(R.id.btnInput);
        Button btnList = findViewById(R.id.btnList);

        // 1. 알림 다이얼로그
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Report2Activity.this);
                builder.setTitle("알림");
                builder.setIcon(android.R.drawable.ic_popup_reminder);
                builder.setMessage("이번주 레포트는 Dialog 입니다");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "확인했습니다", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create();
                builder.show();
            }
        });

        // 2. 입력 다이얼로그
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editName = new EditText(Report2Activity.this);

                AlertDialog.Builder builder = new AlertDialog.Builder(Report2Activity.this);
                builder.setTitle("이름 입력");
                builder.setView(editName);
                builder.setNegativeButton("Cancel", null);   // 그냥 닫기
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = editName.getText().toString().trim();

                        if (name.isEmpty()) {
                            Toast.makeText(getBaseContext(), "입력해주세요", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getBaseContext(), name, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.create();
                builder.show();
            }
        });

        // 3. 리스트 다이얼로그 (학번 홀수: 취미 여러 개 선택)
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checked = new boolean[hobbies.length];   // 열 때마다 초기화

                AlertDialog.Builder builder = new AlertDialog.Builder(Report2Activity.this);
                builder.setTitle("당신의 취미는?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setMultiChoiceItems(hobbies, checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checked[which] = isChecked;
                    }
                });
                builder.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = "";
                        for (int i = 0; i < hobbies.length; i++) {
                            if (checked[i]) {
                                if (!result.isEmpty()) result += ", ";
                                result += hobbies[i];
                            }
                        }

                        if (result.isEmpty()) {
                            Toast.makeText(getBaseContext(), "취미를 선택해주세요", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getBaseContext(), "취미 : " + result, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.create();
                builder.show();
            }
        });
    }
}