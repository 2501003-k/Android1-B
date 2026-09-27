package com.example.projectweek04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        setTitle("원의 면적 계산하기");

        EditText editRadius = findViewById(R.id.editRadius);
        Button btnArea = findViewById(R.id.btnArea);

        TextView txtRadiusLabel = findViewById(R.id.txtRadiusLabel);
        TextView txtRadius = findViewById(R.id.txtRadius);
        TextView txtRadiusUnit = findViewById(R.id.txtRadiusUnit);

        TextView txtAreaLabel = findViewById(R.id.txtAreaLabel);
        TextView txtArea = findViewById(R.id.txtArea);
        TextView txtAreaUnit = findViewById(R.id.txtAreaUnit);

        btnArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editRadius.getText().toString().trim();

                // 입력값이 없으면 Toast 출력
                if (str.isEmpty()) {
                    Toast.makeText(getBaseContext(), "입력 바람", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 문자열 → double 변환
                double radius = Double.parseDouble(str);

                // 원의 면적 = 3.141592 x 반지름 x 반지름
                double area = 3.141592 * radius * radius;

                // 결과 출력
                txtRadiusLabel.setText("원의 반지름 : ");
                txtRadius.setText(String.format("%,.2f", radius));
                txtRadiusUnit.setText(" ㎝");

                txtAreaLabel.setText("원의 면적 : ");
                txtArea.setText(String.format("%,.2f", area));
                txtAreaUnit.setText(" ㎠");
            }
        });
    }
}