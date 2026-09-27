package com.example.projectweek04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        setTitle("EditText06");

        EditText editId = findViewById(R.id.editId);
        EditText editPw = findViewById(R.id.editPw);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editId.getText().toString().trim();
                String pw = editPw.getText().toString().trim();

                // 둘 중 하나라도 비어 있으면 Toast
                if (id.isEmpty() || pw.isEmpty()) {
                    Toast.makeText(getBaseContext(), "데이터 입력 해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    // 둘 다 입력되면 Snackbar로 출력
                    Snackbar.make(v, "아이디 : " + id + " 비밀번호 : " + pw,
                            BaseTransientBottomBar.LENGTH_LONG).show();
                }
            }
        });
    }
}