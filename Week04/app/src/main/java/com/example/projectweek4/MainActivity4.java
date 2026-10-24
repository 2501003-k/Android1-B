package com.example.projectweek4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    // 리스너 안에서 값을 바꿔야 해서 필드로 선언
    int num1 = 1, num2 = 1;
    boolean moved1 = false, moved2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        setTitle("LCM");

        TextView txtNum1 = findViewById(R.id.txtNum1);
        TextView txtNum2 = findViewById(R.id.txtNum2);
        SeekBar seekNum1 = findViewById(R.id.seekNum1);
        SeekBar seekNum2 = findViewById(R.id.seekNum2);
        Button btnLcm = findViewById(R.id.btnLcm);
        TextView txtResult = findViewById(R.id.txtResult);

        // SeekBar는 0부터 시작하니까 +1 해서 1 ~ 100으로 사용
        seekNum1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                num1 = progress + 1;
                txtNum1.setText("자연수 입력(" + num1 + ")");
                moved1 = true;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        seekNum2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                num2 = progress + 1;
                txtNum2.setText("자연수 입력(" + num2 + ")");
                moved2 = true;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        btnLcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SeekBar를 하나라도 안 움직였으면 Toast
                if (!moved1 || !moved2) {
                    Toast.makeText(getBaseContext(), "입력 바람", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 최대공약수: 1부터 작은 수까지 둘 다 나누어떨어지는 가장 큰 수
                int gcd = 1;
                int small = Math.min(num1, num2);
                for (int i = 1; i <= small; i++) {
                    if (num1 % i == 0 && num2 % i == 0) {
                        gcd = i;
                    }
                }

                // 최소공배수 = 두 수의 곱 / 최대공약수
                int lcm = num1 * num2 / gcd;

                txtResult.setText(num1 + ", " + num2 + "의 GCD(최대공약수)는 " + gcd + "입니다\n"
                        + num1 + ", " + num2 + "의 LCM(최소공배수)는 " + lcm + " 입니다.");
            }
        });
    }
}