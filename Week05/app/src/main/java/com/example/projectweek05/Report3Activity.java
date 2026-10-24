package com.example.projectweek05;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Report3Activity extends AppCompatActivity {

    ProgressDialog barDialog;
    int progress = 0;
    Handler handler = new Handler(Looper.getMainLooper());

    // 0.05초마다 1%씩 올리기
    Runnable loading = new Runnable() {
        @Override
        public void run() {
            progress++;
            barDialog.setProgress(progress);

            if (progress < 100) {
                handler.postDelayed(this, 50);
            } else {
                barDialog.setMessage("로딩이 완료되었습니다");
                Toast.makeText(getBaseContext(), "로딩이 완료되었습니다", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report3);

        setTitle("Report3");

        Button btnSpinner = findViewById(R.id.btnSpinner);
        Button btnHorizontal = findViewById(R.id.btnHorizontal);
        Button btnCustom = findViewById(R.id.btnCustom);

        // 1. Progress Dialog (Spinner)
        btnSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog spinner = new ProgressDialog(Report3Activity.this);
                spinner.setTitle("프로그래스 다이얼로그(Spinner)");
                spinner.setIcon(android.R.drawable.ic_lock_idle_lock);
                spinner.setMessage("현재 진행중입니다.");
                spinner.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                spinner.setCancelable(false);
                spinner.setButton(DialogInterface.BUTTON_NEGATIVE, "취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "취소하였습니다", Toast.LENGTH_SHORT).show();
                    }
                });
                spinner.create();
                spinner.show();
            }
        });

        // 2. Progress Dialog (Horizontal Bar)
        btnHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress = 0;

                barDialog = new ProgressDialog(Report3Activity.this);
                barDialog.setTitle("프로그래스 다이얼로그(Horizontal)");
                barDialog.setIcon(android.R.drawable.ic_lock_idle_lock);
                barDialog.setMessage("잠시만 기다려 주세요.");
                barDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                barDialog.setMax(100);
                barDialog.setCancelable(false);
                barDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.removeCallbacks(loading);   // 진행 멈추기
                        if (progress < 100) {
                            Toast.makeText(getBaseContext(), "취소하였습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                barDialog.create();
                barDialog.show();

                handler.postDelayed(loading, 50);
            }
        });

        // 3. Custom Dialog
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_report3_login, null);
                EditText editId = dialogView.findViewById(R.id.editId);
                EditText editPwd = dialogView.findViewById(R.id.editPwd);
                Button btnLogin = dialogView.findViewById(R.id.btnLogin);

                AlertDialog.Builder builder = new AlertDialog.Builder(Report3Activity.this);
                builder.setTitle("커스텀 다이얼로그");
                builder.setIcon(android.R.drawable.ic_btn_speak_now);
                builder.setView(dialogView);
                builder.setNegativeButton("취소", null);
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        checkLogin(editId, editPwd);
                    }
                });

                AlertDialog dialog = builder.create();

                // LOGIN 버튼
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (checkLogin(editId, editPwd)) {
                            dialog.dismiss();
                        }
                    }
                });

                dialog.show();
            }
        });
    }

    // 둘 다 입력했으면 "아이디 / 비밀번호" Toast, 아니면 경고 Toast
    boolean checkLogin(EditText editId, EditText editPwd) {
        String id = editId.getText().toString().trim();
        String pwd = editPwd.getText().toString().trim();

        if (id.isEmpty() || pwd.isEmpty()) {
            Toast.makeText(getBaseContext(), "정확하게 입력해주세요", Toast.LENGTH_SHORT).show();
            return false;
        }

        Toast.makeText(getBaseContext(), id + " / " + pwd, Toast.LENGTH_SHORT).show();
        return true;
    }
}